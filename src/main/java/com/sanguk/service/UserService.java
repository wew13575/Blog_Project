package com.sanguk.service;

import com.sanguk.domain.UserVO;


public interface UserService {
    public void register(UserVO userVO);

    public int getFailcnt(String userid);

    public void addFailcnt(String userid);

    public void resetFailcnt(String userid); 

    public void setUserDisable(String userid); 

    public boolean checkid(String userid); 

    public boolean checknick(String nick);

    
}