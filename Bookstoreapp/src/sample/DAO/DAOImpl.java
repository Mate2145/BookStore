package sample.DAO;

import sample.model.*;
import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class DAOImpl {
    private ResultSet rs;
    private Statement stmt;
    private OracleDataSource ods;
    final private String user = "system";
    final private String pass = "oracle";

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
        try {
            Connection conn = ods.getConnection(user, pass);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM termek";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Product product = new Product(rs.getInt(1), rs.getString(2),
                        rs.getInt(3), rs.getBoolean(4), rs.getString(5), rs.getDate(6));
                productList.add(product);
            }

        } catch (Exception ex) {
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
            String sql = "SELECT * FROM zene";
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
            String sql = "SELECT * FROM szerzo";
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
            String sql = "SELECT * FROM felhasznalo";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                User user1 = new User(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),rs.getInt(6),rs.getDate(7), rs.getBoolean(8),rs.getBoolean(9));
                productList.add(user1);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //getOnStorage(bookLists);
        return productList;
    }
//
//    public List<String> getCategories() {
//        List<String> categories = new ArrayList<>();
//        try {
//            Connection conn = ods.getConnection(user, pass);
//            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            String sql = "SELECT nev FROM Kategoria";
//            rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                categories.add(rs.getString(1));
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        Collections.sort(categories);
//        return categories;
//    }
//
//    public int getCategoryAVG(String category) {
//        int avg = 0;
//        try {
//            Connection conn = ods.getConnection(user, pass);
//            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            String sql = "SELECT AVG(Konyv.ar) FROM Konyv, Kategoria, tartozik WHERE kategoria.id = tartozik.kategoria_id AND tartozik.konyv_isbn = konyv.isbn AND kategoria.nev = '" + category + "'";
//            rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                avg = rs.getInt(1);
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return avg;
//    }
//
//    public List<PublisherMax> getPublisherMaxPrice() {
//        List<PublisherMax> publisherMaxList = new ArrayList<>();
//        try {
//            Connection conn = ods.getConnection(user, pass);
//            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            String sql = "SELECT kiado.id, kiado.nev, konyv.cim, MAX(konyv.ar) FROM konyv, kiado WHERE konyv.kiado_id = kiado.id GROUP BY konyv.cim, kiado.id, kiado.nev";
//            rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                PublisherMax publisherMax = new PublisherMax(rs.getInt(1),
//                        rs.getString(2), rs.getString(3), rs.getInt(4));
//                publisherMaxList.add(publisherMax);
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return publisherMaxList;
//    }
//
//    public List<Toplist> getToplist() {
//        List<Toplist> toplists = new ArrayList<>();
//        try {
//            Connection conn = ods.getConnection(user, pass);
//            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            String sql = "SELECT szerzo.nev, konyv.cim, COUNT(rendeles.id) as darab FROM szerzo, konyv, rendeles, tartalmazza, irta WHERE szerzo.id = irta.szerzo_id AND irta.konyv_isbn = konyv.isbn AND konyv.isbn = tartalmazza.konyv_isbn AND tartalmazza.rendeles_id = rendeles.id GROUP BY konyv.cim, szerzo.nev ORDER BY darab DESC";
//            rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                Toplist toplist = new Toplist(rs.getString(1), rs.getString(2),
//                        rs.getInt(3));
//                toplists.add(toplist);
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return toplists;
//    }
//
//    public List<CategoryBook> getCategoryBooks() {
//        List<CategoryBook> categoryBooks = new ArrayList<>();
//        try {
//            Connection conn = ods.getConnection(user, pass);
//            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            String sql = "SELECT kategoria.nev, COUNT(konyv.isbn) as darab FROM kategoria, konyv, tartozik WHERE kategoria.id = tartozik.kategoria_id AND tartozik.konyv_isbn = konyv.isbn GROUP BY kategoria.nev ORDER BY darab DESC";
//            rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                CategoryBook categoryBook = new CategoryBook(rs.getString(1), rs.getInt(2));
//                categoryBooks.add(categoryBook);
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return categoryBooks;
//    }

}