package com.sanguk.controller;

import java.io.IOException;
import java.nio.file.Path;

import com.sanguk.service.UploadServiceimpl;
import com.sanguk.util.MediaUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;





/**
 * /upload 매핑 컨트롤러 클래스입니다.
 * 
 * @author Sanguk
 * @version 1.0.0
 */
@Controller
@RequestMapping("/upload")
@Log4j

public class UploadController {


    @Autowired
    UploadServiceimpl uploadService;

    @Autowired
    Path imageLocation;

    @Autowired
    Path thumnailLocation;

    @Autowired
    Path profileLocation;


    /**
     * 이미지 업로드
     * @param file
     * @return ResponseEntity<String>
     */
	@PostMapping("/image.do")
    @ResponseBody
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file) {
		try {
			 
			return ResponseEntity.ok().body("/upload/image/" + uploadService.saveImage(file));
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
    }


    /**
     * 이미지 파일 반환
     * @param fileName
     * @return ResponseEntity<String>
     */
    @GetMapping("/image/{fileName:.+}")
    @ResponseBody
    public ResponseEntity<?> serveFile(@PathVariable String fileName) {
        try {
            log.info(fileName+"왜로딩안돼?");
            HttpHeaders headers = new HttpHeaders();
            String extension = fileName.split("\\.")[1];
            
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
            headers.setContentType(MediaUtils.getMediaType(extension));
            Resource resource;

            
            if(fileName.startsWith("THUMB_")){
                resource = uploadService.loadAsResource(fileName,thumnailLocation);
            }
            else if(fileName.startsWith("PROFILE_")){
                resource = uploadService.loadAsResource(fileName,profileLocation);
            }
            else{
                resource = uploadService.loadAsResource(fileName,imageLocation);
            }

            return ResponseEntity.ok().headers(headers).body(resource);
            
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
    }

	
}
