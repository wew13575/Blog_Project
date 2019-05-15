package com.sanguk.security;

import com.sanguk.domain.UserVO;
import com.sanguk.mapper.UserMapper;
import com.sanguk.security.domain.CustomUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.extern.log4j.Log4j;

/**
 * Spring Security CustomUser 처리 클래스 입니다.
 * 
 * @author Sanguk
 * @version 1.0.0
 */

@Log4j
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{

        log.warn("Load User By UserName: "+ userName);

        UserVO vo = userMapper.read(userName);
        
        log.warn("queried by user mapper: " + vo);
    
        return vo == null ? null : new CustomUser(vo);
    }
    
}