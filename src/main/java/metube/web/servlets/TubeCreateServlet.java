package metube.web.servlets;

import metube.domain.entities.User;
import metube.service.impl.TubeServiceImpl;
import metube.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/upload-tube")
public class TubeCreateServlet extends HttpServlet {

    TubeServiceImpl tubeService = new TubeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("upload.jsp")
                .forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String description = req.getParameter("description");
        String youtubeId = req.getParameter("youtubeId");
        int userId = user.getId();

        this.tubeService.create(title, author, description, youtubeId,userId);

        resp.sendRedirect("/home");
    }
}
