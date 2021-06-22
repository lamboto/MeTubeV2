<%@ page import="metube.domain.views.TubeDetailsViewModel" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: t_lamburov
  Date: 18.6.2021 г.
  Time: 11:50 ч.
  To change this template use File | Settings | File Templates.
--%>
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
        <div class="text-center mt-3">
            <h4 class="h4 text-info">Welcome, ${user.getUsername()}</h4>
        </div>
        <hr class="my-4">

        <%for (TubeDetailsViewModel model : ((List<TubeDetailsViewModel>) request.getAttribute("modelTubes"))) {%>
        <div class="container">
            <div class="row">
                <div class="col-md-6 my-5" >
                    <div  class= "embed-responsive embed-responsive-16by9"  >
                        <iframe class="embed-responsive-item "
                                src="https://www.youtube.com/embed/<%=model.getYoutubeId()%>" allowfullscreen
                                frameborder="0"></iframe>
                        <h4 class="text-info"><%=model.getTitle()%>
                        </h4>
                        <h5 class="text-info"><%=model.getAuthor()%>
                        </h5>
                    </div>
                </div>

            </div>
                <% } %>
            <hr class="my-3"/>
    </main>
    <footer>
        <c:import url="footer.jsp"/>
    </footer>
</div>
</body>
</html>
