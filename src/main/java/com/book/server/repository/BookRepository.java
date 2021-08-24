package com.book.server.repository;

import com.book.server.response.BookResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.book.server.model.Book;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthorId(long authorId);
    List<Book> findByTitleContaining(String title);

//    @Query("select u.userName from User u inner join u.area ar where ar.idArea = :idArea")

    @Query("SELECT new com.book.server.response.BookResponse(b.title, a.name) from Book b inner join b.author a")
    public List<BookResponse> getBookAuthors();


    @Query("SELECT new com.book.server.response.BookResponse(b.title, b.title) from Book b")
    public List<BookResponse> getBookDetail();

}
