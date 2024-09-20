package uz.controller;

import lombok.Getter;
import uz.entity.User;
@Getter
public class UserIsmi {
    private  User user;

    public UserIsmi(User user) {
        this.user = user;
    }
}
