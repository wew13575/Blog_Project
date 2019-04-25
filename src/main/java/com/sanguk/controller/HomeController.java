package com.sanguk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class HomeController {


	@GetMapping("/")
	public String index(Model model) {
		return "showhome";
	}
	
	@GetMapping("/blog") // TODO 게시물 목록 요청
	public String getBlogPage(Model model, @RequestParam(value = "pageNo", defaultValue = "0") int pageNo) {
		log.info(pageNo+"");
		model.addAttribute("pageno", pageNo);
		return "showblog";
	}

	@GetMapping("/board") // TODO 게시물 목록 요청
	public String getBoardPage(Model model, @RequestParam(value = "pageNo", defaultValue = "0") int pageNo) {
		model.addAttribute("pageno", pageNo);
		return "showboard";
	}

	@GetMapping("/info") // TODO 게시물 목록 요청 모델을 받아서 페이지넘이 없으면 0 있으면 고대로 넣어준당
	public String getInfoPage() {

		return "showinfo";
	}

}
