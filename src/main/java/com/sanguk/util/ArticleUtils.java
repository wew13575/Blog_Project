package com.sanguk.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.sanguk.domain.ArticleVO;
import com.sanguk.domain.TagVO;
import com.sanguk.domain.UserVO;


import lombok.extern.log4j.Log4j;

/**
 * Article 처리 유틸 클래스 입니다.
 * 
 * @author Sanguk
 * @version 1.0.0
 */

@Log4j
public class ArticleUtils {


	/**
	 * Article 썸네일을 추출 후 파일 명을 도메인에 삽입
	 * @param articleVO
	 * @param uploadPath
	 * @param thumnailPath
	 * @return ArticleVO
	 */
	public static ArticleVO getArticleThumnail(ArticleVO articleVO, String uploadPath, String thumnailPath) {

		String thumnailContent = null;
		if (articleVO.getContentimgcnt() != 0) {
			Pattern p = Pattern.compile("src=\"/upload/image/[0-9a-zA-Z]+.(jpg|gif|png|bmp)\"");
			Matcher m = p.matcher(articleVO.getContent());

			while (m.find()) {
				thumnailContent = m.group().replace("src=\"/upload/image/", "").replace("\"", "");
				break;
			}
			try {
				String extension = thumnailContent.split("\\.")[1];
				articleVO.setThumnailpath(UploadFileUtils.imageCrop(uploadPath+ "/" + thumnailContent, extension,
						thumnailPath, thumnailContent,320,240,"THUMB_"));
			} catch (IOException e) {
				log.warn(e.getMessage());
				articleVO.setThumnailpath("THUMB_basic.jpg");
			} catch (NullPointerException e) {
				log.warn(e.getMessage());
				articleVO.setThumnailpath("THUMB_basic.jpg");
			}
		} else {
			articleVO.setThumnailpath("THUMB_basic.jpg");
		}

		return articleVO;
	}

	/**
	 * Article 제목의 '<','>' 제거 후 반환
	 * @param articleVO
	 * @return ArticleVO
	 */
	public static ArticleVO initArticleTitle(ArticleVO articleVO) {
		String title = articleVO.getTitle().replace("<", "").replace(">", "");
		if (title.length() == 0) {
			title = "제목 없음";
		}
		articleVO.setTitle(title);
		return articleVO;
	}

	/**
	 * 게시글 작성자가 현재 로그인 된 사용자가 맞는 지 확인
	 * @param articleVO
	 * @param userVO
	 * @return boolean
	 */
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

	/**
	 * 태그(100%일치) 검색 결과 반환
	 * @param keyword
	 * @param articles
	 * @return List<ArticleVO>
	 */
	public static List<ArticleVO> getTagedArticleResult(String keyword, List<ArticleVO> articles) {

		List<ArticleVO> resultList = new ArrayList<>();
		List<ArticleVO> articleList = new ArrayList<ArticleVO>(articles);
		for (ArticleVO article : articleList) {
			
			if (article.getTaglist().stream().anyMatch(tag -> tag.getTag().equals(keyword))) {
				article.setContent(article.getContent().replaceAll("<[^>]*>", ""));
				resultList.add(article);
			}
		}
		return resultList;
	}

	/**
	 * 제목,태그,작성자,내용 순으로 검색 후 결과를 반환
	 * @param keyword
	 * @param articles
	 * @return List<ArticleVO>
	 */
	public static List<ArticleVO> getSearchResult(String keyword, List<ArticleVO> articles) {

		List<ArticleVO> resultList = new ArrayList<>();
		List<ArticleVO> articleList = new ArrayList<ArticleVO>(articles); //카피 x -> 캐쉬 값 조정됨


		articleList.removeIf(article -> {
			if (isMatchTitle(article.getTitle(), keyword)) {
				article.setContent(article.getContent().replaceAll("<[^>]*>", ""));
				resultList.add(article);
				return true;
			}
			return false;
		});

		articleList.removeIf(article -> {
			if (article.getTaglist().stream().anyMatch(tag -> isMatchTitle(tag.getTag(), keyword))) {
				article.setContent(article.getContent().replaceAll("<[^>]*>", ""));
				List<TagVO> taglist = new ArrayList<TagVO>(article.getTaglist());
				for(TagVO t : taglist){
					t.setTag(t.getTag().replaceAll(keyword, "<b>" + keyword + "</b>"));
				}
				article.setTaglist(taglist);
				resultList.add(article);
				return true;
			}
			return false;
		});

		articleList.removeIf(article -> {
			if (isMatchContent(article, keyword)) {
				resultList.add(article);
				log.info("bold:::" + article.getContent());
				return true;
			}
			return false;
		});

		articleList.removeIf(article -> {
			if (isMatchTitle(article.getAuthor(), keyword)) {
				article.setContent(article.getContent().replaceAll("<[^>]*>", ""));
				resultList.add(article);
				return true;
			}
			return false;
		});
		

		log.info(articleList);

		return resultList;
	}

	/**
	 * 작성자를 검색한 결과를 반환
	 * @param keyword
	 * @param articles
	 * @return List<ArticleVO>
	 */
	public static List<ArticleVO> getAuthorsArticleResult(String keyword, List<ArticleVO> articles) {

		List<ArticleVO> articleList = new ArrayList<ArticleVO>(articles);
		List<ArticleVO> resultList = new ArrayList<ArticleVO>();
		resultList = articleList.stream().filter(article -> article.getAuthor().equals(keyword)).collect(Collectors.toList());
		resultList.forEach(article -> article.setContent(article.getContent().replaceAll("<[^>]*>", "")));

		
			
		return resultList;
	}

	/**
	 * 두 String을 비교하여 매치 결과를 반환
	 * @param title
	 * @param keyword
	 * @return boolean
	 */
	private static boolean isMatchTitle(String title, String keyword) {

		Pattern p = Pattern.compile(keyword.trim());
		Matcher m = p.matcher(title.trim());

		while (m.find()) {
			return true;
		}
		return false;
	}

	/**
	 * Article의 Content와 keyword 매치 결과를 반환
	 * @param article
	 * @param keyword
	 * @return boolean
	 */
	private static boolean isMatchContent(ArticleVO article, String keyword) {

		String content = article.getContent();

		if (content == null || content.trim().equals("")) {
			return false;
		}

		String[] keywordList = keyword.split(" ");
		int numOfKeywords = keywordList.length;
		int numOfMatch = 0;
		int matchStart = 3000;

		content = content.replaceAll("<[^>]*>", "");

		if (content.equals("")) {
			return false;
		}

		Pattern p = Pattern.compile(keyword.trim());
		Matcher m = p.matcher(content.trim());

		while (m.find()) {
			content = content.replaceAll(keyword, "<b>" + keyword + "</b>");
			article.setContent(content);
			return true;
		}

		if (numOfKeywords <= 1) {
			return false;
		}

		for (String word : keywordList) {

			p = Pattern.compile(word);
			m = p.matcher(content.trim());
			while (m.find()) {
				numOfMatch++;
				if (matchStart > m.start()) {
					matchStart = m.start();
				}
				content = content.replaceAll(word, "<b>" + word + "</b>");
				log.info("bold:::" + content);
				break;
			}
		}

		if (numOfMatch >= ((numOfKeywords / 2) + 1)) {
			content = content.substring(matchStart, content.length());
			article.setContent(content);
			return true;
		}

		return false;
	}
}