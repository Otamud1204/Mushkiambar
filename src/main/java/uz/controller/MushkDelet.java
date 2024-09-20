package uz.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.repository.MushkRepo;

import java.io.IOException;
@WebServlet("/delete")
public class MushkDelet extends HttpServlet {
    MushkRepo mushkRepo = MushkRepo.getInstance();
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        mushkRepo.delete(id);
        resp.sendRedirect("/admin");
    }
}
