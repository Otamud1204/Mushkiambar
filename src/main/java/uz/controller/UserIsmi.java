package uz.controller;

import lombok.Getter;
import uz.entity.User;
@Getter
public class UserIsmi {
    private static UserIsmi ismi;
    private User user;

    private UserIsmi() { }

    public static UserIsmi ismi() {
        if (ismi == null) {
            ismi = new UserIsmi();
        }
        return ismi;
    }

    public void setCurrentUser(User user) {
        this.user = user;
    }

    public User getCurrentUser() {
        return user;
    }
}