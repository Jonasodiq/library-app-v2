import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("1. Add Book ");
            System.out.println("2. Borrow Book ");
            System.out.println("3. Return Book ");
            System.out.println("4. Show All Books ");
            System.out.println("5. Exit");
            System.out.print("Chooise an option: ");

            int choice = 0;
                    try {
                        choice = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input.❌ Please enter a number.");
                        scanner.next(); // Rensa ogiltig inmatning
                        continue;
                    }

            switch (choice) {
                case 1:
                    System.out.println("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter Book Author: ");
                    String author = scanner.nextLine();
                    System.out.println("Enter Book ISBN: ");
                    String isbn = scanner.nextLine();
                    Book book = new Book(title, author, isbn);
                    library.addBook(book);
                    System.out.println("Book Added");
                    break;
                case 2:
                    System.out.println("Enter ISBN of the book to borrow: ");
                    isbn = scanner.nextLine();
                    if (library.borrowBook(isbn)) {
                        System.out.println("Book Borrowed");
                    } else {
                        System.out.println("Book Not Borrowed");
                    }
                    break;
                case 3:
                    System.out.println("Enter ISBN of the book to return: ");
                    isbn = scanner.nextLine();
                    if (library.returnBook(isbn)) {
                        System.out.println("Book Returned");
                    } else {
                        System.out.println("Book Not Returned");
                    }
                    break;
                case 4:
                    Library.showBooks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.❌ Please try again.");
            }
        }
    }
}
