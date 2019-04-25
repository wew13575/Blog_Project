package com.sanguk.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sanguk.domain.ArticleVO;
import com.sanguk.domain.CommentVO;
import com.sanguk.domain.TagVO;
import com.sanguk.mapper.ArticleMapper;
import com.sanguk.mapper.CommentMapper;
import com.sanguk.mapper.TagMapper;
import com.sanguk.util.ArticleUtils;
import com.sanguk.util.UploadFileUtils;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.transaction.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

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