package sample.controller;

import com.sun.org.apache.xpath.internal.operations.Or;
import javafx.beans.property.SimpleBooleanProperty;
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
import sample.model.Order;
import sample.model.Product;

import java.net.URL;
import java.util.ResourceBundle;

public class orderController implements Initializable {

    public TableView<Order> tableView;
    public TableColumn<Order,Number> idCol;
    public TableColumn<Order,String> u_emailCol;
    public TableColumn<Order,String> s_emailCol;
    public TableColumn<Order,String> whenCol;
    public TableColumn<Order,Number> quanCol;
    public TableColumn<Order,Boolean> typeCol;

    @FXML
    public ComboBox<String> userComboBox;
    @FXML
    public ComboBox<String> storeComboBox;
    @FXML
    public Spinner<Integer> amountSpinner;
    @FXML
    public ToggleGroup deliveryToggleGroup;
    @FXML
    public ComboBox<String> productComboBox;
    public TableColumn<Order,Void> actionColumn;

    public void submitOrder(ActionEvent event) {
    }

    public void onBack(ActionEvent actionEvent)
    {
        Main.loadFXML("sample.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idCol.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getId()));
        u_emailCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getUser_email()));
        s_emailCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getStore_email()));
        whenCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getWhen().toString()));
        quanCol.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getQuantity()));
        typeCol.setCellValueFactory(c -> new SimpleBooleanProperty(c.getValue().isOrdertype()));
        actionColumn.setCellFactory(param -> new TableCell(){
            private final Button deleteBtn = new Button("Delete");

            {
                deleteBtn.setOnAction(event -> {
                    Order c = (Order) getTableRow().getItem();
                    System.out.println(c.getId());
                    new DAOImpl().deleteOrder(c);
                    refreshTable();
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
                    container.getChildren().addAll(deleteBtn);
                    container.setSpacing(10.0);
                    setGraphic(container);
                }
            }
        });
        refreshTable();
    }
    private void refreshTable() {
        tableView.getItems().setAll(new DAOImpl().getOrder());
    }

    public void newOrder(ActionEvent event) {
        Main.loadFXML("add_order.fxml");
    }
}
