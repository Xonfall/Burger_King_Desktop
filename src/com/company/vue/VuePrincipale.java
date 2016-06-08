package com.company.vue;

import javax.swing.*;

import com.company.controleur.*;
import com.company.modele.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class VuePrincipale extends JFrame implements ActionListener {

    private static User user;

    private JPanel panelMenu = new JPanel();
    private JPanel panelLister = new JPanel();
    private JPanel panelListerStocks = new JPanel();
    private JPanel panelCommande = new JPanel();

    /**************
     * Objets du panel Menu
     **********/
    private JButton btLister = new JButton("Lister");
    private JButton btListerStocks = new JButton("ListeStocks");
    private JButton btQuitter = new JButton("Quitter");

    /**************
     * Objets du panel Lister
     ********/
    private JLabel lbTitre = new JLabel("Liste des commandes");
    private JButton btFermer = new JButton("Fermer");
    private JTable laTable = null;

    /**************
     * Objets du panel Lister
     ********/
    private JTextField jfModifier = new JTextField();
    private JTextField jfId = new JTextField();
    private JLabel lbModifier = new JLabel("Modifier une qte :");
    private JLabel lbId = new JLabel("ID :");
    private JButton btEnregistrer = new JButton("Enregistrer");

    /**********************************************/

    /**************
     * Objets du panel Lister
     ********/

    private JTextField jfID = new JTextField();
    private JButton btEditer = new JButton("Editer");
    private JButton btArchiver = new JButton("Archiver");


    public VuePrincipale(User unUser) {
        user = unUser;

        this.setBounds(200, 200, 800, 600);
        this.setTitle("Gestion du Restaurant");
        this.setResizable(false);
        this.setLayout(null);

        // placement du panel Menu
        this.panelMenu.setBounds(20, 0, 120, 550);
        //this.panelMenu.setBackground(new Color(44, 62, 80));
        this.panelMenu.setLayout(new GridLayout(8, 1));
        this.panelMenu.add(new JLabel());
        this.panelMenu.add(new JLabel("Le Menu"));
        this.panelMenu.add(this.btLister);
        this.panelMenu.add(this.btListerStocks);
        this.panelMenu.add(this.btQuitter);
        this.panelMenu.add(new JLabel());
        this.panelMenu.setVisible(true);
        this.add(this.panelMenu);

        // placement objets panel lister
        this.panelLister.setBounds(150, 20, 620, 500);
        this.panelLister.setLayout(null);
        //this.panelLister.setBackground(new Color(44, 62, 80));
        this.lbTitre.setBounds(250, 30, 200, 20);
        this.panelLister.add(this.lbTitre);
        this.btFermer.setBounds(265, 400, 80, 20);
        this.panelLister.add(this.btFermer);
        this.panelLister.add(jfID);
        this.panelLister.add(btArchiver);
        this.panelLister.add(btEditer);
        this.panelCommande.setBounds(150, 20, 620, 500);
        this.panelCommande.setLayout(null);
        this.jfID.setBounds(180, 400, 50, 20);
        this.btEditer.setBounds(260, 400, 80, 20);
        this.btArchiver.setBounds(350, 400, 80, 20);

        this.panelListerStocks.setBounds(150, 20, 620, 500);
        this.panelListerStocks.setLayout(null);
        //this.panelListerStocks.setBackground(new Color(44, 62, 80));
        this.lbTitre.setBounds(250, 30, 200, 20);
        this.panelListerStocks.add(this.lbTitre);
        this.btFermer.setBounds(265, 435, 80, 20);
        this.panelListerStocks.add(this.btFermer);

        this.panelListerStocks.add(jfModifier);
        this.jfModifier.setBounds(265, 400, 200, 20);

        this.panelListerStocks.add(jfId);
        this.jfId.setBounds(265, 380, 200, 20);

        this.panelListerStocks.add(lbId);
        this.lbId.setBounds(50, 380, 200, 20);

        this.panelListerStocks.add(lbModifier);
        this.lbModifier.setBounds(50, 400, 180, 20);

        this.panelListerStocks.add(btEnregistrer);
        this.btEnregistrer.setBounds(150, 435, 80, 20);

        this.panelLister.setVisible(false);
        this.panelListerStocks.setVisible(false);
        this.panelCommande.setVisible(false);

        this.add(this.panelLister);
        this.add(this.panelListerStocks);
        this.add(this.panelCommande);

        // rendre les boutons ecoutables
        this.btLister.addActionListener(this);
        this.btFermer.addActionListener(this);
        this.btQuitter.addActionListener(this);
        this.btListerStocks.addActionListener(this);
        this.btEnregistrer.addActionListener(this);
        this.btEditer.addActionListener(this);
        this.btArchiver.addActionListener(this);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btFermer) {
            this.panelLister.setVisible(false);
            this.panelListerStocks.setVisible(false);
            this.panelCommande.setVisible(false);
        } else if (e.getSource() == this.btLister) {
            // construction de la Jtable
            String titres[] = {"ID", "Date", "Menu"};
            LinkedList<Order> Orders = ModeleOrder.selectAll(user);
            Object donnees[][] = new Object[Orders.size()][3];
            int i = 0;
            for (Order uneOrder : Orders) {
                donnees[i][0] = uneOrder.getId();
                donnees[i][1] = uneOrder.getDate();
                LinkedList<MealLines> MealLines = ModeleMealLines.selectAll(uneOrder);
                LinkedList<ProductLines> ProductLines = ModeleProductLines.selectAll(uneOrder);
                String menu = "";
                for (MealLines uneMealLine : MealLines) {
                    menu += uneMealLine.toString();
                    menu += "\r\n";
                }
                for (ProductLines uneProductLine : ProductLines) {
                    Product unProduct = ModeleProduct.select(uneProductLine.getProduct_id());
                    menu += unProduct.getNom();
                    menu += "\r\n";
                }
                donnees[i][2] = menu;
                i++;
            }
            this.laTable = new JTable(donnees, titres);

            // affichage de la table dans une scroll
            JScrollPane uneScroll = new JScrollPane(this.laTable);
            uneScroll.setBounds(20, 65, 550, 300);
            uneScroll.setVisible(true);
            this.panelLister.add(uneScroll);
            this.panelLister.setVisible(true);
            this.panelListerStocks.setVisible(false);
            this.panelCommande.setVisible(false);
        } else if (e.getSource() == this.btListerStocks) {
            // construction de la Jtable
            String[] titres = {"id", "Menu", "Quantités"};
            LinkedList<Stocks> Stocks = ModeleStocks.selectAll(user);
            Order unModeleOrder = new Order();
            Object donnees[][] = new Object[Stocks.size()][3];
            int i = 0;
            for (Stocks unStocks : Stocks) {
                donnees[i][0] = unStocks.getProduct_id();
                donnees[i][1] = ModeleProduct.select(unStocks.getProduct_id()).getNom();
                donnees[i][2] = unStocks.getQte();
                i++;
            }
            this.laTable = new JTable(donnees, titres);

            // affichage de la table dans une scroll
            JScrollPane uneScroll = new JScrollPane(this.laTable);
            uneScroll.setBounds(20, 65, 550, 300);
            uneScroll.setVisible(true);
            this.panelListerStocks.add(uneScroll);

            this.panelListerStocks.setVisible(true);
            this.panelLister.setVisible(false);
            this.panelCommande.setVisible(false);
        } else if (e.getSource() == this.btEnregistrer) {
            int idProduit, qte = 0;
            ModeleStocks unModeleStocks = new ModeleStocks();
            idProduit = Integer.parseInt(jfId.getText());
            qte = Integer.parseInt(this.jfModifier.getText());
            unModeleStocks.edit(user.getRestaurant_id(), idProduit, qte);
        } else if (e.getSource() == this.btQuitter) {
            this.dispose();
        } else if (e.getSource() == this.btArchiver) {
            int id = 0;
            id = Integer.parseInt(this.jfID.getText());
            ModeleOrder.inactivate(id);
        } else if (e.getSource() == this.btEditer) {

            // construction de la Jtable
            String[] titres = {"Date achat", "Prix", "Archiver"};
            LinkedList<Order> Orders = ModeleOrder.selectInactivate(user);
            Object donnees[][] = new Object[Orders.size()][3];
            int i = 0;
            for (Order unOrder : Orders) {
                donnees[i][0] = unOrder.getDate();
                donnees[i][1] = unOrder.getPrix();
                donnees[i][2] = unOrder.getActive();
                i++;
            }
            this.laTable = new JTable(donnees, titres);

            // affichage de la table dans une scroll
            JScrollPane uneScroll = new JScrollPane(this.laTable);
            uneScroll.setBounds(20, 65, 550, 300);
            uneScroll.setVisible(true);
            this.panelCommande.add(uneScroll);

            this.panelCommande.setVisible(true);

            this.panelLister.setVisible(false);
            this.panelListerStocks.setVisible(false);
        }
    }
}
