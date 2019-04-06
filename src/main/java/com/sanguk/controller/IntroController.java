package com.sanguk.controller;

import lombok.extern.log4j.Log4j;

import com.sanguk.domain.UserVO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/intro")
@Log4j
public class IntroController {


	@GetMapping("/")
	public String getIntro(){
		
		return "intro";
    }

    @GetMapping("/editor")//TODO 게시글 에디터 요청
	public String getEditorPage(){
		
		return "editor";
    }   

    @PostMapping("/editor")//TODO 게시글 게시
	public String postIntro(){
		
		return "editor";
    }   


    @DeleteMapping("/")
    public String DeleteIntro(){

        return "intro";
    }
	
}
