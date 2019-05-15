package com.sanguk.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import lombok.*;


/**
 * User 도메인 클래스입니다.
 * 
 * @author Sanguk
 * @version 1.0.0
 */
@Data
public class UserVO implements Serializable{

    private static final long serialVersionUID = 2770112603458907132L;
    private String userid;
    private String userpw;
    private String userName;
    private int failcnt;
    private boolean enabled;
    private String profilePath;
    private String userinfo;
    
    
    private Date regDate;
    private Date updateDate;
    private List<AuthVO> authList;
    

}