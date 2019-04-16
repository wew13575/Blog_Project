package com.sanguk.service;

import java.util.List;

import com.sanguk.domain.ArticleVO;
import com.sanguk.domain.TagVO;

public interface ArticleService{

    public void registerArticle(ArticleVO articleVO, String taglist);
    public void setInfo(ArticleVO articleVO);
    public void registerTag(int articleid, String taglist);
    
}