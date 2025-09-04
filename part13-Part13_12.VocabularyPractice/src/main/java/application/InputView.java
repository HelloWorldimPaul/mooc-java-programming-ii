package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class InputView {

    private Dictionary dictionary;

    public InputView(Dictionary dictionary) {

        this.dictionary = dictionary;
    }

    public Parent getView() {
        GridPane inputView = new GridPane();

        inputView.setAlignment(Pos.CENTER);
        inputView.setVgap(10);
        inputView.setHgap(10);
        inputView.setPadding(new Insets(10, 10, 10, 10));

        Label wordLabel = new Label("Word");
        TextField wordField = new TextField();
        Label translationLabel = new Label("Translation");
        TextField translationField = new TextField();
        Button addButton = new Button("Add the word pair");

        inputView.add(wordLabel, 0, 0);
        inputView.add(wordField, 0, 1);
        inputView.add(translationLabel, 0, 3);
        inputView.add(translationField, 0, 4);
        inputView.add(addButton, 0, 5);

        addButton.setOnMouseClicked(e -> {

            String word = wordField.getText();
            String translation = translationField.getText();

            this.dictionary.addWord(word, translation);
            wordField.clear();
            translationField.clear();
        });

        return inputView;
    }

}
