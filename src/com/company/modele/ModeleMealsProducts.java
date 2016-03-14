package com.company.modele;


import com.company.controleur.MealsProducts;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModeleMealsProducts {
    public static MealsProducts select(int id) {
        String requete = "SELECT * FROM meals_products "
                +"WHERE id = '" + id + "'";
        MealsProducts unMealsProducts = null;
        BDD uneBDD = new BDD("127.0.0.1", "cake_burgerking", "root", "");
        try {
            uneBDD.seConnecter();
            Statement unStat = uneBDD.getMaConnection().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);

            unRes.next();
            int meal_id = unRes.getInt("meal_id");
            int accompagnement_id = unRes.getInt("accompagnement_id");
            int boisson_id = unRes.getInt("boisson_id");
            unMealsProducts = new MealsProducts(id, meal_id, accompagnement_id, boisson_id);

            unStat.close();
            uneBDD.seDeconnecter();
        }
        catch(SQLException exp) {
            JOptionPane.showMessageDialog(null, "requete : " + requete, "Error", JOptionPane.OK_OPTION);
        }
        return unMealsProducts;
    }
}
