package sample.controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.DAO.DAOImpl;
import sample.Main;
import sample.model.Author;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class authorController implements Initializable {
    public TableView tableView;
    public TableColumn<Author,String> birthdayCol;
    public TableColumn<Author,String> nameCol;

    public void onBack(ActionEvent actionEvent)
    {
        Main.loadFXML("sample.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        nameCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getName()));
        birthdayCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getBirth_date().toString()));
        refreshTable();
    }

    private void refreshTable() {
        tableView.getItems().setAll(new DAOImpl().getAuthors());
    }
}
