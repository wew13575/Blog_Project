package com.sanguk.service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import javax.annotation.PostConstruct;

import com.sanguk.domain.AuthVO;
import com.sanguk.domain.UserVO;
import com.sanguk.mapper.UserMapper;
import com.sanguk.util.MediaUtils;
import com.sanguk.util.UploadFileUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class UserServiceimpl implements UserService {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private Path rootLocation;

	@Autowired
	private String uploadPath;

	@Autowired
	private DataSourceTransactionManager transactionManager;

	List<String> userList;

	@PostConstruct
	public void userList() {
		this.userList = userMapper.checkid();
		log.info(this.userList);
	}

	@Override
	public void register(UserVO userVO) {

		

		AuthVO authVO = new AuthVO();
		userVO.setUserpw(passwordEncoder.encode(userVO.getUserpw()));

		authVO.setUserid(userVO.getUserid());
		authVO.setAuth("ROLE_ADMIN");

		TransactionStatus txStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
		try {
			userMapper.registerUsers(userVO);
			userMapper.registerAuths(authVO);
		} catch (Exception e) {
			transactionManager.rollback(txStatus);
			log.info("##########rollback########");
			log.warn(e.getMessage());
		}
		transactionManager.commit(txStatus);

		userList();
	}


	@Override
	public String saveProfile(MultipartFile profile)  throws Exception{
		String profilePath;

		try {
			if (profile.isEmpty()) {
				throw new Exception();
			}
			String fileName = profile.getOriginalFilename();
			String extension = fileName.split("\\.")[1];
			if (!MediaUtils.containsImageMediaType(extension)) {
				throw new Exception();
			}
			profilePath = UploadFileUtils.fileSave(rootLocation.toString(), profile);
			if (profilePath.toCharArray()[0] == '/') {
				profilePath = profilePath.substring(1);
			}

		} catch (Exception e) {
			profilePath = "basicprofile.jpg";
			throw new Exception("Failed to store file " + profile.getOriginalFilename(), e);
		}

		return profilePath;
	}







	@Override
	public int getFailcnt(String userid) {

		return userMapper.getFailcnt(userid);
	}

	@Override
	public void addFailcnt(String userid) {
		userMapper.addFailcnt(userid);
	}

	@Override
	public void resetFailcnt(String userid) {
		userMapper.resetFailcnt(userid);
	}

	@Override
	public void setUserDisable(String userid) {
		userMapper.setUserDisable(userid);
	}

	public boolean checkid(String userid) {
		if (this.userList.contains(userid)) {
			return false;
		}
		return true;
	}
}