package sample.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.Main;
import sample.model.Select4;

public class toplistaController
{

    public TableView<Select4> tabled;
    public TableColumn<Select4,String> productColumn;
    public TableColumn<Select4,Number> sidColumn;
    public TableColumn<Select4,Number> sdbColumn;

    public void onBack(ActionEvent actionEvent)
    {
        Main.loadFXML("sample.fxml");
    }
}
