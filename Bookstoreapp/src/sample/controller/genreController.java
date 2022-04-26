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
import sample.model.Genre;

import java.net.URL;
import java.util.ResourceBundle;

public class genreController implements Initializable {


    public TableView tableView;
    public TableColumn<Genre,String> subCol;
    public TableColumn<Genre,String> genreCol;

    public void onBack(ActionEvent actionEvent)
    {
        Main.loadFXML("sample.fxml");
    }

    @FXML
    public TextField subGenreTextField;
    @FXML
    public TextField mainGenreTextField;

    public void submitGenre(ActionEvent event) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        subCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getSubgenre()));
        genreCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getGenrename()));
        refreshTable();
    }
    private void refreshTable() {
        tableView.getItems().setAll(new DAOImpl().getGenres());
    }
}
