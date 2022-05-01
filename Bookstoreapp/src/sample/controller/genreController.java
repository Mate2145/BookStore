package sample.controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import sample.DAO.DAOImpl;
import sample.Main;
import sample.model.Genre;
import sample.model.Product;

import java.net.URL;
import java.util.ResourceBundle;

public class genreController implements Initializable {


    public TableView<Genre> tableView;
    public TableColumn<Genre,String> subCol;
    public TableColumn<Genre,String> genreCol;
    public TableColumn<Genre,Void> actionColumn;

    public void onBack(ActionEvent actionEvent)
    {
        Main.loadFXML("sample.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        subCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getSubgenre()));
        genreCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getGenrename()));
        actionColumn.setCellFactory(param -> new TableCell(){
            private final Button deleteBtn = new Button("Delete");


            {
                deleteBtn.setOnAction(event -> {
                    Genre c = (Genre) getTableRow().getItem();
                    System.out.println(c.getSubgenre());
                    new DAOImpl().deleteGenre(c);
                    refreshTable();
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
                    container.getChildren().addAll( deleteBtn);
                    container.setSpacing(10.0);
                    setGraphic(container);
                }
            }
        });
        refreshTable();
    }
    private void refreshTable() {
        tableView.getItems().setAll(new DAOImpl().getGenres());
    }

    public void newGenre(ActionEvent event) {
        Main.loadFXML("add_genre.fxml");
    }
}
