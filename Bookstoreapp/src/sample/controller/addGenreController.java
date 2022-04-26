package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.DAO.DAOImpl;
import sample.Main;
import sample.model.Genre;

public class addGenreController {

    @FXML
    public TextField subGenreTextField;
    @FXML
    public TextField mainGenreTextField;

    public void submitGenre(ActionEvent actionEvent)
    {
        Genre genre = new Genre(
                subGenreTextField.getText(),
                mainGenreTextField.getText()
        );
        new DAOImpl().addGenre(genre);
        Main.loadFXML("genres.fxml");
    }

    public void onBack(ActionEvent event) {
        Main.loadFXML("genres.fxml");
    }
}
