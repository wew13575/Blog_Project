<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    
    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog" style="width: 320px;">
        <div class="modal-content">
          <form class="text-center border border-light p-5">

            <p class="h4 mb-4">회원 가입</p>
            <hr>
            <!-- E-mail -->
            <input type="email" id="defaultRegisterFormEmail" class="form-control mb-4" placeholder="이메일 입력">

            <!-- Password -->
            <input type="password" id="defaultRegisterFormPassword" class="form-control" placeholder="패스워드 입력"
              aria-describedby="defaultRegisterFormPasswordHelpBlock">
            <small id="defaultRegisterFormPasswordHelpBlock" class="form-text text-muted mb-4">
              At least 8 characters and 1 digit
            </small>

            <!-- Phone number -->
            <input type="text" id="defaultRegisterPhonePassword" class="form-control" placeholder="휴대폰 번호 입력"
              aria-describedby="defaultRegisterFormPhoneHelpBlock">
            <small id="defaultRegisterFormPhoneHelpBlock" class="form-text text-muted mb-4">
              Optional - for two step authentication
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
          <form>


            <div class="group">
              <input type="text" required>
              <span class="highlight"></span>
              <span class="bar"></span>
              <label>ID</label>
            </div>


            <div class="group">
              <input type="text" required>
              <span class="highlight"></span>
              <span class="bar"></span>
              <label>PASSWORD</label>
            </div>

            <button class="formbtn fifth">Login!</button>
          </form>
        </div>
        <hr class="divider">

        <div class="sidebarnav">
          <div class="sidebaritem" onclick="getPaging()"><i class="fas fa-quote-left"></i>&nbsp; &nbsp; 블로그 메인</div>
          <div class="sidebaritem" onclick="getPaging()"><i class="fas fa-user-alt"></i>&nbsp; &nbsp; 우상욱 소개</div>
        </div>

      </div>

    </nav>