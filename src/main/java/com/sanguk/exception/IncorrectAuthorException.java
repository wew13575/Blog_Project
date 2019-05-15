package com.sanguk.exception;


/**
 * IncorrectAuthorException 예외 클래스입니다.
 * 
 * @author Sanguk
 * @version 1.0.0
 */
public class IncorrectAuthorException extends RuntimeException {

    private static final long serialVersionUID = -2734289111600333844L;

    public IncorrectAuthorException(String errorMessage) {
        super(errorMessage);
    }
}