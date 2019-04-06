package com.sanguk.controller;

import lombok.extern.log4j.Log4j;

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
	public String getArticleList(){
		
		return "index";
    }
    
    @GetMapping("/keyword")//TODO 게시물 검색 목록 요청
	public String getSearchArticles(){
		
		return "index";
    }

    @GetMapping("/{ArticleId}") //TODO 클릭 게시물 요청
	public String getArticle(){
		
		return "index";
    }	
    
    

    @GetMapping("/editor")//TODO 게시글 에디터 요청
	public String getEditorPage(){
		
		return "editor";
    }   
    
    @PostMapping("/editor")//TODO 게시물 게시
	public String postArticle(){
		
		return "index";
    }  
    
    @GetMapping("/editor/{ArticleId}") //TODO 게시물 수정 내용 표시
	public String getArticlesToModify(){
		
		return "index";
    }	
    
    @PostMapping("/editor/{ArticleId}")//TODO 게시물 수정 
	public String postModifiedArticle(){
		
		return "index";
    }

    @DeleteMapping("/{ArticleId}")//TODO 게시물 삭제 
	public String deleteArticle(@PathVariable String ArticleId){
		
		return "index";
	}
	
}
