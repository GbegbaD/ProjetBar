package com.gbegba.model;

// Déclaration de la classe Utilisateur
public class Utilisateur {

    // Variables membres privées de la classe
    private int id;
    private String nom;
    private String prénom; 
    private String email;
    private String motDePasse;

    // Constructeur de la classe Utilisateur
    public Utilisateur(int id, String nom, String prénom, String email, String motDePasse) {
        this.id = id;
        this.nom = nom;
        this.prénom = prénom;
        this.email = email;
        this.motDePasse = motDePasse;
    }
    public Utilisateur() {
        // Initialisation des attributs si nécessaire
    }


    // Méthode pour obtenir l'ID de l'utilisateur
    public int getId() {
        return id;
    }

    // Méthode pour définir l'ID de l'utilisateur
    public void setId(int id) {
        this.id = id;
    }

    // Méthode pour obtenir le nom de l'utilisateur
    public String getNom() {
        return nom;
    }

    // Méthode pour définir le nom de l'utilisateur
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Méthode pour obtenir le prénom de l'utilisateur
    public String getPrenom() {
        return prénom;
    }

    // Méthode pour définir le prénom de l'utilisateur
    public void setPrenom(String prénom) {
        this.prénom = prénom;
    }

    // Méthode pour obtenir l'email de l'utilisateur
    public String getEmail() {
        return email;
    }

    // Méthode pour définir l'email de l'utilisateur
    public void setEmail(String email) {
        this.email = email;
    }

    // Méthode pour obtenir le mot de passe de l'utilisateur
    public String getMotDePasse() {
        return motDePasse;
    }

    // Méthode pour définir le mot de passe de l'utilisateur
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
	public void setToken(String token) {
		// TODO Auto-generated method stub
		
	}
}
