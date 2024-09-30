
import java.util.Date;

class Book extends Media {
    private final String author;

    public Book(String title, Date pubDate, String author) {
        super(title, pubDate);
        this.author = author;
    }

    @Override
    public String getCreator() {
        return author;
    }

    @Override
    public int getLoanPeriod() {
        return 14;  // Vanlig låneperiod för böcker är 14 dagar
    }
}
