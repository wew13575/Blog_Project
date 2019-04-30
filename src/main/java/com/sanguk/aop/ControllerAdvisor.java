package com.sanguk.aop;

import com.sanguk.exception.ArticleNotPoundException;
import com.sanguk.exception.IncorrectAuthorException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(NoHandlerFoundException.class)
    public String noHandlerFoundHandle(Exception e) {

       return "error/404";
   }

   @ExceptionHandler(ArticleNotPoundException.class)
   public String ArticleNotPoundhandle(Exception e) {

      return "error/404";
  }
  @ExceptionHandler(IncorrectAuthorException.class)
  public String IncorrectAuthorhandle(Exception e) {

     return "error/404";
 }
}