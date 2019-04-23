package com.sanguk.mapper;

import com.sanguk.domain.ArticleVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {


    void registerArticle(ArticleVO articleVO);
    void setInfo(ArticleVO articleVO);
    public ArticleVO getArticle(int articleid);
    void updateArticle(ArticleVO articleVO);
    void deleteArticle(int articleid);


}
