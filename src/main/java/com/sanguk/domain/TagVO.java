package com.sanguk.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TagVO implements Serializable{

    private static final long serialVersionUID = -7168706409371711169L;
    private int articleid;
    private String tag;




}