package com.sanguk.mapper;

import java.util.List;

import com.sanguk.domain.ArticleVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {


    void registerArticle(ArticleVO articleVO);
    void setInfo(ArticleVO articleVO);
    ArticleVO getArticle(int articleid);
    void updateArticle(ArticleVO articleVO);
    void deleteArticle(int articleid);
    void addViewcnt(int articleid);
    List<ArticleVO> getArticleList(int boardType);


}
