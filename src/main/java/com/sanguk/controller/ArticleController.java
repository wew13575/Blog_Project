package com.sanguk.controller;

import lombok.extern.log4j.Log4j;

import java.util.List;

import com.sanguk.domain.ArticleVO;
import com.sanguk.domain.TagVO;
import com.sanguk.domain.UserVO;
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

	@GetMapping("/write") // TODO 게시글 에디터 요청 articleid 있으면 수정
	public String getregisterView() {
		
	   	return "showeditor";// 수정시
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
		return "redirect:/";
	}








	@GetMapping("/modify") 
	public String getupdateView(Model model,@RequestParam(value = "articleid", defaultValue = "-1") String articleid) {
		
		if(articleid.equals("-1")){
			return "redirect:/";
		}

		UserVO userVO = ProfileUtils.getProfile(userMapper);
		ArticleVO articleVO = articleService.getArticle(Integer.parseInt(articleid));

		if(!ArticleUtils.isArticleAuthor(articleVO, userVO)){
			return "redirect:/";
		}

		String tagstring =" ";
		for(TagVO tag : articleVO.getTaglist()){
			tagstring = tagstring +" #"+ tag.getTag();
		}

		model.addAttribute("articlevo", articleVO);  
		model.addAttribute("tagstring", tagstring);
		return "showmodify";// 수정가능
	}


	@PostMapping("/modify") 
	@Transactional
	public String updateArticle(ArticleVO articleVO, String tag) {
		
		UserVO userVO = ProfileUtils.getProfile(userMapper);

		if(!ArticleUtils.isArticleAuthor(articleVO, userVO)){
			return "redirect:/";
		}

		articleService.updateArticle(articleVO);
		articleService.deleteTag(articleVO.getId());
		articleService.registerTag(articleVO.getId(), tag);
		return "redirect:/article/post?articleid="+articleVO.getId();// 수정시
	}





	@PostMapping("/delete")
	@Transactional
	public String deleteArticle(@RequestParam(value = "articleid", defaultValue = "-1") String articleId) {
		
		if(articleId.equals("-1")){
			return "redirect:/";
		}

		UserVO userVO = ProfileUtils.getProfile(userMapper);
		ArticleVO articleVO = articleService.getArticle(Integer.parseInt(articleId));

		if(!ArticleUtils.isArticleAuthor(articleVO, userVO)){
			return "redirect:/";
		}


		articleService.deleteArticle(articleVO.getId());
		return "redirect:/";// 수정시
	}



	@GetMapping("/post")
	public String getArticle(Model model, @RequestParam(value = "articleid", defaultValue = "-1") String articleId) {
		
		if(articleId.equals("-1")){
			log.info("이게떴니?");
			return "redirect:/";
		}

		ArticleVO articleVO = articleService.getArticle(Integer.parseInt(articleId));
		if(articleVO==null){
			return "redirect:/"; //TODO 없는 글 처리 페이지 만들기~~
		}

		model.addAttribute("articlevo", articleVO);
		log.info(articleVO);
		return "showarticle";
	}








	@GetMapping("/list") // TODO 게시물 검색 목록 요청
	@ResponseBody
	public ResponseEntity<?> getArticleList(int boardType, int pageNum) {
		
		
		log.info(boardType+""+pageNum);
		
		if(!(boardType==1||boardType==0)){
			return ResponseEntity.badRequest().build();
		}
		
		List<ArticleVO> articleList =  articleService.getArticleList(boardType);
		int Listlength = articleList.size();
		int fromIndex = 6*pageNum;
		int toIndex = 6+6*pageNum;

		if(pageNum<0){
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
	
		return ResponseEntity.ok().body(articleList);
	}


	
	@GetMapping("/search") // TODO 게시물 검색 목록 요청
	public String getSearchArticles(String keyword, int pageNum) {

		return "showindex";
	}

}