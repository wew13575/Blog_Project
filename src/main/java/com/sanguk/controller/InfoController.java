package com.sanguk.controller;

import lombok.extern.log4j.Log4j;

import com.sanguk.domain.UserVO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/info")
@Log4j
public class InfoController {


	@GetMapping("/")//TODO 소개 페이지 요청 + 데이터
	public String getArticleList(){
		
		return "index";
    }
    
}
