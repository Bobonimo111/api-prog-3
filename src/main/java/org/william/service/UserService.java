package org.william.service;

import org.william.DataBase;
import org.william.MyService;
import org.william.dto.UserCreate;
import org.william.dto.UserSimple;

import javax.xml.crypto.Data;

@MyService
public class UserService {

    public final DataBase dataBase;

    public UserService(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public UserSimple createUser(UserCreate dto) {
//        dataBase.getData().add("William");
        UserSimple us = new UserSimple();
        us.setEmail(dto.getEmail());
        us.setNome(dto.getNome());
        us.setSenha(dto.getSenha());
        return us;
    }

    public void updateUser() {

    }

    public void deleteUser() {

    }

    public String getAllUsers() {
        return this.dataBase.getData().toString();
    }
}
