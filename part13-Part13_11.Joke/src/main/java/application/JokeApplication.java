package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JokeApplication extends Application {

    @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();
        HBox menu = new HBox();

        layout.setPrefSize(300, 200);
        layout.setPadding(new Insets(20, 20, 20, 20));

        menu.setSpacing(20);
        menu.setAlignment(Pos.CENTER);



        Button button1 = new Button("Joke");
        Button button2 = new Button("Answer");
        Button button3 = new Button("Explanation");

        layout.setTop(menu);

        //Label label = new Label("What do you call a bear with no teeth?");

        StackPane joke = createView("What do you call a bear with no teeth?");
        StackPane answer  = createView("A gummy bear.");
        StackPane explanation = createView("gummy bears don't have teeth right? heheheheheh");

        menu.getChildren().addAll(button1, button2, button3);

        layout.setCenter(joke);

        button1.setOnAction(e -> { layout.setCenter(joke);});
        button2.setOnAction(e -> { layout.setCenter(answer);});
        button3.setOnAction(e -> { layout.setCenter(explanation);});

        /*
        button1.setOnAction(e -> {
            label.setText("What do you call a bear with no teeth?");
        });
        button2.setOnAction(e -> {
            label.setText("A gummy bear.");
        });
        button3.setOnAction(e -> {
            label.setText(");
        });

         */

        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.show();

    }

    private StackPane createView(String text) {

        StackPane layout = new StackPane();

        layout.setPrefSize(300, 180);

        layout.getChildren().add(new Label(text));

        layout.setAlignment(Pos.CENTER);

        return layout;

    }


    public static void main(String[] args) {

        System.out.println("Hello world!");

        launch(JokeApplication.class);
    }
}
