package sample.controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.DAO.DAOImpl;
import sample.Main;
import sample.model.Select6;

import java.net.URL;
import java.util.ResourceBundle;

public class select6Controller implements Initializable {
    public TableView<Select6> tabled;
    public TableColumn<Select6,String> termekColumn;
    public TableColumn<Select6,Number> genreCount;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        termekColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getTermeknev()));
        genreCount.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getGenrecount()));
        refreshTable();
    }

    private void refreshTable() {
        tabled.getItems().setAll(new DAOImpl().getSelect6());
    }

    public void onBack(ActionEvent actionEvent)
    {
        Main.loadFXML("sample.fxml");
    }
}
