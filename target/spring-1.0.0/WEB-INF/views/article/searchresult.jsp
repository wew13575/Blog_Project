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

                <div class="articlecontainer" style="min-height: 850px;">
                    
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

    </script>
</body>

</html>