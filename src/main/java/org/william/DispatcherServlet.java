package org.william;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.william.controller.MessageController;

import java.io.IOException;


class DispatcherServlet extends HttpServlet {
    private final MessageController controller;

    public DispatcherServlet(MessageController controller) {
        this.controller = controller;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain");
        String path = req.getPathInfo();

        // Roteamento bem simples
        if ("/hello".equals(path)) {
            resp.getWriter().println(controller.hello());
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            resp.getWriter().println("404 - Not Found");
        }
    }
}