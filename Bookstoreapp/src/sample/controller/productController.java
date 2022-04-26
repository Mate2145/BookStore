package sample.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sample.DAO.DAOImpl;
import sample.Main;
import sample.model.*;
import sun.awt.image.ImageWatched;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
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
    @FXML
    public TextField publisherTextField;

    public void submitProduct(ActionEvent event) {
        DAOImpl dao = new DAOImpl();
        Product product = new Product(
                nameTextField.getText(),
                Integer.parseInt(priceTextField.getText()),
                ((RadioButton) electronicToggleGroup.getSelectedToggle()).getText().equals("Igen"),
                publisherTextField.getText(),
                Date.valueOf(LocalDate.now())
        );
        dao.addProduct(product);
        int id = dao.getLastProductId();
        switch (((RadioButton) electronicToggleGroup.getSelectedToggle()).getText()){
            case "Könyv":
                dao.addBook(new Book(
                        id,
                        lengthSpinner.getValue()
                ));
                break;
            case "Zene":
                dao.addMusic(new Music(
                        id,
                        lengthSpinner.getValue()
                ));
                break;
            case "Film":
                dao.addMovie(new Film(
                        id,
                        lengthSpinner.getValue()
                ));
                break;
            default:
                System.err.println("Hiba történt az item insertelésénél!");
        }
        Main.loadFXML("sample.fxml");
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
