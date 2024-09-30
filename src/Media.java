import java.util.Date;

public abstract class Media implements Loanable {
    private final String title;
    private final Date pubDate;

    public Media(String title, Date pubDate) {
        this.title = title;
        this.pubDate = pubDate;
    }

    public String getTitle() {
        return title;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public abstract String getCreator();  // Författare eller Regissör
}