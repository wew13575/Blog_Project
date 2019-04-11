package com.sanguk.domain;

import java.util.Date;
import java.util.List;

import lombok.*;


@Data
public class UserVO{

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