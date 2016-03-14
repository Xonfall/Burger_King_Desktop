package com.company.modele;


import com.company.controleur.Order;
import com.company.controleur.ProductLines;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class ModeleProductLines {
    public static LinkedList<ProductLines> selectAll(Order order) {
        String requete = "SELECT * FROM product_lines "
                +"WHERE order_id = '" + order.getId() + "'";
        LinkedList<ProductLines> uneListe = new LinkedList<ProductLines>();
        ProductLines unProductLines = null;
        BDD uneBDD = new BDD("127.0.0.1", "cake_burgerKing", "root", "");
        try {
            uneBDD.seConnecter();
            Statement unStat = uneBDD.getMaConnection().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);

            while(unRes.next()) {
                int id = unRes.getInt("id");
                int product_id = unRes.getInt("product_id");
                int qte = unRes.getInt("qte");
                int order_id = unRes.getInt("order_id");
                unProductLines = new ProductLines(id, product_id, qte, order_id);
                uneListe.add(unProductLines);
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
