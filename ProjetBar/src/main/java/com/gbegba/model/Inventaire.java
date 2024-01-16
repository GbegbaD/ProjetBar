package com.gbegba.model;

// Import de la classe List depuis le package java.util
import java.util.List;

// Déclaration de la classe Inventaire
public class Inventaire {

    // Variables membres privées de la classe
    private int id;
    private String nom;
    private List<Ingredient> ingredients;
    private int quantité;

    // Constructeur par défaut de la classe Inventaire
    public Inventaire() {
    }

    // Constructeur avec paramètres de la classe Inventaire
    public Inventaire(int id, String nom, List<Ingredient> ingredients, int quantité) {
        this.id = id;
        this.nom = nom;
        this.ingredients = ingredients;
        this.quantité = quantité;
    }

    // Méthode pour obtenir l'ID de l'inventaire
    public int getId() {
        return id;
    }

    // Méthode pour définir l'ID de l'inventaire
    public void setId(int id) {
        this.id = id;
    }

    // Méthode pour obtenir le nom de l'inventaire
    public String getNom() {
        return nom;
    }

    // Méthode pour définir le nom de l'inventaire
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Méthode pour obtenir la liste d'ingrédients de l'inventaire
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    // Méthode pour définir la liste d'ingrédients de l'inventaire
    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    // Méthode pour obtenir la quantité de l'inventaire
    public int getQuantité() {
        return quantité;
    }

    // Méthode pour définir la quantité de l'inventaire
    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }

    // Méthode toString pour afficher une représentation textuelle de l'inventaire
    @Override
    public String toString() {
        return "Inventaire{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", ingredients=" + ingredients +
                ", quantité=" + quantité +
                '}';
    }
}
