package com.sanguk.service;

import java.io.IOException;
import java.nio.file.Path;

import com.sanguk.domain.AuthVO;
import com.sanguk.domain.UserVO;
import com.sanguk.mapper.UserMapper;
import com.sanguk.util.UploadFileUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
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





	@Override
		public void register(UserVO userVO, MultipartFile profile) throws Exception {

		String profilePath;

		AuthVO authVO = new AuthVO();
		userVO.setUserpw(passwordEncoder.encode(userVO.getUserpw()));
		
		{
			try {
					if (profile.isEmpty()) {
							profilePath="basicprofile.jpg";
					}
					else{
					profilePath = UploadFileUtils.fileSave(rootLocation.toString(), profile);
				}
					if (profilePath.toCharArray()[0] == '/') {
						profilePath = profilePath.substring(1);
					}
					
			} catch (IOException e) {
					throw new Exception("Failed to store file " + profile.getOriginalFilename(), e);
			}
	}

		log.debug(profilePath);
		userVO.setProfilePath(profilePath);
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