package sample.controller;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.DAO.DAOImpl;
import sample.Main;
import sample.model.User;

import java.net.URL;
import java.util.ResourceBundle;

public class userController implements Initializable {
    @FXML
    public TableView<User> tableView;
    @FXML
    public TableColumn<User,String > emailCol;
    @FXML
    public TableColumn<User,String > usernameCol;
    @FXML
    public TableColumn<User,String > passCol;
    @FXML
    public TableColumn<User,String > fullnameCol;
    @FXML
    public TableColumn<User,String > addressCol;
    @FXML
    public TableColumn<User,Number> balanceCol;
    @FXML
    public TableColumn<User,Boolean > freqCol;
    @FXML
    public TableColumn<User,Boolean > adminCol;

    public void onBack(ActionEvent actionEvent)
    {
        Main.loadFXML("sample.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        emailCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getEmail()));
        usernameCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getUsername()));
        passCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getPass()));
        fullnameCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getFullname()));
        addressCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getAddress()));
        balanceCol.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getBalance()));
        freqCol.setCellValueFactory(c -> new SimpleBooleanProperty(c.getValue().isFreqbuyer()));
        adminCol.setCellValueFactory(c -> new SimpleBooleanProperty(c.getValue().isAdmin()));
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

        Main.loadFXML("sample.fxml");
    }
}
