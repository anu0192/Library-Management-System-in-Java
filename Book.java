/**
 * Book class represents a book in the library
 * Contains book information: title, author, ISBN, and availability status
 */
public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;
    
    /**
     * Constructor to create a new book
     * @param title Book title
     * @param author Book author
     * @param isbn Book ISBN number
     */
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true; // New books are available by default
    }
    
    // Getters and Setters
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
    
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    
    /**
     * Display book information
     * @return String representation of the book
     */
    @Override
    public String toString() {
        String status = isAvailable ? "Available" : "Borrowed";
        return String.format("Title: %s | Author: %s | ISBN: %s | Status: %s", 
                            title, author, isbn, status);
    }
    
    /**
     * Check if two books are equal based on ISBN
     * @param obj Object to compare
     * @return true if books have same ISBN
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return isbn != null ? isbn.equals(book.isbn) : book.isbn == null;
    }
}

