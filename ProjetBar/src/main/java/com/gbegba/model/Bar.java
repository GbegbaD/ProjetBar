package com.gbegba.model;
import java.util.ArrayList;
import java.util.List;

public class Bar {

    private List<Produit> produits;
    private List<Ingredient> ingredients;

    public Bar() {
        this.produits = new ArrayList<>();
        this.ingredients = new ArrayList<>();
    }

    public void ajouterProduit(Produit produit) {
        produits.add(produit);
    }

    public void passerCommande(Commande commande) {
        Commande.add(commande);
    }

    public void ajouterIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public void supprimerIngredient(Ingredient ingredient) {
        ingredients.remove(ingredient);
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

}
