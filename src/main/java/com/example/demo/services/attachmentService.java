package com.example.demo.services;

import com.example.demo.models.attachementModel;
import com.example.demo.repository.attachmentRepository;

import jakarta.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class attachmentService {

    @Autowired
    private attachmentRepository attachmentRepository;

    private final String uploadDir = "./uploads";

    public String storeFile(MultipartFile file, UUID uuid) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        UUID projectId = uuid; 
        String fileId = UUID.randomUUID().toString();

        try {
            if (fileName.contains("..")) {
                throw new RuntimeException("Invalid file name");
            }

            String uniqueFileName = fileId + "_" + fileName;

            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            Path targetLocation = uploadPath.resolve(uniqueFileName);
            Files.copy(file.getInputStream(), targetLocation);

            attachementModel attachment = new attachementModel();
            attachment.setProjectId(projectId);
            attachment.setFilePath(targetLocation.toString());
            attachmentRepository.save(attachment);

            return uniqueFileName;
        } catch (IOException ex) {
            throw new RuntimeException("Failed to store file " + fileName, ex);
        }
    }

    public void deleteFile(Long id) {
        attachementModel attachment = attachmentRepository.findById(id).get();
        String filePath = attachment.getFilePath();
        try {
            Files.deleteIfExists(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        attachmentRepository.deleteById(id);
    }

    public UrlResource downloadFile(String filePath) {
        Path path = Paths.get(uploadDir + "/" + filePath);
        UrlResource resource = null;
        try {
            resource = new UrlResource(path.toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return resource;
    }
}
