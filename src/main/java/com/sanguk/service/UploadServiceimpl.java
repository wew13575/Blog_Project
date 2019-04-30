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
    public String saveImage(MultipartFile file) throws IOException {
        try {
            if (file.isEmpty()) {
                throw new IOException("Failed to store empty file " + file.getOriginalFilename());
            }
            
            String saveFileName = UploadFileUtils.fileSave(rootLocation.toString(), file);
            
            if (saveFileName.toCharArray()[0] == '/') {
                saveFileName = saveFileName.substring(1);
            }
            
            
            return saveFileName;
        } catch (IOException e) {
            throw new IOException("Failed to store file " + file.getOriginalFilename(), e);
        }
    }

    @Override
    public Resource loadAsResource(String fileName,String loadPath) throws IOException {
        try {
            
            Path file = loadPath(loadPath+fileName);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                System.out.println("awddddddddddd");
                return resource;
            } else {
                throw new IOException("Could not read file: " + fileName);
            }
        } catch (IOException e) {
            throw new IOException("Could not read file: " + fileName);
        }
    }
    
    private Path loadPath(String fileName) {
        return rootLocation.resolve(fileName);
    }

    
	@Override
	public String saveProfile(MultipartFile profile){
		String profilePath;

		try {
			if (profile.isEmpty()) {
				throw new IOException();
			}
			String fileName = profile.getOriginalFilename();
			String extension = fileName.split("\\.")[1];
			if (!MediaUtils.containsImageMediaType(extension)) {
				throw new IOException();
			}
			profilePath = UploadFileUtils.fileSave(rootLocation.toString(), profile);
			if (profilePath.toCharArray()[0] == '/') {
				profilePath = profilePath.substring(1);
			}

		} catch (IOException e) {
			profilePath = "basicprofile.jpg";
			
		}

		return profilePath;
	}
}