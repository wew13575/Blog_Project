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
      <input type="hidden" id="pageNo" value="${pageno}">

      <!--   -----------                       컨텐츠        --------------->
      <!--   -----------                       컨텐츠        --------------->
      <!--   -----------                       컨텐츠        --------------->

      <div class="content contentcontainer" style="margin-top: 60px; padding: 0px 5px;">






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
    var boardType=1;
    $(document).ready(function () {
      pageNo = $("#pageNo").val();
      roadList(boardType, pageNo);
    })



    roadList = function (boardType, No) {
      $.get('/article/list?type=' + boardType + '&pageNo=' + No, function (response) {
        if(response[0] === "Result.OK")
        {
        $('.contentcontainer').children('.boardentity').remove();
        var data = response[1];
        data.forEach(element => {
          var $boardentity = $('<div class="boardentity"></div>');
          var $boardthumnail = $('<img class="boardthumnail" onclick="location.href = \'/article/post?articleid='+element.id+'\'" src="/upload/image/' + element.thumnailpath + '"></img>');
          var $boardboxright = $('<div class="boardboxright"></div>');
          var $boardboxtitle = $('<div class="boardboxtitle" onclick="location.href = \'/article/post?articleid='+element.id+'\'" >' + element.title + '</div>');
          var $boardboxetc = $('<div class="boardboxetc"></div>');
          var $boardinfo = $('<div class="contentDay boardinfo" style="padding-left: 10px !important;"><i class="far fa-calendar-alt"></i>&nbsp; ' + millisToDate(element.updateDate,"#DD#, #MMM#, #YYYY#") + '</div>');
          var $contentauthor = $('<div class="contentauthor boardinfo" style="width: auto; margin-right: 10px;"><img class="contentauthorimage" src="/upload/image/' + element.uservo.profilePath + '">' + element.uservo.userName + '</div>');
          var $tagicon =  $('<i class="fas fa-tags tagicon"></i>');

          $boardentity.append($boardthumnail);
          $boardentity.append($boardboxright);
          $boardboxright.append($boardboxtitle);
          $boardboxright.append($boardboxetc);
          $boardboxetc.append($boardinfo);
          $boardboxetc.append($contentauthor);
          $boardboxetc.append($tagicon);
          element.taglist.forEach(tag => {
            var $tag = ('<a href="/search?type=0&keyword='+tag.tag+'" class="hashtags">' + tag.tag + '</a>');
            $boardboxetc.append($tag);
          })

          $(".contentcontainer").append($boardentity);
        });
        }
        else if(response[0] === "Result.NODATA"){
          pageNo--;
          alert("마지막 페이지 입니다");
        }
        else if(response[0] === "Result.WRONGREQUEST"){
          location.href="/error";
        }

      });
    }






  </script>
  <!--   -----------                       푸터        --------------->
  <!--   -----------                       푸터        --------------->
  <!--   -----------                       푸터        --------------->

</body>

</html>