package com.sanguk.exception;


public class IncorrectAuthorException extends RuntimeException {

    public IncorrectAuthorException(String errorMessage) {
        super(errorMessage);
    }
}