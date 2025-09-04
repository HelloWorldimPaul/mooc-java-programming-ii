package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PracticeView {

    private Dictionary dictionary;
    private String word;

    public PracticeView(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.word = dictionary.getRandom();
    }

    public Parent getView() {
        GridPane practiceView = new GridPane();

        Label practiceLabel = new Label("Translate the word '" + this.word + "'");
        TextField answerField = new TextField();
        Button checkButton = new Button("Check");
        Label remarksLabel = new Label();

        practiceView.setAlignment(Pos.CENTER);
        practiceView.setVgap(10);
        practiceView.setHgap(10);
        practiceView.setPadding(new Insets(10, 10, 10, 10));

        practiceView.add(practiceLabel, 0,0);
        practiceView.add(answerField,0,2);
        practiceView.add(checkButton,0,3);
        practiceView.add(remarksLabel,0,4);

        checkButton.setOnMouseClicked(e -> {
            String translation = answerField.getText();


            if (this.dictionary.getTranslation(word).equals(translation)) {

                remarksLabel.setText("Correct");

            } else {

                remarksLabel.setText("Incorrect! The translation of the word '" +
                        word + "' is '" + dictionary.getTranslation(word) + "'.");

            }
            this.word = this.dictionary.getRandom();
            practiceLabel.setText("Translate the word '" + this.word + "'");
            answerField.clear();

        });

        return practiceView;
    }

}
