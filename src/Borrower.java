import java.util.ArrayList;
import java.util.List;

public class Borrower {
    private String name;
    private List<Book> borrowedBooks;

    // Const
    public Borrower(String name) {
        this.name = name;
        borrowedBooks = new ArrayList<>();
    }

    // Get & Setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Metod för att lägga till en lånad bok
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    // Metod för att ta bort en återlämnad bok
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    // Metod för att visa alla lånade böcker
    public void showBorrowedBooks() {
        for (Book book : borrowedBooks) {
            System.out.println(book);
        }
    }

    @Override
    public String toString() {
        return "Borrower{" +
                "name='" + name + '\'' +
                '}';
    }
}
