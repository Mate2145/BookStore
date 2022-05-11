package sample.model;

public class Select5 {
    String Storename;
    int counter;

    public Select5(String storename, int counter) {
        Storename = storename;
        this.counter = counter;
    }

    public String getStorename() {
        return Storename;
    }

    public void setStorename(String storename) {
        Storename = storename;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
