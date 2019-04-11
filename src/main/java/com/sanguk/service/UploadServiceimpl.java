package com.sanguk.service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.sanguk.util.UploadFileUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;


@Service
@Log4j
public class UploadServiceimpl implements UploadService{ 
    
    @Autowired
    private Path rootLocation;

    @Autowired
    private String uploadPath;



    @Override
    public String saveImage(MultipartFile file) throws Exception {
        try {
            if (file.isEmpty()) {
                throw new Exception("Failed to store empty file " + file.getOriginalFilename());
            }
            
            String saveFileName = UploadFileUtils.fileSave(rootLocation.toString(), file);
            
            if (saveFileName.toCharArray()[0] == '/') {
                saveFileName = saveFileName.substring(1);
            }
            
            
            return saveFileName;
        } catch (IOException e) {
            throw new Exception("Failed to store file " + file.getOriginalFilename(), e);
        }
    }

    @Override
    public Resource loadAsResource(String fileName) throws Exception {
        try {
            
            Path file = loadPath(uploadPath+fileName);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                System.out.println("awddddddddddd");
                return resource;
            } else {
                throw new Exception("Could not read file: " + fileName);
            }
        } catch (Exception e) {
            throw new Exception("Could not read file: " + fileName);
        }
    }
    
    private Path loadPath(String fileName) {
        return rootLocation.resolve(fileName);
    }
}