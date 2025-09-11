package org.william.dto;

import java.time.LocalDateTime;

public class SimpleResponse {
    private String data;
    private String code;
    private String message;

    public SimpleResponse(){

    }

    public SimpleResponse(String code, String message) {
        this.data = LocalDateTime.now().toString();
        this.code = code;
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
