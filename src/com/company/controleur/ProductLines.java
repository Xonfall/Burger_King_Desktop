package com.company.controleur;

public class ProductLines {
    private int id, product_id, qte, order_id;

    public ProductLines() {
        this.id = 0;
        this.product_id = 0;
        this.qte = 0;
        this.order_id = 0;
    }

    public ProductLines(int id, int product_id, int qte, int order_id) {
        this.id = id;
        this.product_id = product_id;
        this.qte = qte;
        this.order_id = order_id;
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

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
}
