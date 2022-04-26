package sample.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sample.DAO.DAOImpl;
import sample.Main;
import sample.model.*;

import java.net.URL;
import java.sql.Date;
import java.time.ZoneId;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class addOrderController implements Initializable
{

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
    @FXML
    public DatePicker datepicker;
    ZoneId defaultZoneId = ZoneId.systemDefault();


    public void submitOrder(ActionEvent actionEvent)
    {
        Date date = Date.valueOf(datepicker.getValue());
        Order order = new Order(
                Integer.parseInt(productComboBox.getValue().split(" - ")[0]),
                userComboBox.getValue(),
                storeComboBox.getValue(),
                date,
                amountSpinner.getValue(),
                ((RadioButton) deliveryToggleGroup.getSelectedToggle()).getText().equals("Igen")
        );

        new DAOImpl().addOrder(order);
        Main.loadFXML("order.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DAOImpl dao = new DAOImpl();
        List<Product> products = dao.getProducts();
        List<String> productsSerialized = new LinkedList<>();
        products.forEach(product -> productsSerialized.add(product.toString()));

        List<User> users = dao.getUsers();
        List<String> usersSerialized = new LinkedList<>();
        users.forEach(user -> usersSerialized.add(user.toString()));

        List<Store> stores = dao.getStores();
        List<String> storesSerialized = new LinkedList<>();
        stores.forEach(store -> storesSerialized.add(store.toString()));

        productComboBox.setItems(FXCollections.observableArrayList(productsSerialized));
        productComboBox.getSelectionModel().select(0);

        userComboBox.setItems(FXCollections.observableArrayList(usersSerialized));
        userComboBox.getSelectionModel().select(0);

        storeComboBox.setItems(FXCollections.observableArrayList(storesSerialized));
        storeComboBox.getSelectionModel().select(0);
    }

    public void onBack(ActionEvent event) {
        Main.loadFXML("order.fxml");
    }
}
