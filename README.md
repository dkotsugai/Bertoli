# Projetos de Estudo - API 

📝 Descrição

Este repositório contém uma série de projetos de estudo que demonstram a evolução de uma API REST para uma pastelaria, construída com Java e Spring Boot. Cada projeto está em sua própria pasta e representa um estágio diferente de desenvolvimento e complexidade.

📝  Pastelaria API v1 (`projeto1`)

Esta é a primeira versão da API. É um projeto Spring Boot simples que expõe endpoints CRUD para gerenciar pastéis.

### Características

- **API RESTful:** Operações de Criar, Ler, Atualizar e Deletar (CRUD) para pastéis.
- **Armazenamento em Memória:** A lista de pastéis é armazenada em uma lista em memória, o que significa que os dados são perdidos quando a aplicação é reiniciada.
- **Modelo Simples:** Um único modelo `Pastel` com atributos básicos.

### Tecnologias

- Java 21
- Spring Boot
- Maven

🚀 Como Executar

1. Navegue até o diretório do projeto:
   ```bash
   cd projeto1/pastelFatec
   ```
2. Execute a aplicação usando o Maven Wrapper:
   ```bash
   ./mvnw spring-boot:run
   ```
A API estará disponível em `http://localhost:8080/pastelaria`.

---

📝  Pastelaria API v2 (`projeto2`)

Esta é a segunda versão da API, uma evolução do `projeto1`. Este projeto introduz uma arquitetura mais robusta e funcionalidades adicionais.

### Melhorias e Novas Características

- **Arquitetura em Camadas:** O código é organizado em camadas de Controller, Service e Repository.
- **Persistência de Dados:** Utiliza Spring Data JPA para persistir os dados em um banco de dados relacional (MySQL).
- **DTO (Data Transfer Object):** Usa DTOs para transferir dados entre o cliente e o servidor, desacoplando o modelo da API da entidade de banco de dados.
- **Validação:** Adiciona validação para os dados de entrada.
- **Categorias:** Introduz um `enum` para categorizar os produtos (Salgado, Doce, Bebida).

### Tecnologias

- Java 21
- Spring Boot
- Spring Data JPA
- Maven
- MySQL (requerido)

🚀 Como Executar

1. **Configure o Banco de Dados:**
   - Certifique-se de ter o MySQL instalado e em execução.
   - Crie um banco de dados (por exemplo, `pastelaria_db`).
   - Configure as credenciais do banco de dados no arquivo `src/main/resources/application.properties`.
2. **Navegue até o diretório do projeto:**
   ```bash
   cd projeto2/pastelFatec2
   ```
3. **Execute a aplicação:**
   ```bash
   ./mvnw spring-boot:run
   ```
A API estará disponível em `http://localhost:8080/pastelaria`.

---

## Autores

- [@dkotsugai](https://www.github.com/dkotsugai)


## Stack utilizada

**Front-end:** Next.js, TailwindCSS

**Back-end:** Java

