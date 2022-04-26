package sample.controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import sample.DAO.DAOImpl;
import sample.Main;
import sample.model.ProductGenre;
import sample.model.Store;

import java.net.URL;
import java.util.ResourceBundle;

public class storeController implements Initializable {


    public TableView tableView;
    public TableColumn<Store,String> emailCol;
    public TableColumn<Store,String> nameCol;
    public TableColumn<Store,String> addrCol;

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
        refreshTable();
    }
    private void refreshTable() {
        tableView.getItems().setAll(new DAOImpl().getStore());
    }
}
