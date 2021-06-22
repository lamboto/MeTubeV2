<%--
  Created by IntelliJ IDEA.
  User: t_lamburov
  Date: 18.6.2021 г.
  Time: 09:55 ч.
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: t_lamburov
  Date: 17.6.2021 г.
  Time: 17:00 ч.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
  <c:import url="head.jsp"/>
</head>
<body>
<div class="container-fluid">
  <header>
    <c:import url="navbar.jsp"/>
  </header>
  <main>
    <hr class="my-2"/>
    <div class="text-center mb-3">
      <h1>Register</h1>
    </div>
    <hr class="my-2">
    <div class="container-fluid">
      <div class="row justify-content-center">
        <div class="form-holder text-center">
          <form class="form-inline" action="/users/register" method="POST">
            <fieldset>
              <div class="control-group">
                <label class="control-label h3 mb-2" for="username">Username</label>
                <div class="controls">
                  <input type="text" id="username" name="username" placeholder="" class="input-xlarge">
                </div>
              </div>
              <br/>
              <div class="control-group">
                <label class="control-label h3 mb-2" for="password">Password</label>
                <div class="controls">
                  <input type="password" id="password" name="password" placeholder=""
                         class="input-xlarge">
                </div>
              </div>
              <br/>
              <div class="control-group">
                <label class="control-label h3 mb-2" for="confirmPassword">Confirm Password</label>
                <div class="controls">
                  <input type="password" id="confirmPassword" name="confirmPassword" placeholder=""
                         class="input-xlarge">
                </div>
              </div>
              <br/>
              <div class="control-group">
                <label class="control-label h3 mb-2" for="email">Email</label>
                <div class="controls">
                  <input type="text" id="email" name="email" placeholder=""
                         class="input-xlarge">
                </div>
              </div>
              <br/>
              <div class="control-group">
                <div class="controls">
                  <button class="btn btn-info">Register</button>
                </div>
              </div>
            </fieldset>
          </form>
        </div>
      </div>
    </div>
    <hr class="my-3"/>
  </main>
  <footer>
    <c:import url="footer.jsp"/>
  </footer>
</div>
</body>
</html>
