package org.william;

import java.util.ArrayList;
import java.util.List;

@MyComponent
public class DataBase {
    List<String> data;
    public DataBase() {
        this.data = new ArrayList<String>();
    }

    public List<String> getData() {
        return data;
    }
}
