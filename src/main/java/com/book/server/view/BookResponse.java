package com.book.server.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse extends BookRequest {

    private long bookId;
    private String title;
    private String author;

}
