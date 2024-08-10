package com.rizwan;

import java.time.Year;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private Year publicationYear;

    public Book(String isbn, String title, String author, Year publicationYear) {

        if(isbn == null || isbn.isBlank()){
            throw new IllegalArgumentException("ISBN should not be null or empty");
        }
        if(title == null || title.isBlank()){
            throw new IllegalArgumentException("title should not be null or empty");
        }
        if(author == null || author.isBlank()){
            throw new IllegalArgumentException("author should not be null or empty");
        }
        if(publicationYear == null){
            throw new IllegalArgumentException("publication year should not be null");
        }

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

    @Override
    public boolean equals(Object object) {
        if(this == object) return true;
        if(object == null || (this.getClass() != object.getClass())) return false;
        Book book = (Book) object;
        return isbn.equals(book.isbn);
    }

    @Override
    public int hashCode() {
        return isbn.hashCode();
    }
}
