package com.sanguk.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sanguk.domain.ArticleVO;
import com.sanguk.domain.TagVO;
import com.sanguk.mapper.ArticleMapper;
import com.sanguk.mapper.CommentMapper;
import com.sanguk.mapper.TagMapper;
import com.sanguk.util.UploadFileUtils;

import org.apache.commons.lang3.StringUtils;
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
	CommentMapper commentMapper;
	@Autowired
	TagMapper tagMapper;
	@Autowired
	String uploadPath;
	@Autowired
	String thumnailPath;

	@Autowired
	private DataSourceTransactionManager transactionManager;

	@Override
	public void registerArticle(ArticleVO articleVO, String taglist) {

		String thumnailContent = null;
		if (articleVO.getContentimgcnt() != 0) {
			Pattern p = Pattern.compile("\\<img src=\"/upload/image/[0-9a-zA-Z]+.(jpg|gif|png|bmp)\"");
			Matcher m = p.matcher(articleVO.getContent());
			String extractHashTag = null;

			while (m.find()) {
				thumnailContent = m.group().replace("<img src=\"/upload/image/", "").replace("\"", "");
				break;
			}

			String extension = thumnailContent.split("\\.")[1];
			try {
				articleVO.setThumnailpath(UploadFileUtils.makeThumbnail(uploadPath + thumnailContent, extension, thumnailPath, thumnailContent));
			} catch (Exception e) {
				log.warn(e.getMessage());
				articleVO.setThumnailpath("basicthumnail.jpg");
			}
		}
		else{
			articleVO.setThumnailpath("basicthumnail.jpg");
		}


		TransactionStatus txStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
		try {
			articleMapper.registerArticle(articleVO);
			registerTag(articleVO.getId(), taglist);
		} catch (Exception e) {
			transactionManager.rollback(txStatus);
			log.info("##########rollback########");
			log.warn(e.getMessage());
		}
		transactionManager.commit(txStatus);
	}

	@Override
	public void setInfo(ArticleVO articleVO) {
		TransactionStatus txStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
		try {
			articleMapper.setInfo(articleVO);
		} catch (Exception e) {
			transactionManager.rollback(txStatus);
			log.info("##########rollback########");
			log.warn(e.getMessage());
		}
		transactionManager.commit(txStatus);
	}

	@Override
	public void registerTag(int articleid, String taglist) {

		Pattern p = Pattern.compile("\\#([0-9a-zA-Z가-힣]*)");
		Matcher m = p.matcher(taglist);
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

}