import java.util.Date;

class DVD extends Media {
    private final String director;

    public DVD(String title, Date pubDate, String director) {
        super(title, pubDate);
        this.director = director;
    }


    @Override
    public String getCreator() {
        return director;
    }

    @Override
    public int getLoanPeriod() {
        return 3;  // DVD-skivor har en låneperiod på 3 dagar
    }
}

