package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.DAO.DAOImpl;
import sample.Main;
import sample.model.*;


public class addUserController
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

        new DAOImpl().addUser(user);
        Main.loadFXML("user.fxml");
    }

    public void onBack(ActionEvent event) {
        Main.loadFXML("user.fxml");
    }
}
