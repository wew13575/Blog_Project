package com.sanguk.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sanguk.service.UserServiceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import lombok.extern.log4j.Log4j;

@Log4j
public class LoginFailureHandler implements AuthenticationFailureHandler {
    

    @Autowired
    public UserServiceimpl userService;

    
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException {
                

        String username = request.getParameter("loginid");
        
        boolean checkStatus = userService.checkid(username); //유저 존재하는지 검사
        
        if(!checkStatus){
            log.info("유저존재함");
        userService.addFailcnt(username);
        if(userService.getFailcnt(username)>=3){
            userService.setUserDisable(username);
            log.warn("########## Login disabled id: "+ username);
        }
    }
        response.sendRedirect("/");
    }


}

