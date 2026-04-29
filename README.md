# Product CRUD API - Java/Spring Boot
API REST de gerenciamento de produtos desenvolvida com Java + Spring Boot, utilizando arquitetura em camadas, DTOs, Exception Handler Global e boas práticas de organização de código.

<br>

# Tecnologias Utilizadas
    * Java
    * Spring Boot
    * Spring Data JPA
    * Hibernate
    * H2 Database
    * Jakarta Validation
    * Lombok
    * Maven

<br>

# Estrutura do Projeto
```
src/main/java/com/proexceptions
  ┣ controller
  ┃ ┗ ProductController.java
  ┣ dtos
  ┃ ┣ ErrorDTO.java
  ┃ ┣ ProductRequestDTO.java
  ┃ ┗ ProductResponseDTO.java
  ┣ entity
  ┃ ┗ Product.java
  ┣ exceptions
  ┃ ┣ GlobalExceptionHandler.java
  ┃ ┗ ProductNotFoundException.java
  ┣ mapper
  ┃ ┗ ProductMapper.java
  ┣ repository
  ┃ ┗ ProductRepository.java
  ┣ service
  ┃ ┗ ProductService.java
  ┃ ┗ ExceptionsApplication.java
```

<br>

# Endpoints
    * Criar produto                      -> POST /api/products                          
    * Listar todos os produtos           -> GET /api/products             
    * Buscar produto por ID              -> GET /api/products/{id}
    * Atualizar produto                  -> PUT /api/products/{id}
    * Remover produto                    -> REMOVE /api/products/{id}

<br>

# Modelo de Produto
REQUEST
```
{
    "name": "Notebook",
    "price": 3500.00
}
```

RESPONSE
```
{
    "id": 1,
    "name": "Notebook",
    "price": 3500.00
}
```

<br>

# Como executar
`Clonar o projeto`
~~~
git clone https://github.com/pr0mesy/exceptions-crud-spring
~~~

`Entrar na pasta`
```
cd exceptions
```

`Executar`
```
./mvnw spring-boot:run
```

ou
```
mvn spring-boot:run
```

<br>

# Conceitos aplicados
    * Arquitetura em camadas
    * DTO pattern
    * Mapper pattern
    * Transações com @Transactional
    * RESTful API design

# Autor
Desenvolvido por `pr0mesy`
