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

      <div class="contentcontainer">





      </div>

      <div class="pagination-wrapper">
        <div class="pagination">
          <svg class="btn btn--prev" height="96" viewBox="0 0 24 24" width="60" xmlns="http://www.w3.org/2000/svg">
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

          <svg class="btn btn--next" height="96" viewBox="0 0 24 24" width="60" xmlns="http://www.w3.org/2000/svg">
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



  <script>

      var pageNo;
      $(document).ready(function () {
        this.pageNo = $("#pageNo").val();
        roadList(0, this.pageNo);
      })
  
  
  
      roadList = function (boardType, pageNo) {
        $.get('/article/list?type=' + boardType + '&pageNo=' + pageNo, function (data) {
          console.log(data);
          
          data.forEach(element => {
            var $contentBox = $('<div class="contentBox"></div>');
            var $contentthumnail = $('<div class="contentthumnail" onclick="location.href = \'/article/post?articleid='+element.id+'\'" style="background: linear-gradient(to bottom,rgba(0, 0, 0, 0),rgba(0, 0, 0, 0.3)), url(\'/upload/image/' + element.thumnailpath + '\');background-repeat: no-repeat;background-size: 320px 240px;"></div>');
            var $contentinfobox = $('<div class="contentinfobox"></div>');
            var $contentTitle = $('<div class="contentTitle" onclick="location.href = \'/article/post?articleid='+element.id+'\'" >' + element.title + '</div>');
            var $contentDay = $(' <div class="contentDay"><i class="far fa-calendar-alt"></i>&nbsp; ' + millisToDate(element.updateDate,"#DD#, #MMM#, #YYYY#") + '</div>');
            var $contentauthor = $('<div class="contentauthor"><img class="contentauthorimage" src="/upload/image/' + element.uservo.profilePath + '">' + element.uservo.userName + '</div>');
            
  
            $contentBox.append($contentthumnail);
            $contentthumnail.append($contentinfobox);
            $contentinfobox.append($contentTitle);
            $contentinfobox.append($contentDay);
            $contentinfobox.append($contentauthor);

  
            $(".contentcontainer").append($contentBox);
          });
  
        });
      }
  
  
  
  
  
  
    </script>
  <!--   -----------                       푸터        --------------->
  <!--   -----------                       푸터        --------------->
  <!--   -----------                       푸터        --------------->

</body>

</html>