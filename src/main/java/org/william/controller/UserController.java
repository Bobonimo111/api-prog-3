package org.william.controller;

import org.william.MyController;
import org.william.service.UserService;

@MyController
public class UserController {
    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public String createUser() {
        return userService.createUser();
    }

    public void updateUser() {

    }

    public void deleteUser() {

    }

    public String getAllUsers() {
        return userService.getAllUsers();
    }
}
