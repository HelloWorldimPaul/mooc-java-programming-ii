package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PartiesApplication extends Application {

    @Override
    public void start(Stage window) {

        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support of parties");

        /*
        XYChart.Series<Number, Number> supportData = new XYChart.Series<>();
        supportData.setName("Support Data");

         */

        Path path = Paths.get("partiesdata.tsv");

        try {

            Map<String, Map<Integer, Double>> data = hashMap(path);

            for (String key : data.keySet()) {

                XYChart.Series<Number, Number> supportData = new XYChart.Series<>();
                supportData.setName(key);

                for (Integer year : data.get(key).keySet()) {

                    supportData.getData().add(new XYChart.Data<Number, Number>(year, data.get(key).get(year)));

                }

                lineChart.getData().add(supportData);

            }

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }

        //lineChart.getData().add(supportData);

        Scene view = new Scene(lineChart, 640, 480);
        window.setScene(view);
        window.show();

    }

    private static Map<String, Map<Integer, Double>> hashMap(Path path) throws IOException {
        Map<String, Map<Integer, Double>> data = new HashMap<>();

        List<String> lines = Files.readAllLines(path);

        String[] header = lines.get(0).split("\t");
        Integer[] years = new Integer[header.length - 1];

        for (int i = 1; i < header.length; i++) {

            years[i - 1] = Integer.valueOf(header[i]);
        }

        for (int i = 1; i < lines.size(); i++) {

            String[] parts = lines.get(i).split("\\s");

            String name = parts[0];

            Map<Integer, Double> yearSupportData = new HashMap<>();

            for (int j = 1; j < parts.length; j++) {

                if (!parts[j].equals("-")) {
                    yearSupportData.put(years[j - 1], Double.parseDouble(parts[j]));
                }

            }
            data.put(name, yearSupportData);
        }

        return data;

    }

    public static void main(String[] args) {

        System.out.println("Hello world!");

        launch(PartiesApplication.class);

        /*
        try {

            for (String key : hashMap().keySet()) {

                System.out.println(key);
                for (Integer year : hashMap().get(key).keySet()) {

                    System.out.println("Year: " + year + "\nSupport: " + hashMap().get(key).get(year));

                }

            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

         */

    }

}
