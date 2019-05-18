package com.sanguk.service;

import java.util.List;

import javax.annotation.PostConstruct;

import com.sanguk.domain.AuthVO;
import com.sanguk.domain.UserVO;
import com.sanguk.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class UserServiceimpl implements UserService {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	private UserMapper userMapper;

	List<String> userIdList;
	List<String> userNickList;

	@PostConstruct
	public void userList() {
		this.userIdList = userMapper.checkid();
		log.info(this.userIdList);
		this.userNickList = userMapper.checknick();
		log.info(this.userNickList);
	}

	@Override
	public void register(UserVO userVO) {

		

		AuthVO authVO = new AuthVO();
		userVO.setUserpw(passwordEncoder.encode(userVO.getUserpw()));

		authVO.setUserid(userVO.getUserid());
		authVO.setAuth("ROLE_ADMIN");

		userMapper.registerUsers(userVO);
		userMapper.registerAuths(authVO);

		userList();
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
		if (this.userIdList.contains(userid)) {
			return false;
		}
		return true;
	}

	
    public boolean checknick(String nick){
		if (this.userNickList.contains(nick)) {
			return false;
		}
		return true;

	}
}