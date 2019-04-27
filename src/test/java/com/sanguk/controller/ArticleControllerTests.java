package com.sanguk.controller;

import com.sanguk.domain.UserVO;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { com.sanguk.config.RootConfig.class })
@Log4j
public class ArticleControllerTests{

    @Autowired
    ArticleController articleController;


    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception{
        mockMvc = MockMvcBuilders.standaloneSetup(articleController).build();
    }
    




    @Test
    @WithUserDetails("wew1355")
    public void testArticleController() throws Exception{
        RequestBuilder reqBuilder = MockMvcRequestBuilders.get("/article/modify?articleid=14");
        mockMvc.perform(reqBuilder).andDo(print()); 



    }    

    
    @Test
    @WithUserDetails("wew1355")
    public void updateArticleTest() throws Exception{
        RequestBuilder reqBuilder = MockMvcRequestBuilders.post("/article/modify?articleid=14");
        mockMvc.perform(reqBuilder).andDo(print()); 



    }    

    @Test
    @WithUserDetails("dntkddnr123")
    public void initialDisplay() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/article/post?articleid=8"))
        .andDo(print());
    }
    

    @Test
    @WithUserDetails("wew1355")
    public void articleListTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/article/list?type=1&pageNo=0"))
        .andDo(print());
    }
}