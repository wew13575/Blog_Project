package com.sanguk.controller;

import java.util.Locale;

import com.sanguk.domain.AuthVO;
import com.sanguk.domain.UserVO;
import com.sanguk.mapper.UserMapper;
import com.sanguk.service.UserService;
import com.sanguk.service.UserServiceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController{
	

	
	@Autowired
	private UserServiceimpl userservice; 
	
	@PostMapping("/register")
	public String register(UserVO userVO) {
		userservice.register(userVO);
		return "redirect:/";
	}
	
}
