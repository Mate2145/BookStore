package sample.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import sample.DAO.DAOImpl;
import sample.Main;
import sample.model.Author;
import sample.model.Genre;
import sun.awt.image.ImageWatched;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class productController implements Initializable {

    @FXML
    public TextField nameTextField;
    @FXML
    public TextField priceTextField;
    @FXML
    public ToggleGroup electronicToggleGroup;
    @FXML
    public ToggleGroup productTypeToggleGroup;
    @FXML
    public ComboBox<String> authorComboBox;
    @FXML
    public ComboBox<String> genreComboBox;
    @FXML
    public Spinner<Integer> lengthSpinner;

    public void submitProduct(ActionEvent event) {
    }

    public void onBack(ActionEvent actionEvent)
    {
        Main.loadFXML("sample.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Author> authors = new DAOImpl().getAuthors();
        List<String> authorsSerialized = new LinkedList<String>();
        authors.forEach(author -> authorsSerialized.add(author.toString()));

        List<Genre> genres = new DAOImpl().getGenres();
        List<String> genresSerialized = new LinkedList<String>();
        genres.forEach(genre -> genresSerialized.add(genre.toString()));

        authorComboBox.setItems(FXCollections.observableArrayList(authorsSerialized));
        authorComboBox.getSelectionModel().select(0);

        genreComboBox.setItems(FXCollections.observableArrayList(genresSerialized));
        genreComboBox.getSelectionModel().select(0);
    }
}
