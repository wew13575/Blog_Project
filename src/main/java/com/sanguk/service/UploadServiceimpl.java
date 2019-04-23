package com.sanguk.service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.sanguk.util.MediaUtils;
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
    public Resource loadAsResource(String fileName,String loadPath) throws Exception {
        try {
            
            Path file = loadPath(loadPath+fileName);
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

    
	@Override
	public String saveProfile(MultipartFile profile)  throws Exception{
		String profilePath;

		try {
			if (profile.isEmpty()) {
				throw new Exception();
			}
			String fileName = profile.getOriginalFilename();
			String extension = fileName.split("\\.")[1];
			if (!MediaUtils.containsImageMediaType(extension)) {
				throw new Exception();
			}
			profilePath = UploadFileUtils.fileSave(rootLocation.toString(), profile);
			if (profilePath.toCharArray()[0] == '/') {
				profilePath = profilePath.substring(1);
			}

		} catch (Exception e) {
			profilePath = "basicprofile.jpg";
			throw new Exception("Failed to store file " + profile.getOriginalFilename(), e);
		}

		return profilePath;
	}
}