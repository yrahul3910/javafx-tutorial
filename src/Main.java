import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    Scene scene1, scene2;

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Title");

        window.setOnCloseRequest(e -> closeProgram());

        Label label1 = new Label("Welcome to scene 1!");
        Button button1 = new Button("Go to scene 2");
        button1.setOnAction(e -> window.setScene(scene2));

        Button closeButton = new Button("Close program");
        closeButton.setOnAction(e -> {
            e.consume(); // We'll consume the event, so we're going to handle the close event
            closeProgram();
        });

        // Layout 1
        VBox layout1 = new VBox(20); // 20 is the space between elements
        layout1.getChildren().addAll(label1, button1, closeButton);
        scene1 = new Scene(layout1, 200, 200);

        Button button2 = new Button("Go to scene 1");
        Button button3 = new Button("Show alert box");
        button2.setOnAction(e -> window.setScene(scene1));
        button3.setOnAction(e -> {
            boolean result = ConfirmBox.display("Modal title", "Are you sure?");
            System.out.println(result);
        });

        // Layout 2
        VBox layout2 = new VBox(20);
        layout2.getChildren().addAll(button2, button3);
        scene2 = new Scene(layout2, 600, 300);

        window.setScene(scene1);
        window.setTitle("Title");
        window.show();
    }

    private void closeProgram() {
        boolean close = ConfirmBox.display("Confirm exit", "Are you sure you want to exit?");
        if (close)
            window.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
