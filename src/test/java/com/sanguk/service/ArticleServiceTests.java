package com.sanguk.service;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.sanguk.domain.ArticleVO;

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
public class ArticleServiceTests{



    @Autowired
    ArticleServiceimpl articleService;


    @Test
	@Transactional
    public void registerTest(){
        ArticleVO ar = new ArticleVO();
        ar.setAuthor("dntkddnr123");
        ar.setBoardType(2);
        ar.setContent("태그입asd력 테스트용입니다");
        ar.setTitle("<>>>");
        ar.setThumnailpath(null);

        articleService.registerArticle(ar);
        log.info(ar.getId());
        articleService.registerTag(ar.getId(), "#aa#aa#aa");
    }


    @Test
    public void Taglisttest(){
        log.info(articleService.getArticle(8));
    }
}