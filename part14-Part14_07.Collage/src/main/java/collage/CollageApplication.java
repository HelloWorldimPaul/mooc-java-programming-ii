package collage;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CollageApplication extends Application {

    @Override
    public void start(Stage stage) {

        // the example opens the image, creates a new image, and copies the opened image
        // into the new one, pixel by pixel
        Image sourceImage = new Image("file:monalisa.png");

        PixelReader imageReader = sourceImage.getPixelReader();

        int width = (int) sourceImage.getWidth();
        int height = (int) sourceImage.getHeight();

        int smallWidth = width / 2;
        int smallHeight = height / 2;

        WritableImage targetImage = new WritableImage(width, height);
        PixelWriter imageWriter = targetImage.getPixelWriter();

        WritableImage smallImage = new WritableImage(smallWidth, smallHeight);
        PixelWriter smallWriter = smallImage.getPixelWriter();

        int yCoordinate = 0;
        while (yCoordinate < height) {
            int xCoordinate = 0;
            while (xCoordinate < width) {

                Color color = imageReader.getColor(xCoordinate, yCoordinate);
                double red = color.getRed();
                double green = color.getGreen();
                double blue = color.getBlue();
                double opacity = color.getOpacity();

                Color newColor = new Color(red, green, blue, opacity);

                imageWriter.setColor(xCoordinate, yCoordinate, newColor);

                xCoordinate++;
            }

            yCoordinate++;
        }

        for (int y = 0; y < smallHeight; y++) {
            for (int x = 0; x < smallWidth; x++) {
                int srcX = x * 2;
                int srcY = y * 2;
                Color color = imageReader.getColor(srcX, srcY);

                Color negativeColor = new Color(1 - color.getRed(), 1 - color.getGreen(), 1 - color.getBlue(), color.getOpacity());
                smallWriter.setColor(x, y, negativeColor);
            }
        }

        PixelReader smallReader = smallImage.getPixelReader();

        for (int tileY = 0; tileY < 2; tileY++) {  // two rows of tiles
            for (int tileX = 0; tileX < 2; tileX++) {  // two columns of tiles
                for (int y = 0; y < smallHeight; y++) {
                    for (int x = 0; x < smallWidth; x++) {
                        Color color = smallReader.getColor(x, y);
                        imageWriter.setColor(tileX * smallWidth + x, tileY * smallHeight + y, color);
                    }
                }
            }
        }

        ImageView image = new ImageView(targetImage);

        Pane pane = new Pane();
        pane.getChildren().add(image);

        stage.setScene(new Scene(pane));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
