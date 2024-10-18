package uz.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.entity.Cheka;
import uz.repository.ChekRepo;
import uz.repository.UserRepo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class ChekSkidka {
    static ChekRepo chekRepo = new ChekRepo();
    UserRepo userRepo = new UserRepo();


    public static Double skidkasi() {
        String username = UserIsmi.ismi().getCurrentUser().getUsername();
        int n = 0;

        ArrayList<Cheka> cheklis = (ArrayList<Cheka>) chekRepo.chekAll();
        for (int i = 0; i < cheklis.size(); i++) {
            if (Objects.equals(cheklis.get(i).getUser().getUsername(), username)) {
                n++;
            }
        }
        if (n>5) {
            return 2.0;
        }else if (n>4&&n<10) {
            return 5.0;
        }else if (n>9&&n<20) {
            return 8.0;
        }else if (n>19&&n<30) {
            return 10.0;
        }else if (n>30) {
            return 15.0;
        }
        return 0.0;

    }public static ArrayList<Cheka> cheklist() {
        String username = UserIsmi.ismi().getCurrentUser().getUsername();
        ArrayList<Cheka> chekli=null;
        ArrayList<Cheka> cheklis = (ArrayList<Cheka>) chekRepo.chekAll();
        for (int i = 0; i < cheklis.size(); i++) {
            if (Objects.equals(cheklis.get(i).getUser().getUsername(), username)) {
              chekli.add(cheklis.get(i));
            }
        }
        return chekli == null ? null : chekli;
    }
}
