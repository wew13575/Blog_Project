package com.sanguk.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sanguk.service.UserService;
import com.sanguk.service.UserServiceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.Data;
import lombok.extern.log4j.Log4j;

@Log4j
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    
    @Autowired
    public UserServiceimpl userService;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        

        String username = request.getParameter("loginid");

        log.warn("############Login Seccesed##############");
        log.warn("##########"+request.getParameter("loginid")+"#################");
        
        


        userService.resetFailcnt(request.getParameter("loginid"));
        response.sendRedirect("/");
    }
}
