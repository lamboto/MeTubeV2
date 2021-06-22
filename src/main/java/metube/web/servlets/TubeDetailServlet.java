package metube.web.servlets;

import metube.config.Mapper;
import metube.domain.entities.Tube;
import metube.domain.model.TubeServiceModel;
import metube.domain.views.TubeDetailsViewModel;
import metube.service.impl.TubeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tube/details/*")
public class TubeDetailServlet extends HttpServlet {

    private final TubeServiceImpl tubeService = new TubeServiceImpl();
    private final Mapper mapper = new Mapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] urlParams = req.getRequestURI().split("/");
        int tubeId = Integer.parseInt(urlParams[urlParams.length - 1]);

        TubeServiceModel tubeServiceModel = this.tubeService.getTubeDetail(tubeId);


        TubeDetailsViewModel tubeDetailsViewModel = this.mapper.map(tubeServiceModel, TubeDetailsViewModel.class);


        req.setAttribute("model", tubeDetailsViewModel);
        req.getRequestDispatcher("/details.jsp").forward(req, resp);
    }

}
