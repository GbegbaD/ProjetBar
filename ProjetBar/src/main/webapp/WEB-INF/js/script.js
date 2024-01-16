// Importe les classes
const Utilisateur = require("./model/Utilisateur.class");
const Recette = require("./model/Recette.class");
const Cocktail = require("./model/Cocktail.class");
const Inventaire = require("./model/Inventaire.class");
const Ingredient = require("./model/Ingredient.class");


// Fonction pour charger les produits depuis la base de données
function chargerProduits() {
    // Récupère la liste des produits
    const produits = Produit.findAll();

    // Récupère la liste des ingrédients
    const ingredients = Ingredient.find();

    // Si la base de données est vide, affiche un message
    if (ingredients.length === 0) {
        document.querySelector('#productList').textContent = 'La base de données est vide.<br>Ajouter un ingrédient <a href="/ingredients/ajouter">ici</a>.';
    } else {
        // Appeler une fonction pour afficher les produits dans le DOM
        afficherProduits(produits, ingredients);
    }
}

// Fonction pour charger les produits dans le DOM
function afficherProduits(produits, ingredients) {
    const productList = document.getElementById('productList');

    // Parcourir la liste des produits
    produits.forEach(produit => {
        // Créer un élément <div> pour représenter un produit
        const produitElement = document.createElement('div');
        produitElement.classList.add('product');

        // Créer des éléments pour afficher les détails du produit (nom, prix, etc.)
        const nomProduitElement = document.createElement('h3');
        nomProduitElement.textContent = produit.nomProduit;

        const categorieElement = document.createElement('p');
        categorieElement.textContent = `Catégorie: ${produit.categorie}`;

        const prixElement = document.createElement('p');
        prixElement.textContent = `Prix: ${produit.prix} €`;

        // Ajouter les éléments au produitElement
        produitElement.appendChild(nomProduitElement);
        produitElement.appendChild(categorieElement);
        produitElement.appendChild(prixElement);

        // Ajouter l'élément produitElement à la liste des produits
        productList.appendChild(produitElement);

        // Parcourir la liste des ingrédients
        ingredients.forEach(ingredient => {
            // Vérifier si l'ingrédient est utilisé par le produit
            if (produit.ingredients.includes(ingredient)) {
                // Créer un élément <p> pour afficher l'ingrédient
                const ingredientElement = document.createElement('p');
                ingredientElement.textContent = `Ingrédient: ${ingredient.nom}`;

                // Ajouter l'élément ingredientElement au produitElement
                produitElement.appendChild(ingredientElement);
            }
        });
    });
}

// Appeler la fonction pour charger les produits lors du chargement de la page
window.onload = chargerProduits;
