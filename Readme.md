# MiniSpringApp -- API de Estudo

## 📚 Objetivo

Esta pequena API foi criada com o intuito de **explorar e compreender
conceitos de baixo nível** como: - Reflexão\
- Injeção de Dependência\
- Inversão de Controle (IoC)

Além disso, busca demonstrar os fundamentos básicos de uma API em
**Java**, utilizando: - **Jetty Servlet** como servidor - **Jackson**
para tratamento de JSONs

A API implementa **5 rotas simples**, com controllers e services,
focando no funcionamento interno --- **com pouco ou nenhum tratamento de
erros**, para fins didáticos.

------------------------------------------------------------------------

## 📝 Estrutura

As rotas utilizam duas classes principais: - `UserSimple`\
- `UserCreate`

Essas classes funcionam como **DTOs** e para **armazenar dados em
memória**.

------------------------------------------------------------------------

## 🚀 Como Executar

1.  Clone este repositório.\
2.  Abra o projeto em sua IDE Java.\
3.  Localize o arquivo `MiniSpringApp` e execute o método `main`.

O servidor iniciará na porta:

    http://localhost:3569

Para testar, acesse:

    http://localhost:3569/hello

Resposta esperada:

``` json
"Olá do serviço gerenciado pelo nosso mini Spring!"
```

------------------------------------------------------------------------

## 🔗 Endpoints

### Estrutura geral

Todas as rotas estão sob o path `/user`.\
O comportamento varia conforme o **verbo HTTP**.

------------------------------------------------------------------------

### POST `/user`

Cria um novo usuário.\
**Body Exemplo:**

``` json
{
  "nome": "Não mais josue",
  "email": "email@email.com.br",
  "senha": null
}
```

**Resposta:**

``` json
{
  "nome": "Não mais josue",
  "email": "email@email.com.br",
  "senha": null,
  "id": "user-1757619162"
}
```

------------------------------------------------------------------------

### GET `/user`

Retorna todos os usuários cadastrados.\
**Resposta:**

``` json
[
  {
    "nome": "Não mais josue",
    "email": "email@email.com.br",
    "senha": null,
    "id": "user-1757619162"
  }
]
```

------------------------------------------------------------------------

### DELETE `/user?id={idDoUsuario}`

Remove um usuário específico.\
**Resposta:**

``` json
{
  "data": "2025-09-11T16:39:04.952912300",
  "code": "200",
  "message": "Deletado"
}
```

------------------------------------------------------------------------

### PUT `/user`

Atualiza um usuário existente.\
**Body Exemplo:**

``` json
{
  "nome": "agora é josue",
  "email": "email@email.com.br",
  "senha": null,
  "id": "user-1757619162"
}
```

**Resposta:**

``` json
{
  "nome": "agora é josue",
  "email": "email@email.com.br",
  "senha": null,
  "id": "user-1757619162"
}
```

------------------------------------------------------------------------

## ⚠️ Observações Importantes

-   Os campos podem ser `null` ou omitidos.\
-   Não é possível adicionar campos extras (o Jackson lançará exceção).\
-   Projeto criado para fins **educacionais**.

------------------------------------------------------------------------

## 🛠️ Tecnologias Utilizadas

-   Java\
-   Jetty Servlet\
-   Jackson

------------------------------------------------------------------------

## 📄 Licença

Este projeto é distribuído sob a licença MIT.\
Sinta-se à vontade para usar, modificar e contribuir.
