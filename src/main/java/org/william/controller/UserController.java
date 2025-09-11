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

    public UserSimple updateUser(UserSimple dto) {
        return userService.updateUser(dto);
    }

    public void deleteUser(String id) {
        userService.deleteUser(id);
    }

    public List<UserSimple> getAllUsers() {
        return userService.getAllUsers();
    }
}
