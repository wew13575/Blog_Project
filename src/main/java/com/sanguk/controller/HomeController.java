package com.sanguk.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.sanguk.domain.ArticleVO;
import com.sanguk.domain.TagVO;
import com.sanguk.service.ArticleServiceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class HomeController {

	@Autowired
	ArticleServiceimpl articleService;

	@GetMapping("/")
	public String index(Model model) {

		List<ArticleVO> blogList = articleService.getArticleList(0);
		List<ArticleVO> boardList = articleService.getArticleList(1);
		List<TagVO> taglist = articleService.getTagRankedList();
 
		if (!blogList.isEmpty()) {
			List<ArticleVO> subList = new ArrayList<>(blogList.size() <= 3 ? blogList : blogList.subList(0, 3));
			model.addAttribute("bloglist", subList);

			

		Collections.sort(blogList, new Comparator<ArticleVO>() {
			@Override
			public int compare(ArticleVO s1, ArticleVO s2) {
				if (s1.getViewcnt() < s2.getViewcnt()) {
					return 1;
				} else if (s1.getViewcnt() > s2.getViewcnt()) {
					return -1;
				}
				return 0;

				
			}
		}); 

		model.addAttribute("bestlist", blogList.size() <= 3 ? blogList : blogList.subList(0, 3));
		} 

		 if (!boardList.isEmpty()) {
			model.addAttribute("boardlist", boardList.size() <= 3 ? boardList : boardList.subList(0, 3));
		}  
		if(!taglist.isEmpty()){
			model.addAttribute("taglist", taglist);
		}


		return "showhome";
	}

	@GetMapping("/blog") // TODO 게시물 목록 요청
	public String getBlogPage(Model model, @RequestParam(value = "pageNo", defaultValue = "0") int pageNo) {
		log.info(pageNo + "");
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
