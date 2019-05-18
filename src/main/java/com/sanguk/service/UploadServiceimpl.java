package com.sanguk.service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Random;


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
    private Path imageLocation;
    @Autowired
    private Path profileLocation;
    @Autowired
    private int numOfBasicProfile;




    @Override
    public String saveImage(MultipartFile file) throws IOException {
        try {
            if (file.isEmpty()) {
                throw new IOException("Failed to store empty file " + file.getOriginalFilename());
            }
            
            String saveFileName = UploadFileUtils.fileSave(imageLocation.toString(), file);
            
            if (saveFileName.toCharArray()[0] == '/') {
                saveFileName = saveFileName.substring(1);
            }
            
            
            return saveFileName;
        } catch (IOException e) {
            throw new IOException("Failed to store file " + file.getOriginalFilename(), e);
        }
    }

    @Override
    public Resource loadAsResource(String fileName,Path path) throws IOException {
        try {
            
            Path file = loadPath(path.toString()+"/"+fileName,path);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                log.info("여기1");
                throw new IOException("Could not read file: " + fileName);
            }
        } catch (IOException e) {
            log.info("여기2ㄴ");
            throw new IOException("Could not read file: " + fileName);
        }
    }
    
    private Path loadPath(String fileName,Path path) {
        log.info(fileName);
        return path.resolve(fileName);
    }

    
	@Override
	public String saveProfile(MultipartFile profile){
        String profilePath;
        String uploadedName;
        String prefix = "PROFILE_";

		try {
            log.info("0번");
			if (profile.isEmpty()) {
				throw new IOException();
			}
			String fileName = profile.getOriginalFilename();
			String extension = fileName.split("\\.")[1];
			if (!MediaUtils.containsImageMediaType(extension)) {
				throw new IOException();
            }
            uploadedName = UploadFileUtils.fileSave(imageLocation.toString(), profile);
            log.info(uploadedName);
            profilePath = UploadFileUtils.imageCrop(imageLocation.toString() +"/"+ uploadedName, extension,
            profileLocation.toString(), uploadedName,60,60,prefix);
            log.info("여기야"+profilePath);
			if (profilePath.toCharArray()[0] == '/') {
				profilePath = profilePath.substring(1);
			}

		} catch (IOException e) {
            Random rd = new Random();
			profilePath = prefix + rd.nextInt(numOfBasicProfile) +".jpg";
		}

		return profilePath;
	}
}