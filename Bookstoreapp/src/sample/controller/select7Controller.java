package sample.controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.DAO.DAOImpl;
import sample.Main;
import sample.model.Select7;

import java.net.URL;
import java.util.ResourceBundle;

public class select7Controller implements Initializable {
    public TableView<Select7> tabled;
    public TableColumn<Select7,String> nameColumn;
    public TableColumn<Select7,Number> countColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        nameColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getTermnekNev()));
        countColumn.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getAuthorcount()));
        refreshTable();
    }

    private void refreshTable() {
        tabled.getItems().setAll(new DAOImpl().getSelect7());
    }

    public void onBack(ActionEvent actionEvent)
    {
        Main.loadFXML("sample.fxml");
    }
}
