package com.sanguk.util;

import java.io.IOException;
import java.util.HashMap;
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
			Pattern p = Pattern.compile("\\<img src=\"/upload/image/[0-9a-zA-Z]+.(jpg|gif|png|bmp)\"");
			Matcher m = p.matcher(articleVO.getContent());
			String extractHashTag = null;

			while (m.find()) {
				thumnailContent = m.group().replace("<img src=\"/upload/image/", "").replace("\"", "");
				break;
			}

			String extension = thumnailContent.split("\\.")[1];
			try {
				articleVO.setThumnailpath(
						UploadFileUtils.makeThumbnail(uploadPath + thumnailContent, extension, thumnailPath, thumnailContent));
			} catch (IOException e) {
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
}