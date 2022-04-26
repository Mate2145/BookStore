package sample.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.ToggleGroup;
import sample.model.Order;

public class addOrderController
{

    public ComboBox userComboBox;
    public ComboBox storeComboBox;
    public Spinner amountSpinner;
    public ToggleGroup deliveryToggleGroup;
    public ComboBox productComboBox;

    public void submitOrder(ActionEvent actionEvent)
    {
        Order order = new Order(
                userComboBox.getValue(),
                storeComboBox.getValue(),
                
        )
    }
}
