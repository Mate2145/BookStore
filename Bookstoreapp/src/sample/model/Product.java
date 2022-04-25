package sample.model;


import java.sql.Date;
import java.sql.Timestamp;

public class Product {
    private int id;
    private String name;
    private int price;
    private boolean electronical;
    private String publisher;
    private Date input_time;


    public Product(int id, String name, int price, boolean electronical, String publisher, Date input_time) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.electronical = electronical;
        this.publisher = publisher;
        this.input_time = input_time;
    }

    public Product(String name, int price, boolean electronical, String publisher, Date input_time) {
        this.name = name;
        this.price = price;
        this.electronical = electronical;
        this.publisher = publisher;
        this.input_time = input_time;
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

    public Date getInput_time() {
        return input_time;
    }

    public void setInput_time(Date input_time) {
        this.input_time = input_time;
    }
}
