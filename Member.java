import java.util.ArrayList;
import java.util.List;


public class Member {
    private String name;
    private String memberId;
    private List<Book> borrowedBooks;
    
    /**
     * Constructor to create a new member
     * @param name Member's name
     * @param memberId Unique member ID
     */
    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = new ArrayList<>();
    }
    
    // Getters and Setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getMemberId() {
        return memberId;
    }
    
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    
    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
    
    /**
     * Add a book to the member's borrowed books list
     * @param book Book to borrow
     */
    public void borrowBook(Book book) {
        if (book != null && book.isAvailable()) {
            borrowedBooks.add(book);
            book.setAvailable(false);
        }
    }
    
    /**
     * Remove a book from the member's borrowed books list
     * @param book Book to return
     * @return true if book was successfully returned
     */
    public boolean returnBook(Book book) {
        if (book != null && borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.setAvailable(true);
            return true;
        }
        return false;
    }
    
    /**
     * Display member information
     * @return String representation of the member
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Member ID: %s | Name: %s | Books Borrowed: %d\n", 
                               memberId, name, borrowedBooks.size()));
        if (!borrowedBooks.isEmpty()) {
            sb.append("  Borrowed Books:\n");
            for (Book book : borrowedBooks) {
                sb.append("    - ").append(book.getTitle()).append("\n");
            }
        }
        return sb.toString();
    }
    
    /**
     * Check if two members are equal based on member ID
     * @param obj Object to compare
     * @return true if members have same ID
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Member member = (Member) obj;
        return memberId != null ? memberId.equals(member.memberId) : member.memberId == null;
    }
}

