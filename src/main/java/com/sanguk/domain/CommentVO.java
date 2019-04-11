package com.sanguk.domain;

import java.util.List;
import java.util.Date;

import lombok.Data;

/**
 * AuthVO
 */
@Data
public class CommentVO {

    private String articleid;
    private String commentid;
    private String commentauthor;
    private String commentcontent;
    
    private Date regDate;
    private Date updateDate;
}