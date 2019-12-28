package com.example.foodforme.LoginSignup.users;

public class ClientUser {
    private String fname;
    private String lname;
    private String email;
    private String password;
    private boolean isAdmin = false;

    public ClientUser(String fname, String lname, String email, String password) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
    public boolean isAdmin() {
        return isAdmin;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLname() {
        return lname;
    }

    public String getFname() {
        return fname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
