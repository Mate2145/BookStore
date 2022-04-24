package sample.model;

import java.sql.Date;

public class User {
    private String email;
    private String username;
    private String pass;
    private String fullname;
    private String address;
    private int balance;
    private Date login_date;
    private boolean admin;
    private boolean freqbuyer;


    public User(String email, String username, String pass, String fullname, String address, int balance, Date login_date, boolean admin, boolean freqbuyer) {
        this.email = email;
        this.username = username;
        this.pass = pass;
        this.fullname = fullname;
        this.address = address;
        this.balance = balance;
        this.login_date = login_date;
        this.admin = admin;
        this.freqbuyer = freqbuyer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isFreqbuyer() {
        return freqbuyer;
    }

    public void setFreqbuyer(boolean freqbuyer) {
        this.freqbuyer = freqbuyer;
    }

    public Date getLogin_date() {
        return login_date;
    }

    public void setLogin_date(Date login_date) {
        this.login_date = login_date;
    }
}
