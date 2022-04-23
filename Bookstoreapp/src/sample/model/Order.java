package sample.model;

import oracle.sql.TIMESTAMP;

public class Order {
    private String id;
    private String user_email;
    private String store_email;
    private TIMESTAMP when;
    private int quantity;

    public Order(String id, String user_email, String store_email, TIMESTAMP when, int quantity) {
        this.id = id;
        this.user_email = user_email;
        this.store_email = store_email;
        this.when = when;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public TIMESTAMP getWhen() {
        return when;
    }

    public void setWhen(TIMESTAMP when) {
        this.when = when;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
