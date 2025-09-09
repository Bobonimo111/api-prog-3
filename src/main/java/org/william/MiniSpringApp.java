package org.william;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.william.controller.MessageController;
import org.william.service.MessageService;

public class MiniSpringApp {
    public static void main(String[] args) throws Exception {
        // Inicializa o container
        MyApplicationContext context = new MyApplicationContext(
                MessageService.class,
                MessageController.class
        );

        // Pega o controller pronto
        MessageController controller = context.getBean(MessageController.class);

        // Cria o servidor Jetty
        Server server = new Server(3569);
        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.setContextPath("/");
        contextHandler.addServlet(new ServletHolder(new DispatcherServlet(controller)), "/*");

        server.setHandler(contextHandler);
        server.start();
        server.join();
    }
}