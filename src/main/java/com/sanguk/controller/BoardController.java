package com.sanguk.controller;

import lombok.extern.log4j.Log4j;

import java.security.Principal;

import com.sanguk.domain.ArticleVO;
import com.sanguk.domain.UserVO;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
@Log4j
public class BoardController {

	@GetMapping("/blog") // TODO 게시물 목록 요청
	public String getBlogPage(int pageNum) {
		if (pageNum == 0) {
			// 첫페이지로 리다이렉트ㄱㄱ
		}
		return "showindex";

	}

	@GetMapping("/board") // TODO 게시물 목록 요청
	public String getBoardPage(int pageNum) {
		if (pageNum == 0) {
			// 첫페이지로 리다이렉트ㄱㄱ
		}
		return "showindex";
	}

	@GetMapping("/info") // TODO 게시물 목록 요청
	public String getInfoPage(int pageNum) {
		if (pageNum == 0) {
			// 첫페이지로 리다이렉트ㄱㄱ
		}
		return "showindex";
	}


}
