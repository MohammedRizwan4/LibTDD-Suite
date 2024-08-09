package com.rizwan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    @Test
    public void testShouldFailWithoutProperConstructor() {
        Library library = new Library("Drishti");
        assertNotNull(library);
    }

    @Test
    public void testLibraryNameShouldNotbeNull() {
        assertThrows(IllegalArgumentException.class, () -> new Library(null));
    }

    @Test
    public void testLibraryNameShouldNotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new Library(""));
    }

    @Test
    public void testLibraryNameShouldBeGreaterThan4Characters() {
        assertThrows(IllegalArgumentException.class, () -> new Library("Dris"));
    }

    @Test
    public void testShouldAddBookToLibrary() {
        Library library = new Library("Drishti");

        Book book = new Book("9780132350884", "Clean Code", "Robert Cecil Martin", 2012);
        library.addBook(book);

        Book storedBook = getBookByISBN("9780132350884");

        assertNotNull(storedBook);
        assertEquals("9780132350884", storedBook.getISBN());
        assertEquals("Clean Code", storedBook.getTitle());
        assertEquals("9Robert Cecil Martin", storedBook.getAuthor());
        assertEquals(2012, storedBook.getPublicationYear());
    }
}