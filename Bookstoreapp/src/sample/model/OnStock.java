package sample.model;

public class OnStock {
    private int id;
    private String store_email;
    private int quantity;

    public OnStock(int id, String store_email, int quantity) {
        this.id = id;
        this.store_email = store_email;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStore_email() {
        return store_email;
    }

    public void setStore_email(String store_email) {
        this.store_email = store_email;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
