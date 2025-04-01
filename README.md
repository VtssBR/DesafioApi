
# Desafio Técnico - API de Gerenciamento de Clientes e Contatos

## 1. Visão Geral

Este projeto foi desenvolvido para um **desafio técnico**, com o objetivo de entregar um sistema de **gerenciamento de clientes e contatos** para uma empresa.

A API permite realizar operações CRUD (Create, Read, Update, Delete) para **clientes** e seus respectivos **contatos**.

---

## 2. Tecnologias Utilizadas 🛠

### 📌 Framework e Plataforma
- **Spring Boot 3.4.4** → Framework para construção de aplicações Java

### 📌 Banco de Dados
- **PostgreSQL** → Banco de dados relacional
- **Spring Data JPA** → Abstração ORM para interação com o banco de dados
- **Flyway** → Migração e versionamento do banco de dados

### 📌 Backend e API
- **Spring Boot Starter Web** → Suporte para desenvolvimento de APIs REST
- **Spring Boot Starter Validation** → Validação de dados no Spring

### 📌 Desenvolvimento e Testes
- **Spring Boot DevTools** → Ferramentas para desenvolvimento ágil
- **Spring Boot Starter Test** → Dependência para testes automatizados

### 📌 Build e Gerenciamento
- **Maven** → Gerenciador de dependências e automação de build
- **Spring Boot Maven Plugin** → Plugin para empacotamento e execução da aplicação

---

## 3. Requisitos e Instalação

### 📌 **Pré-requisitos necessários**
Certifique-se de ter os seguintes pré-requisitos instalados:

1. **Java 21** → Necessário para rodar o Spring Boot
    - Baixe e instale: [[https://jdk.java.net/21/](https://jdk.java.net/21/](https://www.oracle.com/br/java/technologies/downloads/#jdk21-windows))
    - Verifique a instalação:
      ```bash
      java -version
      ```

2. **Maven** → Gerenciador de dependências e build
    - Baixe e instale: [https://maven.apache.org/download.cgi)
    - Verifique a instalação:
      ```bash
      mvn -version
      ```

3. **PostgreSQL** → Banco de dados utilizado
    - Baixe e instale: [https://www.postgresql.org/download/](https://www.postgresql.org/download/)
    - Certifique-se de que o serviço está rodando:
      ```bash
      psql --version
      ```

### 📌 **Clonar o Repositório**

```bash
git clone https://github.com/VtssBR/DesafioApi
cd desafioApi
```

### 📌 **Instalar Dependências**
Caso precise instalar as dependências manualmente, execute o seguinte comando:

```bash
mvn clean install
```

Isso garantirá que todas as dependências sejam baixadas corretamente.

### 📌 **Configurar as Variáveis de Ambiente**
Crie um arquivo `application.properties` na pasta `src/main/resources` e configure as credenciais do banco:

```properties
spring.application.name=desafioApi

spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=validate

spring.flyway.enabled=true
spring.flyway.baseline-on-migrate=true

Obs: no controller configurar o CORS: @CrossOrigin(origins = "http://localhost:sua_porta")
```
---

## 4. Executando a API 🚀

Para rodar a API localmente, execute o seguinte comando no terminal:

```bash
mvn spring-boot:run
```

Se tudo estiver correto, a API estará rodando em:
```
http://localhost:8080
```

---

## 5. Estrutura do Projeto 📂
O projeto segue o padrão **MVC (Model-View-Controller)**:

```
/src/main/java/com/vitor/desafioApi
├── controllers    # Contém os endpoints da API
├── model          # Define as entidades Cliente e Contato
├── repositories   # Interfaces do JPA para interação com o BD
├── services       # Contém as regras de negócio
```

---

## 6. Endpoints da API 📝

### 📌 **Clientes** (`/api/client`)
| Método | Endpoint | Descrição |
|---------|---------|-------------|
| **GET** | `/list` | Lista todos os clientes |
| **POST** | `/create` | Cria um novo cliente |
| **PUT** | `/update/{id}` | Atualiza os dados de um cliente |
| **DELETE** | `/delete/{id}` | Exclui um cliente |

### 📌 **Contatos** (`/api/contact`)
| Método | Endpoint | Descrição |
|---------|---------|-------------|
| **GET** | `/list/{clientId}` | Lista todos os contatos de um cliente |
| **POST** | `/create` | Adiciona um novo contato |
| **PUT** | `/update/{id}` | Atualiza um contato |
| **DELETE** | `/delete/{id}` | Exclui um contato |

---


