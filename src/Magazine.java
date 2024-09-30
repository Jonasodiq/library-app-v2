import java.util.Date;

class Magazine extends Media {
    private final String author;

    /**
     * @param title
     * @param pubDate
     * @param author
     */
    public Magazine(String title, Date pubDate, String author) {
        super(title, pubDate);
        this.author = author;
    }

    @Override
    public String getCreator() {
        return author;
    }

    @Override
    public int getLoanPeriod() {
        return 7;  // Tidskrifter har kortare låneperiod
    }
}