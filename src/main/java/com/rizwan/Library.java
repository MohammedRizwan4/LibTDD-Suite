package com.rizwan;

public class Library {

    String name;

    public Library(String name) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("Library Name Should not be null");
        }
        this.name = name;
    }
}
