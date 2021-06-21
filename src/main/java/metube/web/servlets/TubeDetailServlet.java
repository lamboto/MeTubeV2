package metube.web.servlets;

import metube.domain.entities.Tube;
import metube.domain.model.TubeServiceModel;
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] urlParams = req.getRequestURI().split("/");
        String tubeId = urlParams[urlParams.length - 1];


        super.doGet(req, resp);
    }
}
