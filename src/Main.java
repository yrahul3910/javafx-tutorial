import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
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

        IntegerProperty x = new SimpleIntegerProperty(3);
        IntegerProperty y = new SimpleIntegerProperty();  // has null

        y.bind(x.multiply(10));  // y is bound to 10 * x whenever x is changed

        System.out.println("x = " + x.get() + ", y = " + y.get());

        x.set(9);
        System.out.println("x = " + x.get() + ", y = " + y.get());

        x.set(5);
        System.out.println("x = " + x.get() + ", y = " + y.get());

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
