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
import sample.model.OnStock;
import sample.model.Product;
import sample.model.ProductAuthor;

import java.net.URL;
import java.util.ResourceBundle;

public class onstockController implements Initializable {

    public TableView<OnStock> tableView;
    public TableColumn<OnStock,Number> idCol;
    public TableColumn<OnStock,String> emailCol;
    public TableColumn<OnStock,Number> quanCol;
    public TableColumn<OnStock,Void> actionColumn;

    public void onBack(ActionEvent actionEvent)
    {
        Main.loadFXML("sample.fxml");
    }

    @FXML
    public ComboBox<String> productComboBox;
    @FXML
    public ComboBox<String> storeComboBox;
    @FXML
    public Spinner<Integer> amountSpinner;

    public void submitStock(ActionEvent event) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idCol.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getId()));
        emailCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getStore_email()));
        quanCol.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getQuantity()));
        actionColumn.setCellFactory(param -> new TableCell(){
            private final Button deleteBtn = new Button("Delete");
            private final Button editBtn = new Button("Edit");

            {
                deleteBtn.setOnAction(event -> {
                    OnStock c = (OnStock) getTableRow().getItem();
                    System.out.println(c.getId());
                    new DAOImpl().deleteStock(c);
                    refreshTable();
                });

                editBtn.setOnAction(event -> {
                    //System.out.println(c.getId());
                    OnStock stock = (OnStock) getTableRow().getItem();
                    //System.out.println(productedit.getId());
                    Main.loadFXML("add_stock.fxml",stock);
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
        tableView.getItems().setAll(new DAOImpl().getOnStocks());
    }

    public void newStock(ActionEvent event) {
        Main.loadFXML("add_stock.fxml");
    }
}
