package com.sanguk.controller;

import java.util.Locale;

import com.sanguk.domain.UserDTO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;



/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/")
@Log
public class HomeController {


	@GetMapping("/ex01")
	public String ex01(UserDTO dto){
		
		log.info(""+dto);

		return "ex01";
	}
	
}
