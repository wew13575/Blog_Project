<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>

<head>
  <!--   -----------            헤드        --------------->
  <%@ include file="../include/head.jsp" %>
  <!--   -----------            헤드        --------------->
</head>








<body style="
background: rgb(241, 241, 241) !important;">




  <div class="wrapper">
    <!--   -----------            사이드바        --------------->
    <!--   -----------            사이드바        --------------->
    <!--   -----------            사이드바        --------------->

    <%@ include file="../include/nav.jsp" %>
    <!--   -----------            사이드바        --------------->
    <!--   -----------            사이드바        --------------->
    <!--   -----------            사이드바        --------------->

























    <!--   -----------                       헤  더        --------------->
    <!--   -----------                       헤  더        --------------->
    <!--   -----------                       헤  더        --------------->
    <header>


      <%@ include file="../include/header.jsp" %>
    </header>

    <!--   -----------                       헤  더        --------------->
    <!--   -----------                       헤  더        --------------->
    <!--   -----------                       헤  더        --------------->




    <div class="container-fluid">
      <input type="hidden" id="pageNo" value="${pageno}">

      <!--   -----------                       컨텐츠        --------------->
      <!--   -----------                       컨텐츠        --------------->
      <!--   -----------                       컨텐츠        --------------->

      <!--   -----------                       컨텐츠        --------------->
      <!--   -----------                       컨텐츠        --------------->
      <!--   -----------                       컨텐츠        --------------->
      <!--   -----------                       컨텐츠        --------------->


      <div class="errorcontainer">
          <div class="errormessege">
  
            <p class ="errorheader"> 
              Sorry!
            </p>
            <p class ="errorcontenttop">
              We can not find the page you want. 
            </p>
            <p class ="errorcontentbottom" style="
            color: rgb(150, 63, 63);">
              Error Code = 404 
            </p>
            <p class ="errorcontentbottom" style="
            color: rgb(80, 80, 80);">
  
  If this problem persists without a specific reason, please send an e-mail to <a href="#">wew13575@naver.com.</a></p>
  
          </div>
          <div class="errormessege">
            <img id="errorcharactor" src="/resources/image/character.png" >
          </div>
        
      </div>


      <!--   -----------                       푸터        --------------->
      <!--   -----------                       푸터        --------------->
      <!--   -----------                       푸터        --------------->

    </div>
  </div>





  <!-- Bootstrap core JavaScript
    ================================================== -->
  <!-- Placed at the end of the document so the pages load faster -->

  <%@ include file="../include/script.jsp" %>


  <script>

    var pageNo;
    var boardType = 0;
    $(document).ready(function () {
      this.pageNo = $("#pageNo").val();

      $('#mycarousel').carousel()
      $.get('/article/list?type=0&pageNo=' + this.pageNo, function (data) {

        console.log(data);
      });
    })

//둘다 조금씩 요청하자 뷰카운트 높은거로





  </script>
  <!--   -----------                       푸터        --------------->
  <!--   -----------                       푸터        --------------->
  <!--   -----------                       푸터        --------------->

</body>

</html>