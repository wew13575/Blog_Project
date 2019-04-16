package com.sanguk.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.sanguk.domain.UserVO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { com.sanguk.config.RootConfig.class })
@Log4j
public class UserServiceTests {

    @Autowired
    private UserServiceimpl userServiceimpl;

    @Test
    public void registerUserTest() {
        String fileName = "test.txt";
        MockMultipartFile mockMultipartFile = new MockMultipartFile("user-file",fileName,
              "text/plain", "test data".getBytes());

        UserVO uservo = new UserVO();
        uservo.setUserid("dergw");
        uservo.setUserpw("tfn12egrerweg127");
        uservo.setUserName("sanggergweguk");

        try {
            userServiceimpl.register(uservo);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void checkidTest(){
        log.info(userServiceimpl.checkid("dn"));
    }
    
}


