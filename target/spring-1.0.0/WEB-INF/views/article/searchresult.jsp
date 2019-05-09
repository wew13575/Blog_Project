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

                        <input type="hidden" id="searchtype" value="${type}">
                        <input type="hidden" id="searchpageno" value="${pageno}">
                        <input type="hidden" id="searchkeyword" value="${keyword}">
                        <!--   -----------                       컨텐츠        --------------->
                        <!--   -----------                       컨텐츠        --------------->
                        <!--   -----------                       컨텐츠        --------------->

                        <div class="articlecontainer" style="min-height: 650px; max-width: 590px; padding: 0px 20px;">

                                <div class="searchresultentity">
                                        <a href="#" class="resulttitle">
                                                제목입니다제목입니다제목입니다제목입니다제목입니다제목입니다
                                        </a>
                                        <div class="resultinfo">
                                                <i class="far fa-calendar-alt">
                                                </i> 02, May, 2019 &nbsp;
                                                <img class="contentauthorimage" src="/upload/image/THUMB_basic.jpg">
                                                sanguk &nbsp;
                                                <i class="fas fa-tags"></i>
                                        </div>
                                        <div class="resultcontent">
                                                내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다내용입니다
                                        </div>

                                </div>

                        </div>
                        <div class="pagination-wrapper" style="
                    background: #ffffff;
                    max-width: 590px; margin:0px auto; float: none;">
                                <div class="pagination">
                                        <svg class="btn btn--prev" height="96" viewBox="0 0 24 24" width="60"
                                                xmlns="http://www.w3.org/2000/svg">
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

                                        <svg class="btn btn--next" height="96" viewBox="0 0 24 24" width="60"
                                                xmlns="http://www.w3.org/2000/svg">
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

        <script>

                var pageNo;
                var searchtype;
                var keyword;
                var boardType = 0;
                var length;


                $(document).ready(function () {
                        pageNo = $("#searchpageno").val();
                        searchtype = $("#searchtype").val();
                        keyword = $("#searchkeyword").val();
                        
                        roadSearchList(searchtype, keyword);
                        roadList(0, pageNo);
                })



                roadSearchList = function (type, word) {
                        var list = null;
                        $.get('/article/search?type=' + type + '&keyword=' + word, function (response) {
                                if (response[0] === "Result.OK") {
                                        list = response[1];
                                        console.log(list);

                                }
                                else if (response[0] === "Result.NODATA") {
                                        $(".articlecontainer").text("'" + word + "'에 대한 검색 결과가 없습니다.");
                                        $(".articlecontainer").css("line-height", "350px");
                                        $(".articlecontainer").css("text-align", "center");
                                        $(".articlecontainer").css("font-weight", "700");
                                        $(".pagination-wrapper").hide();

                                }
                                else if (response[0] === "Result.WRONGREQUEST") {
                                        location.href = "/error";
                                }
                        });
                        console.log(list);
                        
                        return list;
                }
                

                roadList = function (type, no) {
                        var fromindex;
                        var toindex;

                        if ((no * 5) > 0) {
                                alert("마지막 페이지 입니다.");
                                pageNo--;
                        }
                        fromindex = no * 5;
                        toindex = (no + 1) * 5 > 0 ? 0 : (no + 1) * 5;
                        console.log("from :" + fromindex + "to :" + toindex + "list :" + 0);

                }






        </script>
</body>

</html>