package com.sanguk.controller;

import lombok.extern.log4j.Log4j;

import java.util.List;

import com.sanguk.domain.ArticleVO;
import com.sanguk.domain.TagVO;
import com.sanguk.domain.UserVO;
import com.sanguk.exception.ArticleNotPoundException;
import com.sanguk.exception.IncorrectAuthorException;
import com.sanguk.mapper.UserMapper;
import com.sanguk.service.ArticleServiceimpl;
import com.sanguk.util.ArticleUtils;
import com.sanguk.util.ProfileUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/article")
@Log4j
public class ArticleController {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	ArticleServiceimpl articleService;

	@GetMapping("/write") 
	public String getregisterView() {
	   	return "article/showeditor";// 수정시
	}






	@PostMapping("/write")
	@Transactional
	public String registerArticle(ArticleVO articleVO, String tag) {
		log.info(articleVO.toString());

		if (articleVO.getBoardType() == 2) {
			articleService.setInfo(articleVO);
			return "redirect:/";
		}
		articleService.registerArticle(articleVO);
		articleService.registerTag(articleVO.getId(), tag);
		return "redirect:/article/post?articleid="+articleVO.getId();
	}








	@GetMapping("/modify") 
	public String getupdateView(Model model,@RequestParam(value = "articleid", defaultValue = "-1") String articleid) throws IncorrectAuthorException {
		
		if(articleid.equals("-1")){
			throw new IncorrectAuthorException("잘못된 접근");
		}

		UserVO userVO = ProfileUtils.getProfile(userMapper);
		ArticleVO articleVO = articleService.getArticle(Integer.parseInt(articleid));

		if(!ArticleUtils.isArticleAuthor(articleVO, userVO)){
			throw new IncorrectAuthorException("잘못된 접근");
		}

		String tagstring =" ";
		for(TagVO tag : articleVO.getTaglist()){
			tagstring = tagstring +" #"+ tag.getTag();
		}

		model.addAttribute("articlevo", articleVO);  
		model.addAttribute("tagstring", tagstring);
		return "article/showmodify";// 수정가능
	}


	@PostMapping("/modify") 
	@Transactional
	public String updateArticle(ArticleVO articleVO, String tag) throws IncorrectAuthorException {
		
		UserVO userVO = ProfileUtils.getProfile(userMapper);

		if(!ArticleUtils.isArticleAuthor(articleVO, userVO)){ 
			throw new IncorrectAuthorException("잘못된 접근");
		}

		articleService.updateArticle(articleVO);
		articleService.deleteTag(articleVO.getId());
		articleService.registerTag(articleVO.getId(), tag);
		return "redirect:/article/post?articleid="+articleVO.getId();// 수정시
	}





	@PostMapping("/delete")
	@Transactional
	public String deleteArticle(@RequestParam(value = "articleid", defaultValue = "-1") String articleId) throws IncorrectAuthorException{
		
		if(articleId.equals("-1")){ 
			throw new IncorrectAuthorException("잘못된 접근");
		}

		UserVO userVO = ProfileUtils.getProfile(userMapper);
		ArticleVO articleVO = articleService.getArticle(Integer.parseInt(articleId));

		if(!ArticleUtils.isArticleAuthor(articleVO, userVO)){ 
			throw new IncorrectAuthorException("잘못된 접근");
		}


		articleService.deleteArticle(articleVO.getId()); 
		return "redirect:/";// 수정시
	}



	@GetMapping("/post")
	public String getArticle(Model model, @RequestParam(value = "articleid", defaultValue = "-1") String articleId)throws IncorrectAuthorException,ArticleNotPoundException {
		

		
		if(articleId.equals("-1")){  
			throw new IncorrectAuthorException("잘못된 접근");
		}

		ArticleVO articleVO = articleService.getArticle(Integer.parseInt(articleId));
		if(articleVO==null){
			throw new ArticleNotPoundException("잘못된 접근");
		}

		model.addAttribute("articlevo", articleVO);
		log.info(articleVO);
		return "article/showarticle";
	}








	@GetMapping("/list") // TODO 게시물 검색 목록 요청
	@ResponseBody
	public ResponseEntity<?> getArticleList(int type, int pageNo) {
		
		
		log.info(type+""+pageNo);
		
		if(!(type==1||type==0)){
			return ResponseEntity.badRequest().build();
		}
		
		List<ArticleVO> articleList =  articleService.getArticleList(type);
		int Listlength = articleList.size();
		int fromIndex = 6*pageNo;
		int toIndex = 6+6*pageNo;

		if(pageNo<0){
			return ResponseEntity.badRequest().build();
		}

		if(fromIndex>Listlength){
			return ResponseEntity.badRequest().build();
		}
		if(toIndex>Listlength){
			toIndex=Listlength;
		}

		List<ArticleVO> responseList = articleList.subList(fromIndex, toIndex);

		if(responseList.isEmpty()){
			log.info("없다이기야");
		}
	
		return ResponseEntity.ok().body(responseList);
	}


	
	@GetMapping("/search") // TODO 게시물 검색 목록 요청
	public String getSearchArticles(String keyword, int pageNum) {

		return "showindex";
	}

}