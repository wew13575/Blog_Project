package com.sanguk.mapper;

import com.sanguk.domain.ArticleVO;
import com.sanguk.domain.CommentVO;
import com.sanguk.domain.TagVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TagMapper {


    void registerTag(TagVO TagVO);


}
