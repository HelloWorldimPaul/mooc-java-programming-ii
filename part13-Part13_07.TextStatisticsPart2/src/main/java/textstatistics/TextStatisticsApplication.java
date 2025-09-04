package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Arrays;


public class TextStatisticsApplication extends Application {


    @Override
    public void start(Stage window) {
        Label lettersCount = new Label("Letters: 0");
        Label wordsCount = new Label("Words: 0");
        Label longestWord = new Label("The longest word is: ");

        TextArea textArea = new TextArea();

        textArea.textProperty().addListener((change, oldValue, newValue) -> {

            int letters = newValue.length();

            String[] parts = newValue.trim().split("\\s+");
            int words = parts.length;

            if (newValue.trim().isEmpty()) {
                words = 0;
            }

            String longest = "";
            if (words > 0) {
                longest = Arrays.stream(parts).filter(word -> !word.trim().isEmpty())  // Remove empty strings
                        .sorted((s1, s2) -> s2.length() - s1.length())  // Sort by length (descending)
                        .findFirst()  // Get the first (longest) word
                        .orElse("");  // Default to empty string if no words found
            }
            lettersCount.setText("Letters: " + letters);
            wordsCount.setText("Words: " + words);
            longestWord.setText("The longest word is: " + longest);
        });


        HBox layout2 = new HBox();
        layout2.setSpacing(10);
        layout2.getChildren().addAll(lettersCount, wordsCount, longestWord);

        BorderPane overAllLayout = new BorderPane();
        overAllLayout.setCenter(textArea);
        overAllLayout.setBottom(layout2);

        Scene view = new Scene(overAllLayout, 600, 400);
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {

        launch(TextStatisticsApplication.class);

        System.out.println("Hello world!");
    }

}

