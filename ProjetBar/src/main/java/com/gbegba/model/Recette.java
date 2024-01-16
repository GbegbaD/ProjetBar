package com.gbegba.model;

// Import de la classe List depuis le package java.util
import java.util.List;

// Déclaration de la classe Recette
public class Recette {

    // Variables membres privées de la classe
    private int id;
    private String nom;
    private List<Ingredient> ingredients;
    private String methodePreparation;
    private String tempsRepos;
    private String conseilsService;

    // Constructeur par défaut de la classe Recette
    public Recette() {
    }

    // Constructeur avec paramètres de la classe Recette
    public Recette(int id, String nom, List<Ingredient> ingredients, String methodePreparation, String tempsRepos, String conseilsService) {
        this.id = id;
        this.nom = nom;
        this.ingredients = ingredients;
        this.methodePreparation = methodePreparation;
        this.tempsRepos = tempsRepos;
        this.conseilsService = conseilsService;
    }

    // Méthode pour obtenir l'ID de la recette
    public int getId() {
        return id;
    }

    // Méthode pour définir l'ID de la recette
    public void setId(int id) {
        this.id = id;
    }

    // Méthode pour obtenir le nom de la recette
    public String getNom() {
        return nom;
    }

    // Méthode pour définir le nom de la recette
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Méthode pour obtenir la liste d'ingrédients de la recette
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    // Méthode pour définir la liste d'ingrédients de la recette
    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    // Méthode pour obtenir la méthode de préparation de la recette
    public String getMethodePreparation() {
        return methodePreparation;
    }

    // Méthode pour définir la méthode de préparation de la recette
    public void setMethodePreparation(String methodePreparation) {
        this.methodePreparation = methodePreparation;
    }

    // Méthode pour obtenir le temps de repos de la recette
    public String getTempsRepos() {
        return tempsRepos;
    }

    // Méthode pour définir le temps de repos de la recette
    public void setTempsRepos(String tempsRepos) {
        this.tempsRepos = tempsRepos;
    }

    // Méthode pour obtenir les conseils de service de la recette
    public String getConseilsService() {
        return conseilsService;
    }

    // Méthode pour définir les conseils de service de la recette
    public void setConseilsService(String conseilsService) {
        this.conseilsService = conseilsService;
    }
}
