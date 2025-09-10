package org.william.service;

import org.william.DataBase;
import org.william.MyService;
import org.william.dto.UserCreate;
import org.william.dto.UserSimple;

import javax.xml.crypto.Data;
import java.util.List;

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

        dataBase.getData().add(us);

        return us;
    }

    public void updateUser() {

    }

    public void deleteUser() {

    }

    public List<UserSimple> getAllUsers() {
        return this.dataBase.getData();
    }
}
