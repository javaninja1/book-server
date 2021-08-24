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
https://www.stackchief.com/blog/Spring%20Data%20JPA%20CRUD%20Example