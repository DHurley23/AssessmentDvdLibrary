import java.util.ArrayList;
import java.util.Date;
import java.io.*;

public class DVDLibrary {
    private ArrayList<DVD> dvds;

    public DVDLibrary() {
        dvds = new ArrayList<>();
    }

    public void addDvd(DVD dvd) {
        dvds.add(dvd);
    }

    public void removeDvd(DVD dvd) {
        dvds.remove(dvd);
    }

    public void editTitle(DVD dvd, String title) {
        if (existsByTitle(dvd.getTitle())) {
            dvd.setTitle(title);
        }
    }

    public void editReleaseDate(DVD dvd, Date date) {
        if (existsByTitle(dvd.getTitle())) {
            dvd.setReleaseDate(date);
        }
    }

    public void editMpaaRating(DVD dvd, String rating) {
        if (existsByTitle(dvd.getTitle())) {
            dvd.setMpaaRating(rating);
        }
    }

    public void editDirectorName(DVD dvd, String name) {
        if (existsByTitle(dvd.getTitle())) {
            dvd.setDirectorName(name);
        }
    }

    public void editStudio(DVD dvd, String studio) {
        if (existsByTitle(dvd.getTitle())) {
            dvd.setStudio(studio);
        }
    }

    public void editUserNote(DVD dvd, String note) {
        if (existsByTitle(dvd.getTitle())) {
            dvd.setUserNote(note);
        }
    }

    //print all DVD info
    public void printList() {
        for (DVD dvd : dvds) {
            System.out.println(dvd.toString());
        }
    }

    //find DVD and print info
    public void printDvd(DVD dvd) {
        for (DVD value : dvds) {
            if (dvd.getTitle().equalsIgnoreCase(value.getTitle())) {
                System.out.println(dvd);
            }
        }
    }

    //used to see if a dvd exists by its title
    public boolean existsByTitle(String title) {
        for (DVD dvd : dvds) {
            if (title.equalsIgnoreCase(dvd.getTitle())) {
                return true;
            }
        }
        return false;
    }

    //return a dvd from its title
    public DVD getByTitle(String title) {
        for (DVD dvd : dvds) {
            if (title.equalsIgnoreCase(dvd.getTitle())) {
                return dvd;
            }
        }
        return null;
    }

    //read in dvd values from file
    public void loadFromFile(String filename) throws IOException {
        dvds = (ArrayList<DVD>) FileIO.loadFromFile(filename);
    }

    //export all dvds to a file
    public void saveToFile(String filename) throws IOException {
        FileIO.saveToFile(filename, dvds);
    }

}
