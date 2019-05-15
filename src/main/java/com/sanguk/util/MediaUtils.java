package com.sanguk.util;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;

/**
 * Media 처리 유틸 클래스 입니다.
 * 
 * @author Sanguk
 * @version 1.0.0
 */
public class MediaUtils {
    
    private static Map<String, MediaType> mediaMap;
    
    static {
        mediaMap = new HashMap<>();
        
        mediaMap.put("JPEG", MediaType.IMAGE_JPEG);
        mediaMap.put("JPG", MediaType.IMAGE_JPEG);
        mediaMap.put("GIF", MediaType.IMAGE_GIF);
        mediaMap.put("PNG", MediaType.IMAGE_PNG);
    }
    
    /**
     * 확장자를 받아서 미디어 타입을 반환
     * @param type
     * @return MediaType
     */
    public static MediaType getMediaType(String type) {
        return mediaMap.get(type.toUpperCase());
    }
    
    /**
     * 개체가 지정 된 미디어 타입에 포함 되는지 확인
     * @param mediaType
     * @return boolean
     */
    public static boolean containsImageMediaType(String mediaType) {
        return mediaMap.keySet().contains(mediaType.toUpperCase());
    }
    
}