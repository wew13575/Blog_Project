package com.sanguk.mapper;

import com.sanguk.domain.ArticleVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {


    void registerArticle(ArticleVO articleVO);
    void setInfo(ArticleVO articleVO);


}
