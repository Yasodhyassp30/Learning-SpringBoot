package com.example.demo.controllers;

import com.example.demo.services.attachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/attachments")
public class attachmentController {

    @Autowired
    private attachmentService attachmentService;

    @PostMapping("/upload")
    public ResponseEntity<Map<String, String>> uploadFile(@RequestParam("file") MultipartFile file,
                                                          @RequestParam("uuid") UUID uuid) {
        String fileName = attachmentService.storeFile(file, uuid);
        Map<String, String> response = new HashMap<>();
        response.put("fileName", fileName);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/download")
    public ResponseEntity<Object> downloadFile(@RequestParam("fileName") String fileName) {
        try{
            UrlResource data =  attachmentService.downloadFile(fileName);
        Path filePath = Paths.get("./uploads/"+ fileName);
         String contentType;
        try {
            contentType = Files.probeContentType(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + data.getFilename() + "\"")
                .body(data);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error downloading file");
        }
    }

}
