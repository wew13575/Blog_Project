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








<body>




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


      <div id="summernotecontainer">
        <form action="/article/modify" class="boardSubmit" method="post" enctype="multipart/form-data"
          style="padding:5px;">
            <input type="hidden" name="boardType" id="boardselector" value="${articlevo.boardType}">
          
          <button class="btn btn-primary" id="editorbutton" type="submit">수정하기</button>
          <input name="title" maxlength="30" type="text" id="defaultRegisterFormEmail" class="form-control p-2 editorcontrol" placeholder="TITLE"
            style="margin: 10px 0px;" required value="${articlevo.title}">
          <textarea class="form-control" id="summernote" name="content" placeholder="content" maxlength="1000"
            rows="7" required>${articlevo.content}</textarea>

          <sec:authorize access="hasRole('ROLE_ADMIN')">
            <input name="tag" maxlength="30" type="text" id="defaultRegisterFormEmail" class="form-control editorcontrol" placeholder="#HASHTAG"
              style="margin: 10px 0px;" value="${tagstring}">
          </sec:authorize>
          <input type="hidden" name="author" value="${uservo.userid}">
          <input type="hidden" name="id" value="${articlevo.id}">
          <input type="hidden" id="imgcnt" name="contentimgcnt" value="1">
          <input type="hidden" name="Thumnailpath" value="THUMB_basic.jpg">
        </form>
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
  <!--   -----------                       푸터        --------------->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.js"></script>

  <script>

    function sendFile(file, el) {
      var form_data = new FormData();
      form_data.append('file', file);
      $.ajax({
        data: form_data,
        type: "POST",
        url: '/upload/image.do',
        cache: false,
        contentType: false,
        enctype: 'multipart/form-data',
        processData: false,
        success: function (url) {
          $("#imgcnt").val("1");
          $(el).summernote('editor.insertImage', url);
        }
      });
    }

    $('#summernote').summernote({
      height: 500,                 // set editor height
      minHeight: 500,             // set minimum height of editor
      maxHeight: null,
      disableDragAndDrop: false,         // set maximum height of editor
      fontNames: ['맑은고딕', 'Arial', 'Arial Black', 'Comic Sans MS', 'Courier New',],
      fontNamesIgnoreCheck: ['맑은고딕'],
      focus: true,
      callbacks: {
        onImageUpload: function (files, editor, welEditable) {
          for (var i = files.length - 1; i >= 0; i--) {
            sendFile(files[i], this);
          }
        }
      }
    });

  </script>
</body>

</html>