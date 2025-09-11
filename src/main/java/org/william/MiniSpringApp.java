package org.william;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.william.controller.MessageController;
import org.william.controller.UserController;
import org.william.service.MessageService;
import org.william.service.UserService;

public class MiniSpringApp {
    public static void main(String[] args) throws Exception {
        //Inicializa o container de invers~ao de dependencia
        MyApplicationContext context = new MyApplicationContext(
                MessageService.class,
                MessageController.class,
                UserController.class,
                UserService.class,
                DumbDataBase.class
        );

        // Pega o controller pronto
        MessageController messageController = context.getBean(MessageController.class);
        UserController userController = context.getBean(UserController.class);

        // Cria o servidor Jetty
        Server server = new Server(3569);
        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.setContextPath("/");
        /*
        * DispatcherServlete 'e a classe responsavel por gerenciar os objetos que v~ao representar
        * Requisiç~oes e resposatas tanto que ele extendo o HttpServlet
        * Tudo isso 'e posto dentro de um Holder para manter o servidor conectado a um socket
        * onde 'e adcionado o cotexto ja criado e configurado do Server
        * */
        contextHandler.addServlet(new ServletHolder(new DispatcherServlet(messageController, userController)), "/*");

        server.setHandler(contextHandler);
        server.start();
        server.join();
    }
}