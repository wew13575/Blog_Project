<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="headerBox">
  <div id="line-wrapper" onclick="myFunction(this)">
    <div class="line"></div>
    <div class="line"></div>
    <div class="line"></div>
  </div>
  <div class="headerItem">
    
    <img src="/resources/image/logo.png" onclick="location.href = '/'" width="80" height="27">
      
  </div>
  <form class="searchform" action="/search" method="get">
    <input type="text" name="keyword" class="input">
    <input type="hidden" name="type" value="1">
    <button type="reset" class="search"></button>
  </form>
</div>