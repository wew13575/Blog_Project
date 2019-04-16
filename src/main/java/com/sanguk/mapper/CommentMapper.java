package com.sanguk.mapper;

import com.sanguk.domain.ArticleVO;
import com.sanguk.domain.CommentVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {


    void registerComment(CommentVO commentVO);


}
