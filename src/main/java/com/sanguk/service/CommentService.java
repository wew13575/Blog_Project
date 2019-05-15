package com.sanguk.service;

import java.util.List;

import com.sanguk.domain.CommentVO;

/**
 * Comment 서비스 인터페이스 입니다.
 * 
 * @author Sanguk
 * @version 1.0.0
 */

public interface CommentService{
    /**
     * Comment 등록
     * @param commentVO
     */
    public void registerComment(CommentVO commentVO);

    /**
     * Comment 삭제
     * @param commentId
     */
    public void deleteComment(int commentId);

    /**
     * CommentId 에 해당하는 Comment 반환
     * @param commentId
     * @return CommentVO
     */
    public CommentVO getComment(int commentId);

    /**
     * 전체 Comment 반환
     * @param articleid
     * @return List<CommentVO>
     */
    List<CommentVO> getCommentList(int articleid);
}