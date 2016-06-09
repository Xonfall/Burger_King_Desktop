package com.company.controleur;

public class Order {

	private String cp, adresse, date, ville;
	private int id, restaurant_id, user_id, active;
	private float prix;

    public Order() {

        this.id = 0;
        this.restaurant_id = 0;
        this.user_id = 0;
        this.prix = 0;
        this.active = 0;
        this.ville = "";
        this.cp = "";
        this.adresse = "";
        this.date = "";
    }
	
	public Order(int id, int restaurant_id, int user_id, String ville, String cp, String adresse, float prix, String date, int active){
		this.id = id;
		this.restaurant_id = restaurant_id;
		this.user_id = user_id;
		this.ville = ville;
		this.cp = cp;
		this.adresse = adresse;
		this.prix = prix;
		this.date = date;
		this.active = active;
	}

	
    public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
}
