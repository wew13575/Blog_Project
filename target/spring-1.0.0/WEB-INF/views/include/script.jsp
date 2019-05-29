<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="/resources/js/jquery-3.3.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
  integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/holderjs@2.9.4/holder.js"></script>
<script>
  var windowWidth = 0;
  var didScroll;
  var lastScrollTop = 0;
  var delta = 5;
  var navbarHeight = 55;
  var token;
  var header;




  //VIEW PROCESSING
  $(document).ready(function () {
    windowWidth = $(window).width();
    Holder.addTheme('thumb', {
      bg: '#55595c',
      fg: '#eceeef',
      text: 'Thumbnail'
    });
    token = $("meta[name='_csrf']").attr("content");
    header = $("meta[name='_csrf_header']").attr("content");
    console.log(token + header);
    $('.overlay').hide();
  });


  $.ajaxSetup({
    beforeSend: function (xhr) {
      if (header && token) {
        xhr.setRequestHeader(header, token);
      }
    }
  });






  $(window).scroll(function (event) {
    didScroll = true;
  });
  setInterval(function () {
    if (didScroll) {
      hasScrolled();
      didScroll = false;
    }
  }, 250);

  function hasScrolled() {
    var st = $(this).scrollTop();
    if (Math.abs(lastScrollTop - st) <= delta)
      return;
    if (st > lastScrollTop && st > navbarHeight) {
      $('.headerBox').hide();
    } else {
      if (st + $(window).height() < $(document).height()) {
        $('.headerBox').show();
      }
    } lastScrollTop = st;
  }

  function debounce(func, wait, immediate) {
    var timeout;
    return function () {
      var context = this, args = arguments;
      var later = function () {
        timeout = null;
        if (!immediate) func.apply(context, args);
      };
      var callNow = immediate && !timeout;
      clearTimeout(timeout);
      timeout = setTimeout(later, wait);
      if (callNow) func.apply(context, args);
    };
  };


  $(window).on('resize', myEfficientFn);

  var myEfficientFn = debounce(function () {

    windowWidth = $(window).width();
    $('.headerBox').show();



    if (windowWidth > 768 && !$('.searchform .search').hasClass('close')) {
      $(".headerItem").removeClass("onSearchForm");
    }
    if (windowWidth <= 768 && $('.searchform .search').hasClass('close') && !$('.headerItem').hasClass('onSearchForm')) {

      $(".headerItem").toggleClass("onSearchForm");
    }
  }, 100);


  myFunction = function () {
    $('.sidenav').addClass('active');
    $('.overlay').show();
  };


  $('.overlay').on('click', function () {
    $('.sidenav').removeClass('active');
    $('.overlay').hide();
  });



  function expand() {

    if (!$('.searchform .search').hasClass('close')) {
      $(".headerItem").removeClass("onSearchForm");
    }
    if (windowWidth < 768) {
      $(".headerItem").toggleClass("onSearchForm");
    }
    $(".searchform .search").toggleClass("close");
    $(".searchform .input").toggleClass("square");
    $(".searchform").toggleClass("opensearch");
    if ($('.searchform .search').hasClass('close')) {
      $('input').focus();
    } else {
      $('input').blur();
    }
  }
  $('.search').on('click', expand);



  //blogpagenation
  var btns = document.querySelectorAll('.pagination .btn');
  var paginationWrapper = document.querySelector('.pagination-wrapper');
  var bigDotContainer = document.querySelector('.big-dot-container');
  var littleDot = document.querySelector('.little-dot');

  for (var i = 0; i < btns.length; i++) {
    btns[i].addEventListener('click', btnClick);
  }

  function btnClick() {
    $('.headerBox').show();
    if (this.classList.contains('btn--prev')) {
      paginationWrapper.classList.add('transition-prev');
      pagenation(0);
    } else {
      paginationWrapper.classList.add('transition-next');
      pagenation(1);
    }

    var timeout = setTimeout(cleanClasses, 500);
  }
  function replaceAll(str, searchStr, replaceStr) {
    return str.split(searchStr).join(replaceStr);
  }
  function cleanClasses() {
    if (paginationWrapper.classList.contains('transition-next')) {
      paginationWrapper.classList.remove('transition-next')
    } else if (paginationWrapper.classList.contains('transition-prev')) {
      paginationWrapper.classList.remove('transition-prev')
    }
  }
  pagenation = function (way) {
    document.documentElement.scrollTop = 0;
    if (way == 0) {
      if (pageNo <= 0) {
        alert("첫 페이지 입니다");
      }
      else {
        pageNo--;
        roadList(boardType, pageNo)
      }
    }
    else {
      pageNo++;
      roadList(boardType, pageNo)
    }
  }
  //blogpagenation





  //blogpagenation





  //userprofileview


  const uploadButton = document.querySelector('.browse-btn');
  const fileInfo = document.querySelector('.file-info');
  const realInput = document.getElementById('fileinput');
  uploadButton.addEventListener('click', (event) => {
    event.preventDefault();
    realInput.click();
  });
  realInput.addEventListener('change', () => {
    const name = realInput.value.split(/\\|\//).pop();
    const truncated = name.length > 20
      ? name.substr(name.length - 20)
      : name;

    fileInfo.innerHTML = truncated;
  });















  //userregisterchect
  $("#userid").on("change", function () {
    checkid();
  });
  $("#username").on("change", function () {
    checknick();
  });




  $("#articledeletebutton").click(function (event) {
    event.preventDefault;

    var con_test = confirm("정말 삭제 하시겠습니까?.");

    if (con_test == true) {
      $("#articledeleteform").submit();
    }
  });






  $("#commentformsubmit").click(function (event) {
    event.preventDefault;
    var form = { articleid: $("#PARAM_articleid").val(), author: $("#PARAM_userid").val(), content: $("#commentformtext").val() };
    console.log(form);
    console.log(JSON.stringify(form));
    $.ajax({

      headers: {
        'Content-Type': 'application/json'
      },
      data: JSON.stringify(form),
      url: "/comment/write",
      processData: false,
      contentType: "application/json",
      type: 'POST',
      success: function (commentVO) {

        console.log(commentVO);

        var $commententity = $('<div class="commententity"></div>');
        var $commentorprofile = $('<div class="commentorprofile"></div>');
        var $comment = $('<div class="comment"></div>');
        var $commentboxtop = $('<div class="commentboxtop"></div>');
        var $commentorname = $('<div class="commentorname">' + commentVO.uservo.userName + '</div>');
        var $commentdate = $('<div class="commentdate">' + commentVO.regDate + '</div>');
        var $commentcontent = $('<div class="commentcontent">' + commentVO.content + '</div>');
        var $commentboxbutton = $('<div class="commentboxbutton"></div>');

        var $userimage = $('<img class="userimage" src="/upload/image/' + commentVO.uservo.profilePath + '"></img>');
        var $commentbutton = $('<button class="commentbutton commentdelete comajax" value="' + commentVO.id + '">Delete</button>');

        $commentorprofile.append($userimage);
        $commententity.append($commentorprofile);

        $commentboxtop.append($commentorname);
        $commentboxtop.append($commentdate);


        $commentboxbutton.append($commentbutton);

        $comment.append($commentboxtop);
        $comment.append($commentcontent);
        $comment.append($commentboxbutton);

        $commententity.append($comment);

        $("#commentcontainer").append($commententity);
        $("#commentformtext").val("");
        $(".commentdelete").off("click");
        
        $(".commentdelete").click(function (e) {
          button = $(this);
          deleteComment(e, button);
        }); 


      },
      error: function (request, status, error) {
        console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
      }
    });
  });








  $(".commentdelete").click(function (e) {
    button = $(this);
    deleteComment(e, button);
  });

  function deleteComment(event, button) {
    event.preventDefault;
    var form = { commentId: Number(button.val()) };
    console.log(form);
    console.log(JSON.stringify(form));
    var thisentity =
      button.closest('.commententity');

    var con_test = confirm("정말 삭제 하시겠습니까?");

    if (con_test == true) {
      $.ajax({
        headers: {
          'Content-Type': 'application/json'
        },
        data: JSON.stringify(form),
        url: "/comment/delete",
        type: 'POST',
        contentType: "application/json",
        success: function (data) {
          thisentity.remove();
          alert("삭제 완료 되었습니다.");

        },
        error: function (e) {
          alert("존재하지 않는 댓글 입니다.");
          console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
        }
      });
    }

  }













  checkid = function () {
    $.ajax({
      data: { "id": $("#userid").val() },
      type: "POST",
      url: '/user/checkid',
      success: function (result) {
        console.log(result);
        console.log(result.checkStatus);
        if (result == true) {
          $("#resultcheck").text("가입 할 수 있는 ID입니다.");
          $("#resultcheck").css("color", "blue");
          $("#checkid").val("1");

        }
        else {
          $("#resultcheck").text("가입 할 수 없는 ID입니다.");
          $("#resultcheck").css("color", "red");
          $("#checkid").val("0");
        }
      }
    });
  };

  millisToDate = function (s, q) {
    var date = new Date(s);

    return date.customFormat(q);

  }


  Date.prototype.customFormat = function (formatString) {
    var YYYY, YY, MMMM, MMM, MM, M, DDDD, DDD, DD, D, hhhh, hhh, hh, h, mm, m, ss, s, ampm, AMPM, dMod, th;
    YY = ((YYYY = this.getFullYear()) + "").slice(-2);
    MM = (M = this.getMonth() + 1) < 10 ? ('0' + M) : M;
    MMM = (MMMM = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"][M - 1]).substring(0, 3);
    DD = (D = this.getDate()) < 10 ? ('0' + D) : D;
    DDD = (DDDD = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"][this.getDay()]).substring(0, 3);
    th = (D >= 10 && D <= 20) ? 'th' : ((dMod = D % 10) == 1) ? 'st' : (dMod == 2) ? 'nd' : (dMod == 3) ? 'rd' : 'th';
    formatString = formatString.replace("#YYYY#", YYYY).replace("#YY#", YY).replace("#MMMM#", MMMM).replace("#MMM#", MMM).replace("#MM#", MM).replace("#M#", M).replace("#DDDD#", DDDD).replace("#DDD#", DDD).replace("#DD#", DD).replace("#D#", D).replace("#th#", th);
    h = (hhh = this.getHours());
    if (h == 0) h = 24;
    if (h > 12) h -= 12;
    hh = h < 10 ? ('0' + h) : h;
    hhhh = hhh < 10 ? ('0' + hhh) : hhh;
    AMPM = (ampm = hhh < 12 ? 'am' : 'pm').toUpperCase();
    mm = (m = this.getMinutes()) < 10 ? ('0' + m) : m;
    ss = (s = this.getSeconds()) < 10 ? ('0' + s) : s;
    return formatString.replace("#hhhh#", hhhh).replace("#hhh#", hhh).replace("#hh#", hh).replace("#h#", h).replace("#mm#", mm).replace("#m#", m).replace("#ss#", ss).replace("#s#", s).replace("#ampm#", ampm).replace("#AMPM#", AMPM);
  };





  checknick = function () {
    $.ajax({
      data: { "nick": $("#username").val() },
      type: "POST",
      url: '/user/checknick',
      success: function (result) {
        console.log(result);
        console.log(result.checkStatus);
        if (result == true) {
          $("#resultchecknick").text("사용 가능한 닉네임입니다.");
          $("#resultchecknick").css("color", "blue");
          $("#checknick").val("1");

        }
        else {
          $("#resultchecknick").text("사용 불 가능한 닉네임입니다.");
          $("#resultchecknick").css("color", "red");
          $("#checknick").val("0");
        }
      }
    });
  };






  $("#userpw").on("change", function () {
    if (!/^[a-zA-Z0-9]{8,12}$/.test($("#userpw").val())) {
      $("#passresultcheck").css("color", "red");
      $("#pwcheck").val("0");
    }
    else {
      $("#passresultcheck").text("good password!!");
      $("#passresultcheck").css("color", "blue");
      $("#pwcheck").val("1");
    }
  });

  $("#registersubmit").click(function (event) {
    event.preventDefault();

    if ($("#checkid").val() == '0') {
      alert("check id for register!!");
    }
    else if ($("#pwcheck").val() == '0') {
      alert("check password for register!!");
    }
    else if ($("#checknick").val() == '0') {
      alert("check nickname for register!!");
    }
    else {
      var form = { userid: $("#userid").val(), userpw: $("#userpw").val(), userName: $("#username").val(), userinfo: $("#userinfo").val(), profilePath: $("#profilepath").val() };
      console.log(form);
      console.log(JSON.stringify(form));


      var formData = new FormData();
      $.ajax({

        headers: {
          'Content-Type': 'application/json'
        },
        data: JSON.stringify(form),
        url: "/user/register",
        processData: false,
        contentType: "application/json",
        type: 'POST',
        success: function (data) {
          $("#myModal").modal("hide");
          $("#resultcheck").text("Enter your ID (necessary)");
          $("#passresultcheck").text("At least 8 characters and 1 digit (necessary)");
          $("#passresultcheck").css("color", "");
          $("#resultcheck").css("color", "");
        },
        error: function (e) {

        }
      });
    }

  })

  $('.modal').on('hidden.bs.modal', function (e) {
    console.log('modal close');
    $(this).find('form')[0].reset()
  });










  $("#fileinput").change(function () {
    var form_data = new FormData();
    form_data.append('file', $('#registerform>div>input[type=file]')[0].files[0]);
    $.ajax({
      data: form_data,
      type: "POST",
      url: '/user/saveprofile',
      cache: false,
      contentType: false,
      enctype: 'multipart/form-data',
      processData: false,
      success: function (profilepath) {
        $("#profilepath").val(profilepath);
        alert(profilepath);
      }
    });
  })



</script>
<!--   -----------                       푸터        --------------->
<!--   -----------                       푸터        --------------->
<!--   -----------                       푸터        --------------->