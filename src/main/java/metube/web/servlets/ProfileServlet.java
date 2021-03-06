package metube.web.servlets;

import metube.config.Mapper;
import metube.domain.entities.User;
import metube.domain.views.UserTubeViewModel;
import metube.service.impl.TubeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {


    private final TubeServiceImpl tubeService = new TubeServiceImpl();
    private final Mapper mapper = new Mapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("user");
        String username = user.getUsername();

        List<UserTubeViewModel> tubes = this.tubeService.getAllByGivenUsername(username)
                .stream()
                .map(tube -> this.mapper.map(tube, UserTubeViewModel.class))
                .collect(Collectors.toList());

        req.setAttribute("viewModel", null);
        req.setAttribute("viewModel", tubes);


        req.getRequestDispatcher("profile.jsp").forward(req, resp);
    }
}
