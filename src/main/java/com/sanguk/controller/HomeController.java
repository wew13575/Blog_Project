package com.sanguk.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.sanguk.domain.ArticleVO;
import com.sanguk.domain.TagVO;
import com.sanguk.exception.ArticleNotPoundException;
import com.sanguk.service.ArticleServiceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j;



/**
 * / 매핑 컨트롤러 클래스입니다.
 * 
 * @author Sanguk
 * @version 1.0.0
 */
@Controller
@Log4j
public class HomeController {

	@Autowired
	ArticleServiceimpl articleService;



	/**
	 * 최근 3 게시물, 조회수 TOP 3게시물과 함께 메인 페이지 반환
	 * @param model
	 * @return .jsp file
	 */
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



	/**
	 * 블로그 페이지 반환
	 * @param model
	 * @param pageNo
	 * @return .jsp file
	 */
	@GetMapping("/blog") // TODO 게시물 목록 요청
	public String getBlogPage(Model model, @RequestParam(value = "pageNo", defaultValue = "0") int pageNo) {
		log.info(pageNo + "");
		model.addAttribute("pageno", pageNo);
		return "showblog";
	}


	/**
	 * 게시판 페이지 반환
	 * @param model
	 * @param pageNo
	 * @return .jsp file
	 */
	@GetMapping("/board") // TODO 게시물 목록 요청
	public String getBoardPage(Model model, @RequestParam(value = "pageNo", defaultValue = "0") int pageNo) {
		model.addAttribute("pageno", pageNo);
		return "showboard";
	}

	/**
	 * 포트폴리오 페이지 반환
	 * @param model
	 * @return .jsp file
	 */
	@GetMapping("/info") // TODO 게시물 목록 요청 모델을 받아서 페이지넘이 없으면 0 있으면 고대로 넣어준당
	public String getInfoPage(Model model) {


		ArticleVO articleVO = articleService.getArticle(8);
		if(articleVO==null){
			throw new ArticleNotPoundException("잘못된 접근");
		}

		model.addAttribute("articlevo", articleVO);

		return "showinfo";
	}

	/**
	 * 검색 페이지 반환
	 * @param type
	 * @param keyword
	 * @param pageNo
	 * @param model
	 * @return .jsp file
	 */
	@GetMapping("/search") // TODO 게시물 목록 요청 모델을 받아서 페이지넘이 없으면 0 있으면 고대로 넣어준당
	public String getSearch(int type, String keyword,@RequestParam(value = "pageNo", defaultValue = "0") int pageNo, Model model) {


		if(keyword.equals("") || keyword.trim().length()<2){
			throw new ArticleNotPoundException("검색어 오류");
		}


		model.addAttribute("type", type);
		model.addAttribute("pageno", pageNo);
		model.addAttribute("keyword", keyword);
		return "article/searchresult";
	}

}
