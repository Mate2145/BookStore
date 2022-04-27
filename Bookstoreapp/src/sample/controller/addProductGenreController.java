package sample.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import sample.DAO.DAOImpl;
import sample.Main;
import sample.model.*;

import java.net.URL;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class addProductGenreController implements Initializable {
    @FXML
    public ComboBox<String> productComboBox;
    @FXML
    public ComboBox<String> genreComboBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DAOImpl dao = new DAOImpl();
        List<Genre> genres = new DAOImpl().getGenres();
        List<String> genresSerialized = new LinkedList<String>();
        genres.forEach(genre -> genresSerialized.add(genre.toString()));

        List<Product> products = dao.getProducts();
        List<String> productsSerialized = new LinkedList<>();
        products.forEach(product -> productsSerialized.add(product.toString()));

        genreComboBox.setItems(FXCollections.observableArrayList(genresSerialized));
        genreComboBox.getSelectionModel().select(0);

        productComboBox.setItems(FXCollections.observableArrayList(productsSerialized));
        productComboBox.getSelectionModel().select(0);

    }

    public void submitProductGenre(ActionEvent event) {
        ProductGenre productGenre = new ProductGenre(
                Integer.parseInt(productComboBox.getValue().split(" - ")[0]),
                genreComboBox.getValue()
        );

        new DAOImpl().addProductGenre(productGenre);
        Main.loadFXML("product_genre.fxml");
    }

    public void onBack(ActionEvent event) {
        Main.loadFXML("product_genre.fxml");
    }
}
