package sample.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import sample.DAO.DAOImpl;
import sample.model.Author;

import java.sql.Date;
import java.time.ZoneId;

public class addAuthorController
{

    public TextField nameTextField;
    public DatePicker dateOfBirthPicker;
    ZoneId defaultZoneId = ZoneId.systemDefault();

    public void submitAuthor(ActionEvent actionEvent)
    {
        Date date = (Date) Date.from(dateOfBirthPicker.getValue().atStartOfDay(defaultZoneId).toInstant());
        Author author = new Author(
                date,
                nameTextField.getText()
        );

        new DAOImpl().AddAuthor(author);
    }
}
