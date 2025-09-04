package notifier;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.w3c.dom.Text;

public class NotifierApplication extends Application {

    @Override
    public void start(Stage window) {
        Button button = new Button("Button");
        TextField textField = new TextField();
        Label label = new Label("");

        VBox layout = new VBox();



        layout.getChildren().add(textField);
        layout.getChildren().add(button);
        layout.getChildren().add(label);

        button.setOnAction(e -> label.setText(textField.getText()) );

        Scene view = new Scene(layout);

        window.setScene(view);
        window.show();

    }


    public static void main(String[] args) {
        launch(NotifierApplication.class);

    }

}
