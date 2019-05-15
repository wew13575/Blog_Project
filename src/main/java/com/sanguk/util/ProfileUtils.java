package com.sanguk.util;

import com.sanguk.domain.UserVO;
import com.sanguk.mapper.UserMapper;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import lombok.extern.log4j.Log4j;

/**
 * Profile 처리 유틸 클래스 입니다.
 * 
 * @author Sanguk
 * @version 1.0.0
 */
@Log4j
public class ProfileUtils{


    /**
     * 시큐리티 콘텍스트에서 현재 로그인 된 사용자 반환
     * @param userMapper
     * @return UserVO
     * @exception ClassCastException
     */
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