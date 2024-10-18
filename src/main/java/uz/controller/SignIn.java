package uz.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uz.entity.User;
import uz.repository.UserRepo;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@WebServlet("/signin")
public class SignIn extends HttpServlet {
    private UserRepo userRepo = UserRepo.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/signin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Optional<User> optionalUser = userRepo.getUserByUsername(username);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            if (user.getPassword().equals(password)) {
                HttpSession session = req.getSession();
                session.setAttribute("username", username);
                session.setAttribute("role", user.getRol());

                // User obyektini UserIsmi ga qo'shamiz
                UserIsmi.ismi().setCurrentUser(user);

                if (Objects.equals("ADMIN", user.getRol())) {
                    resp.sendRedirect(req.getContextPath() + "/admin");
                } else {
                    resp.sendRedirect(req.getContextPath() + "/user");
                }
            } else {
                req.setAttribute("error", "Invalid password.");
                req.getRequestDispatcher("/views/signin.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("error", "User not found.");
            req.getRequestDispatcher("/views/signin.jsp").forward(req, resp);
        }
    }
}
