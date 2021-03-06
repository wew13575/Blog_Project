<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>

<head>
  <!--   -----------            헤드        --------------->
  <%@ include file="include/head.jsp" %>
  <!--   -----------            헤드        --------------->
</head>








<body>




  <div class="wrapper">
    <!--   -----------            사이드바        --------------->
    <!--   -----------            사이드바        --------------->
    <!--   -----------            사이드바        --------------->

    <%@ include file="include/nav.jsp" %>
    <!--   -----------            사이드바        --------------->
    <!--   -----------            사이드바        --------------->
    <!--   -----------            사이드바        --------------->

























    <!--   -----------                       헤  더        --------------->
    <!--   -----------                       헤  더        --------------->
    <!--   -----------                       헤  더        --------------->
    <header>


        <%@ include file="include/header.jsp" %>
    </header>

    <!--   -----------                       헤  더        --------------->
    <!--   -----------                       헤  더        --------------->
    <!--   -----------                       헤  더        --------------->




    <div class="container-fluid">

      <!--   -----------                       컨텐츠        --------------->
      <!--   -----------                       컨텐츠        --------------->
      <!--   -----------                       컨텐츠        --------------->

      <div class="content contentcontainer">
        <div class="contentBox">
          <div class="contentItem">
            <div class="ThumnailBox" style="
        background-image: url('image/144396_66012_628.jpg');"></div>
            <div class="contentTitle">
              장정
            </div>
            <div class="contentDay">
              2019년 3월 29일
            </div>
            <div class="contentHashtag">
              dddddddddd
            </div>
          </div>
        </div>

        <div class="contentBox">
          <div class="contentItem">
            <div class="ThumnailBox" style="
          background-image: url('image/144396_66012_628.jpg');"></div>
            <div class="contentTitle">
              장정
            </div>
            <div class="contentDay">
              2019년 3월 29일
            </div>
            <div class="contentHashtag">
              dddddddddd
            </div>


          </div>
        </div>
        <div class="contentBox">
          <div class="contentItem">
            <div class="ThumnailBox" style="
            background-image: url('image/144396_66012_628.jpg');"></div>
            <div class="contentTitle">
              장정
            </div>
            <div class="contentDay">
              2019년 3월 29일
            </div>
            <div class="contentHashtag">
              dddddddddd
            </div>
          </div>
        </div>




      </div>

      <div class="pagination-wrapper">
        <div class="pagination">
          <svg class="btn btn--prev" height="96" viewBox="0 0 24 24" width="96" xmlns="http://www.w3.org/2000/svg">
            <path d="M15.41 16.09l-4.58-4.59 4.58-4.59L14 5.5l-6 6 6 6z" />
            <path d="M0-.5h24v24H0z" fill="none" />
          </svg>

          <div class="pagination-container">
            <div class="little-dot  little-dot--first"></div>
            <div class="little-dot">
              <div class="big-dot-container">
                <div class="big-dot"></div>
              </div>
            </div>
            <div class="little-dot  little-dot--last"></div>
          </div>

          <svg class="btn btn--next" height="96" viewBox="0 0 24 24" width="96" xmlns="http://www.w3.org/2000/svg">
            <path d="M8.59 16.34l4.58-4.59-4.58-4.59L10 5.75l6 6-6 6z" />
            <path d="M0-.25h24v24H0z" fill="none" />
          </svg>
        </div>
      </div>





      <!--   -----------                       컨텐츠        --------------->
      <!--   -----------                       컨텐츠        --------------->
      <!--   -----------                       컨텐츠        --------------->
      <!--   -----------                       컨텐츠        --------------->





      <!--   -----------                       푸터        --------------->
      <!--   -----------                       푸터        --------------->
      <!--   -----------                       푸터        --------------->
      <footer class="blog-footer">

          <%@ include file="include/footer.jsp" %>

      </footer>
    </div>
  </div>





  <!-- Bootstrap core JavaScript
    ================================================== -->
  <!-- Placed at the end of the document so the pages load faster -->
 
  <%@ include file="include/script.jsp" %>
  <!--   -----------                       푸터        --------------->
  <!--   -----------                       푸터        --------------->
  <!--   -----------                       푸터        --------------->

</body>

</html>