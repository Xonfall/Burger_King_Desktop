package com.company.modele;


import com.company.controleur.MealLines;
import com.company.controleur.Order;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class ModeleMealLines {
    public static LinkedList<MealLines> selectAll(Order order) {
        String requete = "SELECT * FROM meal_lines "
                +"WHERE order_id = '" + order.getId() + "'";
        LinkedList<MealLines> uneListe = new LinkedList<MealLines>();
        MealLines unMealLines = null;
        BDD uneBDD = new BDD("127.0.0.1", "cake_burgerking", "root", "");
        try {
            uneBDD.seConnecter();
            Statement unStat = uneBDD.getMaConnection().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);

            while(unRes.next()) {
                int id = unRes.getInt("id");
                int meal_id = unRes.getInt("meal_id");
                int meal_type_id = unRes.getInt("meal_type_id");
                int qte = unRes.getInt("qte");
                int order_id = unRes.getInt("order_id");
                unMealLines = new MealLines(id, meal_id, meal_type_id, qte, order_id);
                uneListe.add(unMealLines);
            }
            unStat.close();
            uneBDD.seDeconnecter();
        }
        catch(SQLException exp) {
            JOptionPane.showMessageDialog(null, "requete : " + requete, "Error", JOptionPane.OK_OPTION);
        }
        return uneListe;
    }
}
