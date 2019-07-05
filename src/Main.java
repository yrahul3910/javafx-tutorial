import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    ComboBox<String> comboBox;

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Title");

        comboBox = new ComboBox<>();
        comboBox.getItems().addAll("RED", "1989", "reputation", "Speak Now", "Lover", "Taylor Swift", "Fearless");
        comboBox.setPromptText("Favorite Taylor Swift album");
        comboBox.setOnAction(e -> printAlbum());
        comboBox.setEditable(true);  // overwrites prompt text

        Button button = new Button("Useless button");
        button.setOnAction(e -> printAlbum());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(comboBox, button);

        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void printAlbum() {
        System.out.println(comboBox.getValue());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
