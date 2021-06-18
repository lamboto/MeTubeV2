package metube.web.servlets;

import metube.domain.binding.UserLoginBindingModel;
import metube.domain.entities.User;
import metube.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users/login")
public class UserLoginServlet extends HttpServlet {

    private final UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/ tmqas" +
                "login.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserLoginBindingModel userLoginBindingModel = new UserLoginBindingModel();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = this.userService.login(username, password);

        if (user == null) {
            resp.sendRedirect("/users/login");
        } else {
            req.getSession()
                    .setAttribute("user", user);
            resp.sendRedirect("/home");
        }

    }
}
