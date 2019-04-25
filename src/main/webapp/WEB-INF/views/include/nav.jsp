<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" style="width: 320px;">
    <div class="modal-content">
      <form id="registerform" method="post" enctype="multipart/form-data">
        <p>SIGN IN</p>
        <hr>
        <!-- E-mail -->
        <input name="userid" type="id" id="userid" class="form-control" maxlength="10"  required>
        <small id="resultcheck" class="form-text">Enter your ID (necessary)
        </small>
        <input id="checkid" type="hidden" value="0">
        <!-- Password -->
        <input name="userpw" type="password" id="userpw" maxlength="12" class="form-control"
          aria-describedby="defaultRegisterFormPasswordHelpBlock" required>
        <small id="passresultcheck" class="form-text">
          At least 8 characters and 1 digit (necessary)
        </small>
        <input id="pwcheck" type="hidden" value="0">

        <!-- Phone number -->
        <input name="userName" type="text" id="username" maxlength="5" class="form-control"
          aria-describedby="defaultRegisterFormPhoneHelpBlock" required>
          <small id="resultchecknick" class="form-text">
            Enter your Nickname (necessary)
          </small>
          <input id="checknick" type="hidden" value="0">

          <div class="input-container">
            <input type="file" id="fileinput" name="profile" accept=".jpg, .jpeg, .png">
            <button class="browse-btn">
              Browse Files
            </button>
            <span class="file-info">Upload a file</span>
          </div>
        <small  class="form-text">
          Upload your Profile (optionaly)
        </small>
        <input id="profilepath" type="hidden" value="basicprofile.jpg">
        

        <textarea name="userinfo" type="text" id="userinfo" class="form-control" maxlength="200" cols="40" rows="5"></textarea>
        <small  class="form-text">
          Introduce your self (optionaly)
        </small>
        <hr>
        <!-- Sign up button -->
        <button class="btn btn-info btn-block" id="registersubmit">Sign in</button>
      </form>
    </div>
  </div>
</div>

<div class="overlay"></div>

<nav id="mySidenav" class="sidenav">
  <div class="sidebarContent">
    <a href="#" id="logoBox">
      우 산 국
    </a>
    <sec:authorize access="isAnonymous()">
      <div class="row no-gutters" id="loginBox">
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

          <button type="submit" class="formbtn fifth">Login!</button>
        </form>
      </div>
    </sec:authorize>

    <sec:authorize access="isAuthenticated()">
      <div class="row no-gutters" id="userBox">
        <div class="userimagebox">
          <image class="userimage" src="/upload/image/${uservo.profilePath}">
        </div>

        <div id="userinfocontent">
          <p>${uservo.userName}님</p>
        </div>

        <div id="userbuttonbox">
          <a href="#" class="userbutton write">WRITE</a>
          <a href="#" class="userbutton logout">LOGOUT</a>
        </div>
      </div>
    </sec:authorize>
  <hr class="divider">

  <div class="sidebarnav">
    <div class="sidebaritem" onclick="location.href = '/'"><i class="fas fa-user-alt"></i>&nbsp; &nbsp; HOME</div>
    <div class="sidebaritem" onclick="location.href = '/blog'"><i class="fas fa-user-alt"></i>&nbsp; &nbsp; BLOG</div>
    <div class="sidebaritem" onclick="location.href = '/info'"><i class="fas fa-user-alt"></i>&nbsp; &nbsp; INTRODUCE</div>
    <div class="sidebaritem" onclick="location.href = '/board'"><i class="fas fa-user-alt"></i>&nbsp; &nbsp; BOARD</div>
  </div>

  </div>

</nav>