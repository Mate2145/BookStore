package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import sample.DAO.DAOImpl;
import sample.Main;
import sample.model.Product;
import sample.model.Store;

import java.net.URL;
import java.util.ResourceBundle;

public class addStoreController implements Initializable {

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
        if (Main.editable != null){
            new DAOImpl().updateStore(store);
            Main.loadFXML("store.fxml");
            toggleVisible(true);
        }else{
            toggleVisible(false);
        new DAOImpl().addStore(store);
        Main.loadFXML("store.fxml");
        }
    }

    public void onBack(ActionEvent event) {
        toggleVisible(true);
        Main.loadFXML("store.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (Main.editable !=null)
        {
            Store edit = Store.class.cast(Main.editable);

            emailTextField.setText(edit.getEmail());
            nameTextField.setText(edit.getName());
            addressTextField.setText(edit.getAddress());
            toggleVisible(false);
        }
    }
    void toggleVisible(boolean bool){

        emailTextField.setDisable(!bool);

        if (bool && Main.editable !=null)
        {
            Main.editable = null;
        }

    }
}
