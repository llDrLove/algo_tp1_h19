import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.io.PrintWriter;
import java.util.stream.Stream;
import java.util.ArrayList;

public class calcMax {
    public static void main(String args[]) {

        File folder = new File("exemplaires");
        try {
            PrintWriter writer = new PrintWriter("maxValues.txt", "UTF-8");
            listAllFiles(folder, writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void listAllFiles(File folder, PrintWriter writer) {
        File[] fileNames = folder.listFiles();
        for (File file : fileNames) {
            try {
                readContent(file, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void readContent(File file, PrintWriter writer) throws IOException {
        long max = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String strLine;
            // Read lines from the file, returns null when end of stream
            // is reached
            while ((strLine = br.readLine()) != null) {
                if (Long.parseLong(strLine) > max) {
                    max = Long.parseLong(strLine);
                }
            }
            writer.print(file + ", ");
            writer.println(max);
        }
    }
}
