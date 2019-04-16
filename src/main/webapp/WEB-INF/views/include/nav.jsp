<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    
    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog" style="width: 320px;">
        <div class="modal-content">
          <form id="registerform" class="text-center border border-light p-5" method="post" enctype="multipart/form-data">

            <p class="h4 mb-4">회원 가입</p>
            <hr>
            <!-- E-mail -->
            <input name="userid" type="id" id="userid" class="form-control" placeholder="Id *" required>
            <small id="resultcheck" class="form-text text-muted mb-4">
            </small>
            <input id="checkid" type="hidden" value="0"> 
            <!-- Password -->
            <input name="userpw" type="password" id="userpw" class="form-control" placeholder="Password *"
              aria-describedby="defaultRegisterFormPasswordHelpBlock" required>
            <small id="defaultRegisterFormPasswordHelpBlock" class="form-text">
              At least 8 characters and 1 digit
            </small>

            <!-- Phone number -->
            <input name="userName" type="text" id="username" class="form-control" placeholder="Nickname *"
              aria-describedby="defaultRegisterFormPhoneHelpBlock" required>
            <small id="defaultRegisterFormPhoneHelpBlock" class="form-text">
            </small>

            
            <input id="fileinput" type="file" name="profile" accept=".jpg, .jpeg, .png"> 
            <input id="profilepath" type="hidden" value="basicprofile.jpg">
            
            <input name="userinfo" type="text" id="userinfo" class="form-control mb-4" placeholder="Your Info">

            <!-- Sign up button -->
            <button class="btn btn-info my-4 btn-block" id="registersubmit">Sign in</button>


            <hr>
          </form>
        </div>
      </div>
    </div>

    <div class="overlay"></div>

    <nav id="mySidenav" class="sidenav">
      <div class="sidebarContent">
        <a href="#" id="logoBox">
          장애인wdw의 개발일기
        </a>
        <div id="introduce">
          안녕하세요. 개발 뻘짓 블로그입니다~!.
        </div>
        <hr class="divider">
        <div class="row no-gutters" id="loginBox">
          <sec:authorize access="isAnonymous()">
          <form action="/user/login.do" method="POST">
            <div class="group">
              <input type="text" name="loginid" required>
              <span class="highlight"></span>
              <span class="bar"></span>
              <label>ID</label>
            </div>
            <div class="group">
              <input type="password" name="loginpw" required>
              <span class="highlight"></span>
              <span class="bar"></span>
              <label>PASSWORD</label>
            </div>

            <button type="submit" class="formbtn fifth" >Login!</button>
          </form>
          </sec:authorize>
          <sec:authorize access="isAuthenticated()">
              <div class="userimagebox">
                  <image class="userimage" src="/upload/image/${uservo.profilePath}">
              </div>
              
              <div id="userinfocontent">
                  <p>${uservo.userid}님 반갑습니다!</p>
                  <a href="/user/logout.do">로그아웃</a>&nbsp; <a href="/user/mypage">마이페이지</a>
              </div>

          </sec:authorize>
        </div>
        <hr class="divider">

        <div class="sidebarnav">
          <div class="sidebaritem" onclick="getPaging()"><i class="fas fa-user-alt"></i>&nbsp; &nbsp; 홈</div>
          <div class="sidebaritem" onclick="getPaging()"><i class="fas fa-user-alt"></i>&nbsp; &nbsp; 우상욱이야기</div>
          <div class="sidebaritem" onclick="getPaging()"><i class="fas fa-user-alt"></i>&nbsp; &nbsp; 우상욱소개</div>
          <div class="sidebaritem" onclick="getPaging()"><i class="fas fa-user-alt"></i>&nbsp; &nbsp; 자유게시판</div>
        </div>

      </div>

    </nav>