package com.sanguk.domain;

import java.io.Serializable;

import lombok.Data;

/**
 * AuthVO
 */
@Data
public class AuthVO implements Serializable {

    private static final long serialVersionUID = -8556158762823343010L;
    private String userid;
    private String auth;
    
}