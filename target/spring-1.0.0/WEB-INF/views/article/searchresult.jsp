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

                <div class="articlecontainer" style="min-height: 550px; max-width: 590px; padding: 0px 20px;">
                    
                        <div class="searchresultentity">
                                <a href="#" class="resulttitle">
                                        제목입니다제목입니다제목입니다제목입니다제목입니다제목입니다
                                </a>
                                <div class="resultinfo">
                                        <i class="far fa-calendar-alt">
                                        </i> 02, May, 2019 &nbsp; 
                                    <img class="contentauthorimage" src="/upload/image/THUMB_basic.jpg"> sanguk &nbsp; 
                                    <i class="fas fa-tags"></i>
                                </div>
                                <div class="resultcontent">
                                        내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다
                                </div>
                            
                        </div>


                        
                    <div class="searchresultentity">
                            <a href="#" class="resulttitle">
                                    제목입니다제목입니다제목입니다제목입니다제목입니다제목입니다
                            </a>
                            <div class="resultinfo">
                                    <i class="far fa-calendar-alt">
                                    </i> 02, May, 2019 &nbsp; 
                                <img class="contentauthorimage" src="/upload/image/THUMB_basic.jpg"> sanguk &nbsp; 
                                <i class="fas fa-tags"></i>
                            </div>
                            <div class="resultcontent">
                                    내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다
                            </div>
                        
                    </div>
                    <div class="searchresultentity">
                            <a href="#" class="resulttitle">
                                    제목입니다제목입니다제목입니다제목입니다제목입니다제목입니다
                            </a>
                            <div class="resultinfo">
                                    <i class="far fa-calendar-alt">
                                    </i> 02, May, 2019 &nbsp; 
                                <img class="contentauthorimage" src="/upload/image/THUMB_basic.jpg"> sanguk &nbsp; 
                                <i class="fas fa-tags"></i>
                            </div>
                            <div class="resultcontent">
                                    내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다
                            </div>
                        
                    </div>
                    <div class="searchresultentity">
                            <a href="#" class="resulttitle">
                                    제목입니다제목입니다제목입니다제목입니다제목입니다제목입니다
                            </a>
                            <div class="resultinfo">
                                    <i class="far fa-calendar-alt">
                                    </i> 02, May, 2019 &nbsp; 
                                <img class="contentauthorimage" src="/upload/image/THUMB_basic.jpg"> sanguk &nbsp; 
                                <i class="fas fa-tags"></i>
                            </div>
                            <div class="resultcontent">
                                    내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다
                            </div>
                        
                    </div>
                    <div class="searchresultentity">
                            <a href="#" class="resulttitle">
                                    제목입니다제목입니다제목입니다제목입니다제목입니다제목입니다
                            </a>
                            <div class="resultinfo">
                                    <i class="far fa-calendar-alt">
                                    </i> 02, May, 2019 &nbsp; 
                                <img class="contentauthorimage" src="/upload/image/THUMB_basic.jpg"> sanguk &nbsp; 
                                <i class="fas fa-tags"></i>
                            </div>
                            <div class="resultcontent">
                                    내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다
                            </div>
                        
                    </div>
                </div>
                    <div class="pagination-wrapper" style="
                    background: #f1f1f1;
                    max-width: 590px; margin:0px auto; float: none;">
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