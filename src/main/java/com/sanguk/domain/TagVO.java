package com.sanguk.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class TagVO implements Serializable{

    private int articleid;
    private String tag;




}