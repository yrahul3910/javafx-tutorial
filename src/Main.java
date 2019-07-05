import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Title");

        HBox topMenu = new HBox();
        Button buttonA = new Button("File");
        Button buttonB = new Button("Edit");
        Button buttonC = new Button("View");
        topMenu.getChildren().addAll(buttonA, buttonB, buttonC);

        VBox leftMenu = new VBox();
        Button buttonD = new Button("File");
        Button buttonE = new Button("Edit");
        Button buttonF = new Button("View");
        leftMenu.getChildren().addAll(buttonD, buttonE, buttonF);

        BorderPane layout = new BorderPane();
        layout.setTop(topMenu);
        layout.setLeft(leftMenu);

        Scene scene = new Scene(layout, 300, 250);

        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
