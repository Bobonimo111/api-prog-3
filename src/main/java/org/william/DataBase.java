package org.william;

import org.william.dto.UserSimple;

import java.util.ArrayList;
import java.util.List;

@MyComponent
public class DataBase  {
    List<UserSimple> data;
    public DataBase() {
        this.data = new ArrayList<UserSimple>();
    }

    public List<UserSimple> getData() {
        return data;
    }
}
