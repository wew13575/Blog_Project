package com.sanguk.controller;

import lombok.extern.log4j.Log4j;

import java.security.Principal;

import com.sanguk.domain.ArticleVO;
import com.sanguk.domain.UserVO;
import com.sanguk.mapper.UserMapper;
import com.sanguk.service.ArticleServiceimpl;
import com.sanguk.util.ProfileUtils;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/article")
@Log4j
public class ArticleController {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	ArticleServiceimpl articleServiceimpl;

	@GetMapping("/write") // TODO 게시글 에디터 요청 articleid 있으면 수정
	public String getEditorPage(Model model, @RequestParam(value = "articleid", defaultValue = "0") String articleid) throws Exception {

		model.addAttribute("uservo", ProfileUtils.getProfile(userMapper));

		if (Integer.parseInt(articleid) == 0) {
			return "summernote";
		}

		return "summernote";// 수정시
	}

	@PostMapping("/write") // TODO 게시물 게시 articleid 있으면 수정
	public String postArticle(ArticleVO articlevo, String tag) {
		log.info(articlevo.toString());

		if (articlevo.getBoardType()==2) {
			articleServiceimpl.setInfo(articlevo);
			return "redirect:/";
		}
		articleServiceimpl.registerArticle(articlevo, tag);
		return "redirect:/";
	}

	@GetMapping("/post") // TODO 클릭 게시물 요청
	public String getArticle(int articleid) {

		return "index";
	}

	@DeleteMapping("/post") // TODO 게시물 삭제
	public String deleteArticle(int ArticleId) {

		return "index";
	}

	
	@GetMapping("/search") // TODO 게시물 검색 목록 요청
	public String getSearchArticles(String keyword, int pageNum) {

		return "index";
	}

}