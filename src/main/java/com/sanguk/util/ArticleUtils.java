package com.sanguk.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sanguk.domain.ArticleVO;
import com.sanguk.domain.UserVO;

import org.springframework.http.MediaType;

import lombok.extern.log4j.Log4j;

@Log4j
public class ArticleUtils {

	public static ArticleVO getArticleThumnail(ArticleVO articleVO, String uploadPath, String thumnailPath) {

		String thumnailContent = null;
		if (articleVO.getContentimgcnt() != 0) {
			Pattern p = Pattern.compile("<img src=\"/upload/image/[0-9a-zA-Z]+.(jpg|gif|png|bmp)\"");
			Matcher m = p.matcher(articleVO.getContent());
			String extractHashTag = null;

			while (m.find()) {
				thumnailContent = m.group().replace("<img src=\"/upload/image/", "").replace("\"", "");
				break;
			}
			try {
				String extension = thumnailContent.split("\\.")[1];
				articleVO.setThumnailpath(
						UploadFileUtils.makeThumbnail(uploadPath + thumnailContent, extension, thumnailPath, thumnailContent));
			} catch (IOException e) {
				log.warn(e.getMessage());
				articleVO.setThumnailpath("THUMB_basic.jpg");
			} catch(NullPointerException e){
				log.warn(e.getMessage());
				articleVO.setThumnailpath("THUMB_basic.jpg");
			}
		} else {
			articleVO.setThumnailpath("THUMB_basic.jpg");
		}

		return articleVO;
	}



	public static ArticleVO initArticleTitle(ArticleVO articleVO) {
		String title = articleVO.getTitle().replace("<", "").replace(">", "");
		if (title.length() == 0) {
			title = "제목 없음";
		}
		articleVO.setTitle(title);
		return articleVO;
	}



	public static boolean isArticleAuthor(ArticleVO articleVO, UserVO userVO) {

		if (articleVO == null || userVO == null) { // TODO error페이지 처리
			return false;
		}
		if (!userVO.getUserid().equals(articleVO.getAuthor())) { // TODO error페이지 처리
			log.info(userVO.getUserid() + articleVO.getAuthor());
			log.info("다른사람 글 수정불가");
			return false;
		}
		return true;
	}


	public static List<ArticleVO> getTagedArticleResult(String keyword, List<ArticleVO> articleList){

		List<ArticleVO> resultList = new ArrayList<>();
		for(ArticleVO article: articleList){
			if(article.getTaglist().stream().anyMatch(tag -> tag.getTag().equals(keyword))){
				resultList.add(article);
			}
		}
		return resultList;
	}




	public static List<ArticleVO> getSearchResult(String keyword, List<ArticleVO> articleList){

		List<ArticleVO> resultList = new ArrayList<>();

		articleList.removeIf(article -> {
			if(isMatchTitle(article.getTitle(),keyword)){
				resultList.add(article);
				return true;
			}
			return false;
		});

		articleList.removeIf(article -> {
			if(isMatchContent(article.getContent(),keyword)){
				resultList.add(article);
				return true;
			}
			return false;
		});

		log.info(articleList);

		return resultList;
	}	


	private static boolean isMatchTitle(String title, String keyword){

		Pattern p = Pattern.compile(keyword.trim());
		Matcher m = p.matcher(title.trim());

		while (m.find()) {
			return true;
		}
		return false;
	}	
	private static boolean isMatchContent(String content, String keyword){

		if(content==null || content.trim().equals("")){
			return false;
		} 


		String[] keywordList = keyword.split(" ");
		int numOfKeywords = keywordList.length;
		int numOfMatch = 0;

		content = content.replaceAll("<[^>]*>", "").trim();
		

		if(content.equals("")){
			return false;
		}

		Pattern p = Pattern.compile(keyword.trim());
		Matcher m = p.matcher(content);

		while (m.find()) {
			return true;
		}		
		
		
		if(numOfKeywords<=1){
			return false;
		}

		for(String word : keywordList){

			p = Pattern.compile(word);
			m = p.matcher(content);
			while (m.find()) {
				numOfMatch++;
				break;
			}
		}


		if(numOfMatch>=((numOfKeywords/2)+1)){
			return true;
		}



		return false;
	}
}