package org.william.controller;


import org.william.MyController;
import org.william.service.MessageService;

@MyController
public class MessageController {
    private final MessageService service;

    // Injeção via construtor
    public MessageController(MessageService service) {
        this.service = service;
    }

    public String hello() {
        return service.getMessage();
    }
}