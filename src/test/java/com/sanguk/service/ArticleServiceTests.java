package com.sanguk.service;

import com.sanguk.domain.ArticleVO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { com.sanguk.config.RootConfig.class })
@Log4j
public class ArticleServiceTests{



    @Autowired
    ArticleServiceimpl articleService;


    @Test
    public void registerTest(){
        ArticleVO ar = new ArticleVO();
        ar.setAuthor("dntkddnr123");
        ar.setBoardType(2);
        ar.setContent("태그입asd력 테스트용입니다");
        ar.setTitle("제목d입니2다2");
        ar.setThumnailpath(null);

        articleService.registerArticle(ar, "#as#as#as#as#as");
    }


    @Test
    public void Taglisttest(){
        articleService.registerTag(1,"");
    }
}