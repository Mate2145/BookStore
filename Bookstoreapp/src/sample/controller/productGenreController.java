package sample.controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.DAO.DAOImpl;
import sample.Main;
import sample.model.ProductGenre;

import java.net.URL;
import java.util.ResourceBundle;

public class productGenreController implements Initializable {

    public TableView tableView;
    public TableColumn<ProductGenre,Number> idCol;
    public TableColumn<ProductGenre,String> subCol;

    public void onBack(ActionEvent actionEvent)
    {
        Main.loadFXML("sample.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idCol.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getId()));
        subCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getSubgenre()));
        refreshTable();
    }
    private void refreshTable() {
        tableView.getItems().setAll(new DAOImpl().getProductGenres());
    }
}
