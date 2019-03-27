<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>


<%@ include file="include/head.jsp" %>







<body>


  <!--   -----------            사이드바        --------------->
  <div class="wrapper">

        <%@ include file="include/nav.jsp" %>
    <!--   -----------            사이드바        --------------->
    <div class="content">
    <!--   -----------                       헤  더        --------------->
  
    <%@ include file="include/header.jsp" %>


      <!--   -----------                       헤  더        --------------->



      <!--   -----------                       컨텐츠        --------------->

      <div class="container-fluid">

        <div id="emptydiv"></div>
        <!-- HashTag List -->
        <div class="nav-scroller py-1 mb-2" id="hashtagbox">
          <nav class="nav d-flex justify-content-between">
            <a class="p-2 text-muted" href="#">해쉬태그리스트~!</a>
          </nav>
        </div>

        <div class="row mb-2">

          <div class="col-md-6 contentItem">
            <div class="card box-shadow h-md-250">
              <img class="card-img-right flex-auto contentThumbnail" onclick="getPaging()"
                data-src="holder.js/autox250?theme=thumb" alt="Thumbnail [autox250]" style="width: auto; height: 250px;"
                src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%22200%22%20height%3D%22250%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%20200%20250%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_1699f3b9bc5%20text%20%7B%20fill%3A%23eceeef%3Bfont-weight%3Abold%3Bfont-family%3AArial%2C%20Helvetica%2C%20Open%20Sans%2C%20sans-serif%2C%20monospace%3Bfont-size%3A13pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_1699f3b9bc5%22%3E%3Crect%20width%3D%22200%22%20height%3D%22250%22%20fill%3D%22%2355595c%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%2256.203125%22%20y%3D%22131%22%3EThumbnail%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E"
                data-holder-rendered="true">
              <div class="card-body d-flex flex-column align-items-start postContent">
                <p class="postTitle" onclick="getPaging()">포스트 제목</p>
                <p class="postDay">2019년 3월 26일</p>
                <p class="postContent">This is a wider card with supporting text below as a natural lead-in to
                  additional content.</p>
                <div class="hashtaglist">
                  <a class="postHashtag" href="#">해쉬태그</a> <a class="postHashtag" href="#">해쉬태그 </a> <a
                    class="postHashtag" href="#">해쉬태그 </a> <a class="postHashtag" href="#">해쉬태그 </a> <a
                    class="postHashtag" href="#">해쉬태그 </a>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!--   -----------                       컨텐츠        --------------->





        <!--   -----------                       푸터        --------------->

        <%@ include file="include/footer.jsp" %>
  <!--   -----------                       푸터        --------------->

</body>

</html>