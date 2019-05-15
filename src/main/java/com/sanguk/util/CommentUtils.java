package com.sanguk.util;

import com.sanguk.domain.CommentVO;
import com.sanguk.domain.UserVO;


import lombok.extern.log4j.Log4j;

/**
 * Comment 처리 유틸 클래스 입니다.
 * 
 * @author Sanguk
 * @version 1.0.0
 */
@Log4j
public class CommentUtils {

	/**
	 * Comment 작성자가 현재 로그인 된 사용자가 맞는지 확인
	 * @param commentVO
	 * @param userVO
	 * @return boolean
	 */
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
