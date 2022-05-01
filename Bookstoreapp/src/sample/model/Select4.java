package sample.model;

public class Select4
{
    String productname;
    int id;
    int counter;

    public Select4(String productname, int id, int counter) {
        this.productname = productname;
        this.id = id;
        this.counter = counter;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
