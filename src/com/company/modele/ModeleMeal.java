package com.company.modele;

import com.company.controleur.Meal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ModeleMeal {

	public static Meal select(int id){
		String requete = "Select * from meals "
				+ "where id='" + id
				+"';";
		BDD uneBDD = new BDD("localhost", "cake_burgerking", "root", "");
		Meal unMeal = null;
		try
		{
			uneBDD.seConnecter();
			Statement unStat = uneBDD.getMaConnection().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			unRes.next();
			String nom = unRes.getString("nom");
			String description = unRes.getString("description");
			String image = unRes.getString("image");
			unMeal = new Meal(id, nom, description, image);
			uneBDD.seDeconnecter();
		}
		catch(SQLException exp){
			JOptionPane.showMessageDialog(null, "Requete : " + requete, "Erreur", JOptionPane.OK_OPTION);
		}
		return unMeal;
	}

}
