package com.sanguk.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Log4j
public class UploadFileUtils {

    
    /**
     * @param filePath
     * @param multipartFile
     * @return 생성된 파일 명(유일한 값)
     * @throws IllegalStateException
     * @throws IOException
     */
    public static String fileSave(String uploadPath, MultipartFile file) throws IllegalStateException, IOException {

        File uploadPathDir = new File(uploadPath);

        if (!uploadPathDir.exists()) {
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
     * @param fileName 확장자를 포함한 파일 명
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

    /**
     * 파일을 저장하고 파일 명을 반환
     * 
     * @param filePath
     * @param fileExt
     * @param savePath
     * @param saveName
     * @return String 파일 명
     * @throws IllegalStateException
     * @throws IOException
     */
    public static String imageCrop(String filePath, String fileExt, String savePath, String saveName,int width, int height, String namePrefix) throws IllegalStateException, IOException { // 저장된 원본파일로부터
                                                                                                    // BufferedImage 객체를
                                                                                                    // 생성합니다.
        BufferedImage srcImg = ImageIO.read(new File(filePath));
        
        // 썸네일의 너비와 높이 입니다.
        int dw = width, dh = height;
        // 원본 이미지의 너비와 높이 입니다.
        int ow = srcImg.getWidth();
        int oh = srcImg.getHeight();
        // 원본 너비를 기준으로 하여 썸네일의 비율로 높이를 계산합니다.
        int nw = ow;
        int nh = (ow * dh) / dw;
        // 계산된 높이가 원본보다 높다면 crop이 안되므로
        // 원본 높이를 기준으로 썸네일의 비율로 너비를 계산합니다.
        if (nh > oh) {
            nw = (oh * dw) / dh;
            nh = oh;
        }
        // 계산된 크기로 원본이미지를 가운데에서 crop 합니다.
        BufferedImage cropImg = Scalr.crop(srcImg, (ow - nw) / 2, (oh - nh) / 2, nw, nh);
        // crop된 이미지로 썸네일을 생성합니다.
        BufferedImage destImg = Scalr.resize(cropImg, dw, dh);
        // 썸네일을 저장합니다. 이미지 이름 앞에 "THUMB_" 를 붙여 표시했습니다.
        String thumbName =  savePath +"/"+ namePrefix + saveName;
        File thumbFile = new File(thumbName);
        log.info(thumbName);
        ImageIO.write(destImg, fileExt.toUpperCase(), thumbFile);
        return namePrefix + saveName;
    }


}