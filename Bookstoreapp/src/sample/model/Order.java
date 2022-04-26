package sample.model;

import oracle.sql.TIMESTAMP;

import java.sql.Date;

public class Order {
    private int id;
    private String user_email;
    private String store_email;
    private Date when;
    private int quantity;
    private boolean ordertype;

    public Order(int id, String user_email, String store_email, Date when, int quantity,boolean ordertype) {
        this.id = id;
        this.user_email = user_email;
        this.store_email = store_email;
        this.when = when;
        this.quantity = quantity;
        this.ordertype = ordertype;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getStore_email() {
        return store_email;
    }

    public void setStore_email(String store_email) {
        this.store_email = store_email;
    }

    public Date getWhen() {
        return when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isOrdertype() {
        return ordertype;
    }

    public void setOrdertype(boolean ordertype) {
        this.ordertype = ordertype;
    }
}
