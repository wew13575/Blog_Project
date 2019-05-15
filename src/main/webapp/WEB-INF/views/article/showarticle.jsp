<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>

<head>
  <!--   -----------            헤드        --------------->
  <%@ include file="../include/head.jsp" %>
  <!--   -----------            헤드        --------------->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.css" rel="stylesheet">

</head>








<body style="background: rgb(241, 241, 241) !important">




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

      <!--   -----------                       컨텐츠        --------------->
      <!--   -----------                       컨텐츠        --------------->
      <!--   -----------                       컨텐츠        --------------->

      <div class="articlecontainer">
        <div id="articletitle">
          ${articlevo.title}
        </div>



        <div id="topbox">
          <div id="articleinfo">
            <image class="userimage" src="/upload/image/${articlevo.uservo.profilePath}" style="float:left;">
            </image>
            <div class="infobox" id="articleinfoname"><a href="/search?type=2&keyword=${articlevo.author}">${articlevo.uservo.userName}</a></div>
            <input type="hidden" id="articledate" value="${articlevo.millis}">
            <div class="infobox" id="articleinfodate"></div>

          </div>
          <div id="exportBox">

          </div>
        </div>

        <div id="articlecontent">
          ${articlevo.content}
        </div>
        <div id="articletag">
          <c:forEach var="tag" items="${articlevo.taglist}">
            <a href="/search?type=0&keyword=${tag.tag}">${tag.tag}</a>
          </c:forEach>
        </div>
        <div id="commentcontainer">
          <c:forEach var="comment" items="${articlevo.commentlist}">

            <div class="commententity">
              <div class="commentorprofile">
                <img class="userimage" src="/upload/image/${comment.uservo.profilePath}">
                </img>
              </div>
              <div class="comment">
                <div class="commentboxtop">
                  <div class="commentorname">
                    ${comment.uservo.userName}
                  </div>
                  <div class="commentdate">
                    ${comment.regDate}
                  </div>
                </div>
                <div class="commentcontent">
                  ${comment.content}
                </div>
                <div class="commentboxbutton">
                  <c:if test="${uservo.userid eq comment.author}">
                    <button class="commentbutton commentdelete" value="${comment.id}">Delete</button>
                  </c:if>


                </div>
              </div>

            </div>
          </c:forEach>
        </div>
        <sec:authorize access="isAuthenticated()">
          <div id="commenteditor">
            <input type="hidden" id="PARAM_userid" value="${uservo.userid}">
            <input type="hidden" id="PARAM_articleid" value="${articlevo.id}">
            <textarea id="commentformtext"></textarea>
            <div id="formbuttonbox">

              <button class="commentbutton" id=commentformsubmit>
                Write
              </button>
            </div>
          </div>
        </sec:authorize>
        <div id="articlebuttonbox">
          <form style="display: hidden" action="/article/delete?articleid=${articlevo.id}" method="post"
            id="articledeleteform">

            <input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}"/>
            <c:if test="${uservo.userid eq articlevo.author}">
              <button id="articledeletebutton" class="commentbutton articlebutton">
                Delete
              </button>
            </c:if>
          </form>
          <c:if test="${uservo.userid eq articlevo.author}">
            <button onclick="location.href = '/article/modify?articleid=${articlevo.id}' "
              class="commentbutton articlebutton">
              Edit
            </button>
          </c:if>
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

        <%@ include file="../include/footer.jsp" %>

      </footer>
    </div>
  </div>





  <!-- Bootstrap core JavaScript
    ================================================== -->
  <!-- Placed at the end of the document so the pages load faster -->

  <%@ include file="../include/script.jsp" %>
  <!--   -----------                       푸터        --------------->
  <!--   -----------                       푸터        --------------->

  <script>
    $(document).ready(function () {
      var date = Number($("#articledate").val());
      $("#articleinfodate").text(millisToDate(date, "#hh#:#mm# #DD##th#, #MMMM#, #YYYY#"));
    })
  </script>
</body>

</html>