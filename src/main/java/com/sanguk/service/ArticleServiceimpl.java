package com.sanguk.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;

import com.sanguk.domain.ArticleVO;
import com.sanguk.domain.TagVO;
import com.sanguk.mapper.ArticleMapper;
import com.sanguk.mapper.CommentMapper;
import com.sanguk.mapper.TagMapper;
import com.sanguk.util.ArticleUtils;
import com.sanguk.util.UploadFileUtils;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.transaction.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ArticleServiceimpl implements ArticleService {

	@Autowired
	ArticleMapper articleMapper;
	@Autowired
	CommentServiceimpl commentService;
	@Autowired
	TagMapper tagMapper;
	@Autowired
	String uploadPath;
	@Autowired
	String thumnailPath;





	@Override
	public void registerArticle(ArticleVO articleVO) {


		articleVO = ArticleUtils.getArticleThumnail(articleVO,uploadPath,thumnailPath);
		articleVO = ArticleUtils.initArticleTitle(articleVO);

		articleMapper.registerArticle(articleVO);
	}




	@Override
	public void setInfo(ArticleVO articleVO) {
		articleMapper.setInfo(articleVO);
	}




	@Override
	public void registerTag(int articleid, String tag) {

		Pattern p = Pattern.compile("\\#([0-9a-zA-Z가-힣]*)");
		Matcher m = p.matcher(tag);
		String extractHashTag = null;

		while (m.find()) {
			extractHashTag = sepcialCharacter_replace(m.group());

			if (extractHashTag != null) {
				TagVO tagvo = new TagVO(articleid, extractHashTag);
				tagMapper.registerTag(tagvo);
			}
		}

	}

	public String sepcialCharacter_replace(String str) {
		str = StringUtils.replaceChars(str, "-_+=!@#$%^&*()[]{}|\\;:'\"<>,.?/~`） ", "");

		if (str.length() < 1) {
			return null;
		}

		return str;
	}



	@Override
	public ArticleVO getArticle(int articleid) {
		ArticleVO articleVO = articleMapper.getArticle(articleid);
		if (articleVO == null) {
			return null;
		}
		articleVO.setCommentlist(commentService.getCommentList(articleVO.getId()));
		addViewcnt(articleid);
		return articleVO;
	}



	@Override
	public void updateArticle(ArticleVO articleVO) {

		articleVO = ArticleUtils.getArticleThumnail(articleVO,uploadPath,thumnailPath);
		articleVO = ArticleUtils.initArticleTitle(articleVO);

		articleMapper.updateArticle(articleVO);

	}

	@Override
	public void deleteTag(int articleId){
		tagMapper.deleteTag(articleId);
	}


	@Override
	public void deleteArticle(int articleId) {
			articleMapper.deleteArticle(articleId);
	}

	@Override
	public void addViewcnt(int articleId){
		articleMapper.addViewcnt(articleId);
	}

	@Override
	public List<ArticleVO> getArticleList(int boardType) {
		return boardType==0?articleMapper.getBlogList():articleMapper.getBoardList();
	}
}