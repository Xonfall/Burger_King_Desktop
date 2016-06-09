package com.company.controleur;


import com.company.modele.*;

public class MealLines {
    private int id, mealsProducts_id, meal_type_id, qte, order_id;

    public MealLines() {
        this.id = 0;
        this.mealsProducts_id = 0;
        this.meal_type_id = 0;
        this.qte = 0;
        this.order_id = 0;
    }

    public MealLines(int id, int mealsProducts_id, int meal_type_id, int qte, int order_id) {
        this.id = id;
        this.mealsProducts_id = mealsProducts_id;
        this.meal_type_id = meal_type_id;
        this.qte = qte;
        this.order_id = order_id;
    }
    
    public String toString(){
    	String chaine = "";
    	MealsProducts mealsProducts = ModeleMealsProducts.select(this.mealsProducts_id);
    	Meal meal = ModeleMeal.select(mealsProducts.getMeal_id());
    	Product accompagnement = ModeleProduct.select(mealsProducts.getAccompagnement_id());
    	Product boisson = ModeleProduct.select(mealsProducts.getBoisson_id());
    	MealsTypes mealtype = ModeleMealsTypes.select(this.meal_type_id);
    	Types type = ModeleTypes.select(mealtype.getType_id());
    	chaine += this.qte + " x " + meal.getNom() + " (taille " + type.getNom() + " :" + "\r\n\t" + "- " + accompagnement.getNom() + "\r\n\t" + "- " + boisson.getNom();
    	return chaine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMeal_id() {
        return mealsProducts_id;
    }

    public void setMeal_id(int meal_id) {
        this.mealsProducts_id = meal_id;
    }

    public int getMeal_type_id() {
        return meal_type_id;
    }

    public void setMeal_type_id(int meal_type_id) {
        this.meal_type_id = meal_type_id;
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
