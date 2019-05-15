package com.sanguk.exception;


public class ArticleNotPoundException extends RuntimeException {

    private static final long serialVersionUID = -2734289111600333844L;

    public ArticleNotPoundException(String errorMessage) {
        super(errorMessage);
    }
}