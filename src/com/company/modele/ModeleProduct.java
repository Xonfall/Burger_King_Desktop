package com.company.modele;

import com.company.controleur.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ModeleProduct {

	public static Product select(int id){
		String requete = "Select * from products "
				+ "where id='" + id
				+"';";
		BDD uneBDD = new BDD("localhost", "cake_burgerking", "root", "");
		Product unProduct = null;
		try
		{
			uneBDD.seConnecter();
			Statement unStat = uneBDD.getMaConnection().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			unRes.next();
			int category_id = unRes.getInt("category_id");
			String nom = unRes.getString("nom");
			String description = unRes.getString("description");
			float prix = unRes.getFloat("prix");
			String image = unRes.getString("image");
			unProduct = new Product(id,  category_id, nom, description, prix, image);
			uneBDD.seDeconnecter();
		}
		catch(SQLException exp){
			JOptionPane.showMessageDialog(null, "Requete : " + requete, "Erreur", JOptionPane.OK_OPTION);
		}
		return unProduct;
	}

}
