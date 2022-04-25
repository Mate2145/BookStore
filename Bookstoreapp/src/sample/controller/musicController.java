package sample.controller;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.DAO.DAOImpl;
import sample.Main;
import sample.model.Music;

import java.net.URL;
import java.util.ResourceBundle;

public class musicController implements Initializable {

    public TableView<Music> tableView;
    public TableColumn<Music,Number> idCol;
    public TableColumn<Music,Number> lenCol;

    public void onBack(ActionEvent actionEvent)
    {
        Main.loadFXML("sample.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        idCol.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getId()));
        lenCol.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getLen()));
        refreshTable();
    }

    private void refreshTable() {
        tableView.getItems().setAll(new DAOImpl().getMusics());
    }
}
