package com.book.server.model;

import javax.persistence.*;

import java.util.StringJoiner;

@Entity
@Table (name = "book")
public class Book {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column (name = "title")
	private String title;

	@Column (name = "author_id", insertable = false, updatable = false)
	private long authorId;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "author_id", nullable = false)
	private Author author;

	
	public Book() {
		super();
	}

	public Book(long id, String title, Author author) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
	}

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
