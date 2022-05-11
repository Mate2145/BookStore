package sample.controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.DAO.DAOImpl;
import sample.Main;
import sample.model.Select8;

import java.net.URL;
import java.util.ResourceBundle;

public class select8Controller implements Initializable {
    public TableView<Select8> tabled;
    public TableColumn<Select8,String> nameColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        nameColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getBookname()));
        refreshTable();
    }

    private void refreshTable() {
        tabled.getItems().setAll(new DAOImpl().getSelect8());
    }

    public void onBack(ActionEvent actionEvent)
    {
        Main.loadFXML("sample.fxml");
    }
}
