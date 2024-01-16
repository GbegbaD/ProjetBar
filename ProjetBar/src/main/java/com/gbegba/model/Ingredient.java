package com.gbegba.model;

// Déclaration de la classe Ingredient
public class Ingredient {

    // Variables membres privées de la classe
    private int id;
    private String nom;
    private String type;
    private double quantite;
    private String unite;

    // Constructeur avec paramètres de la classe Ingredient
    public Ingredient(int id, String nom, String type, double quantite, String unite) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.quantite = quantite;
        this.unite = unite;
    }

    // Méthode pour obtenir l'ID de l'ingrédient
    public int getId() {
        return id;
    }

    // Méthode pour définir l'ID de l'ingrédient
    public void setId(int id) {
        this.id = id;
    }

    // Méthode pour obtenir le nom de l'ingrédient
    public String getNom() {
        return nom;
    }

    // Méthode pour définir le nom de l'ingrédient
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Méthode pour obtenir le type de l'ingrédient
    public String getType() {
        return type;
    }

    // Méthode pour définir le type de l'ingrédient
    public void setType(String type) {
        this.type = type;
    }

    // Méthode pour obtenir la quantité de l'ingrédient
    public double getQuantite() {
        return quantite;
    }

    // Méthode pour définir la quantité de l'ingrédient
    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    // Méthode pour obtenir l'unité de mesure de l'ingrédient
    public String getUnite() {
        return unite;
    }

    // Méthode pour définir l'unité de mesure de l'ingrédient
    public void setUnite(String unite) {
    	this.unite = unite;    }
    
    }
