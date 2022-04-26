package sample.controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.DAO.DAOImpl;
import sample.Main;
import sample.model.OnStock;
import sample.model.ProductAuthor;

import java.net.URL;
import java.util.ResourceBundle;

public class onstockController implements Initializable {

    public TableView tableView;
    public TableColumn<OnStock,Number> idCol;
    public TableColumn<OnStock,String> emailCol;
    public TableColumn<OnStock,Number> quanCol;

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
        refreshTable();
    }
    private void refreshTable() {
        tableView.getItems().setAll(new DAOImpl().getOnStocks());
    }
}
