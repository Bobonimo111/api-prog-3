# Objetivo 
Objetivo dessa pequana api é implementar o funcionamento porbaixo dos panos de reflexion injeção de dependendecia e inversão de controles
Alem de entender os fucionamentos básicos de uma API,em java utilizando jetty servelet para ser o server, e jackson para tratar JSONs 

Foi implementado 5 rotas simples, com controllers e services com pouco ou nenhum tratamento de erros

As rotas implementam duas classes chamadas UserSimple e UserCreate, que são utilizados majoritamriamente como DTO´s e para salvar os dados em memoria 

# Como utlizar
Inicilizando o main que se encontra no arquivo MiniSpringApp, o servidor ir iniciar na porta 
> http://localhost:3569

Onde pode-se acesar o path
> /hello

retorno
>"Olá do serviço gerenciado pelo nosso mini Spring!"

o servidor esta funionando 

Json requerido:
>{
"nome": "Não mais josue",
"email": "email@email.com.br",
"senha": null
}

Os campos podem ficar null ou serem removidos completamente, so não é possivel adicionar outros campos ja que o jackson não vai conseguir reconhecer e retornar uma excessão

> Todas as rotas são /user a unica mudança é o seu verbo HTTP

POST: 
>{
"nome": "Não mais josue",
"email": "email@email.com.br",
"senha": null
}
>
resposta
>{
"nome": "Não mais josue",
"email": "email@email.com.br",
"senha": null,
"id": "user-1757619162"
}

GET resposta é uma lista
>[{
"nome": "Não mais josue",
"email": "email@email.com.br",
"senha": null,
"id": "user-1757619162"
}]

DELETE passamos um paramentro de querry
>/user?id=user-1757619162
> 
retorno:
> {
"data": "2025-09-11T16:39:04.952912300",
"code": "200",
"message": "Deletado"
}
>
PUT passamos todo o objeto, sem modificar o id;
>{
"nome": "agora é josue",
"email": "email@email.com.br",
"senha": null,
"id": "user-1757619162"
}
> 
RETORNO sera o mesmo objeto que enviamos
>{
"nome": "agora é josue",
"email": "email@email.com.br",
"senha": null,
"id": "user-1757619162"
}
