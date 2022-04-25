package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.ToggleGroup;

public class orderController {
    @FXML
    public ComboBox<String> userComboBox;
    @FXML
    public ComboBox<String> storeComboBox;
    @FXML
    public Spinner<Integer> amountSpinner;
    @FXML
    public ToggleGroup deliveryToggleGroup;
    @FXML
    public ComboBox<String> productComboBox;

    public void submitOrder(ActionEvent event) {
    }
}
