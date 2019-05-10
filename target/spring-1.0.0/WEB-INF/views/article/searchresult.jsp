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
                var list;
                var length;


                $(document).ready(function () {
                        pageNo = $("#searchpageno").val();
                        searchtype = $("#searchtype").val();
                        keyword = $("#searchkeyword").val();

                        roadSearchList(searchtype, keyword).then(function (data) {
                                list = data;
                                length = data.length;
                                roadList(0, pageNo);
                        });
                })



                roadSearchList = function (type, word) {
                        return new Promise(function (resolve, reject) {
                                $.get('/article/search?type=' + type + '&keyword=' + word, function (response) {
                                        if (response[0] === "Result.OK") {
                                                resolve(response[1]);

                                        }
                                        else if (response[0] === "Result.NODATA") {
                                                var $img = $('<img id="searchcharactor" src="/resources/image/character.png" >')
                                                $(".articlecontainer").text("'" + word + "'에 대한 검색 결과가 없습니다.");
                                                $(".articlecontainer").css("line-height", "50px");
                                                $(".articlecontainer").css("text-align", "center");
                                                $(".articlecontainer").css("font-weight", "700");
                                                $(".articlecontainer").css("padding-top", "100px");
                                                $(".articlecontainer").append($img);
                                                $(".pagination-wrapper").hide();

                                        }
                                        else if (response[0] === "Result.WRONGREQUEST") {
                                                location.href = "/error";
                                        }
                                });
                        })

                }


                roadList = function (type, no) {
                        var fromindex;
                        var toindex;

                        fromindex = no * 5;
                        toindex = (no + 1) * 5;
                        if (fromindex > length - 1) {
                                alert("마지막 페이지 입니다.");
                                pageNo--;
                        }
                        else {
                                toindex = toindex > length - 1 ? length : toindex;

                                renderList = list.slice(fromindex, toindex);

                                $('.articlecontainer').children('.searchresultentity').remove();
                                renderList.forEach(element => {
                                        console.log(element);

                                        var $searchresultentity = $('<div class="searchresultentity"></div>');
                                        var $resulttitle = $('<a href="/article/post?articleid=' + element.id + '" class="resulttitle">' + element.title + '</a>');
                                        var $resultinfo = $('<div class="resultinfo"><i class="far fa-calendar-alt"></i>&nbsp; ' + millisToDate(element.updateDate, "#DD#, #MMM#, #YYYY#") + ' &nbsp; <img class="contentauthorimage" src="/upload/image/' + element.uservo.profilePath + '">&nbsp;' + element.uservo.userName + ' &nbsp; <i class="fas fa-tags"></i>&nbsp;</div>');
                                        var $resultcontent = $('<div class="resultcontent">' + element.content + '</div>');
                                        var $tag = $('<a>gewgerger</a>');




                                        $searchresultentity.append($resulttitle);
                                        $searchresultentity.append($resultinfo);
                                        element.taglist.forEach(tag => {
                                                var $tag = $('<a class="searchtag" href="/search?type=0&keyword='+replaceAll(replaceAll(tag.tag,"</b>",""), "<b>", "")+'">#' + tag.tag + '&nbsp;</a>');
                                                $resultinfo.append($tag);
                                        })



                                        $searchresultentity.append($resultcontent);

                                        $(".articlecontainer").append($searchresultentity);


                                });




                        }
                        console.log("from :" + fromindex + "to :" + toindex + "list :" + length);
                }






        </script>
</body>

</html>