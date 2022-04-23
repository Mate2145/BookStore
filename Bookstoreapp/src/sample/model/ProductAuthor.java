package sample.model;

import oracle.sql.DATE;

public class ProductAuthor {
    private int id;
    private String name;
    private DATE birth_date;

    public ProductAuthor(int id, String name, DATE birth_date) {
        this.id = id;
        this.name = name;
        this.birth_date = birth_date;
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

    public DATE getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(DATE birth_date) {
        this.birth_date = birth_date;
    }
}
