package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application {


    @Override
    public void start(Stage window) {

        GridPane layout1 = new GridPane();
        BorderPane layout2 = new BorderPane();

        Label label1 = new Label("Enter your name and start.");
        TextField textField1 = new TextField();
        Button button = new Button("Start");

        Label greetingsView = new Label();

        layout1.add(label1, 0, 0);
        layout1.add(textField1, 0, 1);
        layout1.add(button, 0, 2);

        layout2.setCenter(greetingsView);

        layout1.setPrefSize(300, 180);
        layout2.setPrefSize(300, 180);
        layout1.setAlignment(Pos.CENTER);
        layout1.setVgap(10);
        layout1.setHgap(10);
        layout1.setPadding(new Insets(20, 20, 20, 20));

        Scene view1 = new Scene(layout1);
        Scene view2 = new Scene(layout2);

        button.setOnAction(e -> {

            greetingsView.setText("Welcome " + textField1.getText() + "!");
            window.setScene(view2);
        });

        window.setScene(view1);
        window.show();

    }


    public static void main(String[] args) {

        System.out.println("Hellow world! :3");
        launch(GreeterApplication.class);

    }
}
