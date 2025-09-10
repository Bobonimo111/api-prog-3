package org.william;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.william.controller.MessageController;
import org.william.controller.UserController;
import org.william.dto.UserCreate;
import org.william.dto.UserSimple;
import org.william.misc.HttpMisc;

import java.io.BufferedReader;
import java.io.IOException;


class DispatcherServlet extends HttpServlet {
    private final MessageController controller;
    private final UserController userController;

    DispatcherServlet(MessageController controller, UserController userController) {
        this.controller = controller;
        this.userController = userController;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain");
        String path = req.getPathInfo();

        // Roteamento bem simples

        if ("/hello".equals(path)) {
            resp.getWriter().println(controller.hello());
        } else if ("/user".equals(path)) {
            resp.getWriter().println(userController.getAllUsers());
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            resp.getWriter().println("404 - Not Found");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        String path = req.getPathInfo();

        if ("/user".equals(path)) {
            System.out.println("POST /user acessado");
            //Coleta o body da requisição e converte em uma string plana

            String result = HttpMisc.recive(req,resp);

            //Utilizo do jackson para converte o texto plano em um dto
            UserCreate uc = new ObjectMapper().readValue(result,UserCreate.class);
            System.out.println("Convertido para json");

            //passo tudo para o controller
            UserSimple us = userController.createUser(uc);
            System.out.println("Retornou do controller");

            //Converto para json novamente
            String resJson = new ObjectMapper().writeValueAsString(us);
            System.out.println("Convertendo novamente para json");

            resp.getWriter().println(resJson);
        }
    }
}