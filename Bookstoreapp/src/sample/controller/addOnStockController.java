package sample.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import sample.DAO.DAOImpl;
import sample.model.OnStock;

public class addOnStockController
{

    public ComboBox<Integer> productComboBox;
    public ComboBox<String> storeComboBox;
    public Spinner<Integer> amountSpinner;

    public void submitStock(ActionEvent actionEvent)
    {
        OnStock stock = new OnStock(
                productComboBox.getValue(),
                storeComboBox.getValue(),
                amountSpinner.getValue()
        );
        new DAOImpl().addOnStock(stock);
    }
}
