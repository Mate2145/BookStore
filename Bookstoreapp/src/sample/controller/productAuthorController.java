package sample.controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.DAO.DAOImpl;
import sample.Main;
import sample.model.ProductAuthor;
import sample.model.ProductGenre;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class productAuthorController implements Initializable {

    public TableView tableView;
    public TableColumn<ProductAuthor,Number> idCol;
    public TableColumn<ProductAuthor,String> nameCol;
    public TableColumn<ProductAuthor,String> birthCol;




    public void onBack(ActionEvent actionEvent)
    {
        Main.loadFXML("sample.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idCol.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getId()));
        nameCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getName()));
        birthCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getBirth_date().toString()));
        refreshTable();
    }

    private void refreshTable() {
        tableView.getItems().setAll(new DAOImpl().getProductAuthors());
    }
}
