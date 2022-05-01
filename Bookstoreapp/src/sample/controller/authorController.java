package sample.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import sample.DAO.DAOImpl;
import sample.Main;
import sample.model.Author;
import sample.model.Product;

import java.net.URL;
import java.util.ResourceBundle;

public class authorController implements Initializable {

    @FXML
    public TableView<Author> tableView;
    @FXML
    public TableColumn<Author,String> birthdayCol;
    @FXML
    public TableColumn<Author,String> nameCol;
    @FXML
    public TextField nameTextField;
    @FXML
    public DatePicker dateOfBirthPicker;
    public TableColumn<Author,Void> actionColumn;
    public static Author authoredit;

    public void onBack(ActionEvent actionEvent)
    {
        Main.loadFXML("sample.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        nameCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getName()));
        birthdayCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getBirth_date().toString()));
        actionColumn.setCellFactory(param -> new TableCell(){
            private final Button deleteBtn = new Button("Delete");
            private final Button editBtn = new Button("Edit");

            {
                deleteBtn.setOnAction(event -> {
                    Author c = (Author) getTableRow().getItem();
                    System.out.println(c.getName());
                    new DAOImpl().deleteAuthor(c);
                    refreshTable();
                });

                editBtn.setOnAction(event -> {
                    //System.out.println(c.getId());
                    //authoredit = (Product) getTableRow().getItem();
                    //System.out.println(authoredit.getId());
                    Main.loadFXML("add_product.fxml");
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
        tableView.getItems().setAll(new DAOImpl().getAuthors());
    }

    public void submitAuthor(ActionEvent event) {
    }

    public void newAuthor(ActionEvent event) {
        Main.loadFXML("add_author.fxml");
    }
}
