package sample.DAO;

import sample.model.*;
import oracle.jdbc.pool.OracleDataSource;

import java.sql.*;
import java.util.*;

public class DAOImpl {

    private ResultSet rs;
    private Statement stmt;
    private OracleDataSource ods;
    final private String user = "TEST";
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
            Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt =  conn.prepareStatement(INSERT_CONTACT);

            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getPrice());
            stmt.setInt(3, product.isElectronical() ? 1 : 0);
            stmt.setString(4, product.getPublisher());

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
    public boolean updateStore(Store updateStore){
        try
        {
            String UPDATE_CONTACT = "UPDATE Aruhaz SET nev = ? ,cim = ? WHERE email = ?";
            Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt = conn.prepareStatement(UPDATE_CONTACT);
            stmt.setString(1, updateStore.getName());
            stmt.setString(2, updateStore.getAddress());
            stmt.setString(3,updateStore.getEmail());

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

    public void updateUser(User adduser)
    {
        String DELETE_PRODUCT = "UPDATE Felhasznalo SET felhasznalonev=?,jelszo=?,teljes_nev=?,lakcim=?,egyenleg=? WHERE email=?";
        try(Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt = conn.prepareStatement(DELETE_PRODUCT, Statement.RETURN_GENERATED_KEYS);
        ) {
            stmt.setString(1, adduser.getUsername());
            stmt.setString(2, adduser.getPass());
            stmt.setString(3, adduser.getFullname());
            stmt.setString(4, adduser.getAddress());
            stmt.setInt(5, adduser.getBalance());
            stmt.setString(6, adduser.getEmail());
            stmt.executeUpdate();

        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }

    }

    public void updateStock(OnStock onStock)
    {
        String UPDATE = "UPDATE Keszleten SET mennyi=? WHERE id=? and a_email=?";
        try(Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt = conn.prepareStatement(UPDATE);
        ) {
            stmt.setInt(1, onStock.getQuantity());
            stmt.setInt(2, onStock.getId());
            stmt.setString(3, onStock.getStore_email());
            stmt.executeUpdate();

        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }

    }

    public void updateProduct(Product product)
    {
        try
        {
            String UPDATE_CONTACT = "UPDATE Termek SET nev=?, ar=?, kiado=? WHERE id=?";
            Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt =  conn.prepareStatement(UPDATE_CONTACT);
            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getPrice());
            stmt.setString(3, product.getPublisher());
            stmt.setInt(4,product.getId());

            stmt.executeUpdate();

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public boolean updateGenre(Genre addgenre)
    {
        try
        {
            String INSERT_CONTACT = "UPDATE Mufaj SET mufaj=? WHERE almufaj=?";
            Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt = conn.prepareStatement(INSERT_CONTACT, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(2, addgenre.getSubgenre());
            stmt.setString(1, addgenre.getGenrename());

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

    public List<Select1> getSelect1()
    {
        List<Select1> genreList = new ArrayList<>();
        try
        {
            Connection conn = ods.getConnection(user, pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT Mufaj.mufaj, COUNT(Termek.id) AS mennyi FROM Termek\n" +
            "INNER JOIN Mufaja ON Termek.id = Mufaja.id\n" +
            "INNER JOIN Mufaj ON Mufaja.almufaj = Mufaj.almufaj\n" +
            "GROUP BY Mufaj.mufaj";
            rs = stmt.executeQuery(sql);
            while (rs.next())
            {
                Select1 genre = new Select1(rs.getString(1),rs.getInt(2));
                genreList.add(genre);
            }

        } catch (Exception ex)
        {
            System.out.println("Bajom van");
            ex.printStackTrace();
        }
        return genreList;
    }

    public List<Select2> getSelect2()
    {
        List<Select2> productList = new ArrayList<>();
        try
        {
            Connection conn = ods.getConnection(user, pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT Termek.nev, TO_CHAR(Termek.beviteli_ido, 'YYYY-MM-DD') AS mikor, Mufaj.mufaj FROM Termek\n"+
            "INNER JOIN Mufaja ON Termek.id = Mufaja.id\n"+
            "INNER JOIN Mufaj ON Mufaja.almufaj = Mufaj.almufaj\n"+
            "WHERE(Termek.beviteli_ido, Mufaj.mufaj) IN\n"+
                "(SELECT MAX(Termek.beviteli_ido), Mufaj.mufaj FROM Termek\n"+
                        "INNER JOIN Mufaja ON Termek.id = Mufaja.id\n"+
                        "INNER JOIN Mufaj ON Mufaja.almufaj = Mufaj.almufaj\n"+
                        "GROUP BY Mufaj.mufaj)\n"+
            "ORDER BY mikor DESC";
            rs = stmt.executeQuery(sql);
            while (rs.next())
            {
                Select2 genre = new Select2(rs.getString(1),rs.getString(2), rs.getString(3));
                productList.add(genre);
            }

        } catch (Exception ex)
        {
            System.out.println("Bajom van");
            ex.printStackTrace();
        }
        return productList;
    }

    public List<Select3> getSelect3()
    {
        List<Select3> genreList = new ArrayList<>();
        try
        {
            Connection conn = ods.getConnection(user, pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT Termek.nev, Mufaj.mufaj, y_db FROM Termek\n"+
            "INNER JOIN Mufaja ON Termek.id = Mufaja.id\n"+
            "INNER JOIN Mufaj ON Mufaja.almufaj = Mufaj.almufaj\n"+
            "INNER JOIN (SELECT id AS y_id, SUM(mennyit) AS y_db FROM Megrendel GROUP BY id) ON Termek.id = y_id\n"+
            "WHERE (Mufaj.mufaj, y_db) IN\n"+
                "(SELECT Mufaj.mufaj as x_muf, MAX(s_db) as x_db FROM Mufaj INNER JOIN Mufaja ON Mufaj.almufaj = Mufaja.almufaj\n"+
                        "INNER JOIN (SELECT id AS s_id, SUM(mennyit) AS s_db FROM Megrendel GROUP BY id) ON Mufaja.id = s_id\n"+
                        "GROUP BY Mufaj.mufaj) ORDER BY y_db DESC";

            rs = stmt.executeQuery(sql);
            while (rs.next())
            {
                Select3 genre = new Select3(rs.getString(1),rs.getString(2), rs.getInt(3));
                genreList.add(genre);
            }

        } catch (Exception ex)
        {
            System.out.println("Bajom van");
            ex.printStackTrace();
        }
        return genreList;
    }

    public List<Select4> getSelect4()
    {
        List<Select4> productList = new ArrayList<>();
        try
        {
            Connection conn = ods.getConnection(user, pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "    SELECT Termek.nev, s_id, s_db FROM Termek\n" +
                    "    INNER JOIN\n" +
                    "    (SELECT * FROM (SELECT id AS s_id, SUM(mennyit) AS s_db FROM Megrendel \n" +
                    "    WHERE SYSDATE - CAST(Megrendel.mikor AS DATE)< 31\n" +
                    "    GROUP BY  id ORDER BY s_db DESC) WHERE ROWNUM <= 3) ON Termek.id = s_id\n" +
                    "    ORDER BY s_db DESC";
            rs = stmt.executeQuery(sql);
            while (rs.next())
            {
                Select4 product = new Select4(rs.getString(1),rs.getInt(2),rs.getInt(3));
                productList.add(product);
            }

        } catch (Exception ex)
        {
            System.out.println("Bajom van");
            ex.printStackTrace();
        }
        return productList;
    }

    public List<Select5> getSelect5()
    {
        List<Select5> productList = new ArrayList<>();
        try
        {
            Connection conn = ods.getConnection(user, pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT Aruhaz.nev, s_count as \"Megrendelések szama\" FROM Aruhaz\n" +
                    "INNER JOIN \n" +
                    "(SELECT Aruhaz.email as s_email,COUNT(*) as s_count FROM Aruhaz\n" +
                    "INNER JOIN Megrendel ON Aruhaz.email = Megrendel.a_email\n" +
                    "Group BY Aruhaz.email) ON Aruhaz.email = s_email";
            rs = stmt.executeQuery(sql);
            while (rs.next())
            {
                Select5 product = new Select5(rs.getString(1),rs.getInt(2));
                productList.add(product);
            }

        } catch (Exception ex)
        {
            System.out.println("Bajom van");
            ex.printStackTrace();
        }
        return productList;
    }

    public List<Select9> getSelect9()
    {
        List<Select9> list = new ArrayList<>();
        try
        {
            Connection conn = ods.getConnection(user, pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT Termek.nev FROM Termek INNER JOIN (SELECT id as s_id, COUNT(*) FROM Megrendel GROUP BY id HAVING COUNT(*) >= 2) ON Termek.id = s_id";
            rs = stmt.executeQuery(sql);
            while (rs.next())
            {
                Select9 product = new Select9(rs.getString(1));
                list.add(product);
            }

        } catch (Exception ex)
        {
            System.out.println("Bajom van");
            ex.printStackTrace();
        }
        return list;
    }

    public List<Select6> getSelect6()
    {
        List<Select6> list = new ArrayList<>();
        try
        {
            Connection conn = ods.getConnection(user, pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT Termek.nev, s_count as \"Alműfajok száma\" FROM Termek\n" +
                    "\tINNER JOIN \n" +
                    "\t(SELECT id as s_id, COUNT(*) as s_count FROM Mufaja GROUP BY id) \n" +
                    "\tON Termek.id = s_id \n" +
                    "\tWHERE s_count >= 2;";
            rs = stmt.executeQuery(sql);
            while (rs.next())
            {
                Select6 product = new Select6(rs.getString(1),rs.getInt(2));
                list.add(product);
            }

        } catch (Exception ex)
        {
            System.out.println("Bajom van");
            ex.printStackTrace();
        }
        return list;
    }


    public List<Select7> getSelect7()
    {
        List<Select7> list = new ArrayList<>();
        try
        {
            Connection conn = ods.getConnection(user, pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT Termek.nev, s_count as \"Szerzők száma\" FROM Termek\n" +
                    "\tINNER JOIN \n" +
                    "\t(SELECT id as s_id, COUNT(*) as s_count FROM Szerzoje GROUP BY id) \n" +
                    "\tON Termek.id = s_id \n" +
                    "\tWHERE s_count >= 2;";
            rs = stmt.executeQuery(sql);
            while (rs.next())
            {
                Select7 product = new Select7(rs.getString(1),rs.getInt(2));
                list.add(product);
            }

        } catch (Exception ex)
        {
            System.out.println("Bajom van");
            ex.printStackTrace();
        }
        return list;
    }


    public List<Select8> getSelect8()
    {
        List<Select8> list = new ArrayList<>();
        try
        {
            Connection conn = ods.getConnection(user, pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT s_nev FROM Konyv INNER JOIN \n" +
                    "\t(SELECT id AS s_id, nev as s_nev FROM Termek \n" +
                    "\tWHERE EXISTS (SELECT id, COUNT(*) AS s_count FROM Keszleten \n" +
                    "\tGROUP BY id HAVING COUNT(*) > 1)) \n" +
                    "\tON Konyv.id = s_id;";
            rs = stmt.executeQuery(sql);
            while (rs.next())
            {
                Select8 product = new Select8(rs.getString(1));
                list.add(product);
            }

        } catch (Exception ex)
        {
            System.out.println("Bajom van");
            ex.printStackTrace();
        }
        return list;
    }








}