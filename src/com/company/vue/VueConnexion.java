package com.company.vue;


import com.company.controleur.User;
import com.company.modele.ModeleUser;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VueConnexion extends JFrame implements ActionListener {
    private JLabel lbUsername = new JLabel("Utilisateur :");
    private JLabel lbMDP = new JLabel("Mot de passe :");
    private TextField tfUsername = new TextField();
    private JPasswordField tfPassword = new JPasswordField();
    private JButton btnSeConnecter = new JButton("Se connecter");
    private JButton btnAnnuler = new JButton("Annuler");

    public VueConnexion() {

        this.setBounds(200, 200, 450, 300);
        this.setTitle("Gestion des restaurants");
        this.setResizable(false);
        this.setLayout(null);

        this.lbUsername.setBounds(80, 50, 100, 20);
        this.add(this.lbUsername);
        this.lbMDP.setBounds(80, 100, 100, 20);
        this.add(this.lbMDP);
        this.tfUsername.setBounds(220, 50, 150, 20);
        this.add(this.tfUsername);
        this.tfPassword.setBounds(220, 100, 150, 20);
        this.add(this.tfPassword);
        this.btnSeConnecter.setBounds(250, 200, 150, 20);
        this.add(this.btnSeConnecter);
        this.btnAnnuler.setBounds(110, 200, 100, 20);
        this.add(btnAnnuler);

        this.btnSeConnecter.addActionListener(this);
        this.btnAnnuler.addActionListener(this);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSeConnecter) {
            String username = this.tfUsername.getText();
            char[] password = this.tfPassword.getPassword();
            String champPassword = String.valueOf(password);
            //JOptionPane.showMessageDialog(null, champPassword);
            
            User unUser = null;
            unUser = ModeleUser.verifConnexion(username, champPassword);
            if(unUser == null){
            	JOptionPane.showMessageDialog(null, "Erreur de saisie");
            } else {
            	this.setVisible(false);
            	new VuePrincipale(unUser);
            }
        } else if(e.getSource() == btnAnnuler) {
            this.dispose();
        }
    }
}