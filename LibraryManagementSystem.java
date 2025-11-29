import java.util.Scanner;

public class LibraryManagementSystem {
    private static Library library;
    private static Scanner scanner;
    
    public static void main(String[] args) {
        library = new Library();
        scanner = new Scanner(System.in);
        
        System.out.println("========================================");
        System.out.println("   Library Management System");
        System.out.println("========================================\n");
        
        // Add some sample data for demonstration
        initializeSampleData();
        
        boolean running = true;
        
        while (running) {
            displayMenu();
            int choice = getChoice();
            
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    displayAllBooks();
                    break;
                case 4:
                    displayAvailableBooks();
                    break;
                case 5:
                    addMember();
                    break;
                case 6:
                    removeMember();
                    break;
                case 7:
                    displayAllMembers();
                    break;
                case 8:
                    borrowBook();
                    break;
                case 9:
                    returnBook();
                    break;
                case 10:
                    displayStatistics();
                    break;
                case 0:
                    running = false;
                    System.out.println("Thank you for using Library Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
            
            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
    
    /**
     * Display the main menu
     */
    private static void displayMenu() {
        System.out.println("\n========== MAIN MENU ==========");
        System.out.println("1.  Add Book");
        System.out.println("2.  Remove Book");
        System.out.println("3.  Display All Books");
        System.out.println("4.  Display Available Books");
        System.out.println("5.  Add Member");
        System.out.println("6.  Remove Member");
        System.out.println("7.  Display All Members");
        System.out.println("8.  Borrow Book");
        System.out.println("9.  Return Book");
        System.out.println("10. Display Statistics");
        System.out.println("0.  Exit");
        System.out.println("================================");
        System.out.print("Enter your choice: ");
    }
    
    /**
     * Get user's menu choice
     * @return Integer choice
     */
    private static int getChoice() {
        try {
            int choice = Integer.parseInt(scanner.nextLine().trim());
            return choice;
        } catch (NumberFormatException e) {
            return -1; // Invalid choice
        }
    }
    
    /**
     * Add a new book to the library
     */
    private static void addBook() {
        System.out.println("\n--- Add New Book ---");
        System.out.print("Enter book title: ");
        String title = scanner.nextLine().trim();
        
        System.out.print("Enter author name: ");
        String author = scanner.nextLine().trim();
        
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine().trim();
        
        if (title.isEmpty() || author.isEmpty() || isbn.isEmpty()) {
            System.out.println("Error: All fields are required!");
            return;
        }
        
        library.addBook(title, author, isbn);
    }
    
    /**
     * Remove a book from the library
     */
    private static void removeBook() {
        System.out.println("\n--- Remove Book ---");
        System.out.print("Enter ISBN of the book to remove: ");
        String isbn = scanner.nextLine().trim();
        
        if (isbn.isEmpty()) {
            System.out.println("Error: ISBN is required!");
            return;
        }
        
        library.removeBook(isbn);
    }
    
    /**
     * Display all books
     */
    private static void displayAllBooks() {
        library.displayAllBooks();
    }
    
    /**
     * Display available books
     */
    private static void displayAvailableBooks() {
        library.displayAvailableBooks();
    }
    
    /**
     * Add a new member to the library
     */
    private static void addMember() {
        System.out.println("\n--- Add New Member ---");
        System.out.print("Enter member name: ");
        String name = scanner.nextLine().trim();
        
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine().trim();
        
        if (name.isEmpty() || memberId.isEmpty()) {
            System.out.println("Error: All fields are required!");
            return;
        }
        
        library.addMember(name, memberId);
    }
    
    /**
     * Remove a member from the library
     */
    private static void removeMember() {
        System.out.println("\n--- Remove Member ---");
        System.out.print("Enter member ID to remove: ");
        String memberId = scanner.nextLine().trim();
        
        if (memberId.isEmpty()) {
            System.out.println("Error: Member ID is required!");
            return;
        }
        
        library.removeMember(memberId);
    }
    
    /**
     * Display all members
     */
    private static void displayAllMembers() {
        library.displayAllMembers();
    }
    
    /**
     * Borrow a book to a member
     */
    private static void borrowBook() {
        System.out.println("\n--- Borrow Book ---");
        System.out.print("Enter ISBN of the book: ");
        String isbn = scanner.nextLine().trim();
        
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine().trim();
        
        if (isbn.isEmpty() || memberId.isEmpty()) {
            System.out.println("Error: Both ISBN and Member ID are required!");
            return;
        }
        
        library.borrowBook(isbn, memberId);
    }
    
    /**
     * Return a book from a member
     */
    private static void returnBook() {
        System.out.println("\n--- Return Book ---");
        System.out.print("Enter ISBN of the book: ");
        String isbn = scanner.nextLine().trim();
        
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine().trim();
        
        if (isbn.isEmpty() || memberId.isEmpty()) {
            System.out.println("Error: Both ISBN and Member ID are required!");
            return;
        }
        
        library.returnBook(isbn, memberId);
    }
    
    /**
     * Display library statistics
     */
    private static void displayStatistics() {
        library.displayStatistics();
    }
    
    /**
     * Initialize sample data for demonstration
     */
    private static void initializeSampleData() {
        // Add sample books
        library.addBook("The Great Gatsby", "F. Scott Fitzgerald", "978-0-7432-7356-5");
        library.addBook("To Kill a Mockingbird", "Harper Lee", "978-0-06-112008-4");
        library.addBook("1984", "George Orwell", "978-0-452-28423-4");
        library.addBook("Pride and Prejudice", "Jane Austen", "978-0-14-143951-8");
        library.addBook("The Catcher in the Rye", "J.D. Salinger", "978-0-316-76948-0");
        
        // Add sample members
        library.addMember("James Smith", "M001");
        library.addMember("Jane Smith", "M002");
        library.addMember("Bob Smith", "M003");
        
        System.out.println("Sample data loaded successfully!\n");
    }
}

