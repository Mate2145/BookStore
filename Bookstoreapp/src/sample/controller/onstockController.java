package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;

public class onstockController {

    @FXML
    public ComboBox<String> productComboBox;
    @FXML
    public ComboBox<String> storeComboBox;
    @FXML
    public Spinner<Integer> amountSpinner;

    public void submitStock(ActionEvent event) {
    }
}
