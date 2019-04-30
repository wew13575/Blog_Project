package com.sanguk.service;

import java.io.IOException;
import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService{

    public String saveImage(MultipartFile file) throws IOException;
    public Resource loadAsResource(String fileName,String loadPath) throws IOException;
    public String saveProfile(MultipartFile profile);
}