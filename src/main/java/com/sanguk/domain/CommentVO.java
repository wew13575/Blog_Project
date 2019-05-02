package com.sanguk.domain;

import java.util.List;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * AuthVO
 */
@Data
public class CommentVO implements Serializable{

    private int articleid;
    private int id;
    private String author;
    private String content;
    
    private UserVO uservo;
    
    private Date regDate;
}