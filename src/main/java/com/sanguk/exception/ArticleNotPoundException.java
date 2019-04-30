package com.sanguk.exception;


public class ArticleNotPoundException extends RuntimeException {

    public ArticleNotPoundException(String errorMessage) {
        super(errorMessage);
    }
}