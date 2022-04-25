package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class productController {

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

    public void submitProduct(ActionEvent event) {
    }
}
