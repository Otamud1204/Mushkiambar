package uz.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.entity.Cheka;
import uz.entity.Harid;
import uz.entity.Mushkiambar;
import uz.entity.User;
import uz.repository.ChekRepo;
import uz.repository.HaridRepo;


import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/chek")
public class ChekCantrol extends HttpServlet{
    HaridRepo haridRepo = new HaridRepo();

    private final ChekRepo chekRepo = ChekRepo.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            req.getRequestDispatcher("/views/cheka.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing your request.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
             User user = UserIsmi.ismi().getCurrentUser();
             ArrayList<Harid> arrayList= (ArrayList<Harid>) HaridRepo.getInstance().haridAll();
            LocalDateTime now = LocalDateTime.now();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String bugungiSana  = now.format(formatter);


            if (user == null || arrayList == null || bugungiSana == null ) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "user || arrayList || bugungiSana da malumot yo'q ");
                resp.sendRedirect("/haridlari");
                return;
            }

            Cheka chek = Cheka.builder()
                    .user(user)
                    .harids(arrayList)
                    .oligansana(bugungiSana)
                            .build();
            ChekRepo.getInstance().save(chek);
            req.setAttribute("chek",chek);
            resp.sendRedirect("/chek");
        } catch (Exception e) {
            // Log the exception and show an error page
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing your request.");
        }
    }
}


