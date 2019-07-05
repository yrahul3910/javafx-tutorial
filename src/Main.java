import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    ListView<String> listView;

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Title");

        listView = new ListView<>();
        listView.getItems().addAll("RED", "1989", "reputation", "Lover", "Fearless", "Speak Now", "Taylor Swift");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        Button button = new Button("Submit");
        button.setOnAction(e -> printItems());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(listView, button);

        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void printItems() {
        ObservableList<String> selected = listView.getSelectionModel().getSelectedItems();

        for (String s : selected)
            System.out.println(s);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
