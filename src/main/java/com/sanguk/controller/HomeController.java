package com.sanguk.controller;

import lombok.extern.log4j.Log4j;

import com.sanguk.domain.UserVO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/")
@Log4j
public class HomeController {


	@GetMapping("/")
	public String index(){
		
		return "index";
	}
	
}
