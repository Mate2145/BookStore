package sample.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import sample.DAO.DAOImpl;
import sample.Main;
import sample.model.OnStock;
import sample.model.Product;
import sample.model.Store;
import sample.model.User;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class addOnStockController implements Initializable
{

    public ComboBox<String> productComboBox;
    public ComboBox<String> storeComboBox;
    public Spinner<Integer> amountSpinner;

    public void submitStock(ActionEvent actionEvent)
    {
        OnStock stock = new OnStock(
                Integer.parseInt(productComboBox.getValue().split(" - ")[0]),
                storeComboBox.getValue(),
                amountSpinner.getValue()
        );
        new DAOImpl().addOnStock(stock);
        Main.loadFXML("onstock.fxml");
    }

    public void onBack(ActionEvent event) {
        Main.loadFXML("onstock.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DAOImpl dao = new DAOImpl();
        List<Product> products = dao.getProducts();
        List<String> productsSerialized = new LinkedList<>();
        products.forEach(product -> productsSerialized.add(product.toString()));

        List<Store> stores = dao.getStores();
        List<String> storesSerialized = new LinkedList<>();
        stores.forEach(store -> storesSerialized.add(store.toString()));

        productComboBox.setItems(FXCollections.observableArrayList(productsSerialized));
        productComboBox.getSelectionModel().select(0);

        storeComboBox.setItems(FXCollections.observableArrayList(storesSerialized));
        storeComboBox.getSelectionModel().select(0);

        if (Main.editable !=null) {
            OnStock edit = OnStock.class.cast(Main.editable);
            for (int i = 0; i < storesSerialized.size(); i++) {
                if (storesSerialized.get(i).contains(edit.getStore_email()))
                {
                    storeComboBox.getSelectionModel().select(i);
                    break;
                }
            }

            for (int i = 0; i < productsSerialized.size(); i++) {
                if (productsSerialized.get(i).contains(Integer.toString(edit.getId()))) {
                    productComboBox.getSelectionModel().select(i);
                    break;
                }
            }
            amountSpinner.getValueFactory().setValue(edit.getQuantity());
            toggleVisible(true);
        }
    }
    void toggleVisible(boolean bool){

        storeComboBox.setDisable(bool);
        productComboBox.setDisable(bool);

        if (bool && Main.editable !=null)
        {
            Main.editable = null;
        }

    }
}
