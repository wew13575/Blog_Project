package com.sanguk.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * Comment 도메인 클래스입니다.
 * 
 * @author Sanguk
 * @version 1.0.0
 */
@Data
public class CommentVO implements Serializable{

    private static final long serialVersionUID = -8300819204804179653L;
    private int articleid;
    private int id;
    private String author;
    private String content;
    
    private UserVO uservo;
    
    private Date regDate;
}