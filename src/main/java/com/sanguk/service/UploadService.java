package com.sanguk.service;

import java.io.IOException;
import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 * Upload 서비스 인터페이스 입니다.
 * 
 * @author Sanguk
 * @version 1.0.0
 */

public interface UploadService{

    /**
     * 이미지를 저장하고 파일 명을 반환
     * @param file
     * @return String
     * @throws IOException
     */
    public String saveImage(MultipartFile file) throws IOException;

    /**
     * fileName에 해당하는 파일 반환
     * @param fileName
     * @param loadPath
     * @return Resource
     * @throws IOException
     */
    public Resource loadAsResource(String fileName,Path loadPath) throws IOException;
    
    /**
     * profile 이미지를 저장하고 파일 명을 반환
     * @param profile
     * @return String
     */
    public String saveProfile(MultipartFile profile);
}