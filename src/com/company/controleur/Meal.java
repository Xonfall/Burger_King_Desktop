package com.company.controleur;

public class Meal {

	private String nom, description, image;
	private int id;
	
	public Meal(int id, String nom, String description, String image){
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.image = image;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}