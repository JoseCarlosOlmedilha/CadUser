# 📌 API de Cadastro de Usuários

API REST desenvolvida para gerenciamento de usuários, aplicando boas práticas de arquitetura com validações, DTOs e padrão Strategy.

---

## 🚀 Tecnologias

- Java 25  
- Spring Boot  
- Spring Validation  
- JPA / Hibernate  
- PostgreSQL  
- Docker  

---

## 📌 Funcionalidades

- ✅ Cadastro de usuário  
- ✅ Atualização de dados
- ✅ Busca de usuário
- ✅ Exclusão de usuário    
- ✅ Validação de campos (email, CPF, etc.)  
- ✅ Regras de negócio desacopladas com Strategy  
- ✅ Separação de camadas com DTO  

---

## 🧱 Arquitetura

O projeto segue boas práticas de desenvolvimento backend:

### 🔹 DTO (Data Transfer Object)
Utilizado para separar os dados de entrada e saída da entidade.

### 🔹 Validation
Validações feitas com annotations do Spring:
- `@NotBlank`
- `@Email`
- `@CPF`

### 🔹 Strategy Pattern
Implementação do padrão Strategy para validações de regras de negócio, permitindo fácil extensão e manutenção.

---

## 📡 Endpoint de cadastro

### ➜ Criar usuário
```http
POST /usuarios/cadastrar
```
## 📥 Exemplo de requisição

```json
{
  "nome": "João Silva",
  "cpf": "12345678909",
  "email": "joao@email.com",
  "senha": "123456",
  "endereco": {
    "cep": "11700-000",
    "rua": "Rua A",
    "bairro": "Centro",
    "cidade": "Praia Grande",
    "estado": "SP",
    "numero": "123"
  }
}
```
