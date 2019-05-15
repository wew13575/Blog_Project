package com.sanguk.domain;

import java.util.List;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * Article 도메인 클래스입니다.
 * 
 * @author Sanguk
 * @version 1.0.0
 */
@Data
public class ArticleVO implements Serializable {

    private static final long serialVersionUID = -3132587059934975631L;
    private int id; // default generated sequence
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