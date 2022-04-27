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

public class addProductAuthorController implements Initializable {

    @FXML
    public ComboBox<String> authorComboBox;
    @FXML
    public ComboBox<String> productComboBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DAOImpl dao = new DAOImpl();
        List<Author> authors = new DAOImpl().getAuthors();
        List<String> authorsSerialized = new LinkedList<String>();
        authors.forEach(author -> authorsSerialized.add(author.toString()));

        List<Product> products = dao.getProducts();
        List<String> productsSerialized = new LinkedList<>();
        products.forEach(product -> productsSerialized.add(product.toString()));

        authorComboBox.setItems(FXCollections.observableArrayList(authorsSerialized));
        authorComboBox.getSelectionModel().select(0);

        productComboBox.setItems(FXCollections.observableArrayList(productsSerialized));
        productComboBox.getSelectionModel().select(0);
    }

    public void onBack(ActionEvent event) {
        Main.loadFXML("product_author.fxml");
    }

    public void submitProductAuthor(ActionEvent event) {
        DAOImpl dao = new DAOImpl();
        String[] authorData = authorComboBox.getValue().split(":");
        dao.addProductAuth(new ProductAuthor(
                Integer.parseInt(productComboBox.getValue().split(" - ")[0]),
                authorData[0],
                Date.valueOf(authorData[1])
        ));
        Main.loadFXML("product_author.fxml");
    }
}
