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








<body style="
background: rgb(241, 241, 241) !important;">




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
      <input type="hidden" id="pageNo" value="${pageno}">

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
                <div class="carousel-item active">
                  <img data-src="holder.js/800x330/text:First slide">
                  <div class="carousel-caption">
                    <h3>Los Angeles</h3>
                    <p>We had such a great time in LA!</p>
                  </div>
                </div>
                <div class="carousel-item">
                  <img data-src="holder.js/800x330/text:First slide">
                  <div class="carousel-caption">
                    <h3>Los Angeles</h3>
                    <p>We had such a great time in LA!</p>
                  </div>
                </div>
                <div class="carousel-item">
                  <img data-src="holder.js/800x330/text:First slide">
                  <div class="carousel-caption">
                    <h3>Los Angeles</h3>
                    <p>We had such a great time in LA!</p>
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

      <div class="homeBox">

        <div class="homeBoxcontent">
          <p>Latest <a href="#">Blog</a> Post</p>
          <div class="homeBoxrow">
              <img class="homeBoxthum" data-src="holder.js/73x73/text:First slide">
              <div class="homeBoxtitle">제목입니다제목입니다제목입니다제목입니다제목입니다제목입니다</div>
          </div>
          <div class="homeBoxrow">

          </div>
          <div class="homeBoxrow">

          </div>
        </div>
        
      
      
      </div>
      <div class="homeBox">
        <div class="homeBoxcontent">
            <p>Latest <a href="#">Board</a> Post</p>
            <div class="homeBoxrow">

            </div>
            <div class="homeBoxrow">

            </div>
            <div class="homeBoxrow">

            </div>
          </div>
      
      
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