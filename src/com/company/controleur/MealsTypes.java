package com.company.controleur;

public class MealsTypes {

	private int id, meal_id, type_id, prix;

	public MealsTypes(int id, int meal_id, int type_id, int prix){
		this.id = id;
		this.meal_id = meal_id;
		this.type_id = type_id;
		this.prix = prix;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMeal_id() {
		return meal_id;
	}

	public void setMeal_id(int meal_id) {
		this.meal_id = meal_id;
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}


}
