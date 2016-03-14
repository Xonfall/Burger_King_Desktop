package com.company.controleur;

public class Stocks {
    private int id, product_id, restaurant_id, qte;

    public Stocks() {
        this.id = 0;
        this.product_id = 0;
        this.restaurant_id = 0;
        this.qte = 0;
    }

    public Stocks(int id, int product_id, int restaurant_id, int qte) {
        this.id = id;
        this.product_id = product_id;
        this.restaurant_id = restaurant_id;
        this.qte = qte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }
}
