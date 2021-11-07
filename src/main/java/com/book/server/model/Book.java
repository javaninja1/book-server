package com.book.server.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.StringJoiner;


@Schema(description = "Book object")
@Entity
@Table(name="books")
public class Book {

	@JsonProperty(value="id", required=true, index = 10)
	@Schema(description = "UNIQUE Identifier.",
			example = "1", required = true)
	private long id;

	@JsonProperty(value="title", required=true, index = 20)
	@Schema(description = "Name of the title.",
			example = "Effective Java", required = true)
	@NotBlank
	@Size(min = 0, max = 20)
	private String title;

	@JsonProperty(value="author", required=true, index = 30)
	@Schema(description = "Name of the author.",
			example = "Joshua Bloch", required = true)
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

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
