package sample.controller;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import sample.DAO.DAOImpl;
import sample.Main;
import sample.model.Author;
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
    public TableColumn<User,Void> actionColumn;

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
        actionColumn.setCellFactory(param -> new TableCell(){
            private final Button deleteBtn = new Button("Delete");
            private final Button editBtn = new Button("Edit");

            {
                deleteBtn.setOnAction(event -> {
                    User c = (User) getTableRow().getItem();
                    System.out.println(c.getEmail());
                    new DAOImpl().deleteUser(c);
                    refreshTable();
                });

                editBtn.setOnAction(event -> {
                    //System.out.println(c.getId());
                   User user1 = (User) getTableRow().getItem();
                    //System.out.println(authoredit.getId());
                    Main.loadFXML("add_user.fxml",user1);
                    //refreshTable();
                });
            }

            @Override
            protected void updateItem(Object item, boolean empty) {
                super.updateItem(item, empty);
                if(empty){
                    setGraphic(null);
                }
                else{
                    HBox container = new HBox();
                    container.getChildren().addAll(editBtn, deleteBtn);
                    container.setSpacing(10.0);
                    setGraphic(container);
                }
            }
        });
        refreshTable();
    }

    private void refreshTable() {
        tableView.getItems().setAll(new DAOImpl().getUsers());
    }

    public void newUser(ActionEvent event) {
        Main.loadFXML("add_user.fxml");
    }
}
