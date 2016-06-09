package com.company.modele;

import com.company.controleur.Types;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ModeleTypes {

	public static Types select(int id) {
        String requete = "SELECT * FROM types "
                +"WHERE id = '" + id + "'";
        Types unTypes = null;
        BDD uneBDD = new BDD("127.0.0.1", "cake_burgerking", "root", "");
        try {
            uneBDD.seConnecter();
            Statement unStat = uneBDD.getMaConnection().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);

            unRes.next();
            String nom = unRes.getString("nom");
            unTypes = new Types(id, nom);

            unStat.close();
            uneBDD.seDeconnecter();
        }
        catch(SQLException exp) {
            JOptionPane.showMessageDialog(null, "requete : " + requete, "Error", JOptionPane.OK_OPTION);
        }
        return unTypes;
    }
}
