package com.sanguk.controller;

import lombok.extern.log4j.Log4j;

import com.sanguk.domain.UserVO;
import com.sanguk.mapper.UserMapper;
import com.sanguk.security.domain.CustomUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/")
@Log4j
public class HomeController {


	@Autowired
	private UserMapper userMapper;


	@GetMapping("/home")
	public String index(Model model,@AuthenticationPrincipal CustomUser customUser){

		try {
			if(!customUser.getUsername().	isEmpty()){
			UserVO uservo = userMapper.read(customUser.getUsername());
			model.addAttribute("user", uservo);}
			
		log.info("######################Login OK########################");
		log.info(customUser.toString());
		log.info("######################Login OK########################");
			
		} catch (Exception e) {
			log.warn(e.getMessage());
		}
		return "index";
	}

	@GetMapping("/")
	public String index2(){
		return "index";
	}	//로그인 정보가 없을때의 매핑

}
