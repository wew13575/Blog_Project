package com.sanguk.domain;

import java.util.List;
import java.util.Date;

import lombok.Data;

/**
 * AuthVO
 */
@Data
public class CommentVO {

    private int articleid;
    private int id;
    private String author;
    private String content;
    
    private Date regDate;
    private Date updateDate;
}