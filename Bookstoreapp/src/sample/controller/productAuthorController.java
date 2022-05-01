package sample.controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import sample.DAO.DAOImpl;
import sample.Main;
import sample.model.Product;
import sample.model.ProductAuthor;
import sample.model.ProductGenre;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class productAuthorController implements Initializable {

    public TableView<ProductAuthor> tableView;
    public TableColumn<ProductAuthor,Number> idCol;
    public TableColumn<ProductAuthor,String> nameCol;
    public TableColumn<ProductAuthor,String> birthCol;
    public TableColumn<ProductAuthor,Void> actionColumn;


    public void onBack(ActionEvent actionEvent)
    {
        Main.loadFXML("sample.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idCol.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getId()));
        nameCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getName()));
        birthCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getBirth_date().toString()));
        actionColumn.setCellFactory(param -> new TableCell(){
            private final Button deleteBtn = new Button("Delete");
            private final Button editBtn = new Button("Edit");

            {
                deleteBtn.setOnAction(event -> {
                    ProductAuthor c = (ProductAuthor) getTableRow().getItem();
                    System.out.println(c.getId());
                    new DAOImpl().deleteProductAuthor(c);
                    refreshTable();
                });

                editBtn.setOnAction(event -> {
                    //System.out.println(c.getId());
                    //productedit = (Product) getTableRow().getItem();
                    //System.out.println(productedit.getId());
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
        tableView.getItems().setAll(new DAOImpl().getProductAuthors());
    }


    public void newProductAuthor(ActionEvent event) {
        Main.loadFXML("add_product_author.fxml");
    }
}
