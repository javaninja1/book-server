package com.book.server.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.StringJoiner;


@Entity
@Table(name="books")
public class Book {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;


	@NotBlank
	@Size(min = 0, max = 20)
	private String title;


	@NotBlank
	@Size(min = 0, max = 30)
	private String author;

	public  Book() {}

	public Book(int id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;
	}

    public Book(String book1, String author1) {
		this.title = title;
		this.author = author;
    }


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "title", nullable = false)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "author", nullable = false)
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Book.class.getSimpleName() + "[", "]")
				.add("id=" + id)
				.add("title='" + title + "'")
				.add("author='" + author + "'")
				.toString();
	}
}
