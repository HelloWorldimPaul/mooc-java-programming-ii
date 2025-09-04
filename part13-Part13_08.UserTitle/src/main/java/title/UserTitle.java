package title;

import javafx.application.Application;
import javafx.application.Application.Parameters;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Map;


public class UserTitle extends Application {


    @Override
    public void start(Stage window) {

        Parameters params = getParameters();
        Map<String, String> namedParams = params.getNamed();

        Label title = new Label(namedParams.get("title"));

        BorderPane layout = new BorderPane();

        layout.setCenter(title);

        Scene scene = new Scene(layout, 400, 300);

        window.setScene(scene);
        window.show();

    }

}
