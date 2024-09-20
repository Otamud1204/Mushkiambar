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

@WebServlet(urlPatterns = "/haridlari")
public class HaridLar extends HttpServlet {
    HaridRepo haridRepo = HaridRepo.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Haridlar ro'yxatini olish va uni requestga qo'shish
            List<Harid> all = haridRepo.haridAll();
            req.setAttribute("haridlaris", all);
            // haridlari.jsp sahifasiga ma'lumotlar bilan birga o'tish
            req.getRequestDispatcher("/views/haridlari.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            // Ichki server xatosi haqida xabar berish
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "HaridRepo ning haridAll metodi ishlamayapti");
        }
    }
}
