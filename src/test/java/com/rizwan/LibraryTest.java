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
}