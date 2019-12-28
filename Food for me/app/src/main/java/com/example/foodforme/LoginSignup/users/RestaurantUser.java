package com.example.foodforme.LoginSignup.users;

public class RestaurantUser {
    private String restaurantName;
    private String location;
    private String email;
    private String password;
    private boolean isAdmin = true;

    public RestaurantUser(String restaurantName, String location, String email, String password) {
        this.restaurantName = restaurantName;
        this.location = location;
        this.email = email;
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}