package com.sanguk.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.sanguk.service.UploadServiceimpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { com.sanguk.config.RootConfig.class })
@Log4j
public class UploadUtilTests {

    @Autowired
    String uploadPath;

    @Autowired
    UploadServiceimpl uploadService;

/* 
    @Test
    public void teetete() {
        Path rootLocation = Paths.get(uploadPath);
        System.out.println(rootLocation.toString());
    } */


    @Test
    public void tess(){
        String filePath = "c:\\image\\589e74e0e226419a8e6ee07a5603fa21.jpg";
        System.out.println(filePath);
        System.out.println(filePath.substring(uploadPath.length()).replace(File.separatorChar, '/'));
    }
/* 
    @Test
    public void fileUploadTest() {
        try {
            uploadService.loadAsResource("c:\\image\\2019\\03\\10\\201e6f5f9de849a19fde9d6921877908.jpg");
        } catch (Exception e) {
            // TODO Auto-generated catch block
        System.out.println("예외처리됨");
            e.printStackTrace();
        }
} 
 */


    @Test
    public void makethumnailtest(){
        
			try {
				log.info(UploadFileUtils.imageCrop("c:/image/c4d6d1ed5e234b5c98ed50fa7bdded40.jpg","jpg", "c:/thumnail/","c4d6d1ed5e234b5c98ed50fa7bdded40.jpg",320,240,"THUMB_"));
			} catch (Exception e) {
				log.warn(e.getStackTrace());
				//articleVO.setThumnailpath("basicthumnail.jpg");
			}
    }
}


