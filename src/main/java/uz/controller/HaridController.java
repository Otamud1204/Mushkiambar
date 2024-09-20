package uz.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.entity.Harid;
import uz.entity.Mushkiambar;
import uz.repository.HaridRepo;
import uz.repository.MushkRepo;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/harid")
public class HaridController extends HttpServlet {
    MushkRepo mushkRepo = MushkRepo.getInstance();
    HaridRepo haridRepo = HaridRepo.getInstance();
    Integer id;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            id = Integer.parseInt(req.getParameter("id"));
            req.setAttribute("id", id); // id ni o'tkazish
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID format.");
            return;
        }
        Optional<Mushkiambar> optionalMushkiambar = mushkRepo.findById(id);
        if (optionalMushkiambar.isEmpty()){
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        Mushkiambar mushk = optionalMushkiambar.get();
        req.setAttribute("mushk", mushk);
        try {
            req.getRequestDispatcher("/views/harid.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "HaridRepo ni haridAll metodi ishlamayapdi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Double olishGrami;
        Double jamiSumma;
        try {
            olishGrami = Double.parseDouble(req.getParameter("olishGrami"));
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid number format.");
            return;
        }

        Optional<Mushkiambar> optionalMushkiambar = mushkRepo.findById(id);
        if (optionalMushkiambar.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Mushkiambar data is empty.");
            return;
        }

        Mushkiambar mushkiambar = optionalMushkiambar.get();
        jamiSumma = mushkiambar.getGramNarhi() * olishGrami;

        Harid harid = Harid.builder()
                .mushkiambar(mushkiambar)
                .olishGrami(olishGrami)
                .jamiSumma(jamiSumma)
                .build();
        haridRepo.save(harid);

        resp.sendRedirect("/haridlari"); // id ni qo'shish
    }
}