import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Title");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel, 0, 0);

        TextField nameInput = new TextField();
        nameInput.setPromptText("Enter your username");
        GridPane.setConstraints(nameInput, 1, 0);

        Label pwdLabel = new Label("Password:");
        GridPane.setConstraints(pwdLabel, 0, 1);

        PasswordField pwdInput = new PasswordField();
        pwdInput.setPromptText("Enter your password");
        GridPane.setConstraints(pwdInput, 1, 1);

        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> isInt(nameInput));
        GridPane.setConstraints(loginButton, 1, 2);

        grid.getChildren().addAll(nameLabel, nameInput, pwdLabel, pwdInput, loginButton);

        Scene scene = new Scene(grid, 300, 250);
        window.setScene(scene);

        window.show();
    }

    private void isInt(TextField input) {
        try {
            int user = Integer.parseInt(input.getText());
            System.out.println("User is: " + user);
        } catch (NumberFormatException e) {
            System.out.println("Error.");
            input.setStyle("-fx-border-color: red;");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
