package com.sanguk.mapper;

import java.util.List;

import com.sanguk.domain.CommentVO;

import org.apache.ibatis.annotations.Mapper;

/**
 * Mybatis Comment Mapper 연결 인터페이스 입니다.
 * 
 * @author Sanguk
 * @version 1.0.0
 */
@Mapper
public interface CommentMapper {


    /**
     * 
     * @param commentVO
     */
    void registerComment(CommentVO commentVO);

    /**
     * 
     * @param commentId
     */
    void deleteComment(int commentId);

    /**
     * 
     * @param articleid
     * @return List<CommentVO>
     */
    List<CommentVO> getCommentList(int articleid);

    /**
     * 
     * @param commentid
     * @return
     */
    CommentVO getComment(int commentid);


}
