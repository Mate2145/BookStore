package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import sample.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class userinsertController implements Initializable {

    public void onBack(ActionEvent actionEvent)
    {
        Main.loadFXML("sample.fxml");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void onSubmit(ActionEvent actionEvent)
    {

    }
}
