package com.sanguk.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sanguk.domain.AuthVO;
import com.sanguk.domain.UserVO;
import com.sanguk.mapper.UserMapper;
import com.sanguk.service.UserService;
import com.sanguk.service.UserServiceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/user")
public class UserController{
	

	
	@Autowired
	private UserServiceimpl userservice; 
	
	@PostMapping("/register")
	public String register(UserVO userVO, @RequestParam("file") MultipartFile profile) throws Exception {
		userservice.register(userVO,profile);
		return "redirect:/";
	}



	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	 public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception 
	 {
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		   if (auth != null){ new SecurityContextLogoutHandler().logout(request, response, auth);
		 } return "redirect:/";
	}

}
