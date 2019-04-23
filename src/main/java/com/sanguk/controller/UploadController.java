package com.sanguk.controller;

import com.sanguk.service.UploadServiceimpl;
import com.sanguk.util.MediaUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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



@Controller
@RequestMapping("/upload")
@Log4j
public class UploadController {


    @Autowired
    UploadServiceimpl uploadService;

    @Autowired
    String uploadPath;

    @Autowired
    String thumnailPath;

	@PostMapping("/image.do")
    @ResponseBody
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file) {
		try {
			 
			return ResponseEntity.ok().body("/upload/image/" + uploadService.saveImage(file));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }


    @GetMapping("/image/{fileName:.+}")
    @ResponseBody
    public ResponseEntity<?> serveFile(@PathVariable String fileName) {
        try {
            HttpHeaders headers = new HttpHeaders();
            String extension = fileName.split("\\.")[1];
            
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
            headers.setContentType(MediaUtils.getMediaType(extension));
            Resource resource;

            
            if(fileName.startsWith("THUMB_")){
                resource = uploadService.loadAsResource(fileName,thumnailPath);
            }
            else{
                resource = uploadService.loadAsResource(fileName,uploadPath);
            }

            return ResponseEntity.ok().headers(headers).body(resource);
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

	
}
