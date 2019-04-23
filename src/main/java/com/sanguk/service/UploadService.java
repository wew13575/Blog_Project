package com.sanguk.service;

import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService{

    public String saveImage(MultipartFile file) throws Exception;
    public Resource loadAsResource(String fileName,String loadPath) throws Exception;
    public String saveProfile(MultipartFile profile)  throws Exception;
}