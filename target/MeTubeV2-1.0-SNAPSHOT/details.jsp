<%@ page import="metube.domain.views.TubeDetailsViewModel" %><%--
  Created by IntelliJ IDEA.
  User: t_lamburov
  Date: 22.6.2021 г.
  Time: 09:43 ч.
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
    <% TubeDetailsViewModel model = (TubeDetailsViewModel) request.getAttribute("model"); %>
    <header>
        <c:import url="navbar.jsp"/>
    </header>
    <main>
        <hr class="my-2">
        <div class="container-fluid">
            <h2 class="text-center"><%=model.getTitle()%>
            </h2>
            <div class="row">
                <div class="col-md-6 my-5">
                    <div class="embed-responsive embed-responsive-16by9">
                        <iframe class="embed-responsive-item"
                                src="https://www.youtube.com/embed/<%=model.getYoutubeId()%>" allowfullscreen
                                frameborder="0"></iframe>
                    </div>
                </div>
                <div class="col-md-6 my-5">
                    <h1 class="text-center text-info"><%=model.getAuthor()%>
                    </h1>
                    <h3 class="text-center text-info"><%=model.getViews()%>
                    </h3>
                    <div class="h5 my-5 text-center"><%=model.getDescription()%>
                    </div>
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
