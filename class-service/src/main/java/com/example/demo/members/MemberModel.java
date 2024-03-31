package com.example.demo.members;

import java.util.HashMap;
import java.util.Map;


import com.example.demo.classes.ClassModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "students")
public class MemberModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Pattern(regexp = "^[a-f0-9]{8}-[a-f0-9]{4}-[1-5][a-f0-9]{3}-[89ab][a-f0-9]{3}-[a-f0-9]{12}$")
    @Size(min = 36, max = 36, message = "SID must be 36 characters")
    private String sid;

    @ManyToOne
    @JoinColumn(name = "classId", referencedColumnName = "cid")
    private ClassModel course;

    public MemberModel() {
    }

    public MemberModel(Long id, String sid, ClassModel course) {
        this.id = id;
        this.sid = sid;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public String getSid() {
        return sid;
    }

    public ClassModel getCourse() {
        return course;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public void setCourse(ClassModel course) {
        this.course = course;
    }

    public Map<String,String> toMap() {
        Map<String, String> map = new HashMap<>();
        map.put("id", this.id.toString());
        map.put("sid", this.sid);
        map.put("course", this.course.toString());
        return map;
    }

}
