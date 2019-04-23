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
  <%@ include file="include/head.jsp" %>
  <!--   -----------            헤드        --------------->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.css" rel="stylesheet">

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

      <div id="articlecontainer">
        <input type="hidden" id="PARAM_articleid" value="${articlevo.id}">
        <div id="articletitle">
          ${articlevo.title}
        </div>



        <div id="topbox">
          <div id="articleinfo">
            <image class="userimage" src="/upload/image/${articlevo.uservo.profilePath}" style="float:left;">
            </image>
            <div class="infobox" id="articleinfoname">${articlevo.uservo.userName}</div>
            <div class="infobox" id="articleinfodate">${articlevo.updateDate}</div>

          </div>
          <div id="exportBox">

          </div>
        </div>

        <div id="articlecontent">
          ${articlevo.content}
        </div>
        <div id="articletag">
          <c:forEach var="tag" items="${articlevo.taglist}">
            <a href="/search?keyword=${tag.tag}">${tag.tag}</a>
          </c:forEach>
        </div>
        <div id="commentcontainer">
          <c:forEach var="comment" items="${articlevo.commentlist}">
            <div class="commententity">
              <div class="commentorprofile">
                <image class="userimage" src="/upload/image/${comment.uservo.profilePath}">
                </image>
              </div>
              <div class="comment">
                <div class="commentboxtop">
                  <div class="commentorname">
                    ${comment.uservo.userName}
                  </div>
                  <div class="commentdate">
                    ${comment.updateDate}
                  </div>
                </div>
                  <div class="commentcontent">
                    ${comment.content}
                  </div>
                  <div class="commentboxbutton">
                      <button class="commentbutton">Edit</button>
                      <button class="commentbutton">Delete</button>

                  </div>

              </div>
            </div>
          </c:forEach>
        </div>
        <sec:authorize access="isAuthenticated()">
          <form id="commenteditor">
            <input type="hidden" id="PARAM_userid" value="${uservo.userName}">
            <textarea id=commentformtext></textarea>
            <div id="formbuttonbox">

            <button class="commentbutton" id=commentformsubmit>
              Write
            </button>
          </div>
          </form>
        </sec:authorize>
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
</body>

</html>