import java.util.Date;

public abstract class Media implements Loanable {
    private final String title;
    private final Date pubDate;

    /**
     * @param title
     * @param pubDate
     */
    public Media(String title, Date pubDate) {
        this.title = title;
        this.pubDate = pubDate;
    }

    public String getTitle() {
        return title;
    }

    public abstract String getCreator();
}