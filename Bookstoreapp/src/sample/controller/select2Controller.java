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
import sample.model.Select2;

import java.net.URL;
import java.util.ResourceBundle;

public class select2Controller implements Initializable {

    @FXML
    public TableColumn<Select2,String> productNameColumn;
    @FXML

    public TableColumn<Select2,String> whenColumn;

    @FXML

    public TableColumn<Select2,String> genreColumn;
    @FXML
    public TableView<Select2> tabled;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        productNameColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getProductname()));
        whenColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getWhen()));
        genreColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getGenreName()));
        refreshTable();
    }

    private void refreshTable() {
        tabled.getItems().setAll(new DAOImpl().getSelect2());
    }

    public void onBack(ActionEvent event) {
        Main.loadFXML("sample.fxml");
    }
}
