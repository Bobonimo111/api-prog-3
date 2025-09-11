package org.william.service;

import org.william.DumbDataBase;
import org.william.MyService;
import org.william.dto.UserCreate;
import org.william.dto.UserSimple;

import java.util.List;

@MyService
public class UserService {

    public final DumbDataBase dumbDataBase;

    public UserService(DumbDataBase dataBase) {
        this.dumbDataBase = dataBase;
    }

    public UserSimple createUser(UserCreate dto) {
//        dataBase.getData().add("William");

        UserSimple us = new UserSimple();
        us.setEmail(dto.getEmail());
        us.setNome(dto.getNome());
        us.setSenha(dto.getSenha());

        dumbDataBase.saveData(us);

        return us;
    }

    public UserSimple updateUser(UserSimple dto) {
        return dumbDataBase.edit(dto);
    }

    public void deleteUser(String id) {
        dumbDataBase.remove(id);
    }

    public List<UserSimple> getAllUsers() {
        return this.dumbDataBase.getData();
    }
}
