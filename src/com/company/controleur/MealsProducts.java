package com.company.controleur;

public class MealsProducts {
    private int id, meal_id, accompagnement_id, boisson_id;

    public MealsProducts() {
        this.id = 0;
        this.meal_id = 0;
        this.accompagnement_id = 0;
        this.boisson_id = 0;
    }

    public MealsProducts(int id, int meal_id, int accompagnement_id, int boisson_id) {
        this.id = id;
        this.meal_id = meal_id;
        this.accompagnement_id = accompagnement_id;
        this.boisson_id = boisson_id;
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

    public int getAccompagnement_id() {
        return accompagnement_id;
    }

    public void setAccompagnement_id(int accompagnement_id) {
        this.accompagnement_id = accompagnement_id;
    }

    public int getBoisson_id() {
        return boisson_id;
    }

    public void setBoisson_id(int boisson_id) {
        this.boisson_id = boisson_id;
    }
}
