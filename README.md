# UserManagement-API-Refactored-code
Refatoração feita no codigo "UserManagement-API"

# 🖥️ Spring Boot User Management API

API RESTful em **Spring Boot** para gerenciamento de usuários, construída seguindo boas práticas de arquitetura em camadas.  

O projeto demonstra o uso de **DTOs**, **entidades JPA**, **camadas de service e repository**, validação de dados e tratamento global de exceções.

---

## 📌 Tecnologias e dependências

- Java 17+  
- Spring Boot 3.x  
- Spring Web  
- Spring Data JPA  
- PostgreSQL / H2 (banco de dados relacional)  
- Jakarta Validation (Bean Validation)  
- Maven  

---

## 🏗️ Estrutura do projeto

src/main/java/com/muriloDev/backend
│
├─ controller # Recebe requisições HTTP
├─ service # Lógica de negócio e manipulação de entidades
├─ repository # Interface para acesso ao banco de dados (JPA)
├─ model # Entidades JPA
├─ dto # Objetos para comunicação entre client ↔ server (DTOs)
├─ exception # Tratamento global de exceções

yaml
Copiar código

---

## 📦 Principais DTOs

- `UserCreateDTO` → usado para receber dados de cadastro do usuário.  
- `UserResponseDTO` → usado para retornar ao cliente apenas informações seguras (ex: nome e e-mail).  
- `UserNameDTO` → usado para listagens resumidas.  
- `ApiResponseDTO` → padroniza respostas da API (sucesso ou erro).  
- `MessageResponseDTO` → mensagens simples de retorno.

---

## ⚙️ Endpoints da API

| Método | Endpoint               | Descrição                         | Request Body / Response |
|--------|----------------------|----------------------------------|-----------------------|
| POST   | `/users/register`     | Cadastrar novo usuário           | `UserCreateDTO` → `ApiResponseDTO` |
| GET    | `/users/read`         | Retornar todos os usuários       | Lista de `UserResponseDTO` ou `ApiResponseDTO` |
| GET    | `/users/readData`     | Retornar apenas nomes e e-mails  | Lista de `UserNameDTO` ou `ApiResponseDTO` |
| PATCH  | `/users/update/{id}`  | Atualização parcial de usuário   | Map<String,Object> → `ApiResponseDTO` |
| DELETE | `/users/{id}`         | Deletar usuário por ID           | `ApiResponseDTO` |

---

## 🔧 Funcionalidades

- Cadastro de usuários com validação de campos (nome, e-mail, senha).  
- Listagem completa ou resumida de usuários.  
- Atualização parcial de campos de usuário (PATCH).  
- Exclusão de usuários.  
- Tratamento global de exceções com respostas padronizadas (`ApiResponseDTO`).  

---

## 🛠️ Rodando o projeto

1. Clone o repositório:
```bash
git clone https://github.com/seuusuario/user-management-api.git
cd user-management-api
Configure o banco de dados no application.properties ou application.yml.

Rode a aplicação:

bash
Copiar código
mvn spring-boot:run
Teste os endpoints usando Postman, Insomnia ou qualquer cliente HTTP.

💡 Boas práticas aplicadas
Separação de responsabilidades entre Controller, Service e Repository.

Uso de DTOs para comunicação segura entre backend e client.

Validação de dados usando Jakarta Validation.

Tratamento global de erros com @ControllerAdvice e ApiResponseDTO.

Arquitetura limpa e extensível, preparada para futuras implementações (autenticação JWT, Spring Security, etc).
