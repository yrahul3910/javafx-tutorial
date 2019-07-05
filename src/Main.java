import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    TableView<Product> tableView;
    TextField nameInput, priceInput, qtyInput;

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Title");

        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Product, Integer> qtyColumn = new TableColumn<>("Quantity");
        qtyColumn.setMinWidth(100);
        qtyColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        tableView = new TableView<>();
        tableView.setItems(getProduct());
        tableView.getColumns().addAll(nameColumn, priceColumn, qtyColumn);

        nameInput = new TextField();
        nameInput.setPromptText("Product name");
        nameInput.setMinWidth(100);

        priceInput = new TextField();
        priceInput.setPromptText("Unit price");

        qtyInput = new TextField();
        qtyInput.setPromptText("Quantity");

        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());

        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput, priceInput, qtyInput, addButton, deleteButton);

        VBox layout = new VBox();
        //layout.setPadding(new Insets(20));
        layout.getChildren().addAll(tableView, hBox);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

    private void deleteButtonClicked() {
        ObservableList<Product> productSelected, products;
        products = tableView.getItems();
        productSelected = tableView.getSelectionModel().getSelectedItems();

        productSelected.forEach(products::remove);
    }

    private void addButtonClicked() {
        Product product = new Product();
        product.setName(nameInput.getText());

        try {
            product.setPrice(Double.parseDouble(priceInput.getText()));
            product.setQuantity(Integer.parseInt(qtyInput.getText()));
        } catch (NumberFormatException e) {
            // Handle this
        }

        tableView.getItems().add(product);

        nameInput.clear();
        priceInput.clear();
        qtyInput.clear();
    }

    private ObservableList<Product> getProduct() {
        // Typically, it would connect to a DB or something
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Laptop", 859.00, 20));
        products.add(new Product("Ball", 2.49, 198));
        products.add(new Product("Toilet", 99.00, 74));
        products.add(new Product("Lover CD", 16.99, 846));
        products.add(new Product("Corn", 1.49, 12));

        return products;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
