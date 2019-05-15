package com.sanguk.mapper;

import java.util.List;

import com.sanguk.domain.ArticleVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * Mybatis Article Mapper 연결 인터페이스 입니다.
 * 
 * @author Sanguk
 * @version 1.0.0
 */
@Mapper
public interface ArticleMapper {


    /**
     * 
     * @param articleVO
     */
    void registerArticle(ArticleVO articleVO);

    /**
     * 
     * @param articleVO
     */
    void setInfo(ArticleVO articleVO);

    /**
     * 
     * @param articleid
     * @return ArticleVO
     */
    ArticleVO getArticle(int articleid);

    /**
     * 
     * @param articleVO
     */
    void updateArticle(ArticleVO articleVO);

    /**
     * 
     * @param articleid
     */
    void deleteArticle(int articleid);

    /**
     * 
     * @param articleid
     */
    void addViewcnt(int articleid);

    /**
     * 
     * @param boardType
     * @return List<ArticleVO>
     */
    List<ArticleVO> getArticleList(int boardType);


}
