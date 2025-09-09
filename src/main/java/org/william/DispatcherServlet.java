package org.william;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.william.controller.MessageController;
import org.william.controller.UserController;

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
        resp.setContentType("text/plain");
        String path = req.getPathInfo();

        if ("/user".equals(path)) {
            resp.getWriter().println(userController.createUser());
        }
    }
}