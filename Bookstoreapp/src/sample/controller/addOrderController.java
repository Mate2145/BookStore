package sample.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import sample.DAO.DAOImpl;
import sample.model.Order;

import java.sql.Date;
import java.time.ZoneId;

public class addOrderController
{

    public ComboBox<String> userComboBox;
    public ComboBox<String> storeComboBox;
    public Spinner<Integer> amountSpinner;
    public ToggleGroup deliveryToggleGroup;
    public ComboBox<Integer> productComboBox;
    public DatePicker datepicker;
    ZoneId defaultZoneId = ZoneId.systemDefault();


    public void submitOrder(ActionEvent actionEvent)
    {
        Date date = (Date) Date.from(datepicker.getValue().atStartOfDay(defaultZoneId).toInstant());
        Order order = new Order(
                productComboBox.getValue(),
                userComboBox.getValue(),
                storeComboBox.getValue(),
                date,
                amountSpinner.getValue(),
                ((RadioButton) deliveryToggleGroup.getSelectedToggle()).getText().equals("Igen")
        );

        new DAOImpl().addOrder(order);
    }
}
