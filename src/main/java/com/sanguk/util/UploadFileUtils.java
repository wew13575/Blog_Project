package com.sanguk.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class UploadFileUtils {
    
    private static final Logger logger = LoggerFactory.getLogger(UploadFileUtils.class);
    
    /**
     * @param filePath
     * @param multipartFile
     * @return 생성된 파일 명(유일한 값)
     * @throws IllegalStateException
     * @throws IOException
     */
    public static String fileSave(String uploadPath, MultipartFile file) throws IllegalStateException, IOException {
        
        File uploadPathDir = new File(uploadPath);
        
        if ( !uploadPathDir.exists() ){
            uploadPathDir.mkdirs();
        }
        
        // 파일 중복명 처리
        String genId = UUID.randomUUID().toString();
        genId = genId.replace("-", "");
        
        String originalfileName = file.getOriginalFilename();
        String fileExtension = getExtension(originalfileName);
        String saveFileName = genId + "." + fileExtension;
        
        System.out.println(saveFileName);
        
        File target = new File(uploadPath, saveFileName);
        
        FileCopyUtils.copy(file.getBytes(), target);
        
        return saveFileName;
    }
    
    /**
     * 파일이름으로부터 확장자를 반환
     * 
     * @param fileName
     *            확장자를 포함한 파일 명
     * @return 파일 이름에서 뒤의 확장자 이름만을 반환
     */
    public static String getExtension(String fileName) {
        int dotPosition = fileName.lastIndexOf('.');
        
        if (-1 != dotPosition && fileName.length() - 1 > dotPosition) {
            return fileName.substring(dotPosition + 1);
        } else {
            return "";
        }
    }
    
    
}