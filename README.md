# Book Store REST API

This project demonstrates following:

* spring boot rest controller
* REST methods for CRUD operations
* spring data jpa
* swagger UI docs
* modelmapper
* mockito testing framework
* separation of client views from ORM objects for extensible API design
* javax validation constraints

### Running the application
```
mvn spring-boot:run
```

### Swagger UI docs
http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/

### default swagger reference
http://localhost:8080/swagger-ui/index.html

### Get all books
GET http://localhost:8080/api/v1/books/

### Get one books
GET http://localhost:8080/api/v1/books/2

### Add a book
POST http://localhost:8080/api/v1/books/
Content-Type: application/json

{
"id": 4,
"title": "book4",
"author": "author4"
}

### Delete a book
DELETE http://localhost:8080/api/v1/books/3

### Replace a Book
PUT http://localhost:8080/api/v1/books/2
Content-Type: application/json

{
"id": 2,
"title": "book22",
"author": "author2"
}

### Update part of a Book
PATCH http://localhost:8080/api/v1/books/2
Content-Type: application/json

{
"title": "book223" ,
"author": "author2"
}


### GET	/api/books/published	find all published books
### GET	/api/books?title=[keyword]	find all books which title contains keyword

