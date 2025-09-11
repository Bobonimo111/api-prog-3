package org.william;

import org.william.dto.UserSimple;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@MyComponent
public class DumbDataBase {
    List<UserSimple> data;
    public DumbDataBase() {
        this.data = new ArrayList<UserSimple>();
    }

    public List<UserSimple> getData() {
        return data;
    }

    public UserSimple saveData(UserSimple user) {
        long unixTime = Instant.now().getEpochSecond();
        String id = "user-"+unixTime;
        user.setId(id);
        data.add(user);
        return user;
    }

    public UserSimple getById(String id) {
        for(UserSimple user : data){
            if(user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }

    public Boolean remove (String id) {
        UserSimple user = getById(id);
        if(user == null){
            return false;
        }
        data.remove(user);
        return true;
    }

    public UserSimple edit(UserSimple user) {
        UserSimple userToEdit = getById(user.getId());
        remove(userToEdit.getId());

        UserSimple userEdited = new UserSimple();

        userEdited.setId(userToEdit.getId());
        userEdited.setNome(user.getNome() == null ? userToEdit.getNome() : user.getNome());
        userEdited.setEmail(user.getEmail() == null ? userToEdit.getEmail() : user.getEmail());
        userEdited.setSenha(user.getSenha() == null ? userToEdit.getSenha() : user.getSenha());

        data.add(userEdited);

        return userEdited;
    }
}
