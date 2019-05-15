package com.sanguk.service;

import java.util.List;

import com.sanguk.domain.CommentVO;

public interface CommentService{
    public void registerComment(CommentVO commentVO);
    public void deleteComment(int commentId);
    public CommentVO getComment(int commentId);
    List<CommentVO> getCommentList(int articleid);
}