<%--
  Created by IntelliJ IDEA.
  User: t_lamburov
  Date: 21.6.2021 г.
  Time: 10:30 ч.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <div class="text-ceter mt-3">
            <h4 class="text-info text-center">${user.getUsername()}</h4>
            <h4 class="text-info text-center">(${user.getEmail()})</h4>
        </div>
        <hr>
        <div class="container-fluid">
            <div class="row d-flex flex-column">
                <table class="table table-hover table-dark">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Title</th>
                        <th scope="col">Author</th>
                        <th scope="col">Actions</th>
                    </tr>
                    </thead>
                    <c:forEach items="${viewModel}" var="u">
                        <tbody>
                            ${u.get}
                        </tbody>
                    </c:forEach>
                </table>
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
