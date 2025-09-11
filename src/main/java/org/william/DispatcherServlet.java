package org.william;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.william.controller.MessageController;
import org.william.controller.UserController;
import org.william.dto.SimpleResponse;
import org.william.dto.UserCreate;
import org.william.dto.UserSimple;
import org.william.misc.HttpMisc;

import java.io.IOException;


class DispatcherServlet extends HttpServlet {
    private final MessageController controller;
    private final UserController userController;

    DispatcherServlet(MessageController controller, UserController userController) {
        this.controller = controller;
        this.userController = userController;
    }

    //Essa rota transcreve o verbo GET do protocolo HTTP
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String path = req.getPathInfo();

        // Roteamento bem simples
        if ("/hello".equals(path)) {
            resp.setContentType("text/plain");
            resp.getWriter().println(controller.hello());
        } else if ("/user".equals(path)) {
            //Definindo o tipo de conteudo para o HEADER da resposta para API
            resp.setContentType("application/json");
            //Definindo uma resposta no HEADER da requisiçao
            resp.setStatus(HttpServletResponse.SC_OK);
            //Convertendo o resultado do controller, para um jason utilizadno jackson
            String response = new ObjectMapper().writeValueAsString(userController.getAllUsers());
            //Enviando a resposata de volta para o cliente
            resp.getWriter().println(response);
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            resp.getWriter().println("404 - Not Found");
        }
    }

    //Essa rota transcreve o verbo POST do protocolo HTTP
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        String path = req.getPathInfo();

        if ("/user".equals(path)) {
            System.out.println("POST /user acessado");
            //Coleta o body da requisição e converte em uma string plana
            String result = HttpMisc.recive(req, resp);

            //Utilizo do jackson para converte o texto plano em um dto
            UserCreate uc = new ObjectMapper().readValue(result, UserCreate.class);
            System.out.println("Convertido para json");

            //passo tudo para o controller
            UserSimple us = userController.createUser(uc);
            System.out.println("Retornou do controller");

            //definindo o status da requisiç~ao no header para CREATED 201
            resp.setStatus(HttpServletResponse.SC_CREATED);

            //Converto para json novamente
            String resJson = new ObjectMapper().writeValueAsString(us);
            System.out.println("Convertendo novamente para json");

            resp.getWriter().println(resJson);
        }
    }

    //esse verbo edita enviando todo o objeto necessario
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        String path = req.getPathInfo();
        if ("/user".equals(path)) {
            System.out.println("PUT /user acessado");
            String result = HttpMisc.recive(req, resp);
            UserSimple us = new ObjectMapper().readValue(result, UserSimple.class);
            UserSimple edited = userController.updateUser(us);
            System.out.println("Retornou do controller");
            resp.setStatus(HttpServletResponse.SC_OK);
            String json = new ObjectMapper().writeValueAsString(edited);
            System.out.println("Convertendo novamente para json");
            resp.getWriter().println(json);
        }
    }

    //esse verbo deleta o elemento, e tambem ele pega o id do parametro da querry
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        String path = req.getPathInfo();
        if ("/user".equals(path)) {
            try{
                String id = req.getParameter("id").trim();
                userController.deleteUser(id);
                SimpleResponse sp = new SimpleResponse("200", "Deletado");
                String Json = new ObjectMapper().writeValueAsString(sp);
                resp.getWriter().println(Json);
            }catch (Exception e){
                resp.getWriter().println(e);
            }
        }
    }
}