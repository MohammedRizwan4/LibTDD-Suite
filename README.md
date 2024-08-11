# Library Management TDD (Incubyte) Kata Solution

Welcome to my solution for the Library Management Kata! This repository showcases the use of Test-Driven Development (TDD) to solve a programming problem, emphasizing small, incremental commits and clear, concise code.

## Project Overview

This project follows TDD principles to solve a kata problem. The solution is built with small, incremental commits, ensuring that each feature is developed and tested in isolation, demonstrating effective TDD practices.

## Features

- **Test-Driven Development**: The entire solution adheres to TDD principles.
- **Incremental Commits**: Code changes are made in small, manageable steps.
- **Comprehensive Tests**: All aspects of the solution are validated with thorough tests.

## Setup Instructions

### Prerequisites

- **Java Development Kit (JDK)**: Ensure JDK 11 or later is installed on your machine.
- **Maven**: Ensure Maven is installed for managing dependencies and building the project.

### Clone the Repository

1. Open your terminal or command prompt.
2. Run the following command to clone the repository:

    ```bash
    git clone https://github.com/MohammedRizwan4/LibTDD-Suite.git
    ```

3. Navigate into the project directory:

    ```bash
    cd LibTDD-Suite
    ```

### Import Project into IntelliJ IDEA

1. Open IntelliJ IDEA.
2. Click on `File` > `Open...`.
3. Select the root directory of the project (where the `pom.xml` file is located).
4. Click `OK` to import the project.

### Build the Project

1. In IntelliJ IDEA, go to the Maven tool window (usually on the right side of the IDE).
2. Click on the `Reload All Maven Projects` button to ensure all dependencies are downloaded and the project is set up correctly.

### Running Tests

- To run the tests, navigate to the `LibraryTest` class and click on the run button.

## Features

### User Management

- **addUser**:
    - Adds a new user to the library's user catalog.
    - Validates that the user is not null.
    - Throws an exception if the user already exists.

- **getUserByName**:
    - Retrieves a user from the library by their username.
    - Returns `null` if the user is not found.

### Book Management

- **addBook**:
    - Allows a user to add a book to the library's inventory.
    - Validates that the user is a librarian.
    - Ensures the book is not null.
    - Throws an exception if the user is unauthorized.

- **viewAvailableBooks**:
    - Returns a list of all books currently available in the library.
    - Ensures the list is unmodifiable.

- **getBookByISBN**:
    - Retrieves a book from the inventory using its ISBN.
    - Returns `null` if the book is not found.

### Borrowing and Returning Books

- **borrowBook**:
    - Allows a user to borrow a book from the library.
    - Validates that the book is not already borrowed.
    - Ensures the book exists in the inventory.
    - Throws an exception if the book is already borrowed.

- **returnBook**:
    - Allows a user to return a borrowed book to the library.
    - Validates that the book was borrowed by the same user.
    - Ensures the book is returned to the inventory.

- **getBorrowerNameByISBN**:
    - Retrieves the name of the user who borrowed a specific book.
    - Returns `null` if the book is not found.

- **getBookByISBNFromBorrowedBook**:
    - Retrieves details of a borrowed book using its ISBN.
    - Returns `null` if the book is not found.
