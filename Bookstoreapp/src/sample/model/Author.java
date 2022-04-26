package sample.model;

import java.sql.Date;

public class Author {
    private Date birth_date;
    private String name;

    public Author(Date birth_date, String name) {
        this.birth_date = birth_date;
        this.name = name;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + ":" + birth_date;
    }
}
