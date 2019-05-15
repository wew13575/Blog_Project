package com.sanguk.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Tag 도메인 클래스입니다.
 * 
 * @author Sanguk
 * @version 1.0.0
 */
@Data
@AllArgsConstructor
public class TagVO implements Serializable{

    private static final long serialVersionUID = -7168706409371711169L;
    private int articleid;
    private String tag;




}