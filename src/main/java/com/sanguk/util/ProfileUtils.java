package com.sanguk.util;

import com.sanguk.domain.UserVO;
import com.sanguk.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import lombok.extern.log4j.Log4j;

@Log4j
public class ProfileUtils{


    public static UserVO getProfile(UserMapper userMapper){
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			User user = (User) authentication.getPrincipal();
            UserVO uservo = userMapper.read(user.getUsername());
            return uservo;
        }catch(ClassCastException e){
            log.info("로그인 정보 로드 실패.");
            return null;
        }
    }
}