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
    final private String user = "ADAM";
    final private String pass = "adam";

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
        //getOnStorage(bookLists);
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
                System.out.println(rs.getInt("EGYENLEG"));
                User user1 = new User(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),rs.getInt(6),rs.getBoolean("TORZSVASARLO"));
                productList.add(user1);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //getOnStorage(bookLists);
        return productList;
    }
    public boolean AddUser(User adduser)
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
        }

        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

}