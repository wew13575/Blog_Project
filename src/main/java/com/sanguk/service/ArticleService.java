package com.sanguk.service;

import java.util.List;

import com.sanguk.domain.ArticleVO;
import com.sanguk.domain.TagVO;


/**
 * Article 서비스 인터페이스 입니다.
 * 
 * @author Sanguk
 * @version 1.0.0
 */

public interface ArticleService{
    /**
     * Article 등록
     * @param articleVO
     */
    public void registerArticle(ArticleVO articleVO);

    /**
     * 포트폴리오 글 업데이트
     * @param articleVO
     */
    public void setInfo(ArticleVO articleVO);

    /**
     * Article 태그 등록
     * @param articleid
     * @param tag
     */
    public void registerTag(int articleid, String tag);

    /**
     * Articleid로 부터 Article 반환
     * @param articleid
     * @return ArticleVO
     */
    public ArticleVO getArticle(int articleid);
    
    /**
     * Article 업데이트
     * @param articleVO
     */
    public void updateArticle(ArticleVO articleVO);
    
    /**
     * Article 삭제
     * @param articleid
     */
    public void deleteArticle(int articleid);

    /**
     * Tag 삭제
     * @param articleId
     */
    public void deleteTag(int articleId);

    /**
     * Article 조회 시 조회수 증가
     * @param articleId
     */
    public void addViewcnt(int articleId);
    
    /**
     * 게시판 타입에 따른 Article List 반환
     * @param boardType
     * @return List<ArticleVO>
     */
    public List<ArticleVO> getArticleList(int boardType);
    
    /**
     * Tag 수 기준으로 내림차순인 Tag List 반환
     * @return List<TagVO>
     */
    public List<TagVO> getTagRankedList();

}