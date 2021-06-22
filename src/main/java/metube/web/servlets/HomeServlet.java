package metube.web.servlets;


import metube.config.Mapper;
import metube.domain.views.TubeDetailsViewModel;
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

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    private final TubeServiceImpl tubeService = new TubeServiceImpl();
    private final Mapper mapper = new Mapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        List<TubeDetailsViewModel> tubes = this.tubeService.getAllTubes()
                .stream()
                .map(tube -> this.mapper.map(tube, TubeDetailsViewModel.class))
                .collect(Collectors.toList());

        req.setAttribute("modelTubes", tubes);

        req.getRequestDispatcher("home.jsp")
                .forward(req, resp);

    }
}
