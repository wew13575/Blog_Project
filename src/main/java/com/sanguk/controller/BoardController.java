package com.sanguk.controller;

import lombok.extern.log4j.Log4j;

import com.sanguk.domain.ArticleVO;
import com.sanguk.domain.UserVO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/board")
@Log4j
public class BoardController {


	@GetMapping("/list")//TODO 게시물 목록 요청
	public String getArticleList(int pageNum){
		if(pageNum==0){
			//첫페이지로 리다이렉트ㄱㄱ	
		}
		return "index";
    }
    
    @GetMapping("/search")//TODO 게시물 검색 목록 요청
	public String getSearchArticles(String keyword, int pageNum){
		
		return "index";
    }

    @GetMapping("/article") //TODO 클릭 게시물 요청
	public String getArticle(String articleid){
		
		return "index";
    }	
    
    
    

    @GetMapping("/editor")//TODO 게시글 에디터 요청 articleid 있으면 수정
	public String getEditorPage(String articleid){
		if(!articleid.equals("")){
			
		return "editor";
		}
		
		return "editor";
    }   
		
		
    @PostMapping("/editor/write")//TODO 게시물 게시 articleid 있으면 수정
	public String postArticle(ArticleVO articlevo){
		

		
		return "index";
    }  
    
    @DeleteMapping("/article")//TODO 게시물 삭제 
	public String deleteArticle(@PathVariable String ArticleId){
		
		return "index";
	}
	
}
