package com.sanguk.util;

import com.sanguk.domain.UserVO;
import com.sanguk.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;


public class ProfileUtils{


    public static UserVO getProfile(UserMapper userMapper) throws Exception{
        
        try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			User user = (User) authentication.getPrincipal();
            UserVO uservo = userMapper.read(user.getUsername());
            return uservo;
            
        } catch (Exception e) {
            return null;
        }
    }
}