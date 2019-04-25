package com.sanguk.controller;

import com.sanguk.domain.UserVO;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { com.sanguk.config.RootConfig.class })
@Log4j
public class HomeControllerTests{

    @Autowired
    HomeController homeController;


    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception{
        mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
    }
    




    @Test
    public void testHomeController() throws Exception{
        RequestBuilder reqBuilder = MockMvcRequestBuilders.get("/");
        mockMvc.perform(reqBuilder).andDo(print()); 



    }    

    @Test
    @WithUserDetails("dntkddnr123")
    public void testInitialDisplay() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
        .andDo(print());
    }

    @Test
    public void blogmethodTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/blog?pageNo=2"))
        .andDo(print());
    }
    
}