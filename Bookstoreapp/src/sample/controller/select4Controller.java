package sample.controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.DAO.DAOImpl;
import sample.Main;
import sample.model.Select4;

import java.net.URL;
import java.util.ResourceBundle;

public class select4Controller implements Initializable {

    @FXML
    public TableColumn<Select4,Number> idColumn;
    @FXML
    public TableColumn<Select4,String> nameColumn;
    @FXML
    public TableColumn<Select4,Number> countColumn;
    @FXML
    public TableView<Select4> tabled;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idColumn.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getId()));
        nameColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getProductname()));
        countColumn.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getCounter()));
        refreshTable();
    }

    private void refreshTable() {
        tabled.getItems().setAll(new DAOImpl().getSelect4());
    }

    public void onBack(ActionEvent event) {
        Main.loadFXML("sample.fxml");
    }
}
