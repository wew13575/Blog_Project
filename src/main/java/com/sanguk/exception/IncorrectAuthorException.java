package com.sanguk.exception;


public class IncorrectAuthorException extends RuntimeException {

    private static final long serialVersionUID = -2734289111600333844L;

    public IncorrectAuthorException(String errorMessage) {
        super(errorMessage);
    }
}