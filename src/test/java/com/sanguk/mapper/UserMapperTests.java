package com.sanguk.mapper;

import com.sanguk.domain.UserVO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { com.sanguk.config.RootConfig.class })
@Log4j
public class UserMapperTests {
    @Autowired
    private UserMapper mapper;

    @Test
    public void testRead(){

        UserVO vo = mapper.read("wew13575");
        log.info(vo);

        vo.getAuthList().forEach(authVO -> log.info(authVO));
    }
}