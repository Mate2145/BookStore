package sample.controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import sample.DAO.DAOImpl;
import sample.Main;
import sample.model.Product;
import sample.model.ProductGenre;
import sample.model.Store;

import java.net.URL;
import java.util.ResourceBundle;

public class storeController implements Initializable {


    public TableView tableView;
    public TableColumn<Store,String> emailCol;
    public TableColumn<Store,String> nameCol;
    public TableColumn<Store,String> addrCol;
    public TableColumn<Store,Void> actionColumn;

    public void onBack(ActionEvent actionEvent)
    {
        Main.loadFXML("sample.fxml");
    }

    @FXML
    public TextField emailTextField;
    @FXML
    public TextField nameTextField;
    @FXML
    public TextField addressTextField;

    public void submitStore(ActionEvent event) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        emailCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getEmail()));
        nameCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getName()));
        addrCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getAddress()));
        actionColumn.setCellFactory(param -> new TableCell(){
            private final Button deleteBtn = new Button("Delete");
            private final Button editBtn = new Button("Edit");

            {
                deleteBtn.setOnAction(event -> {
                    Store c = (Store) getTableRow().getItem();
                    System.out.println(c.getEmail());
                    new DAOImpl().deleteStore(c);
                    refreshTable();
                });

                editBtn.setOnAction(event -> {
                    //System.out.println(c.getId());
                    //productedit = (Product) getTableRow().getItem();
                    //System.out.println(productedit.getId());
                    Main.loadFXML("add_product.fxml");
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
        refreshTable();
    }
    private void refreshTable() {
        tableView.getItems().setAll(new DAOImpl().getStores());
    }

    public void newStore(ActionEvent event) {
        Main.loadFXML("add_store.fxml");
    }
}
