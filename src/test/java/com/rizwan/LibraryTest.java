package com.rizwan;

import org.junit.jupiter.api.Test;

import java.time.Year;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    Library library = new Library("Drishti");
    @Test
    public void testShouldFailWithoutProperConstructor() {
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
    public void testShouldAllowOnlyPermittedUserToAddBook() {
        User user = new User("Rizwan", Role.LIBRARIAN);

        Book book = new Book("9780132350884", "Clean Code", "Robert Cecil Martin", Year.of(2012));
        library.addBook(user, book);

        Book storedBook = library.getBookByISBN("9780132350884");

        assertNotNull(storedBook);
        assertEquals(book, storedBook);
    }

    @Test
    public void testShouldThrowExceptionIfUnauthorizedUserAddBook() {
        User user = new User("Rizwan", Role.USER);

        Book book = new Book("9780132350884", "Clean Code", "Robert Cecil Martin", Year.of(2012));
        PermissionDeniedException exception = assertThrows(PermissionDeniedException.class, () -> library.addBook(user, book));
        assertEquals("You are not authorized to add book", exception.getMessage());
    }

    @Test
    public void testShouldAddUserToLibrary() {
        User librarian = new User("rizwan", Role.LIBRARIAN);

        library.addUser(librarian);

        User user = library.getUserByName("rizwan");
        assertEquals(librarian, user);
    }

    @Test
    public void testShouldNotAllowDuplicateUsers() {
        User primaryLibrarian = new User("rizwan", Role.LIBRARIAN);
        User secondaryLibrarian = new User("rizwan", Role.LIBRARIAN);

        library.addUser(primaryLibrarian);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> library.addUser(secondaryLibrarian));
        assertEquals("User already exists in catalog", exception.getMessage());
    }

    @Test
    public void testShouldFetchUserByUsername() {
        User primaryLibrarian = new User("rizwan", Role.LIBRARIAN);

        library.addUser(primaryLibrarian);
        User fetchedUser = library.getUserByName("rizwan");
        assertEquals(primaryLibrarian, fetchedUser);
    }

    @Test
    public void testShouldRetrieveAllAvailableBooks() {
        User librarian = new User("Rizwan", Role.LIBRARIAN);
        Book book1 = new Book("9780132350884", "Clean Code", "Robert Cecil Martin", Year.of(2012));
        Book book2 = new Book("9780134685991", "Effective Java", "Joshua Bloch", Year.of(2018));

        library.addUser(librarian);
        library.addBook(librarian, book1);
        library.addBook(librarian, book2);

        Map<String, Book> availableBooks = library.viewAvailableBooks();

        assertEquals(2, availableBooks.size());
        assertTrue(availableBooks.containsKey("9780132350884"));
        assertTrue(availableBooks.containsKey("9780134685991"));
    }

    @Test
    public void testShouldReturnUnmodifiableHashMap() {
        User librarian = new User("Rizwan", Role.LIBRARIAN);
        Book book1 = new Book("9780132350884", "Clean Code", "Robert Cecil Martin", Year.of(2012));

        library.addUser(librarian);
        library.addBook(librarian, book1);

        Map<String, Book> availableBooks = library.viewAvailableBooks();

        assertThrows(UnsupportedOperationException.class, () -> availableBooks.put("9780134685991", new Book("9780134685991", "Effective Java", "Joshua Bloch", Year.of(2018))));
    }
}