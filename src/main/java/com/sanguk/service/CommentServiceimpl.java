package com.sanguk.service;

import java.util.List;
import com.sanguk.domain.CommentVO;
import com.sanguk.mapper.CommentMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class CommentServiceimpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;


    @Override
    public void registerComment(CommentVO commentVO) {
        commentMapper.registerComment(commentVO);
    }

    @Override
    public void deleteComment(int commentId) {
        commentMapper.deleteComment(commentId);
    }

    @Override
    public CommentVO getComment(int commentId) {
        return commentMapper.getComment(commentId);
    }

    @Override
    public List<CommentVO> getCommentList(int articleId) {
        return commentMapper.getCommentList(articleId);
    }

    











}