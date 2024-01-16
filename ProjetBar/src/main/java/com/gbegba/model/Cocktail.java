package com.gbegba.model;
// Import de la classe List depuis le package java.util
import java.util.List;

// Déclaration de la classe Cocktail
public class Cocktail {

    // Variables membres privées de la classe
    private int id;
    private String titre;
    private String type;
    private List<String> ingredients;
    private List<String> instructions;

    // Constructeur par défaut de la classe Cocktail
    public Cocktail() {
    }

    // Constructeur avec paramètres de la classe Cocktail
    public Cocktail(int id, String titre, String type, List<String> ingredients, List<String> instructions) {
        this.id = id;
        this.titre = titre;
        this.type = type;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    // Méthode pour obtenir l'ID du cocktail
    public int getId() {
        return id;
    }

    // Méthode pour définir l'ID du cocktail
    public void setId(int id) {
        this.id = id;
    }

    // Méthode pour obtenir le titre du cocktail
    public String getTitre() {
        return titre;
    }

    // Méthode pour définir le titre du cocktail
    public void setTitre(String titre) {
        this.titre = titre;
    }

    // Méthode pour obtenir le type du cocktail
    public String getType() {
        return type;
    }

    // Méthode pour définir le type du cocktail
    public void setType(String type) {
        this.type = type;
    }

    // Méthode pour obtenir la liste d'ingrédients du cocktail
    public List<String> getIngredients() {
        return ingredients;
    }

    // Méthode pour définir la liste d'ingrédients du cocktail
    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    // Méthode pour obtenir la liste d'instructions du cocktail
    public List<String> getInstructions() {
        return instructions;
    }

    // Méthode pour définir la liste d'instructions du cocktail
    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }

    // Méthode toString pour afficher une représentation textuelle du cocktail
    @Override
    public String toString() {
        return "Cocktail{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", type='" + type + '\'' +
                ", ingredients=" + ingredients +
                ", instructions=" + instructions +
                '}';
    }
}
