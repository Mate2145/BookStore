package sample.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import sample.DAO.DAOImpl;
import sample.Main;
import sample.model.Author;

import java.sql.Date;
import java.time.ZoneId;

public class addAuthorController
{

    public TextField nameTextField;
    public DatePicker dateOfBirthPicker;

    public void submitAuthor(ActionEvent actionEvent)
    {
        Author author = new Author(
                Date.valueOf(dateOfBirthPicker.getValue()),
                nameTextField.getText()
        );

        new DAOImpl().addAuthor(author);
        Main.loadFXML("author.fxml");
    }
}
