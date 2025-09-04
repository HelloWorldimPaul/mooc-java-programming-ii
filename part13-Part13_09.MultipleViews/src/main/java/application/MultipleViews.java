package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {


    @Override
    public void start(Stage window) {

        Label label = new Label("First view");
        Label label2 = new Label("Second view!");
        Label label3 = new Label("Third view");

        Button buttonFirst = new Button("To the second view");
        Button buttonSecond = new Button("To the third view!");
        Button buttonThird = new Button("To the first view!");


        BorderPane layout1 = new BorderPane();
        VBox layout2 = new VBox();
        GridPane layout3 = new GridPane();

        layout1.setTop(label);
        layout1.setCenter(buttonFirst);

        layout2.setSpacing(20);
        layout2.getChildren().addAll(buttonSecond, label2);

        layout3.add(label3, 0, 0);
        layout3.add(buttonThird, 1, 1);

        Scene first = new Scene(layout1, 400, 400);
        Scene second = new Scene(layout2, 400, 400);
        Scene third = new Scene(layout3, 400, 400);

        buttonFirst.setOnAction(e ->{window.setScene(second);});

        buttonSecond.setOnAction(e ->{window.setScene(third);});

        buttonThird.setOnAction(e ->{window.setScene(first);});

        window.setScene(first);
        window.show();



    }


    public static void main(String[] args) {
        System.out.println("Hello world!");

        launch(MultipleViews.class);

    }

}
