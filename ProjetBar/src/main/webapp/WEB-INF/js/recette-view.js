// Importe la classe RecetteView
import { RecetteView } from './recette-view';

// Fonction pour afficher les recettes
function afficherRecettes() {
    // Récupère la liste des recettes
    const recettes = Recette.findAll();

    // Parcourir la liste des recettes
    recettes.forEach(recette => {
        // Créer une instance de la classe RecetteView
        const recetteView = new RecetteView(recette);

        // Afficher la recette dans la vue
        document.querySelector('#recetteList').appendChild(recetteView.afficherTitre());
        document.querySelector('#recetteList').appendChild(recetteView.afficherIngredients());
        document.querySelector('#recetteList').appendChild(recetteView.afficherInstructions());
    });
}
