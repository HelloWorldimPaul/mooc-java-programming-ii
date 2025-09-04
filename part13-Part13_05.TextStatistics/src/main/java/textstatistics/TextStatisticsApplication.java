package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;


public class TextStatisticsApplication extends Application {


    @Override
    public void start(Stage window){
        BorderPane layout = new BorderPane();

        TextArea textField = new TextArea("text");

        HBox textComponent = new HBox();

        textComponent.setSpacing(10);

        textComponent.getChildren().add(new Label("Letters: 0"));
        textComponent.getChildren().add(new Label("Words: 0"));
        textComponent.getChildren().add(new Label("The longest word is:"));

        layout.setCenter(textField);
        layout.setBottom(textComponent);

        Scene view = new Scene(layout);

        window.setScene(view);
        window.show();







    }


    public static void main(String[] args) {

        launch(TextStatisticsApplication.class);
        System.out.println("Hello world!");



    }

}
