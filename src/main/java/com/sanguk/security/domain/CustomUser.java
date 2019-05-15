package com.sanguk.security.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import com.sanguk.domain.UserVO;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * Spring Security CustomUser 도메인 클래스 입니다.
 * 
 * @author Sanguk
 * @version 1.0.0
 */

public class CustomUser extends User{


    private static final long serialVersionUID = 1L;


    private UserVO userVO;


    /**
     * 
     * @param username
     * @param password
     * @param authorities
     */
    public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities){
        super(username, password, authorities);
    }


    /**
     * 
     * @param vo
     */
    public CustomUser(UserVO vo){
        super(vo.getUserid(),vo.getUserpw(),vo.getAuthList().stream().map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));

        this.userVO = vo;
    }
    
}
