package com.sanguk.controller;

import lombok.extern.log4j.Log4j;

import java.security.Principal;

import com.sanguk.domain.UserVO;
import com.sanguk.mapper.UserMapper;
import com.sanguk.security.domain.CustomUser;
import com.sanguk.util.ProfileUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
@Log4j
public class HomeController {

	@Autowired
	private UserMapper userMapper;

	@GetMapping("/")
	public String index(Model model) {
		return "showindex";
	}

}
