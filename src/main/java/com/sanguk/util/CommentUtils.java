package com.sanguk.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sanguk.domain.ArticleVO;
import com.sanguk.domain.CommentVO;
import com.sanguk.domain.UserVO;

import org.springframework.http.MediaType;

import lombok.extern.log4j.Log4j;

@Log4j
public class CommentUtils {

	public static boolean isCommentAuthor(CommentVO commentVO, UserVO userVO) {

		if (commentVO == null || userVO == null) { // TODO error페이지 처리
			return false;
		}
		if (!userVO.getUserid().equals(commentVO.getAuthor())) { // TODO error페이지 처리
			log.info(userVO.getUserid() + commentVO.getAuthor());
			log.info("다른사람 댓글 삭제불가");
			return false;
		}
		return true;
	}
}