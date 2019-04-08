<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    
    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog" style="width: 320px;">
        <div class="modal-content">
          <form class="text-center border border-light p-5" action="/user/register" method="post">

            <p class="h4 mb-4">회원 가입</p>
            <hr>
            <!-- E-mail -->
            <input name="userid" type="id" id="defaultRegisterFormEmail" class="form-control mb-4" placeholder="id 입력" required>

            <!-- Password -->
            <input name="userpw" type="password" id="defaultRegisterFormPassword" class="form-control" placeholder="패스워드 입력"
              aria-describedby="defaultRegisterFormPasswordHelpBlock" required>
            <small id="defaultRegisterFormPasswordHelpBlock" class="form-text text-muted mb-4">
              At least 8 characters and 1 digit
            </small>

            <!-- Phone number -->
            <input name="userName" type="text" id="defaultRegisterPhonePassword" class="form-control" placeholder="이름 입력"
              aria-describedby="defaultRegisterFormPhoneHelpBlock" required>
            <small id="defaultRegisterFormPhoneHelpBlock" class="form-text text-muted mb-4">
            </small>

            <!-- Sign up button -->
            <button class="btn btn-info my-4 btn-block" type="submit">Sign in</button>


            <hr>
          </form>
        </div>
      </div>
    </div>

    <div class="overlay"></div>

    <nav id="mySidenav" class="sidenav">
      <div class="sidebarContent">
        <a href="#" id="logoBox">
          장애인의 개발일기
        </a>
        <div id="introduce">
          안녕하세요. 개발 뻘짓 블로그입니다~!.
        </div>
        <hr class="divider">
        <div class="row no-gutters" id="loginBox">
          <sec:authentication property="principal" var="pinfo"/>
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
                  <image class="userimage" src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Albert_Einstein_%28Nobel%29.png/100px-Albert_Einstein_%28Nobel%29.png">
              </div>
              
              <div id="userinfocontent">
                  <p>${pinfo.username}님 반갑습니다!</p>
                  <a href="/user/logout.do">로그아웃</a>&nbsp; <a href="/user/mypage">마이페이지</a>
              </div>

          </sec:authorize>
        </div>
        <hr class="divider">

        <div class="sidebarnav">
          <div class="sidebaritem" onclick="getPaging()"><i class="fas fa-user-alt"></i>&nbsp; &nbsp; 우상욱이야기</div>
          <div class="sidebaritem" onclick="getPaging()"><i class="fas fa-user-alt"></i>&nbsp; &nbsp; 우상욱소개</div>
          <div class="sidebaritem" onclick="getPaging()"><i class="fas fa-user-alt"></i>&nbsp; &nbsp; 자유게시판</div>
        </div>

      </div>

    </nav>