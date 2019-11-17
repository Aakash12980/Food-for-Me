package com.example.foodie.Admin.Home.AdminHomeDataStructure;

public class FoodMenuData {
    private int foodImage;
    private String foodGenre;

    public FoodMenuData(int foodImage, String foodGenre) {
        this.foodImage = foodImage;
        this.foodGenre = foodGenre;
    }

    public int getFoodImage() {
        return foodImage;
    }

    public String getFoodGenre() {
        return foodGenre;
    }

    public void setFoodImage(int foodImage) {
        this.foodImage = foodImage;
    }

    public void setFoodGenre(String foodGenre) {
        this.foodGenre = foodGenre;
    }
}
