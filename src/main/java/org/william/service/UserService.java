package org.william.service;

import org.william.DataBase;
import org.william.MyService;

import javax.xml.crypto.Data;

@MyService
public class UserService {

    public final DataBase dataBase;

    public UserService(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public String createUser() {
        dataBase.getData().add("William");
        return "usuario criado";
    }

    public void updateUser() {

    }

    public void deleteUser() {

    }

    public String getAllUsers() {
        return this.dataBase.getData().toString();
    }
}
