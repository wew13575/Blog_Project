package com.sanguk.service;

import com.sanguk.domain.AuthVO;
import com.sanguk.domain.UserVO;
import com.sanguk.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {
    

 	

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserMapper userMapper;

	@Override
    public void register(UserVO userVO){
		AuthVO authVO = new AuthVO();
		userVO.setUserpw(passwordEncoder.encode(userVO.getUserpw()));
		authVO.setUserid(userVO.getUserid());
		authVO.setAuth("ROLE_ADMIN");

		userMapper.registerUsers(userVO);
		userMapper.registerAuths(authVO);
		}
		
		
		@Override
    public int getFailcnt(String userid){

			return userMapper.getFailcnt(userid);
		}

		@Override
    public void addFailcnt(String userid){
			userMapper.addFailcnt(userid);
		}

		@Override
    public void resetFailcnt(String userid){
			userMapper.resetFailcnt(userid);
		}

		@Override
    public void setUserDisable(String userid){
			userMapper.setUserDisable(userid);
		}
}