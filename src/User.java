import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class User {

    private static final String ADD = "add";
    private static final String REMOVE = "remove";
    private static final String EDIT = "edit";
    private static final String PRINT_ALL = "print all";
    private static final String PRINT_ONE = "print one";
    private static final String SEARCH = "search";
    private static final String QUIT = "quit";
    private static final String DVD_LIBRARY_FILENAME = "dvdlibrary.txt";
    private static DVDLibrary dvdLibrary = new DVDLibrary();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean active = true;
        System.out.println("Hello there, welcome to the DVD library.");
        importFunction();
        while (active) {
            System.out.println("\nWhat would you like to do? (Add, Remove, Edit, Print all, Print one, Search, Quit)");
            String command = scanner.nextLine();
            switch (command.toLowerCase()) {
                case ADD:
                    addFunction();
                    break;
                case REMOVE:
                    removeFunction();
                    break;
                case EDIT:
                    editFunction();
                    break;
                case PRINT_ALL:
                    dvdLibrary.printList();
                    break;
                case PRINT_ONE:
                    printOneFunction();
                    break;
                case SEARCH:
                    searchFunction();
                    break;
                case QUIT:
                    System.out.println("See you next time!");
                    exportFunction();
                    active = false;
                    break;
                default:
                    break;
            }
        }
    }

    public static void addFunction() {
        System.out.println("You want to add a dvd. We just need a few details.");
        System.out.println("What is the Title of the dvd?");
        String titleToBeAdded = scanner.nextLine();
        if(!dvdLibrary.existsByTitle(titleToBeAdded)) {
            System.out.println("Who is the Director of the film?");
            String directorNameToBeAdded = scanner.nextLine();
            System.out.println("What is the release date of the dvd?");
            String releaseDateToBeAdded = scanner.nextLine();
            try {
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(releaseDateToBeAdded);
                DVD dvdToBeAdded = new DVD(titleToBeAdded, date, directorNameToBeAdded);
                dvdLibrary.addDvd(dvdToBeAdded);
                System.out.println("Thank you, the dvd has been added. You can add additional information using the edit function.");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("This dvd already exists.");
        }
    }

    public static void removeFunction() {
        System.out.println("You want to remove a dvd.");
        System.out.println("What is the Title of the dvd?");
        String titleToBeRemoved = scanner.nextLine();
        if(dvdLibrary.existsByTitle(titleToBeRemoved)) {
            DVD dvdToBeRemoved = dvdLibrary.getByTitle(titleToBeRemoved);
            dvdLibrary.removeDvd(dvdToBeRemoved);
            System.out.println("The dvd has been removed");
        }
        else{
            System.out.println("This dvd does not exist.");
        }
    }

    public static void importFunction() {
        try {
            dvdLibrary.loadFromFile(DVD_LIBRARY_FILENAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void exportFunction() {
        try {
            dvdLibrary.saveToFile(DVD_LIBRARY_FILENAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void editFunction() {
        System.out.println("You want to edit a dvds information.");
        System.out.println("What is the title of the dvd you would like to edit?");
        String titleToBeEdited = scanner.nextLine();
        DVD toBeEdited = dvdLibrary.getByTitle(titleToBeEdited);
        System.out.println("What information would you like to edit? (Title, Release Date, MPAA Rating, Director, Studio, User note)");
        String informationToBeEdited = scanner.nextLine();
        switch (informationToBeEdited) {
            case "title":
                System.out.println("Please enter the title edit that you would like to make.");
                String titleEdit = scanner.nextLine();
                dvdLibrary.editTitle(toBeEdited, titleEdit);
                break;
            case "release date":
                System.out.println("Please enter the release date edit that you would like to make.");
                String releaseDateEdit = scanner.nextLine();
                try {
                    Date date = new SimpleDateFormat("dd/MM/yyyy").parse(releaseDateEdit);
                    dvdLibrary.editReleaseDate(toBeEdited, date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "mpaa rating":
                System.out.println("Please enter the mpaa rating edit that you would like to make.");
                String mpaaRatingEdit = scanner.nextLine();
                dvdLibrary.editMpaaRating(toBeEdited, mpaaRatingEdit);
                break;
            case "director":
                System.out.println("Please enter the director edit that you would like to make.");
                String directorEdit = scanner.nextLine();
                dvdLibrary.editDirectorName(toBeEdited, directorEdit);
                break;
            case "studio":
                System.out.println("Please enter the studio edit that you would like to make.");
                String studioEdit = scanner.nextLine();
                dvdLibrary.editStudio(toBeEdited, studioEdit);
                break;
            case "user note":
                System.out.println("Please enter the user note edit that you would like to make.");
                String userNoteEdit = scanner.nextLine();
                dvdLibrary.editUserNote(toBeEdited, userNoteEdit);
                break;
            default:
                break;
        }
    }

    public static void printOneFunction() {
        System.out.println("You want to print the information of one dvd.");
        System.out.println("What is the title of the dvd?");
        String titleToBePrinted = scanner.nextLine();
        if (dvdLibrary.existsByTitle(titleToBePrinted)) {
            DVD dvdToBePrinted = dvdLibrary.getByTitle(titleToBePrinted);
            dvdLibrary.printDvd(dvdToBePrinted);
        }
        else{
            System.out.println("That dvd does not exist.");
        }

    }

    public static void searchFunction() {
        System.out.println("Please enter the title of the film you're searching for.");
        String searchTitle = scanner.nextLine();
        if (dvdLibrary.existsByTitle(searchTitle)) {
            System.out.println("It looks like we have that DVD");
        } else {
            System.out.println("We do not have that DVD");
        }
    }
}
