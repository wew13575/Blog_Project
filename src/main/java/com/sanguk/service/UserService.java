package com.sanguk.service;

import com.sanguk.domain.UserVO;

import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    public void register(UserVO userVO);

    public String saveProfile(MultipartFile profile) throws Exception;

    public int getFailcnt(String userid);

    public void addFailcnt(String userid);

    public void resetFailcnt(String userid); 

    public void setUserDisable(String userid); 

    public boolean checkid(String userid); 

    
}