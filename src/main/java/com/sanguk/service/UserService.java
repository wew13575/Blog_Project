package com.sanguk.service;

import com.sanguk.domain.UserVO;


/**
 * User 서비스 인터페이스 입니다.
 * 
 * @author Sanguk
 * @version 1.0.0
 */

public interface UserService {

    /**
     * User 등록
     * @param userVO
     */
    public void register(UserVO userVO);

    /**
     * Login 실패 횟수 반환
     * @param userid
     * @return int
     */
    public int getFailcnt(String userid);

    /**
     * Login 실패 시 실패 횟수 증가
     * @param userid
     */
    public void addFailcnt(String userid);

    /**
     * Login 성공 시 실패 횟수 초기화
     * @param userid
     */
    public void resetFailcnt(String userid); 

    /**
     * Login 3회 실패 시 User 정지
     * @param userid
     */
    public void setUserDisable(String userid); 

    /**
     * 가입 시 id 중복 방지를 위한 중복 체크 결과를 반환
     * @param userid
     * @return boolean
     */
    public boolean checkid(String userid); 


    /**
     * 가입 시 name 중복 방지를 위한 중복 체크 결과를 반환
     * @param nick
     * @return boolean
     */
    public boolean checknick(String nick);

    
}