package com.sanguk.service;

import java.util.List;

import com.sanguk.domain.ArticleVO;
import com.sanguk.domain.TagVO;

import org.springframework.transaction.annotation.Transactional;

public interface ArticleService{
    public void registerArticle(ArticleVO articleVO);
    public void setInfo(ArticleVO articleVO);
    public void registerTag(int articleid, String tag);
    public ArticleVO getArticle(int articleid);
    public void updateArticle(ArticleVO articleVO);
    public void deleteArticle(int articleid);
    public void deleteTag(int articleId);

}