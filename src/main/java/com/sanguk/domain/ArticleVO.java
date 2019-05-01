package com.sanguk.domain;

import java.util.List;
import java.util.Date;

import lombok.Data;

/**
 * AuthVO
 */
@Data
public class ArticleVO {

    private int id; //default generated sequence
    private String author;
    private String title;
    private String content;
    private int viewcnt;  //default 0
    private String Thumnailpath; //1 or not
    private int contentimgcnt; //default 0
    private int boardType; //mapping in controller
    private Date updateDate;
    private long millis;
    

    private List<TagVO> taglist;
    private UserVO uservo;
    
    

    //get from mapper resulttype
    
    
    private List<CommentVO> commentlist;
    
    
    
}