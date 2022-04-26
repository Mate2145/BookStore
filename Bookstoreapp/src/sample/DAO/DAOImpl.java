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
            String sql = "SELECT * FROM Termek";
            rs = stmt.executeQuery("SELECT * FROM Termek");
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
            String sql = "SELECT * FROM Zene";
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
            String sql = "SELECT * FROM zene";
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

    public User AddUser(User adduser)
    {
        try
        {
            String INSERT_CONTACT = "INSERT INTO Felhasznalo(email, felhasznalonev, jelszo, teljes_nev,lakcim,egyenleg,bejelentkezett) \n" +
                    "VALUES(?,?,?,?,?,?,?,?);";
            Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt = conn.prepareStatement(INSERT_CONTACT, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, adduser.getEmail());
            stmt.setString(2, adduser.getUsername());
            stmt.setString(3, adduser.getPass());
            stmt.setString(4, adduser.getFullname());
            stmt.setString(5, adduser.getAddress());
            stmt.setTimestamp(6,new Timestamp(System.currentTimeMillis()));

            int affectedRows = stmt.executeUpdate();
            if(affectedRows == 0)
            {
                return null;
            }


        }

        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return adduser;
    }

    public Product AddProduct(Product product)
    {
        try
        {
            String INSERT_CONTACT = "INSERT INTO Termek(nev, ar, elektronikus, kiado, beviteli_ido) VALUES(?,?, ?,?, TO_TIMESTAMP(?));";
            Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt = conn.prepareStatement(INSERT_CONTACT, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getPrice());
            stmt.setBoolean(3, product.isElectronical());
            stmt.setString(4, product.getPublisher());
            stmt.setTimestamp(5,new Timestamp(System.currentTimeMillis()));

            int affectedRows = stmt.executeUpdate();
            if(affectedRows == 0)
            {
                return null;
            }

            if(product.getId() <= 0) { // INSERT
                ResultSet genKeys = stmt.getGeneratedKeys();
                if (genKeys.next()) {
                    product.setId(genKeys.getInt(1));
                }
            }
        }

        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return product;
    }

    public boolean AddMusic(Music addmusic)
    {
        try
        {
            String INSERT_CONTACT = "INSERT INTO Zene(id, hossz) VALUES(?,?);";
            Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt = conn.prepareStatement(INSERT_CONTACT, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, addmusic.getId());
            stmt.setInt(2, addmusic.getLen());
        }

        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean AddMovie(Film addfilm)
    {
        try
        {
            String INSERT_CONTACT = "INSERT INTO Film(id, hossz) VALUES(?,?);";
            Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt = conn.prepareStatement(INSERT_CONTACT, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, addfilm.getId());
            stmt.setInt(2, addfilm.getLen());
        }

        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean AddBook(Book addbook)
    {
        try
        {
            String INSERT_CONTACT = "INSERT INTO Konyv(id, oldalszam) VALUES(?,?);";
            Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt = conn.prepareStatement(INSERT_CONTACT, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, addbook.getId());
            stmt.setInt(2, addbook.getLen());
        }

        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean AddAuthor(Author addauthor)
    {
        try
        {
            String INSERT_CONTACT = "INSERT INTO Szerzo(szul_datum, nev) VALUES(TO_DATE(?),?);";
            Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt = conn.prepareStatement(INSERT_CONTACT, Statement.RETURN_GENERATED_KEYS);
            stmt.setDate(1, addauthor.getBirth_date());
            stmt.setString(2, addauthor.getName());
        }

        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean AddGenre(Genre addgenre)
    {
        try
        {
            String INSERT_CONTACT = "INSERT INTO Mufaj(almufaj, mufaj) VALUES(?,?);";
            Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt = conn.prepareStatement(INSERT_CONTACT, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, addgenre.getSubgenre());
            stmt.setString(2, addgenre.getGenrename());
        }

        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean AddStore(Store addstore)
    {
        try
        {
            String INSERT_CONTACT = "INSERT INTO Aruhaz(email, nev, cim) VALUES(?,?,?);";
            Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt = conn.prepareStatement(INSERT_CONTACT, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, addstore.getEmail());
            stmt.setString(2, addstore.getName());
            stmt.setString(3, addstore.getAddress());
        }

        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean AddProductAuth(ProductAuthor pauthor)
    {
        try
        {
            String INSERT_CONTACT = "INSERT INTO Szerzoje(id, nev, szul_datum) VALUES(?,?, TO_DATE(?));";
            Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt = conn.prepareStatement(INSERT_CONTACT, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, pauthor.getId());
            stmt.setString(2, pauthor.getName());
            stmt.setDate(3, pauthor.getBirth_date());
        }

        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean AddOrder(Order addorder)
    {
        try
        {
            String INSERT_CONTACT = "INSERT INTO Megrendel(id, f_email, a_email, mikor, mennyit, hazhozszallitas) VALUES(?, ?,?, TO_TIMESTAMP(?), ?, ?);";
            Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt = conn.prepareStatement(INSERT_CONTACT, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, addorder.getId());
            stmt.setString(2, addorder.getUser_email());
            stmt.setString(3, addorder.getStore_email());
            stmt.setDate(4, addorder.getWhen());
            stmt.setInt(5, addorder.getQuantity());
            stmt.setBoolean(6, addorder.isOrdertype());

        }

        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean OnStock(OnStock onStock)
    {
        try
        {
            String INSERT_CONTACT = "INSERT INTO Keszleten(id, a_email, mennyi) VALUES(?,?,?);";
            Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt = conn.prepareStatement(INSERT_CONTACT, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, onStock.getId());
            stmt.setString(2, onStock.getStore_email());
            stmt.setInt(3, onStock.getQuantity());

        }

        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean AddProductGenre(ProductGenre progenre)
    {
        try
        {
            String INSERT_CONTACT = "INSERT INTO Mufaja(id, almufaj) VALUES(?,?);";
            Connection conn = ods.getConnection(user, pass);
            PreparedStatement stmt = conn.prepareStatement(INSERT_CONTACT, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, progenre.getId());
            stmt.setString(2, progenre.getSubgenre());

        }

        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }


}