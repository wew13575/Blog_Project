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

  $(document).ready(function () {
    windowWidth = $(window).width();
    Holder.addTheme('thumb', {
      bg: '#55595c',
      fg: '#eceeef',
      text: 'Thumbnail'
    });
    $('.overlay').hide();
  });

  $("#userid").on("change", function () {
    checkid();
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

  $(window).on('resize', myEfficientFn);




  myFunction = function () {
    $('.sidenav').addClass('active');
    $('.overlay').show();
  };


  $('.overlay').on('click', function () {
    $('.sidenav').removeClass('active');
    $('.overlay').hide();
  });

  getPaging = function () {
    alert('ddd');
  };

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

  $("#registersubmit").click(function (event) {
    event.preventDefault();

    if ($("#checkid").val() == '0') {
      alert("check id for register");
    }
    else {
      var form = { userid: $("#userid").val(), userpw: $("#userpw").val(), userName: $("#username").val(), userinfo: $("#userinfo").val(), profilePath: $("#profilepath").val()};
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
        },
        error: function (e) {

        }
      });
    }

  })
$("#fileinput").change(function (){
  var form_data = new FormData();
      form_data.append('file', $('#registerform>input[type=file]')[0].files[0]);
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



  var btns = document.querySelectorAll('.pagination .btn');
  var paginationWrapper = document.querySelector('.pagination-wrapper');
  var bigDotContainer = document.querySelector('.big-dot-container');
  var littleDot = document.querySelector('.little-dot');

  for (var i = 0; i < btns.length; i++) {
    btns[i].addEventListener('click', btnClick);
  }

  function btnClick() {
    if (this.classList.contains('btn--prev')) {
      paginationWrapper.classList.add('transition-prev');
    } else {
      paginationWrapper.classList.add('transition-next');
    }

    var timeout = setTimeout(cleanClasses, 500);
  }

  function cleanClasses() {
    if (paginationWrapper.classList.contains('transition-next')) {
      paginationWrapper.classList.remove('transition-next')
    } else if (paginationWrapper.classList.contains('transition-prev')) {
      paginationWrapper.classList.remove('transition-prev')
    }
  }
  $('.modal').on('hidden.bs.modal', function (e) {
    console.log('modal close');
  $(this).find('form')[0].reset()
});

</script>
<!--   -----------                       푸터        --------------->
<!--   -----------                       푸터        --------------->
<!--   -----------                       푸터        --------------->