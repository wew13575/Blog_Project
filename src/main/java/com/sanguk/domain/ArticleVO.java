package com.sanguk.domain;

import java.util.List;
import java.util.Date;

import lombok.Data;

/**
 * AuthVO
 */
@Data
public class ArticleVO {

    private String id; //default generated sequence
    private String author;
    private String title;
    private String content;
    private int viewcnt;  //default 0
    private String Thumnailpath; //1 or not
    private int contentimgcnt; //default 0

    private String boardType; //mapping in controller
    
    

    private List<TagVO> taglist;
    private List<CommentVO> commentlist;

    //get from mapper resulttype
    
    private Date regDate;
    private Date updateDate;
    
    
    
    
}