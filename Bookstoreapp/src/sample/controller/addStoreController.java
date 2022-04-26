package sample.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import sample.DAO.DAOImpl;
import sample.Main;
import sample.model.Store;

public class addStoreController
{

    public TextField emailTextField;
    public TextField nameTextField;
    public TextField addressTextField;

    public void submitStore(ActionEvent actionEvent)
    {
        Store store = new Store(
                emailTextField.getText(),
                nameTextField.getText(),
                addressTextField.getText()
        );
        new DAOImpl().addStore(store);
        Main.loadFXML("store.fxml");
    }

    public void onBack(ActionEvent event) {
        Main.loadFXML("store.fxml");
    }
}
