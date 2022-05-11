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
import sample.model.Select1;

import java.net.URL;
import java.util.ResourceBundle;

public class select1Controller implements Initializable {

    @FXML
    public TableColumn<Select1,String> nameColumn;

    public TableColumn<Select1,Number> countColumn;
    @FXML
    public TableView<Select1> tabled;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getGenreName()));
        countColumn.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getCounter()));
        refreshTable();
    }

    private void refreshTable() {
        tabled.getItems().setAll(new DAOImpl().getSelect1());
    }

    public void onBack(ActionEvent event) {
        Main.loadFXML("sample.fxml");
    }
}
