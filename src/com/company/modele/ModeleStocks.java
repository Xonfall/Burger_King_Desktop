package com.company.modele;

import com.company.controleur.Stocks;
import com.company.controleur.User;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class ModeleStocks {

/*    public static Stocks select(int id) {
        String requete = "SELECT * FROM stocks "
                +"WHERE id = '" + id + "'";
        Stocks unStocks = null;
        BDD uneBDD = new BDD("127.0.0.1", "cake_burgerking", "root", "");
        try {
            uneBDD.seConnecter();
            Statement unStat = uneBDD.getMaConnection().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);

            unRes.next();
            id = unRes.getInt("id");
            int product_id = unRes.getInt("product_id");
            int restaurant_id = unRes.getInt("restaurant_id");
            int qte = unRes.getInt("qte");
            unStocks = new Stocks(id, product_id, restaurant_id, qte);

            unStat.close();
            uneBDD.seDeconnecter();
        }
        catch(SQLException exp) {
            JOptionPane.showMessageDialog(null, "requete : " + requete, "Error", JOptionPane.OK_OPTION);
        }
        return unStocks;
    }*/

    public static LinkedList<Stocks> selectAll(User user) {
        LinkedList<Stocks> uneListe = new LinkedList<>();
        String requete = "SELECT * FROM stocks where restaurant_id ='"+ user.getRestaurant_id() +"';";
        Stocks unStocks = null;
        BDD uneBDD = new BDD("127.0.0.1", "cake_burgerking", "root", "");
        try {
            uneBDD.seConnecter();
            Statement unStat = uneBDD.getMaConnection().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            while(unRes.next()) {
                int id = unRes.getInt("id");
                int product_id = unRes.getInt("product_id");
                int restaurant_id = unRes.getInt("restaurant_id");
                int qte = unRes.getInt("qte");
                unStocks = new Stocks(id, product_id, restaurant_id, qte);
                uneListe.add(unStocks);
            }
            unStat.close();
            uneBDD.seDeconnecter();
        }
        catch(SQLException exp) {
            JOptionPane.showMessageDialog(null, "requete : " + requete, "Error", JOptionPane.OK_OPTION);
        }
        return uneListe;
    }

    public static void edit(int id_restaurant, int id_produit, int qte) {
        String requete = "UPDATE stocks SET qte = '" + qte + "'"
                +" WHERE product_id = '" + id_produit + "' AND restaurant_id = '" + id_restaurant + "'";
        System.out.println(requete);
        BDD uneBDD = new BDD("127.0.0.1", "cake_burgerKing", "root", "");
        try {
            uneBDD.seConnecter();
            Statement unStat = uneBDD.getMaConnection().createStatement();
            unStat.execute(requete);
            unStat.close();
            uneBDD.seDeconnecter();

        }
        catch(SQLException exp) {
            JOptionPane.showMessageDialog(null, "requete : " + requete, "Error", JOptionPane.OK_OPTION);
        }
    }
}
