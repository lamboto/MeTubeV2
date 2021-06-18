<%--
  Created by IntelliJ IDEA.
  User: t_lamburov
  Date: 18.6.2021 г.
  Time: 11:50 ч.
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
    <div class="text-center mt-3">
      <h4 class="h4 text-info">Welcome, ${username}</h4>
    </div>
    <hr class="my-4">
    <div class="container">
      ${allTubes}
    </div>
    <hr class="my-3"/>
  <footer>
    <c:import url="footer.jsp"/>
  </footer>
</div>
</body>
</html>
