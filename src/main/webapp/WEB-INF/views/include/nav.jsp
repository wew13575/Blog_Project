<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <div class="overlay"></div>

    <nav id="mySidenav" class="sidenav">
      <div class="sidebarContent">

        <div class="row no-gutters" id="logoBox">
          장애인의 개발일기
        </div>
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

        <ul class="sidebarnav" id="nav">
          <li onclick="getPaging()">블로그 메인</li>
          <li onclick="getPaging()">포트폴리오</li>
          <li onclick="getPaging()">연락</li>
        </ul>

      </div>
    </nav>