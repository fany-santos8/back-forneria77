# Forneria77 - API REST

Forneria77 é uma API REST desenvolvida em **Java com Spring Boot**, projetada para gerenciar pedidos e itens de uma forneria (pizzaria). O projeto segue boas práticas de arquitetura e implementa documentação via **Swagger**.

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- Hibernate
- MySQL
- Swagger
- Docker
- Maven

## Configuração do Projeto

### Requisitos
Antes de executar o projeto, certifique-se de ter instalado:

- **Java 17**
- **Maven**
- **MySQL**
- **Docker** (opcional)

### Clonando o Repositório
```bash
git clone https://github.com/seu-usuario/forneria77.git
cd forneria77
```
### Configurando o Banco de Dados

Crie um banco de dados MySQL:
```sql
CREATE DATABASE forneria77
```
Edite o arquivo src/main/resources/application.properties para ajustar as credenciais:
```sql
spring.datasource.url=jdbc:mysql://localhost:3306/forneria77
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

### Executando o Projeto

Para rodar o projeto localmente:
```bash
mvn spring-boot:run
```
Ou, se estiver usando Docker:
```bash
docker-compose up
```

### Acessando a Documentação Swagger

Depois de iniciar o servidor, acesse o Swagger UI:
```bash
http://localhost:8080/swagger-ui.html
```

### Estrutura do Projeto
```bash
forneria77/
├── src/main/java/com/forneria
│   ├── configuration/       # Configurações (Swagger, Security)
│   ├── controller/          # Controllers (endpoints da API)
│   ├── model/               # Modelos de dados (entidades)
│   ├── repository/          # Repositórios (acesso ao banco de dados)
│   ├── service/             # Serviços (lógica de negócio)
│   ├── Forneria77Application.java  # Classe principal
├── src/main/resources/
│   ├── application.properties  # Configuração da aplicação
├── pom.xml                   # Dependências do projeto (Maven)
├── Dockerfile                # Configuração para Docker
├── README.md                 # Documentação
```

### Endpoints Principais
| Método  | Endpoint            | Descrição               |
|---------|---------------------|-------------------------|
| GET     | `/pizzas`           | Lista todas as pizzas   |
| POST    | `/pizzas`           | Cadastra uma nova pizza |
| GET     | `/usuarios`         | Lista os usuários       |
| POST    | `/usuarios/login`   | Realiza login           |
| GET     | `/tipos`            | Lista os tipos de pizza |


### Desenvolvido por:

- [Estafany Santos](https://www.linkedin.com/in/estefany-santos/)
- [Lucas Matheus](https://www.linkedin.com/in/lucas-matheus-lima/)
- [Kevin Schuab](https://www.linkedin.com/in/kevin-schuab/)
- [Priscila Soares](https://www.linkedin.com/in/priscila-soares-161644111/)
- [Rayane Moara](https://www.linkedin.com/in/rayane-moara/)
- [Sarah Tavares](https://www.linkedin.com/in/sarahtavaresl)
