package com.company.modele;

import com.company.controleur.Order;
import com.company.controleur.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class ModeleOrder {

	public static LinkedList<Order> selectAll(User user){
		String requete = "Select * from orders "
				+ "where active='1' and restaurant_id='" 
				+ user.getRestaurant_id() +"' ORDER BY date ASC ;";
        System.out.println(requete);
        BDD uneBDD = new BDD("localhost", "cake_burgerking", "root", "");
		Order uneOrder = null;
		LinkedList<Order> uneListe = new LinkedList<Order>();
		try
		{
			uneBDD.seConnecter();
			Statement unStat = uneBDD.getMaConnection().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			while(unRes.next()){
				int id = unRes.getInt("id");
				int town_id = unRes.getInt("town_id");
				int user_id = unRes.getInt("user_id");
				String cp = unRes.getString("cp");
				String adresse = unRes.getString("adresse");
				float prix = unRes.getFloat("prix");
				String date = unRes.getString("date");
				uneOrder = new Order(id, user.getRestaurant_id(), town_id, user_id, cp, adresse, prix, date, 1);
				uneListe.add(uneOrder);
			}
			uneBDD.seDeconnecter();
		}
		catch(SQLException exp){
			JOptionPane.showMessageDialog(null, "Requete : " + requete, "Erreur", JOptionPane.OK_OPTION);
		}
		return uneListe;
	}

	public static LinkedList<Order> selectInactivate(User user) {
        String requete = "Select * from orders where active = 0 and restaurant_id =" + user.getRestaurant_id();

        System.out.println(requete);
        BDD uneBDD = new BDD("localhost", "cake_burgerking", "root", "");
        Order uneOrder = null;
        LinkedList<Order> uneListe = new LinkedList<Order>();
        try
        {
            uneBDD.seConnecter();
            Statement unStat = uneBDD.getMaConnection().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            while(unRes.next()){
                int id = unRes.getInt("id");
                int town_id = unRes.getInt("town_id");
                int user_id = unRes.getInt("user_id");
                String cp = unRes.getString("cp");
                String adresse = unRes.getString("adresse");
                float prix = unRes.getFloat("prix");
                String date = unRes.getString("date");
                uneOrder = new Order(id, user.getRestaurant_id(), town_id, user_id, cp, adresse, prix, date, 0);
                uneListe.add(uneOrder);
            }
            uneBDD.seDeconnecter();
        }
        catch(SQLException exp){
            JOptionPane.showMessageDialog(null, "Requete : " + requete, "Erreur", JOptionPane.OK_OPTION);
        }
        return uneListe;
	}
	
	public static int inactivate(int id){
		String requete = "Update orders set active = '0' where id='" + id + "';";
        BDD uneBDD = new BDD("127.0.0.1", "cake_burgerking", "root", "");
		try
		{
			uneBDD.seConnecter();
			Statement unStat = uneBDD.getMaConnection().createStatement();
			unStat.execute(requete);
			uneBDD.seDeconnecter();
		}
		catch(SQLException exp){
			JOptionPane.showMessageDialog(null, "Requete : " + requete, "Erreur", JOptionPane.OK_OPTION);
		}
		return 0;
	}
}
