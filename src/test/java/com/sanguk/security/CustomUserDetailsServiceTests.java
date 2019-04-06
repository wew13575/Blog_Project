package com.sanguk.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { com.sanguk.config.RootConfig.class,com.sanguk.config.SecurityConfig.class, })
@Log4j
public class CustomUserDetailsServiceTests{


    @Autowired
    private CustomUserDetailsService customUserDetailsService;


    @Test
    public void voInjectionTest(){
    
        String userName = "wew13575";
        customUserDetailsService.loadUserByUsername(userName);
    }
    
}