import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Title");

        Button button = new Button("OK");

        Person bucky = new Person();
        bucky.firstNameProperty().addListener(
                (v, oldValue, newValue) -> {
                    System.out.println(newValue);
                }
        );

        button.setOnAction(e -> bucky.setFirstName("Porky"));

        StackPane layout = new StackPane();
        layout.getChildren().addAll(button);

        Scene scene = new Scene(layout, 300, 250);

        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
