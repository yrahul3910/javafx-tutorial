import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    BorderPane layout;

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Title");

        // File menu
        Menu fileMenu = new Menu("File");

        MenuItem newFile = new MenuItem("New...");
        newFile.setOnAction(e -> System.out.println("Create a new file"));
        fileMenu.getItems().add(newFile);

        // Or a bunch of them...
        fileMenu.getItems().addAll(
                new MenuItem("Open..."),
                new MenuItem("Save..."),
                new SeparatorMenuItem(),
                new MenuItem("Settings..."),
                new SeparatorMenuItem(),
                new MenuItem("Exit")
        );

        // Edit menu
        Menu editMenu = new Menu("_Edit"); // _ adds a shortcut

        MenuItem pasteItem = new MenuItem("Paste");
        pasteItem.setOnAction(e -> System.out.println("Pasting"));
        pasteItem.setDisable(true); // disable the item

        // sub-menu
        Menu findMenu = new Menu("Find");
        MenuItem findMenuItem = new MenuItem("Find...");
        findMenuItem.setAccelerator(KeyCombination.valueOf("Ctrl+F"));  // adding shortcuts
        findMenuItem.setOnAction(e -> System.out.println("Finding..."));

        findMenu.getItems().addAll(
                findMenuItem,
                new MenuItem("Replace...")
        );

        editMenu.getItems().addAll(
                new MenuItem("Cut"),
                new MenuItem("Copy"),
                pasteItem,
                new SeparatorMenuItem(),
                findMenu
        );

        // Help menu
        Menu helpMenu = new Menu("_Help");
        CheckMenuItem showLines = new CheckMenuItem("Show Line Numbers");
        showLines.setOnAction(e -> {
            if (showLines.isSelected())
                System.out.println("Showing line numbers...");
            else
                System.out.println("Not showing line numbers...");
        });
        helpMenu.getItems().addAll(showLines);

        // Difficulty menu
        Menu difficultyMenu = new Menu("Difficulty");
        ToggleGroup difficultyToggle = new ToggleGroup();
        RadioMenuItem easy = new RadioMenuItem("Easy");
        RadioMenuItem medium = new RadioMenuItem("Medium");
        RadioMenuItem hard = new RadioMenuItem("Hard");
        difficultyToggle.getToggles().addAll(easy, medium, hard);
        difficultyMenu.getItems().addAll(easy, medium, hard);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu, difficultyMenu, helpMenu);

        layout = new BorderPane();
        layout.setTop(menuBar);

        Scene scene = new Scene(layout, 400, 300);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
