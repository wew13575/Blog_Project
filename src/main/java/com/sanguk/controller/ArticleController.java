package com.sanguk.controller;

import lombok.extern.log4j.Log4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public String getregisterView(Model model) {
		
		List<TagVO> taglist = articleService.getTagRankedList();
		if(!taglist.isEmpty()){
			model.addAttribute("taglist", taglist);
		}

	   	return "article/showeditor";// 수정시
	}


	@PostMapping("/write")
	@Transactional
	public String registerArticle(ArticleVO articleVO, String tag) {
		log.info(articleVO.toString());

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

		List<TagVO> taglist = articleService.getTagRankedList();
		if(!taglist.isEmpty()){
			model.addAttribute("taglist", taglist);
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
		if (articleVO.getBoardType() == 2) {
			articleService.setInfo(articleVO);
			log.info("이거실행됨");
			return "redirect:/info";
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
		

		log.info(articleId);
		if(articleId.equals("-1")){  
			throw new IncorrectAuthorException("잘못된 접근");
		}

		ArticleVO articleVO = articleService.getArticle(Integer.parseInt(articleId));
		if(articleVO==null){
			throw new ArticleNotPoundException("잘못된 접근");
		}
		if(articleVO.getBoardType()==2){
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
		Map<Integer,Object> responseResult = new HashMap<>();

		if(!(type==1||type==0)){
			responseResult.put(0,"Result.WRONGREQUEST");
			return ResponseEntity.ok().body(responseResult);
		}

		List<ArticleVO> articleList =  articleService.getArticleList(type);
		int Listlength = articleList.size();
		int fromIndex = 6*pageNo;
		int toIndex = 6+6*pageNo;

		if(pageNo<0){
			responseResult.put(0,"Result.WRONGREQUEST");
			return ResponseEntity.ok().body(responseResult);
		}

		if(fromIndex>Listlength){
			responseResult.put(0,"Result.NODATA");
			return ResponseEntity.ok().body(responseResult);
		}
		if(toIndex>Listlength){
			toIndex=Listlength;
		}

		List<ArticleVO> responseList = articleList.subList(fromIndex, toIndex);

		if(responseList.isEmpty()){
			responseResult.put(0,"Result.NODATA");
			return ResponseEntity.ok().body(responseResult);
		}
	
		responseResult.put(0,"Result.OK");
		responseResult.put(1,responseList);
		
		return ResponseEntity.ok().body(responseResult);
	}





	@GetMapping("/search") // TODO 게시물 검색 목록 요청
	@ResponseBody
	public ResponseEntity<?> getSearchResult(int type, String keyword) {
		
		Map<Integer,Object> responseResult = new HashMap<>();
		///type0 = Tag
		///type1 = content ,, or title,, or tags..
		if(!(type==1||type==0)||keyword.equals("")){
			responseResult.put(0,"Result.WRONGREQUEST");
			return ResponseEntity.ok().body(responseResult);
		}

		List<ArticleVO> articleList =  articleService.getArticleList(3);  //this will return articles of all type
		List<ArticleVO> responseList = type==0? ArticleUtils.getTagedArticleResult(keyword, articleList) : ArticleUtils.getSearchResult(keyword, articleList);
		log.info(responseList);

		if(responseList.isEmpty()){
			responseResult.put(0,"Result.NODATA");
			return ResponseEntity.ok().body(responseResult);
		}

		
		responseResult.put(0,"Result.OK");
		responseResult.put(1,responseList);
	//검색결과에 대한 페이징 처리는 클라이언트 렌더링.
		return ResponseEntity.ok().body(responseResult);
	}

	


}