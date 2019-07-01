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
  <%@ include file="include/head.jsp" %>
  <!--   -----------            헤드        --------------->
</head>








<body style="background: rgb(241, 241, 241) !important">




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

      <div id="homecontainer">
        <div id="homeCarousel">
          <div id="mycarousel" class="carousel slide" data-ride="carousel">

            <!-- Indicators -->
            <ul class="carousel-indicators">
              <li data-target="#mycarousel" data-slide-to="0" class="active"></li>
              <li data-target="#mycarousel" data-slide-to="1"></li>
              <li data-target="#mycarousel" data-slide-to="2"></li>
            </ul>

            <!-- The slideshow -->
            <div class="carousel-inner">
              <div class="carousel-item active" onclick="location.href = '/article/post?articleid=${bestlist[0].id}'">
                <img src="/upload/image/${bestlist[0].thumnailpath}">
                <div class="caroverlay"></div>
                <div class="carousel-caption">
                  <h3>${bestlist[0].title}</h3>
                  <p>${bestlist[0].uservo.userName}</p>
                </div>
              </div>
              <div class="carousel-item" onclick="location.href = '/article/post?articleid=${bestlist[1].id}'">
                <img src="/upload/image/${bestlist[1].thumnailpath}">
                <div class="caroverlay"></div>
                <div class="carousel-caption">
                  <h3>${bestlist[1].title}</h3>
                  <p>${bestlist[1].uservo.userName}</p>
                </div>
              </div>
              <div class="carousel-item" onclick="location.href = '/article/post?articleid=${bestlist[2].id}'">
                <img src="/upload/image/${bestlist[2].thumnailpath}">
                <div class="caroverlay"></div>
                <div class="carousel-caption">
                  <h3>${bestlist[2].title}</h3>
                  <p>${bestlist[2].uservo.userName}</p>
                </div>
              </div>
            </div>

            <!-- Left and right controls -->
            <a class="carousel-control-prev" href="#mycarousel" data-slide="prev">
              <span class="carousel-control-prev-icon"></span>
            </a>
            <a class="carousel-control-next" href="#mycarousel" data-slide="next">
              <span class="carousel-control-next-icon"></span>
            </a>

          </div>


        </div>

        <div class="homeBox" >

          <div class="homeBoxcontent">
            <p><a href="/blog">RecentPost</a></p>

            <c:forEach var="article" items="${bloglist}">
              <div class="homeBoxrow" onclick="location.href = '/article/post?articleid=${article.id}'">
                <img class="homeBoxthum" src="/upload/image/${article.thumnailpath}">
                <div class="homeBoxtitle">${article.title}</div>
              </div>
            </c:forEach>
          </div>



        </div>
        <div class="homeBox">
          <div class="homeBoxcontent">
            <p><a href="/board">RecentQuestion</a></p>
            <c:forEach var="article" items="${boardlist}">
              <div class="homeBoxrow" onclick="location.href = '/article/post?articleid=${article.id}'">
                <img class="homeBoxthum" src="/upload/image/${article.thumnailpath}">
                <div class="homeBoxtitle">${article.title}</div>
              </div>
            </c:forEach>
          </div>
        </div>

        <div id="tagcirclecontainer">
            <svg width="320" height="320" viewBox="0 0 320 320">


                <circle r="160" cx="160" cy="160"/>
                <foreignObject id="text" width="320" height="320">
                    <div class="shape shape-left"></div>
                    <div class="shape shape-right"></div>
                    <div class="shapedtext">
                        <p>
                            <c:forEach var="tag" items="${taglist}">
                                <c:choose >
                                  <c:when test="${tag.articleid ge 2}"><a class="highlighttag" href="/search?type=0&keyword=${tag.tag}">#${tag.tag}</a></c:when>
                                  <c:otherwise><a href="/search?type=0&keyword=${tag.tag}">#${tag.tag}</a></c:otherwise>
                                </c:choose>
                            </c:forEach> 
                        </p>  
                    </div> 
                </foreignObject>

            </svg>



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


    <script>

      var pageNo;
      var boardType = 0;
      $(document).ready(function () {
        this.pageNo = $("#pageNo").val();

        $('#mycarousel').carousel()
       
      })

//둘다 조금씩 요청하자 뷰카운트 높은거로





    </script>
    <!--   -----------                       푸터        --------------->
    <!--   -----------                       푸터        --------------->
    <!--   -----------                       푸터        --------------->

</body>

</html>