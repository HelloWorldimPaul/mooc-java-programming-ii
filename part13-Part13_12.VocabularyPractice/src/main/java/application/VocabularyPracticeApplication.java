package application;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

// END SOLUTION
public class VocabularyPracticeApplication extends Application {

    private Dictionary dictionary;

    @Override
    public void init() throws Exception {

        this.dictionary = new Dictionary();

    }

    @Override
    public void start(Stage window) {

        InputView inputView = new InputView(dictionary);
        PracticeView practiceView = new PracticeView(dictionary);

        BorderPane layout = new BorderPane();

        Button inputViewButton = new Button("Enter new Words");
        Button practiceButton = new Button("Practice");

        HBox menu = new HBox();
        menu.setSpacing(20);
        menu.getChildren().addAll(inputViewButton, practiceButton);

        layout.setTop(menu);
        layout.setPrefSize(300, 300);
        layout.setPadding(new Insets(20, 20, 20, 20));

        layout.setCenter(inputView.getView());

        inputViewButton.setOnAction(e -> {
            layout.setCenter(inputView.getView());
        });
        practiceButton.setOnAction(e -> {
            layout.setCenter(practiceView.getView());
        });

        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.show();

    }


    public static void main(String[] args) {

        launch(VocabularyPracticeApplication.class);


    }
}
