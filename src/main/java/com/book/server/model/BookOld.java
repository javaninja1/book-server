package com.book.server.model;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.util.StringJoiner;

public class BookOld {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the Book.",
            example = "1", required = true)
    private long id;

    @Column(name = "title")
    @Schema(description = "Name of the title.",
            example = "Java", required = true)
    private String title;

    @Column (name = "author_id", insertable = false, updatable = false)
    @Schema(description = "ID of the author.",
            example = "1234", required = true)
    private long authorId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;


    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Book.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("title='" + title + "'")
                .toString();
    }
}
