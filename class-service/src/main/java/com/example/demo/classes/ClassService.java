package com.example.demo.classes;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.errorHandler.EntityExistenceException;
import com.example.demo.members.MemberModel;
import com.example.demo.members.MemberRepo;
import com.google.common.base.Optional;


@Service
public class ClassService {
    @Autowired
    private ClassRepo classRepo;

    @Autowired
    private MemberRepo memberRepo;

    public Map<String,String> createClass(ClassModel classModel) {
        Random rand = new Random();
        String joinCode = Integer.toString(rand.nextInt(9000)+1000);
        classModel.setJoinCode(joinCode);
        classRepo.save(classModel);
        return classModel.ClassModelToMap(classModel);
    }

    public Map<String,String> getClassById(UUID cid) {
        ClassModel classModel = classRepo.findByCid(cid);
        if(classModel == null){
            throw new EntityExistenceException("Class does not exist");
        }
        return classModel.ClassModelToMap(classModel);
    }

    public List<ClassModel> getAllClassesByTeacher(String teacher) {
        return classRepo.findAllByTeacher(teacher);
    }

    public void deleteClass(UUID cid) {
        classRepo.deleteById(cid);
    }

    public void joinClass(UUID cid, String sid, String joinCode) {
        ClassModel classModel = classRepo.findByCid(cid);
        Optional<MemberModel> memberModel = memberRepo.findBySid(sid);
        if(memberModel.isPresent()){
            throw new EntityExistenceException("Student already in class");
        }
        if(classModel == null){
            throw new EntityExistenceException("Class does not exist");
        }
        if(!classModel.getJoinCode().equals(joinCode)){
            throw new EntityExistenceException("Invalid join code");
        }
        memberRepo.save(new MemberModel(null, sid, classModel));
    }

    public void leaveClass(UUID cid, String sid) {
        ClassModel classModel = classRepo.findByCid(cid);
        Optional<MemberModel> memberModel = memberRepo.findBySid(sid);
        if(((Map<String, String>) memberModel).isEmpty()){
            throw new EntityExistenceException("Student not in class");
        }
        if(classModel == null){
            throw new EntityExistenceException("Class does not exist");
        }
        memberRepo.delete(memberModel.get());
    }

    public List<MemberModel> getMembers(UUID cid) {
        ClassModel classModel = classRepo.findByCid(cid);
        if(classModel == null){
            throw new EntityExistenceException("Class does not exist");
        }
        return memberRepo.findAllByCourse(classModel);
    }
}

