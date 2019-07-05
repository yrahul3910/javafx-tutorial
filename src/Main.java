import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Title");

        CheckBox box1 = new CheckBox("Turkey");
        CheckBox box2 = new CheckBox("Ham");
        box2.setSelected(true);

        Button button = new Button("Order now!");
        button.setOnAction(e -> handleOptions(box1, box2));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(box1, box2, button);

        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void handleOptions(CheckBox... boxes) {
        for (CheckBox box : boxes) {
            if (box.isSelected())
                System.out.println(box.getText());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
