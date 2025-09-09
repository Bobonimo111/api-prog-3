package org.william.service;

import org.william.MyService;

@MyService
public class MessageService {
    public String getMessage() {
        return "Olá do serviço gerenciado pelo nosso mini Spring!";
    }
}
