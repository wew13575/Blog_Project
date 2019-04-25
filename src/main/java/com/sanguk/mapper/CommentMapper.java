package com.sanguk.mapper;

import java.util.List;

import com.sanguk.domain.ArticleVO;
import com.sanguk.domain.CommentVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {


    void registerComment(CommentVO commentVO);
    void deleteComment(int commentId);
    List<CommentVO> getCommentList(int articleid);
    CommentVO getComment(int commentid);


}
