package com.sanguk.service;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.sanguk.domain.CommentVO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { com.sanguk.config.RootConfig.class })
@Log4j
public class CommentServiceTests{



    @Autowired
    CommentServiceimpl commentService;


    @Test
    @Transactional
    public void registerTest(){

        CommentVO commentVO = new CommentVO();
        commentVO.setArticleid(28);
        commentVO.setAuthor("wew1355");
        commentVO.setContent("안녕~!~123!");

        commentService.registerComment(commentVO);
        log.info(commentVO);//preventinsert
    }

    @Test
    @Transactional
    public void deleteTest(){
        
        commentService.deleteComment(12);
    }

}