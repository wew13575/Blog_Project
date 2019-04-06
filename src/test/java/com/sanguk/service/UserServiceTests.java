package com.sanguk.service;



import com.sanguk.domain.UserVO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { com.sanguk.config.RootConfig.class })
@Log4j
public class UserServiceTests{

    @Autowired
    private UserServiceimpl userServiceimpl;



    @Test
    public void registerUserTest(){
        UserVO uservo = new UserVO();
        uservo.setUserid("dntkddnr");
        uservo.setUserpw("tfn12127");
        uservo.setUserName("sanguk");

        userServiceimpl.register(uservo);

    }
}


