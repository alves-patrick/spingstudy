# API de Estudo - Spring Boot com Security

Esse é um projeto pessoal que eu fiz para estudar a fundo como funciona o **Spring Security 6** (o mais novo) com autenticação **JWT (JSON Web Tokens)**.

O objetivo era criar do zero uma API REST que fizesse o básico de segurança:

* Permitir o cadastro de um novo usuário (`/usuarios`).
* Criptografar a senha desse usuário no banco (usando Bcrypt).
* Ter um endpoint de login (`/auth/login`) que, se o e-mail e senha estiverem corretos, devolve um token JWT.
* Proteger outros endpoints (ex: ver a lista de usuários), que só podem ser acessados se o usuário enviar esse token JWT no *Header* da requisição.

---

## 💻 Techs que eu usei:

* **Java 17**
* **Spring Boot 3**
* **Spring Security 6**
* **Spring Data JPA** (para falar com o banco)
* **Maven**
* **H2 Database** (banco em memória, só pra rodar local fácil. Os dados somem quando desliga)
* **Lombok** (para não precisar escrever getter/setter)

---

## 🏃 Como rodar na sua máquina

É bem simples.

1.  Clona o projeto:
    ```bash
    git clone [https://github.com/alves-patrick/spingstudy.git](https://github.com/alves-patrick/spingstudy.git)
    ```

2.  Entra na pasta:
    ```bash
    cd spingstudy
    ```

3.  Roda com o Maven Wrapper (ele já baixa o Maven certo, não precisa instalar nada):
    ```bash
    ./mvnw spring-boot:run
    ```

Pronto! A API vai estar rodando em `http://localhost:8080`.

---

## Endpoints (para testar no Postman)

### 1. Criar um usuário

**`POST`** `http://localhost:8080/usuarios`

No **Body** (raw, JSON), manda isso:

```json
{
    "nome": "Patrick Alves",
    "email": "patrick@email.com",
    "senha": "minhasenha123"
}
