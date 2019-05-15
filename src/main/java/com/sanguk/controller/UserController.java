package com.sanguk.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sanguk.domain.AuthVO;
import com.sanguk.domain.UserVO;
import com.sanguk.mapper.UserMapper;
import com.sanguk.service.UploadServiceimpl;
import com.sanguk.service.UserService;
import com.sanguk.service.UserServiceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/user")
@Log4j
public class UserController{
	

	
	@Autowired
	private UserServiceimpl userService; 

	@Autowired
	private UploadServiceimpl uploadService;
	
	@PostMapping("/register")
	@ResponseBody //TODO 테스트 해보고 없앨것!
	@Transactional
	public void register(@RequestBody UserVO userVO) {
		userService.register(userVO);
	}



	
	@PostMapping("/saveprofile")
    @ResponseBody
    public ResponseEntity<?> saveprofile(@RequestParam("file") MultipartFile file) {
			log.info(file.getOriginalFilename());
			return ResponseEntity.ok().body(uploadService.saveProfile(file));
    }


	
	@PostMapping("/checkid")
	public @ResponseBody boolean checkid(@RequestParam("id") String id) {

		boolean checkStatus = userService.checkid(id);
		return checkStatus;
	}

	@PostMapping("/checknick")
	public @ResponseBody boolean checknick(@RequestParam("nick") String nick) {

		boolean checkStatus = userService.checknick(nick);
		return checkStatus;
	}





	@RequestMapping(value = "/logout.do", method = RequestMethod.POST)
	 public String logout(HttpServletRequest request, HttpServletResponse response) throws ClassCastException 
	 {
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		   if (auth != null){ new SecurityContextLogoutHandler().logout(request, response, auth);
		 } return "redirect:/";
	}

}
