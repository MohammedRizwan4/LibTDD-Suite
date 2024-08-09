package com.rizwan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class LibraryTest {
    @Test
    public void testShouldFailWithoutProperConstructor() {
        Library library = new Library("Drishti");
        assertNotNull(library);
    }
}