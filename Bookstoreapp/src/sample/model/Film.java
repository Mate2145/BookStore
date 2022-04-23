package sample.model;

public class Film {
   private int id;
   private int len;

    public Film(int id, int len) {
        this.id = id;
        this.len = len;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }
}
