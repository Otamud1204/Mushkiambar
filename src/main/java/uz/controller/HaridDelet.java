package uz.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.repository.HaridRepo;

import java.io.IOException;

    @WebServlet("/delett")
    public class HaridDelet extends HttpServlet {
        HaridRepo haridRepo = HaridRepo.getInstance();

        @Override
        public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            int id;
            try {
                id = Integer.parseInt(req.getParameter("id"));
            } catch (NumberFormatException e) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID noto'g'ri formatda kiritilgan.");
                return;
            }
            haridRepo.delete(id);
            resp.sendRedirect("/harid");
        }
    }
