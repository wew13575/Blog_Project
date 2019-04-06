package com.sanguk.mapper;

import com.sanguk.domain.AuthVO;
import com.sanguk.domain.UserVO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    UserVO read(String userid);



    void registerUsers(UserVO userVO);
    
    void registerAuths(AuthVO authVO);
}
