package com.example.chenifargan_318941309;

public class Product {

    private String product = "";
    private String image = ""; // link
    private int duration = 0; // minutes
    private int rating = 0; // 0 - 100
    private boolean favorite = false;

    public Product() {

    }

    public String getProduct() {
        return product;
    }

    public Product setProduct(String product) {
        this.product = product;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Product setImage(String image) {
        this.image = image;
        return this;
    }

    public int getDuration() {
        return duration;
    }

    public Product setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    public int getRating() {
        return rating;
    }

    public Product setRating(int rating) {
        this.rating = rating;
        return this;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public Product setFavorite(boolean favorite) {
        this.favorite = favorite;
        return this;
    }
}
