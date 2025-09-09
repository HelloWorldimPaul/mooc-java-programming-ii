package hurraa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
//import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

import java.io.File;

public class HurraaSovellus extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();

        Button nappi = new Button("Hurraa!");
        pane.setCenter(nappi);

        //AudioClip sound = new AudioClip(new File("PSYGANGNAM_STYLE.mp3").toURI().toString());


        nappi.setOnAction(e -> {

            //sound.play();

        });


        //System.out.println(new File("Applause-Yannick_Lemieux.wav").getAbsolutePath());
        //System.out.println(new File("Applause-Yannick_Lemieux.wav").exists());


        //System.out.println(sound.getSource());


        Scene scene = new Scene(pane, 600, 400);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch(HurraaSovellus.class);
    }

}
