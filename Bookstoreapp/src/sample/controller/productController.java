package sample.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import sample.DAO.DAOImpl;
import sample.Main;
import sample.model.*;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class productController implements Initializable {

    @FXML
    public TextField nameTextField;
    @FXML
    public TextField priceTextField;
    @FXML
    public ToggleGroup electronicToggleGroup;
    @FXML
    public ToggleGroup productTypeToggleGroup;
    @FXML
    public ComboBox<String> authorComboBox;
    @FXML
    public ComboBox<String> genreComboBox;
    @FXML
    public Spinner<Integer> lengthSpinner;
    @FXML
    public TextField publisherTextField;
    public Label idLabel;

    public void submitProduct(ActionEvent event) {
        DAOImpl dao = new DAOImpl();
        Product product = new Product(
                Integer.parseInt(idLabel.getText()),
                nameTextField.getText(),
                Integer.parseInt(priceTextField.getText()),
                ((RadioButton) electronicToggleGroup.getSelectedToggle()).getText().equals("Igen"),
                publisherTextField.getText(),
                Date.valueOf(LocalDate.now())
        );
        if (Main.editable == null)
        {
            toggleVisible(false);
            new DAOImpl().addProduct(product);
            int id = dao.getLastProductId();
            System.out.println(id);
            System.out.println(((RadioButton) productTypeToggleGroup.getSelectedToggle()).getText());
            switch (((RadioButton) productTypeToggleGroup.getSelectedToggle()).getText()){
                case "Könyv":
                    dao.addBook(new Book(
                            id,
                            lengthSpinner.getValue()
                    ));
                    break;
                case "Zene":
                    dao.addMusic(new Music(
                            id,
                            lengthSpinner.getValue()
                    ));
                    break;
                case "Film":
                    dao.addMovie(new Film(
                            id,
                            lengthSpinner.getValue()
                    ));
                    break;
                default:
                    System.err.println("Hiba történt az item insertelésénél!");
            }

            dao.addProductGenre(new ProductGenre(
                    id,
                    genreComboBox.getValue()
            ));

            String[] authorData = authorComboBox.getValue().split(":");
            dao.addProductAuth(new ProductAuthor(
                    id,
                    authorData[0],
                    Date.valueOf(authorData[1])
            ));
            Main.loadFXML("sample.fxml");
        }


        if (Main.editable != null)
        {
            new DAOImpl().updateProduct(product);
            Main.loadFXML("sample.fxml");
            toggleVisible(true);
        }

    }

    public void onBack(ActionEvent actionEvent)
    {
        toggleVisible(true);
        Main.loadFXML("sample.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        idLabel.setVisible(false);
        idLabel.setText("0");
        List<Author> authors = new DAOImpl().getAuthors();
        List<String> authorsSerialized = new LinkedList<String>();
        authors.forEach(author -> authorsSerialized.add(author.toString()));

        List<Genre> genres = new DAOImpl().getGenres();
        List<String> genresSerialized = new LinkedList<String>();
        genres.forEach(genre -> genresSerialized.add(genre.toString()));

        authorComboBox.setItems(FXCollections.observableArrayList(authorsSerialized));
        authorComboBox.getSelectionModel().select(0);

        genreComboBox.setItems(FXCollections.observableArrayList(genresSerialized));
        genreComboBox.getSelectionModel().select(0);

        if (Main.editable !=null)
        {

            Product edit = Product.class.cast(Main.editable);

            idLabel.setText(Integer.toString(edit.getId()));
            nameTextField.setText(edit.getName());
            priceTextField.setText(Integer.toString(edit.getPrice()));
            publisherTextField.setText(edit.getPublisher());
            toggleVisible(false);

        }
    }

    void toggleVisible(boolean bool){
        electronicToggleGroup.getToggles().forEach(e -> {
            Node node = (Node) e;
            node.setDisable(!bool);
        });
        productTypeToggleGroup.getToggles().forEach(e -> {
            Node node = (Node) e;
            node.setDisable(!bool);
        });
        authorComboBox.setDisable(!bool);
        genreComboBox.setDisable(!bool);
        lengthSpinner.setDisable(!bool);

        if (bool && Main.editable !=null)
        {
            Main.editable = null;
        }

    }
}
