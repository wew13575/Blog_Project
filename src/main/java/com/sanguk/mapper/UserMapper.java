package com.sanguk.mapper;

import java.util.List;

import com.sanguk.domain.AuthVO;
import com.sanguk.domain.UserVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    UserVO read(String userid);

    List<String> checkid();
    List<String> checknick();

    void registerUsers(UserVO userVO);
    
    void registerAuths(AuthVO authVO);

    
    int getFailcnt(String userid);
    
    void addFailcnt(String userid);

    void resetFailcnt(String userid);

    void setUserDisable(String userid);
    UserVO getUserByAuthor(String author);
}
