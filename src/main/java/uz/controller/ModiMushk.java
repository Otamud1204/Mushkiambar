package uz.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.entity.Mushkiambar;
import uz.repository.MushkRepo;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/edit")
public class ModiMushk extends HttpServlet {
    MushkRepo mushkRepo = MushkRepo.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        Optional<Mushkiambar> optionalMushkiambar = mushkRepo.findById(id);
        if (optionalMushkiambar.isEmpty()){
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        Mushkiambar mushk = optionalMushkiambar.get();
        req.setAttribute("mushk", mushk);
        req.getRequestDispatcher("/views/edit_mushk.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String rangi = req.getParameter("rangi");
        String turi = req.getParameter("turi");
        String stoykasi = req.getParameter("stoykasi");
        Double jammiGrami = Double.parseDouble(req.getParameter("jamiGrami"));
        Double gramNarhi = Double.parseDouble(req.getParameter("gramNarhi"));
        String gender = req.getParameter("gender");

        Mushkiambar mushk = Mushkiambar
                .builder()
                .id(id)
                .name(name)
                .rangi(rangi)
                .turi(turi)
                .stoykasi(stoykasi)
                .jamiGrami(jammiGrami)
                .gramNarhi(gramNarhi)
                .gender(gender)
                .build();
        mushkRepo.save(mushk);
        resp.sendRedirect("/admin");
    }
}
