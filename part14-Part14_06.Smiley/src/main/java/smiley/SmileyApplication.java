package smiley;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class SmileyApplication extends Application {

    @Override
    public void start(Stage window){

        Canvas paintingCanvas = new Canvas(300, 300);
        GraphicsContext painter = paintingCanvas.getGraphicsContext2D();

        ColorPicker colorPalette = new ColorPicker(Color.BLACK);

        BorderPane paintingLayout = new BorderPane();
        paintingLayout.setCenter(paintingCanvas);
        paintingLayout.setRight(colorPalette);


        painter.fillRect(110, 100, 20,20);
        painter.fillRect(170, 100, 20,20);

        painter.fillRect(120, 180, 20,20);
        painter.fillRect(140, 180, 20,20);
        painter.fillRect(160, 180, 20,20);

        painter.fillRect(100, 160, 20,20);
        painter.fillRect(180, 160, 20,20);

        /*
        paintingCanvas.setOnMouseDragged(e -> {

            double xLocation = e.getX();
            double yLocation = e.getY();

            painter.setFill(colorPalette.getValue());
            painter.fillOval(xLocation, yLocation, 60, 60);


        });

         */

        Scene view = new Scene(paintingLayout);

        window.setScene(view);
        window.show();

    }



    public static void main(String[] args) {
        System.out.println("Hello world!");

        launch(SmileyApplication.class);

    }

}
