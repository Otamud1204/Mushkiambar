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

        // Retrieve user from repository
        Optional<User> optionalUser = userRepo.getUserByUsername(username);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            UserIsmi UserIsmi = new UserIsmi(user);

            // Check if the provided password matches
            if (user.getPassword().equals(password)) { // Replace with proper password validation
                HttpSession session = req.getSession();
                session.setAttribute("username", username);
                session.setAttribute("role", user.getRol()); // Store the user's role in the session

                // Redirect based on user role
                if (Objects.equals( "ADMIN",(user.getRol()))) {
                    resp.sendRedirect(req.getContextPath() + "/admin"); // Admin dashboard page
                } else {
                    resp.sendRedirect(req.getContextPath() + "/user"); // User home page
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
