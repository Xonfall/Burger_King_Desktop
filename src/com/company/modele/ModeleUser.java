package com.company.modele;

import com.company.controleur.User;

import javax.swing.JOptionPane;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModeleUser {

    public static User verifConnexion(String username, String password) {
        String requete = "SELECT * FROM users "
                +"WHERE `username` = '" + username
                +"' and `password` = '" + password + "';";
        BDD uneBDD = new BDD("127.0.0.1", "cake_burgerking", "root", "");
        User unUser = null;

        try {
            uneBDD.seConnecter();
            Statement unStat = uneBDD.getMaConnection().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            unRes.next();
            int id = unRes.getInt("id");
            String email = unRes.getString("email");
            String role = unRes.getString("role");
            String nom = unRes.getString("nom");
            String prenom = unRes.getString("prenom");
            String telephone = unRes.getString("telephone");
            String ville = unRes.getString("ville");
            String cp = unRes.getString("cp");
            String adresse = unRes.getString("adresse");
            String dateInscription = unRes.getString("dateInscription");
            int restaurant_id = unRes.getInt("restaurant_id");
            unUser= new User(id, username, email, password, role, nom, prenom, telephone, ville, cp, adresse,
                    dateInscription, restaurant_id);
            unStat.close();
            uneBDD.seDeconnecter();
        }
        catch(SQLException exp) {
            JOptionPane.showMessageDialog(null, "requete : " + requete, "Error", JOptionPane.OK_OPTION);
        }
        return unUser;
    }
}
