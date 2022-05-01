package sample.controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.DAO.DAOImpl;
import sample.model.Select1;
import sample.model.Select9;

import java.net.URL;
import java.util.ResourceBundle;

public class select9Controller implements Initializable {
    public TableColumn<Select9,String> nameColumn;
    public TableView<Select9> tabled;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getName()));
        refreshTable();
    }

    private void refreshTable() {
        tabled.getItems().setAll(new DAOImpl().getSelect9());
    }
}
