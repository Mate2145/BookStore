package sample.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import sample.DAO.DAOImpl;
import sample.model.Genre;

public class addGenreController {

    public TextField subGenreTextField;
    public TextField mainGenreTextField;

    public void submitGenre(ActionEvent actionEvent)
    {
        Genre genre = new Genre(
                subGenreTextField.getText(),
                mainGenreTextField.getText()
        );
        new DAOImpl().addGenre(genre);
    }
}
