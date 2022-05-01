package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import sample.DAO.DAOImpl;
import sample.Main;
import sample.model.*;

import java.net.URL;
import java.util.ResourceBundle;


public class addUserController implements Initializable
{

    @FXML
    public TextField emailTextField;
    @FXML
    public TextField usernameTextField;
    @FXML
    public TextField passwordTextField;
    @FXML
    public TextField surnameTextField;
    @FXML
    public TextField firstnameTextField;
    @FXML
    public TextField addressTextField;
    @FXML
    public Spinner<Integer> balanceSpinner;
    @FXML
    public ToggleGroup adminToggleGroup;


    public void submitUser(ActionEvent actionEvent)
    {
        User user = new User(
                emailTextField.getText(),
                usernameTextField.getText(),
                passwordTextField.getText(),
                surnameTextField.getText() + " " + firstnameTextField.getText(),
                addressTextField.getText(),
                balanceSpinner.getValue(),
                ((RadioButton) adminToggleGroup.getSelectedToggle()).getText().equals("Igen")
        );
        if (Main.editable != null){
            new DAOImpl().updateUser(user);
            Main.loadFXML("user.fxml");
            toggleVisible(true);
        }
        else {
            toggleVisible(false);
            new DAOImpl().addUser(user);
            Main.loadFXML("user.fxml");
        }

    }

    public void onBack(ActionEvent event)
    {
        Main.loadFXML("user.fxml");
        toggleVisible(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (Main.editable !=null)
        {
            User edit = User.class.cast(Main.editable);
            emailTextField.setText(edit.getEmail());
            usernameTextField.setText(edit.getUsername());
            passwordTextField.setText(edit.getPass());
            surnameTextField.setText(edit.getFullname().split(" ")[1]);
            firstnameTextField.setText(edit.getFullname().split(" ")[0]);
            addressTextField.setText(edit.getAddress());
            balanceSpinner.getValueFactory().setValue(edit.getBalance());
            toggleVisible(false);



        }
    }

    void toggleVisible(boolean bool){

        adminToggleGroup.getToggles().forEach(e -> {
            Node node = (Node) e;
            node.setDisable(!bool);
        });
        emailTextField.setDisable(!bool);

        if (bool && Main.editable !=null)
        {
            Main.editable = null;
        }

    }
}
