package sample.controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.DAO.DAOImpl;
import sample.Main;
import sample.model.Film;
import sample.model.Music;

import java.net.URL;
import java.util.ResourceBundle;

public class filmController implements Initializable {

    public TableView tableView;
    public TableColumn<Film,Number> idCol;
    public TableColumn<Film,Number> lenCol;

    public void onBack(ActionEvent actionEvent)
    {
        Main.loadFXML("sample.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idCol.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getId()));
        lenCol.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getLen()));
        refreshTable();
    }
    private void refreshTable() {
        tableView.getItems().setAll(new DAOImpl().getFilms());
    }
}
