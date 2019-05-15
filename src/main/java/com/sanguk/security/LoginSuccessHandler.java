package com.sanguk.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sanguk.service.UserServiceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j;

/**
 * Spring Security LoginSuccess 처리 클래스 입니다.
 * 
 * @author Sanguk
 * @version 1.0.0
 */

@Log4j
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    
    @Autowired
    public UserServiceimpl userService;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        

        log.warn("############Login Seccesed##############");
        log.warn("##########"+request.getParameter("loginid")+"#################");
        
        


        userService.resetFailcnt(request.getParameter("loginid"));
        response.sendRedirect("/");
    }
}
