import java.text.SimpleDateFormat;
import java.util.Date;

public class DVD {

    private String title;
    private Date releaseDate;
    private String mpaaRating;
    private String directorName;
    private String studio;
    private String userNote;

    public DVD(String title, Date releaseDate, String mpaaRating, String directorName, String studio, String userNote) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.mpaaRating = mpaaRating;
        this.directorName = directorName;
        this.studio = studio;
        this.userNote = userNote;
    }

    //more simple constructor that only requires the title, release date and director of a DVD
    public DVD(String title, Date releaseDate, String directorName) {
        this.title = title;
        this.directorName = directorName;
        this.releaseDate = releaseDate;
        this.mpaaRating = " ";
        this.studio = " ";
        this.userNote = " ";
    }

    @Override
    public String toString() {
        return "DVD{" +
                "title='" + title + '\'' +
                ", releaseDate=" + printDate(releaseDate) +
                ", mpaaRating=" + mpaaRating +
                ", directorName='" + directorName + '\'' +
                ", studio='" + studio + '\'' +
                ", userNote='" + userNote + '\'' +
                '}';
    }

    //to keep the dates in the csv files constant when exporting
    public String printDate(Date releaseDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateTime = dateFormat.format(releaseDate);
        return dateTime;
    }

    //to keep the csv files constant when exporting
    public String toCsv() {
        return "" + title + "," + printDate(releaseDate) + "," + mpaaRating
                + "," + directorName + "," + studio + "," + userNote + "\n";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }
}
