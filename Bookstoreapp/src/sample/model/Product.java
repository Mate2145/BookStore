package sample.model;

public class Product {
    private int id;
    private String name;
    private int price;
    private boolean electronical;
    private String publisher;
    private String imageString;

    public Product(int id, String name, int price, boolean electronical, String publisher, String imageString) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.electronical = electronical;
        this.publisher = publisher;
        this.imageString = imageString;
    }

    public Product(String name, int price, boolean elektronical, String publisher, String imageString) {
        this.name = name;
        this.price = price;
        this.electronical = elektronical;
        this.publisher = publisher;
        this.imageString = imageString;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isElectronical() {
        return electronical;
    }

    public void setElectronical(boolean elektronical) {
        this.electronical = elektronical;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getImageString() {
        return imageString;
    }

    public void setImageString(String imageString) {
        this.imageString = imageString;
    }
}
