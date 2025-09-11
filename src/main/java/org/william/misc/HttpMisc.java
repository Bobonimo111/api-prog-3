package org.william.misc;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpMisc {

    //Objetivo da classe tratar o recebimento de requisições e retornar o texto plano
    public static String recive(HttpServletRequest req, HttpServletResponse resp){
        StringBuilder stringBuilder = new StringBuilder();
        try{
            BufferedReader reader = req.getReader();
            String stringLine;
            while ((stringLine = reader.readLine()) != null) {
                stringBuilder.append(stringLine);
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            return e.getMessage();
        }

    }
}
