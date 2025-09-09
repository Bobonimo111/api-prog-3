package org.william.controller;


import org.william.MessageService;
import org.william.MyController;

@MyController
class MessageController {
    private final MessageService service;

    // Injeção via construtor
    public MessageController(MessageService service) {
        this.service = service;
    }

    public String hello() {
        return service.getMessage();
    }
}