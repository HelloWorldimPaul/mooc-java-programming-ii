
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LiteracyComparison {

    public static void main(String[] args) {


        String fileName = "literacy.csv";
        sortByLiteracy(fileName);

    }

    public static void sortByLiteracy(String fileName){


        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {

            lines.map(row -> row.split(","))
                    .filter(parts -> parts.length == 6)

                    .map(parts -> new LiteracyRate(parts[0], parts[1], parts[2] = parts[2].replaceAll("[^a-zA-Z\\s]", "").trim() , parts[3], Integer.parseInt(parts[4]), Double.parseDouble(parts[5])))
                    .sorted((p1, p2) -> Double.compare(p1.getLiteracyPercent(), p2.getLiteracyPercent()))
                    .forEach(rate -> System.out.println(rate) );


        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }

    }
}
