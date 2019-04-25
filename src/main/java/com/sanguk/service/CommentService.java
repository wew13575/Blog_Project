package com.sanguk.service;

import java.util.List;

import com.sanguk.domain.ArticleVO;
import com.sanguk.domain.CommentVO;
import com.sanguk.domain.TagVO;

import org.springframework.transaction.annotation.Transactional;

public interface CommentService{
    public void registerComment(CommentVO commentVO);
    public void deleteComment(int commentId);
    public CommentVO getComment(int commentId);
    List<CommentVO> getCommentList(int articleid);
}