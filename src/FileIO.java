import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class FileIO {

    private FileIO() {
    }

    private static final String COMMA_DELIMITER = ",";

    public static List<DVD> loadFromFile(String filename) throws IOException {
        List<DVD> dvds = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                Date currentDate = new SimpleDateFormat("dd/MM/yyyy").parse(values[1]);
                DVD newDVD = new DVD(values[0], currentDate, values[2], values[3], values[4], values[5]);
                dvds.add(newDVD);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dvds;
    }

    //export all dvds to a file
    public static void saveToFile(String filename, List<DVD> dvds) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (DVD dvd : dvds) {
                writer.write(dvd.toCsv());
            }
        }

    }
}
