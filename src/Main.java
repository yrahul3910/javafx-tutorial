import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    TreeView<String> treeView;

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Title");

        TreeItem<String> root, left, right;
        root = new TreeItem<>();
        root.setExpanded(true);

        left = makeBranch("Left", root);
        makeBranch("leaf 1", left);
        makeBranch("leaf 2", left);

        right = makeBranch("Right", root);
        makeBranch("leaf 3", right);

        treeView = new TreeView<>(root);
        treeView.setShowRoot(false);  // don't show root explicitly
        treeView.getSelectionModel().selectedItemProperty().addListener(
                (v, oldValue, newValue) -> {
                    if (newValue != null)
                        System.out.println(newValue.getValue());
                }
        );

        Button button = new Button("Dummy");

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(treeView, button);

        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private TreeItem<String> makeBranch(String s, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(s);
        item.setExpanded(true);
        parent.getChildren().add(item);

        return item;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
