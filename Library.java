import java.util.ArrayList;
import java.util.List;

/**
 * Library class manages books and members
 * Handles all library operations: adding/removing books and members,
 * borrowing/returning books, and displaying information
 */
public class Library {
    private List<Book> books;
    private List<Member> members;
    
    /**
     * Constructor to initialize the library
     */
    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }
    
    // Book Management Methods
    
    /**
     * Add a new book to the library
     * @param title Book title
     * @param author Book author
     * @param isbn Book ISBN
     * @return true if book was added successfully
     */
    public boolean addBook(String title, String author, String isbn) {
        // Validate input
        if (title == null || title.trim().isEmpty()) {
            System.out.println("Error: Book title cannot be empty!");
            return false;
        }
        if (author == null || author.trim().isEmpty()) {
            System.out.println("Error: Author name cannot be empty!");
            return false;
        }
        if (isbn == null || isbn.trim().isEmpty()) {
            System.out.println("Error: ISBN cannot be empty!");
            return false;
        }
        
        // Normalize inputs
        title = title.trim();
        author = author.trim();
        isbn = isbn.trim();
        
        // Check if book with same ISBN already exists
        for (Book book : books) {
            if (book.getIsbn() != null && book.getIsbn().equals(isbn)) {
                System.out.println("Error: Book with ISBN " + isbn + " already exists!");
                return false;
            }
        }
        Book newBook = new Book(title, author, isbn);
        books.add(newBook);
        System.out.println("Book added successfully: " + title);
        return true;
    }
    
    /**
     * Remove a book from the library
     * @param isbn ISBN of the book to remove
     * @return true if book was removed successfully
     */
    public boolean removeBook(String isbn) {
        Book bookToRemove = findBookByIsbn(isbn);
        if (bookToRemove != null) {
            if (!bookToRemove.isAvailable()) {
                System.out.println("Error: Cannot remove book. It is currently borrowed.");
                return false;
            }
            books.remove(bookToRemove);
            System.out.println("Book removed successfully: " + bookToRemove.getTitle());
            return true;
        }
        System.out.println("Error: Book with ISBN " + isbn + " not found!");
        return false;
    }
    
    /**
     * Find a book by ISBN
     * @param isbn ISBN to search for
     * @return Book object if found, null otherwise
     */
    public Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }
    
    /**
     * Display all books in the library
     */
    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        System.out.println("\n=== All Books in Library ===");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
        System.out.println("Total books: " + books.size() + "\n");
    }
    
    /**
     * Display only available books
     */
    public void displayAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        
        if (availableBooks.isEmpty()) {
            System.out.println("No available books in the library.");
            return;
        }
        
        System.out.println("\n=== Available Books ===");
        for (int i = 0; i < availableBooks.size(); i++) {
            System.out.println((i + 1) + ". " + availableBooks.get(i));
        }
        System.out.println("Total available: " + availableBooks.size() + "\n");
    }
    
    // Member Management Methods
    
    /**
     * Add a new member to the library
     * @param name Member's name
     * @param memberId Unique member ID
     * @return true if member was added successfully
     */
    public boolean addMember(String name, String memberId) {
        // Check if member with same ID already exists
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                System.out.println("Error: Member with ID " + memberId + " already exists!");
                return false;
            }
        }
        Member newMember = new Member(name, memberId);
        members.add(newMember);
        System.out.println("Member added successfully: " + name);
        return true;
    }
    
    /**
     * Remove a member from the library
     * @param memberId ID of the member to remove
     * @return true if member was removed successfully
     */
    public boolean removeMember(String memberId) {
        Member memberToRemove = findMemberById(memberId);
        if (memberToRemove != null) {
            if (!memberToRemove.getBorrowedBooks().isEmpty()) {
                System.out.println("Error: Cannot remove member. They have borrowed books.");
                return false;
            }
            members.remove(memberToRemove);
            System.out.println("Member removed successfully: " + memberToRemove.getName());
            return true;
        }
        System.out.println("Error: Member with ID " + memberId + " not found!");
        return false;
    }
    
    /**
     * Find a member by ID
     * @param memberId Member ID to search for
     * @return Member object if found, null otherwise
     */
    public Member findMemberById(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }
    
    /**
     * Display all members in the library
     */
    public void displayAllMembers() {
        if (members.isEmpty()) {
            System.out.println("No members registered in the library.");
            return;
        }
        System.out.println("\n=== All Library Members ===");
        for (int i = 0; i < members.size(); i++) {
            System.out.println((i + 1) + ". " + members.get(i));
        }
        System.out.println("Total members: " + members.size() + "\n");
    }
    
    // Book Borrowing/Returning Methods
    
    /**
     * Borrow a book to a member
     * @param isbn ISBN of the book to borrow
     * @param memberId ID of the member borrowing the book
     * @return true if book was borrowed successfully
     */
    public boolean borrowBook(String isbn, String memberId) {
        Book book = findBookByIsbn(isbn);
        Member member = findMemberById(memberId);
        
        if (book == null) {
            System.out.println("Error: Book with ISBN " + isbn + " not found!");
            return false;
        }
        
        if (member == null) {
            System.out.println("Error: Member with ID " + memberId + " not found!");
            return false;
        }
        
        if (!book.isAvailable()) {
            System.out.println("Error: Book is not available. It is currently borrowed.");
            return false;
        }
        
        member.borrowBook(book);
        System.out.println("Book '" + book.getTitle() + "' borrowed successfully by " + member.getName());
        return true;
    }
    
    /**
     * Return a book from a member
     * @param isbn ISBN of the book to return
     * @param memberId ID of the member returning the book
     * @return true if book was returned successfully
     */
    public boolean returnBook(String isbn, String memberId) {
        Book book = findBookByIsbn(isbn);
        Member member = findMemberById(memberId);
        
        if (book == null) {
            System.out.println("Error: Book with ISBN " + isbn + " not found!");
            return false;
        }
        
        if (member == null) {
            System.out.println("Error: Member with ID " + memberId + " not found!");
            return false;
        }
        
        if (member.returnBook(book)) {
            System.out.println("Book '" + book.getTitle() + "' returned successfully by " + member.getName());
            return true;
        } else {
            System.out.println("Error: Member " + member.getName() + " has not borrowed this book.");
            return false;
        }
    }
    
    /**
     * Get statistics about the library
     */
    public void displayStatistics() {
        int totalBooks = books.size();
        int availableBooks = 0;
        int borrowedBooks = 0;
        
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks++;
            } else {
                borrowedBooks++;
            }
        }
        
        System.out.println("\n=== Library Statistics ===");
        System.out.println("Total Books: " + totalBooks);
        System.out.println("Available Books: " + availableBooks);
        System.out.println("Borrowed Books: " + borrowedBooks);
        System.out.println("Total Members: " + members.size());
        System.out.println();
    }
}

