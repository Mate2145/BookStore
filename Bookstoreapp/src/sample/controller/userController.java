package sample.controller;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.DAO.DAOImpl;
import sample.Main;
import sample.model.User;

import java.net.URL;
import java.util.ResourceBundle;

public class userController implements Initializable {
    public TableView<User> tableView;
    public TableColumn<User,String > emailCol;
    public TableColumn<User,String > usernameCol;
    public TableColumn<User,String > passCol;
    public TableColumn<User,String > fullnameCol;
    public TableColumn<User,String > adressCol;
    public TableColumn<User,Boolean > adminCol;
    public TableColumn<User,Boolean > freqCol;

    public void onBack(ActionEvent actionEvent)
    {
        //Main.loadFXML("add_user.fxml");
        Main.loadFXML("sample.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        emailCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getEmail()));
        usernameCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getUsername()));
        passCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getPass()));
        fullnameCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getFullname()));
        adressCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getAddress()));
        adminCol.setCellValueFactory(c -> new SimpleBooleanProperty(c.getValue().isAdmin()));
        freqCol.setCellValueFactory(c -> new SimpleBooleanProperty(c.getValue().isFreqbuyer()));
        refreshTable();
    }

    private void refreshTable() {
        tableView.getItems().setAll(new DAOImpl().getUsers());
    }

    public void onUpdate(ActionEvent actionEvent)
    {
        Main.loadFXML("add_user.fxml");
    }

    public void onDelete(ActionEvent actionEvent) {
    }

    public void userSubmit(ActionEvent event) {
    }
}
