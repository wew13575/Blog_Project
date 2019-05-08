package com.sanguk.domain;

import java.io.Serializable;

import lombok.Data;

/**
 * AuthVO
 */
@Data
public class AuthVO implements Serializable {

    private String userid;
    private String auth;
    
}