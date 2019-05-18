package com.sanguk.aop;

import com.sanguk.exception.ArticleNotPoundException;
import com.sanguk.exception.IncorrectAuthorException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;


/** 
 * 전역 예외 처리 클래스 입니다.
 * @author Sanguk
 * @version 1.0.0
 */

@ControllerAdvice
public class ControllerAdvisor {



    /**
     * @param NoHandlerFoundException
     * @return .jsp file
     */

    @ExceptionHandler(NoHandlerFoundException.class)
    public String noHandlerFoundHandle(Exception e) {

       return "error/404";
   }



    /**
     * @param ArticleNotPoundException
     * @return .jsp file
     */

   @ExceptionHandler(ArticleNotPoundException.class)
   public String ArticleNotPoundhandle(Exception e) {

      return "error/404";
  }


    /**
     * @param IncorrectAuthorException
     * @return .jsp file
     */
    
  @ExceptionHandler(IncorrectAuthorException.class)
  public String IncorrectAuthorhandle(Exception e) {

     return "error/403";
 }
}