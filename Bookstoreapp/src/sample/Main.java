package sample;

import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import sample.DAO.DAOImpl;
import sample.model.Product;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Main extends Application implements Initializable
{
    private static Stage stage;
    @FXML
    private TableView<Product> tableView;
    @FXML
    private TableColumn<Product, Number> idCol;
    @FXML
    private TableColumn<Product, String> nameCol;
    @FXML
    private TableColumn<Product, Number> priceCol;
    @FXML
    private TableColumn<Product, Boolean> electronicalCol;
    @FXML
    private TableColumn<Product, String> publisherCol;
    @FXML
    private TableColumn<Product, String> imageCol;
    @FXML
    private TableColumn<Product,Void>actionColumn;

    public static Object editable;

    @Override
    public void start(Stage primaryStage) throws IOException{
        Main.stage = primaryStage;
        Main.loadFXML("sample.fxml");
        stage.show();
    }

    public static FXMLLoader loadFXML(String fxml){

        FXMLLoader loader = new FXMLLoader(Main.class.getResource(fxml));
        Scene scene = null;
        try {
            Parent root = loader.load();
            scene = new Scene(root);
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setScene(scene);
        return loader;
    }

    public static FXMLLoader loadFXML(String fxml,Object object)
    {
        editable = object;
        FXMLLoader loader = new FXMLLoader(Main.class.getResource(fxml));
        Scene scene = null;
        try {
            Parent root = loader.load();
            scene = new Scene(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);

        return loader;
    }


    public static void main(String[] args) {
        launch();
    }

    public void onMenuTermek(ActionEvent actionEvent) {
        Main.loadFXML("sample.fxml");
    }

    public void onMenuUser(ActionEvent actionEvent) {
        Main.loadFXML("user.fxml");
    }

    public void onMenuFilm(ActionEvent actionEvent) {
        Main.loadFXML("film.fxml");
    }

    public void onMenuKeszlet(ActionEvent actionEvent) {
        Main.loadFXML("onstock.fxml");
    }

    public void onMenuKonyv(ActionEvent actionEvent)
    {
        Main.loadFXML("book.fxml");
    }

    public void onMenuMegrendel(ActionEvent actionEvent) {
        Main.loadFXML("order.fxml");
    }

    public void onMenuMufaj(ActionEvent actionEvent) {
        Main.loadFXML("genres.fxml");
    }

    public void onMenuMufaja(ActionEvent actionEvent) {
        Main.loadFXML("product_genre.fxml");
    }

    public void onMenuSzerzo(ActionEvent actionEvent)
    {
        Main.loadFXML("author.fxml");
    }

    public void onMenuSzerzoje(ActionEvent actionEvent) {
        Main.loadFXML("product_author.fxml");
    }

    public void onMenuZene(ActionEvent actionEvent)
    {
        Main.loadFXML("music.fxml");
    }

    public void onMenuStore(ActionEvent actionEvent) {
        Main.loadFXML("store.fxml");
    }



    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        refreshTable();
        idCol.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getId()));
        nameCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getName()));
        priceCol.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getPrice()));
        electronicalCol.setCellValueFactory(c -> new SimpleBooleanProperty(c.getValue().isElectronical()));
        publisherCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getPublisher()));
        actionColumn.setCellFactory(param -> new TableCell(){
            private final Button deleteBtn = new Button("Delete");
            private final Button editBtn = new Button("Edit");

            {
                deleteBtn.setOnAction(event -> {
                    Product c = (Product) getTableRow().getItem();
                    System.out.println(c.getId());
                    new DAOImpl().deleteProduct(c);
                    refreshTable();
                });

                editBtn.setOnAction(event -> {
                    //System.out.println(c.getId());
                    Product product = (Product) getTableRow().getItem();
                    Main.loadFXML("add_product.fxml",product);
                    //refreshTable();
                });
            }

            @Override
            protected void updateItem(Object item, boolean empty) {
                super.updateItem(item, empty);
                if(empty){
                    setGraphic(null);
                }
                else{
                    HBox container = new HBox();
                    container.getChildren().addAll(editBtn, deleteBtn);
                    container.setSpacing(10.0);
                    setGraphic(container);
                }
            }
        });

    }

    private void refreshTable() {
        tableView.getItems().setAll(new DAOImpl().getProducts());
    }

    public void newProduct(ActionEvent event) {
        Main.loadFXML("add_product.fxml");
    }


    public void onMenuStoreCount(ActionEvent actionEvent)
    {
        Main.loadFXML("select5.fxml");
    }

    public void onMenuOrderedTwice(ActionEvent actionEvent) {
        Main.loadFXML("select9.fxml");
    }

    public void onMenuTop3(ActionEvent actionEvent) {
        Main.loadFXML("select4.fxml");
    }

    public void onMenuGenreCount(ActionEvent actionEvent) {
        Main.loadFXML("select1.fxml");
    }

    public void onMenuNewestProducts(ActionEvent actionEvent) {
        Main.loadFXML("select2.fxml");
    }

    public void onMenuMostPopular(ActionEvent actionEvent) {
        Main.loadFXML("select3.fxml");
    }
}
