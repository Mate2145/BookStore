package sample.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import sample.DAO.DAOImpl;
import sample.Main;
import sample.model.Author;

import java.net.URL;
import java.util.ResourceBundle;

public class authorController implements Initializable {

    @FXML
    public TableView<Author> tableView;
    @FXML
    public TableColumn<Author,String> birthdayCol;
    @FXML
    public TableColumn<Author,String> nameCol;
    @FXML
    public TextField nameTextField;
    @FXML
    public DatePicker dateOfBirthPicker;

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

    public void submitAuthor(ActionEvent event) {
    }

    public void newAuthor(ActionEvent event) {
        Main.loadFXML("add_author.fxml");
    }
}
