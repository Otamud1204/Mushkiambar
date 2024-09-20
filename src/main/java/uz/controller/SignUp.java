package uz.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.entity.User;
import uz.repository.UserRepo;

import java.io.IOException;

@WebServlet("/signup")
public class SignUp extends HttpServlet {


    UserRepo userRepo = UserRepo.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/signup.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String rol="USER";
        User user = User
                .builder()
                .name(name)
                .age(age)
                .username(username)
                .password(password)
                .rol(rol)
                .build();
        userRepo.save(user);
        resp.sendRedirect("/signin");
    }
}