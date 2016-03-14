package com.company.modele;

import com.company.controleur.MealsTypes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ModeleMealsTypes {

	public static MealsTypes select(int id) {
        String requete = "SELECT * FROM meals_types "
                +"WHERE id = '" + id + "'";
        MealsTypes unMealsTypes = null;
        BDD uneBDD = new BDD("127.0.0.1", "cake_burgerking", "root", "");
        try {
            uneBDD.seConnecter();
            Statement unStat = uneBDD.getMaConnection().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);

            unRes.next();
            int meal_id = unRes.getInt("meal_id");
            int type_id = unRes.getInt("type_id");
            int prix = unRes.getInt("prix");
            unMealsTypes = new MealsTypes(id, meal_id, type_id, prix);

            unStat.close();
            uneBDD.seDeconnecter();
        }
        catch(SQLException exp) {
            JOptionPane.showMessageDialog(null, "requete : " + requete, "Error", JOptionPane.OK_OPTION);
        }
        return unMealsTypes;
    }
}
