package myFirstApplication;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MyFirstApplication extends Application {

    @Override
    public void start(Stage window) {
        window.setTitle("My first application");

        Label label = new Label("Hello world!");

        // Create a scene containing the label, with width 300 and height 200
        Scene scene = new Scene(label, 1000, 1000);

        // Set the window title
        window.setTitle("My first application");

        // Add the scene to the window
        window.setScene(scene);

        // Show the window
        window.show();

        window.show();


    }

    public static void main(String[] args) {
        launch(args);
        System.out.println("Hello world!");
    }
}

/*
package myFirstApplication;
import javafx.application.Application;
import javafx.stage.Stage;


public class MyFirstApplication extends Application{

    @Override
    public void start(Stage window) {
        window.setTitle("My first application");
        window.show();
    }



    public static void main(String[] args) {
        System.out.println("Hello world!");

    }

}


 */