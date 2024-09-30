import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

class Loan {
    private User user;
    private Media media;
    private Date startDate;
    private Date endDate;
    private boolean isLate;

    public Loan(User user, Media media, Date startDate) {
        this.user = user;
        this.media = media;
        this.startDate = startDate;
        this.endDate = calculateEndDate();
        this.isLate = false;  // Initialt inte försenat
    }


    private Date calculateEndDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        cal.add(Calendar.DAY_OF_MONTH, user.getLoanPeriod());
        return cal.getTime();
    }

    // Formaterar datum utan att inkludera tidszonen
    public String getFormattedEndDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(calculateEndDate());
    }

    public void checkLate(Date currentDate) {
        if (currentDate.after(endDate)) {
            isLate = true;
        }
    }

    public Date getEndDate() {
        return endDate;
    }

    public User getUser() {
        return user;
    }

    public Media getMedia() {
        return media;
    }
}
