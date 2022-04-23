package sample.model;

public class ProductGenre {
    private int id;
    private String subgenre;

    public ProductGenre(int id, String subgenre) {
        this.id = id;
        this.subgenre = subgenre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubgenre() {
        return subgenre;
    }

    public void setSubgenre(String subgenre) {
        this.subgenre = subgenre;
    }
}
