import java.util.ArrayList;
import java.util.List;

public class Library {
    public List<Book> books;

    // Const
    public Library() {
        books = new ArrayList<Book>();
    }

    // Metod för att lägga till en bok i biblioteket
    public void addBook(Book book) {
        books.add(book);
    }

    // Metod för att visa
    public void showBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Metod hitta en bok baserat på ISBN
    public Book findBookIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    // Metod för att låna en bok
    public boolean borrowBook(String title , String isbn) {
        Book book = findBookIsbn(isbn);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            return false;
        }
        return false;
    }

    // Metod för att återlämna en bok
    public boolean returnBook(String isbn) {
        Book book = findBookIsbn(isbn);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            return true;
        }
        return false;
    }
}
