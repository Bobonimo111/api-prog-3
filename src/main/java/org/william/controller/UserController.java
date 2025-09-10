package org.william.controller;

import org.william.MyController;
import org.william.dto.UserCreate;
import org.william.dto.UserSimple;
import org.william.service.UserService;

import java.util.List;

@MyController
public class UserController {
    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public UserSimple createUser(UserCreate dto) {
        return userService.createUser(dto);
    }

    public void updateUser() {

    }

    public void deleteUser() {

    }

    public List<UserSimple> getAllUsers() {
        return userService.getAllUsers();
    }
}
