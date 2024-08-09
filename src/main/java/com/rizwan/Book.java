package com.rizwan;

import java.time.Year;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private Year publicationYear;

    public Book(String isbn, String title, String author, Year publicationYear) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getISBN() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Year getPublicationYear() {
        return publicationYear;
    }
}
