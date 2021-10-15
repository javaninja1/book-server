# book-server
spring boot backend


## Methods	Urls	Actions

# POST	/api/books	create new book
# GET	/api/books	retrieve all books
# GET	/api/books/:id	retrieve a book by :id
# PUT	/api/books/:id	update a book by :id
# DELETE	/api/books/:id	delete a book by :id
# DELETE	/api/books	delete all books
# GET	/api/books/published	find all published books
# GET	/api/books?title=[keyword]	find all books which title contains keyword

References:
https://www.baeldung.com/spring-data-jpa-query
https://www.baeldung.com/jpa-queries-custom-result-with-aggregation-functions
https://attacomsian.com/blog/spring-data-jpa-query-annotation
https://www.stackchief.com/b
https://www.baeldung.com/intro-to-querydsls
https://stackoverflow.blog/2020/03/02/best-practices-for-rest-api-design/s
https://medium.com/@bcarunmail/rest-api-best-practices-volume-1-83c6ecaddd8clog/Spring%20Data%20JPA%20CRUD%20Example
https://www.baeldung.com/spring-interface-driven-controllers
https://swagger.io/docs/specification/authentication/bearer-authentication/

https://spring.io/guides/tutorials/react-and-spring-data-rest/

https://spring.io/guides/tutorials/rest/

~~~~


POST http:///
Content-Type:



###
POST http://localhost:8080/api/book
Content-Type: application/json

{
  "id": 4,
  "title": "new book",
  "authorId": 1
}

<> 2021-08-24T232319.500.json
<> 2021-08-24T231652.500.json

###
###
POST http://localhost:8080/api/book

###
DELETE http://localhost:8080/api/books/3

###
PUT http://localhost:8080/api/books/2
Content-Type: application/json

{
  "id": 2,
  "title": "new book33",
  "authorId": 1
}

<> 2021-08-24T234838.200.json
###

<> 2021-08-24T234612.400.html