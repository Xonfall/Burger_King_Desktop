package com.company.modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDD {
	private String serveur, bdd, user, mdp;
	private Connection maConnexion;
	
	public BDD (String serveur, String bdd, String user, String mdp){
		this.serveur = serveur;
		this.bdd = bdd;
		this.user = user;
		this.mdp = mdp;
		this.maConnexion = null;
	}
	
	public void chargerPilote(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException exp){
			System.out.println("Erreur de chargement de pilote ! ");
		}
	}
	
	public void seConnecter(){
		this.chargerPilote();
		String url = "mysql://" + this.serveur + "/" + this.bdd;
		try{
			this.maConnexion = DriverManager.getConnection("jdbc:" + url, this.user, this.mdp);
		}
		catch(SQLException exp){
			System.out.println("Erreur de connexion à l'url : " + url);
		}
	}
	
	public void seDeconnecter(){
		try{
			if (this.maConnexion != null){
				this.maConnexion.close();
			}
		}
		catch(SQLException exp){
			System.out.println("Erreur de fermeture de la connexion :");
		}
	}
	
	public Connection getMaConnection(){
		return this.maConnexion;
	}
}
