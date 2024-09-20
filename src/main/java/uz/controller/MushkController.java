package uz.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.entity.Mushkiambar;
import uz.repository.MushkRepo;

import java.io.IOException;
import java.util.List;

@WebServlet("/admin")
public class MushkController extends HttpServlet {
    private final MushkRepo mushkRepo = MushkRepo.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Mushkiambar> all = mushkRepo.mushkAll();
            req.setAttribute("mushks", all);
            req.getRequestDispatcher("/views/admin.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing your request.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("name");
            String rangi = req.getParameter("rangi");
            String turi = req.getParameter("turi");
            String stoykasi = req.getParameter("stoykasi");
            String gramNarhiStr = req.getParameter("gramNarhi");
            String jammiGramiStr = req.getParameter("jamiGrami");
            String gender = req.getParameter("gender");

            if (name == null || rangi == null || turi == null || stoykasi == null || gramNarhiStr == null || jammiGramiStr == null || gender == null) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing required parameters.");
                resp.sendRedirect("/admin");
                return;
            }

            double gramNarhi;
            double jammiGrami;

            try {
                gramNarhi = Double.parseDouble(gramNarhiStr);
                jammiGrami = Double.parseDouble(jammiGramiStr);
            } catch (NumberFormatException e) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid number format.");
                resp.sendRedirect("/admin");
                return;
            }

            Mushkiambar mushk = Mushkiambar.builder()
                    .name(name)
                    .rangi(rangi)
                    .turi(turi)
                    .stoykasi(stoykasi)
                    .gramNarhi(gramNarhi)
                    .jamiGrami(jammiGrami)
                    .gender(gender)
                    .build();

            mushkRepo.save(mushk);

            resp.sendRedirect("/admin");
        } catch (Exception e) {
            // Log the exception and show an error page
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing your request.");
        }
    }
}
