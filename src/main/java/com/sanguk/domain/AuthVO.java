package com.sanguk.domain;

import java.io.Serializable;

import lombok.Data;

/**
 * Auth 도메인 클래스입니다.
 * 
 * @author Sanguk
 * @version 1.0.0
 */
@Data
public class AuthVO implements Serializable {

    private static final long serialVersionUID = -8556158762823343010L;
    private String userid;
    private String auth;
    
}