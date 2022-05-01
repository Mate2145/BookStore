package sample.DAO;

import sample.model.*;
import oracle.jdbc.pool.OracleDataSource;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class DAOImpl {

    private ResultSet rs;
    private Statement stmt;
    private OracleDataSource ods;
    final private String user = "matee";
    final private String pass = "test";

    public DAOImpl() {
        try {
            ods = new OracleDataSource();
            Class.forName("oracle.jdbc.OracleDriver");
            ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Product> getProducts() {
        List<Product> productList = new ArrayList<>();
        try
        {
            Connection conn = ods.getConnection(user, pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM Termek ORDER BY id";
            rs = stmt.executeQuery(sql);
            while (rs.next())
            {

                Product product = new Product(rs.getInt(1), rs.getString(2),
                        rs.getInt(3), rs.getBoolean(4), rs.getString(5), rs.getDate(6));
                productList.add(product);
            }

        } catch (Exception ex)
        {
            System.out.println("Bajom van");
            ex.printStackTrace();
        }
        return productList;
    }

    public int getLastProductId() {
        try
        {
            Connection conn = ods.getConnection(user, pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT id FROM Termek ORDER BY id DESC";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex)
        {
            System.out.println("Bajom van");
            ex.printStackTrace();
        }
        return -1;
    }

    public List<Music> getMusics() {
        List<Music> musicList = new ArrayList<>();
        try {
            Connection conn = ods.getConnection(user, pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM Zene";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Music music = new Music(rs.getInt(1), rs.getInt(2));
                musicList.add(music);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return musicList;
    }
    public List<Book> getBooks() {
        List<Book> bookList = new ArrayList<>();
        try {
            Connection conn = ods.getConnection(user, pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM Konyv";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Book book = new Book(rs.getInt(1), rs.getInt(2));
                bookList.add(book);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bookList;
    }
    public List<Film> getFilms() {
        List<Film> filmList = new ArrayList<>();
        try {
            Connection conn = ods.getConnection(user, pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM Film";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Film film = new Film(rs.getInt(1), rs.getInt(2));
                filmList.add(film);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return filmList;
    }

    public List<Author> getAuthors() {
        List<Author> authorList = new ArrayList<>();
        try {
            Connection conn = ods.getConnection(user, pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM Szerzo";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Author author = new Author(rs.getDate(1), rs.getString(2));
                authorList.add(author);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return authorList;
    }

    public List<User> getUsers() {
        List<User> productList = new ArrayList<>();
        try {
            Connection conn = ods.getConnection(user, pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM Felhasznalo";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                User user1 = new User(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),rs.getInt(6),rs.getBoolean("TORZSVASARLO"), rs.getBoolean("ADMIN"));
                productList.add(user1);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return productList;
    }



    public List<Genre> getGenres() {
        List<Genre> genreList = new ArrayList<>();
        try {
            Connection conn = ods.getConnection(user, pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM Mufaj";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Genre genre = new Genre(rs.getString(1), rs.getString(2));
                genreList.add(genre);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return genreList;
    }


    public List<ProductGenre> getProductGenres() {
        List<ProductGenre> productGenreList = new ArrayList<>();
        try {
            Connection conn = ods.getConnection(user, pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM Mufaja";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ProductGenre productgenre = new ProductGenre(rs.getInt(1), rs.getString(2));
                productGenreList.add(productgenre);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return productGenreList;
    }

    public List<ProductAuthor> getProductAuthors() {
        List<ProductAuthor> productAuthorList = new ArrayList<>();
        try {
            Connection conn = ods.getConnection(user, pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM Szerzoje";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ProductAuthor productAuthor = new ProductAuthor(rs.getInt(1), rs.getString(2),rs.getDate(3));
                productAuthorList.add(productAuthor);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return productAuthorList;
    }

    public List<OnStock> getOnStocks() {
        List<OnStock> onStockList = new ArrayList<>();
        try {
            Connection conn = ods.getConnection(user, pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM Keszleten";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                OnStock onStock = new OnStock(rs.getInt(1), rs.getString(2),rs.getInt(3));
                onStockList.add(onStock);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return onStockList;
    }

    public List<Order> getOrder() {
        List<Order> orderList = new ArrayList<>();
        try
        {
            Connection conn = ods.getConnection(user, pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM Megrendel";
            rs = stmt.executeQuery(sql);
            while (rs.next())
            {
                Order order = new Order(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getDate(4), rs.getInt(5), rs.getBoolean(6));
                orderList.add(order);
            }

        } catch (Exception ex)
        {
            System.out.println("Bajom van");
            ex.printStackTrace();
        }
        return orderList;
    }

    public List<Store> getStores() {
        List<Store> storeList = new ArrayList<>();
        try {
            Connection conn = ods.getConnection(user, pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM Aruhaz";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Store store = new Store(rs.getString(1), rs.getString(2),rs.getString(3));
                storeList.add(store);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return storeList;
    }

    public void addUser(User adduser)
    {
        try
        {
            String INSERT_CONTACT = "INSERT INTO Felhasznalo(email, felhasznalonev, jelszo, teljes_nev, lakcim, egyenleg, admin) \n" +
                    "VALUES(?,?,?,?,?,?,?)";
            Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt = conn.prepareStatement(INSERT_CONTACT, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, adduser.getEmail());
            stmt.setString(2, adduser.getUsername());
            stmt.setString(3, adduser.getPass());
            stmt.setString(4, adduser.getFullname());
            stmt.setString(5, adduser.getAddress());
            stmt.setInt(6, adduser.getBalance());
            stmt.setBoolean(7, adduser.isAdmin());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating product failed, no rows affected.");
            }
        }

        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void addProduct(Product product)
    {
        try
        {
            String INSERT_CONTACT = "INSERT INTO Termek(nev, ar, elektronikus, kiado) VALUES(?,?,?,?)";
            String UPDATE_CONTACT = "UPDATE Termek SET nev=?, ar = ?, elektronikus = ?, kiado=? WHERE id=?";
            Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt = product.getId() <=0 ? conn.prepareStatement(INSERT_CONTACT, Statement.RETURN_GENERATED_KEYS) : conn.prepareStatement(UPDATE_CONTACT);
            if (product.getId() > 0)
            {
                stmt.setInt(5,product.getId());
            }
            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getPrice());
            stmt.setInt(3, product.isElectronical() ? 1 : 0);
            stmt.setString(4, product.getPublisher());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating product failed, no rows affected.");
            }

            if(product.getId() <= 0){ // INSERT
                ResultSet genKeys = stmt.getGeneratedKeys();
                if(genKeys.next()){
                    product.setId(genKeys.getInt(1));
                }
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public boolean addMusic(Music addmusic)
    {
        try
        {
            String INSERT_CONTACT = "INSERT INTO Zene(id, hossz) VALUES(?,?)";
            Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt = conn.prepareStatement(INSERT_CONTACT, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, addmusic.getId());
            stmt.setInt(2, addmusic.getLen());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating product failed, no rows affected.");
            }
        }

        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean addMovie(Film addfilm)
    {
        try
        {
            String INSERT_CONTACT = "INSERT INTO Film(id, hossz) VALUES(?,?)";
            Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt = conn.prepareStatement(INSERT_CONTACT, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, addfilm.getId());
            stmt.setInt(2, addfilm.getLen());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating product failed, no rows affected.");
            }
        }

        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean addBook(Book addbook)
    {
        try
        {
            String INSERT_CONTACT = "INSERT INTO Konyv(id, oldalszam) VALUES(?,?)";
            Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt = conn.prepareStatement(INSERT_CONTACT, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, addbook.getId());
            stmt.setInt(2, addbook.getLen());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating product failed, no rows affected.");
            }
        }

        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean addAuthor(Author addauthor)
    {
        try
        {
            String INSERT_CONTACT = "INSERT INTO Szerzo(szul_datum, nev) VALUES(?,?)";
            Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt = conn.prepareStatement(INSERT_CONTACT, Statement.RETURN_GENERATED_KEYS);
            stmt.setDate(1,addauthor.getBirth_date());
            stmt.setString(2, addauthor.getName());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating product failed, no rows affected.");
            }
        }

        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean addGenre(Genre addgenre)
    {
        try
        {
            String INSERT_CONTACT = "INSERT INTO Mufaj(almufaj, mufaj) VALUES(?,?)";
            Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt = conn.prepareStatement(INSERT_CONTACT, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, addgenre.getSubgenre());
            stmt.setString(2, addgenre.getGenrename());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating product failed, no rows affected.");
            }
        }

        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean addStore(Store addstore)
    {
        try
        {
            String INSERT_CONTACT = "INSERT INTO Aruhaz(email, nev, cim) VALUES(?,?,?)";
            Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt = conn.prepareStatement(INSERT_CONTACT, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, addstore.getEmail());
            stmt.setString(2, addstore.getName());
            stmt.setString(3, addstore.getAddress());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating product failed, no rows affected.");
            }
        }

        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean addProductAuth(ProductAuthor pauthor)
    {
        try
        {
            String INSERT_CONTACT = "INSERT INTO Szerzoje(id, nev, szul_datum) VALUES(?,?,?)";
            Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt = conn.prepareStatement(INSERT_CONTACT, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, pauthor.getId());
            stmt.setString(2, pauthor.getName());
            stmt.setDate(3, pauthor.getBirth_date());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating product failed, no rows affected.");
            }
        }

        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean addOrder(Order addorder)
    {
        try
        {
            String INSERT_CONTACT = "INSERT INTO Megrendel(id, f_email, a_email, mikor, mennyit, hazhozszallitas) VALUES(?, ?, ?, ?, ?, ?)";
            Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt = conn.prepareStatement(INSERT_CONTACT, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, addorder.getId());
            stmt.setString(2, addorder.getUser_email());
            stmt.setString(3, addorder.getStore_email());
            stmt.setDate(4, addorder.getWhen());
            stmt.setInt(5, addorder.getQuantity());
            stmt.setBoolean(6, addorder.isOrdertype());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating product failed, no rows affected.");
            }

        }

        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean addOnStock(OnStock onStock)
    {
        try
        {
            String INSERT_CONTACT = "INSERT INTO Keszleten(id, a_email, mennyi) VALUES(?,?,?)";
            Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt = conn.prepareStatement(INSERT_CONTACT, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, onStock.getId());
            stmt.setString(2, onStock.getStore_email());
            stmt.setInt(3, onStock.getQuantity());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating product failed, no rows affected.");
            }
        }

        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean addProductGenre(ProductGenre progenre)
    {
        try
        {
            String INSERT_CONTACT = "INSERT INTO Mufaja(id, almufaj) VALUES(?,?)";
            Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt = conn.prepareStatement(INSERT_CONTACT, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, progenre.getId());
            stmt.setString(2, progenre.getSubgenre());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating product failed, no rows affected.");
            }
        }

        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    public void deleteProduct(Product product)
    {
        String DELETE_PRODUCT = "DELETE FROM Termek WHERE id=?";
        try(Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt = conn.prepareStatement(DELETE_PRODUCT, Statement.RETURN_GENERATED_KEYS);
        ) {
            stmt.setInt(1, product.getId());
            stmt.executeUpdate();

        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }

    }

    public void deleteAuthor(Author author)
    {
        String DELETE_PRODUCT = "DELETE FROM Szerzo WHERE nev=? and szul_datum=?";
        try(Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt = conn.prepareStatement(DELETE_PRODUCT, Statement.RETURN_GENERATED_KEYS);
        ) {
            stmt.setString(1, author.getName());
            stmt.setDate(2, author.getBirth_date());
            stmt.executeUpdate();

        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }

    }

    public void deleteUser(User user1)
    {
        String DELETE_PRODUCT = "DELETE FROM Felhasznalo WHERE email=?";
        try(Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt = conn.prepareStatement(DELETE_PRODUCT, Statement.RETURN_GENERATED_KEYS);
        ) {
            stmt.setString(1, user1.getEmail());
            stmt.executeUpdate();

        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }

    }

    public void deleteGenre(Genre genre)
    {
        String DELETE_PRODUCT = "DELETE FROM Mufaj WHERE almufaj=?";
        try(Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt = conn.prepareStatement(DELETE_PRODUCT, Statement.RETURN_GENERATED_KEYS);
        ) {
            stmt.setString(1, genre.getSubgenre());
            stmt.executeUpdate();

        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }

    }

    public void deleteStore(Store store)
    {
        String DELETE_PRODUCT = "DELETE FROM Aruhaz WHERE email=?";
        try(Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt = conn.prepareStatement(DELETE_PRODUCT, Statement.RETURN_GENERATED_KEYS);
        ) {
            stmt.setString(1, store.getEmail());
            stmt.executeUpdate();

        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }

    }

    public void deleteProductAuthor(ProductAuthor productAuthor)
    {
        String DELETE_PRODUCT = "DELETE FROM Szerzoje WHERE id=? and nev=? and szul_datum=?";
        try(Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt = conn.prepareStatement(DELETE_PRODUCT, Statement.RETURN_GENERATED_KEYS);
        ) {
            stmt.setInt(1, productAuthor.getId());
            stmt.setString(2,productAuthor.getName());
            stmt.setDate(3,productAuthor.getBirth_date());
            stmt.executeUpdate();

        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }

    }

    public void deleteProductGenre(ProductGenre productGenre)
    {
        String DELETE_PRODUCT = "DELETE FROM Mufaja WHERE id=? and almufaj=?";
        try(Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt = conn.prepareStatement(DELETE_PRODUCT, Statement.RETURN_GENERATED_KEYS);
        ) {
            stmt.setInt(1,productGenre.getId());
            stmt.setString(2,productGenre.getSubgenre());
            stmt.executeUpdate();

        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }

    }

    public void deleteOrder(Order order)
    {
        String DELETE_PRODUCT = "DELETE FROM Megrendel WHERE id=? and f_email=? and a_email=? and mikor=?";
        try(Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt = conn.prepareStatement(DELETE_PRODUCT, Statement.RETURN_GENERATED_KEYS);
        ) {
            stmt.setInt(1,order.getId());
            stmt.setString(2,order.getUser_email());
            stmt.setString(3,order.getStore_email());
            stmt.setDate(4,order.getWhen());
            stmt.executeUpdate();

        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }

    }

    public void deleteStock(OnStock onStock)
    {
        String DELETE_PRODUCT = "DELETE FROM Keszleten WHERE id=? and a_email=?";
        try(Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt = conn.prepareStatement(DELETE_PRODUCT, Statement.RETURN_GENERATED_KEYS);
        ) {
            stmt.setInt(1,onStock.getId());
            stmt.setString(2,onStock.getStore_email());
            stmt.executeUpdate();

        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }

    }


}