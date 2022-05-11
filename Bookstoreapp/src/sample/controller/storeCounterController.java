package sample.controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.DAO.DAOImpl;
import sample.Main;
import sample.model.Select5;

import java.net.URL;
import java.util.ResourceBundle;

public class storeCounterController implements Initializable {
    public TableColumn<Select5,String> storeColumn;
    public TableColumn<Select5,Number> quantityColumn;
    public TableView<Select5> tabled;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        storeColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getStorename()));
        quantityColumn.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getCounter()));
        refreshTable();
    }

    private void refreshTable() {
        tabled.getItems().setAll(new DAOImpl().getStoreCount());
    }

    public void onBack(ActionEvent actionEvent)
    {
        Main.loadFXML("sample.fxml");
    }
}
