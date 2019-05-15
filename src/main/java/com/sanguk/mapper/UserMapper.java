package com.sanguk.mapper;

import java.util.List;

import com.sanguk.domain.AuthVO;
import com.sanguk.domain.UserVO;

import org.apache.ibatis.annotations.Mapper;

/**
 * Mybatis User Mapper 연결 인터페이스 입니다.
 * 
 * @author Sanguk
 * @version 1.0.0
 */
@Mapper
public interface UserMapper {

    /**
     * 
     * @param userid
     * @return UserVO
     */
    UserVO read(String userid);

    /**
     * 
     * @return List<String>
     */
    List<String> checkid();

    /**
     * 
     * @return List<String>
     */
    List<String> checknick();

    /**
     * 
     * @param userVO
     */
    void registerUsers(UserVO userVO);
    
    /**
     * 
     * @param authVO
     */
    void registerAuths(AuthVO authVO);

    
    /**
     * 
     * @param userid
     * @return int
     */
    int getFailcnt(String userid);
    
    /**
     * 
     * @param userid
     */
    void addFailcnt(String userid);

    /**
     * 
     * @param userid
     */
    void resetFailcnt(String userid);

    /**
     * 
     * @param userid
     */
    void setUserDisable(String userid);

    /**
     * 
     * @param author
     * @return UserVO
     */
    UserVO getUserByAuthor(String author);
}
