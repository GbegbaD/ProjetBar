package com.gbegba.dao;
// Import de la classe ArrayList depuis le package java.util
import java.util.ArrayList;
// Import de la classe List depuis le package java.util
import java.util.List;

// Import de la classe Recette depuis le package com.gbegba.model
import com.gbegba.model.Recette;

// Déclaration de la classe RecetteDAO
public class RecetteDAO {

    // Variable membre privée de la classe pour stocker la liste des recettes
    private List<Recette> recettes;

    // Constructeur par défaut de la classe RecetteDAO
    public RecetteDAO() {
        // Initialisation de la liste des recettes avec une nouvelle instance de ArrayList
        recettes = new ArrayList<>();
    }

    // Méthode pour ajouter une recette à la liste
    public void add(Recette recette) {
        recettes.add(recette);
    }

    // Méthode pour obtenir toutes les recettes de la liste
    public List<Recette> getAll() {
        return recettes;
    }

    // Méthode pour obtenir une recette spécifique en fonction de son ID
    public Recette get(int id) {
        for (Recette recette : recettes) {
            if (recette.getId() == id) {
                return recette;
            }
        }
        return null; // Retourne null si aucune recette avec l'ID spécifié n'est trouvée
    }

    // Méthode pour mettre à jour une recette dans la liste
    public void update(Recette recette) {
        for (int i = 0; i < recettes.size(); i++) {
            if (recettes.get(i).getId() == recette.getId()) {
                recettes.set(i, recette); // Remplace l'ancienne recette par la nouvelle
                return;
            }
        }
    }

    // Méthode pour supprimer une recette de la liste en fonction de son ID
    public void delete(int id) {
        for (int i = 0; i < recettes.size(); i++) {
            if (recettes.get(i).getId() == id) {
                recettes.remove(i); // Supprime la recette de la liste
                return;
            }
        }
    }
}
