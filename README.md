# Library Management System - Week 3 Java Project

A console-based Library Management System built with Java that demonstrates Object-Oriented Programming principles, classes, objects, methods, and collections.

## 📚 Project Overview

This project implements a complete library management system with the following features:
- Book tracking (add, remove, display)
- Member management (add, remove, display)
- Book borrowing and returning operations
- Library statistics

## 🏗️ Project Structure

```
Library Management System/
├── Book.java                      # Book class with properties and methods
├── Member.java                    # Member class with borrowing functionality
├── Library.java                   # Library class managing books and members
├── LibraryManagementSystem.java   # Main class with console menu
└── README.md                      # Project documentation
```

## 📋 Classes Description

### 1. Book Class
Represents a book in the library with:
- **Properties**: title, author, ISBN, availability status
- **Methods**: Getters/setters, toString(), equals()

### 2. Member Class
Represents a library member with:
- **Properties**: name, memberId, list of borrowed books
- **Methods**: borrowBook(), returnBook(), toString(), equals()

### 3. Library Class
Manages the entire library system with:
- **Collections**: ArrayList<Book>, ArrayList<Member>
- **Methods**: 
  - Book management: addBook(), removeBook(), findBookByIsbn(), displayAllBooks(), displayAvailableBooks()
  - Member management: addMember(), removeMember(), findMemberById(), displayAllMembers()
  - Operations: borrowBook(), returnBook(), displayStatistics()

### 4. LibraryManagementSystem Class
Main class providing console-based user interface:
- Menu-driven system
- Input validation
- Sample data initialization

## 🚀 How to Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command line terminal

### Compilation
```bash
javac *.java
```

### Execution
```bash
java LibraryManagementSystem
```

## 💡 Features

### Book Management
1. **Add Book**: Add new books with title, author, and ISBN
2. **Remove Book**: Remove books (only if not borrowed)
3. **Display All Books**: View all books with their status
4. **Display Available Books**: View only available books

### Member Management
1. **Add Member**: Register new library members
2. **Remove Member**: Remove members (only if no borrowed books)
3. **Display All Members**: View all members with their borrowed books

### Library Operations
1. **Borrow Book**: Members can borrow available books
2. **Return Book**: Members can return borrowed books
3. **Statistics**: View library statistics (total books, available, borrowed, members)

## 🎯 Java Concepts Demonstrated

### Object-Oriented Programming
- **Classes and Objects**: Book, Member, Library classes
- **Encapsulation**: Private fields with public getters/setters
- **Abstraction**: Methods hide implementation details
- **Polymorphism**: Method overriding (toString(), equals())

### Data Structures
- **ArrayList**: Used for storing books and members
- **Collections**: List interface implementation

### Control Structures
- **Loops**: for loops, while loops
- **Conditionals**: if-else statements
- **Switch-case**: Menu selection

### Input/Output
- **Scanner**: Console input handling
- **System.out**: Console output

### Methods
- **Instance Methods**: Operations on objects
- **Static Methods**: Utility methods in main class
- **Method Overloading**: Not used but concept applicable

## 📝 Sample Usage

```
========== MAIN MENU ==========
1.  Add Book
2.  Remove Book
3.  Display All Books
4.  Display Available Books
5.  Add Member
6.  Remove Member
7.  Display All Members
8.  Borrow Book
9.  Return Book
10. Display Statistics
0.  Exit
================================
Enter your choice: 3
```

## 🔍 Key Learning Points

1. **Class Design**: How to design classes with appropriate properties and methods
2. **Collection Usage**: Using ArrayList for dynamic data storage
3. **Object Relationships**: How objects interact (Member borrows Book)
4. **Input Validation**: Checking for empty inputs and existing records
5. **Menu System**: Creating user-friendly console interfaces
6. **Error Handling**: Basic error messages for invalid operations

## 🛠️ Extending the Project

You can extend this project by adding:
- **Date tracking**: Track borrow/return dates
- **Due dates**: Implement due dates and late fees
- **Search functionality**: Search books by title/author
- **File I/O**: Save/load data from files
- **Exception handling**: Try-catch blocks for robust error handling
- **Database integration**: Store data in a database
- **GUI**: Create a graphical user interface

---
