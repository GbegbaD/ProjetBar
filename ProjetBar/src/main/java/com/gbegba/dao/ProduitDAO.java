package com.gbegba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gbegba.model.DatabaseUtil;
import com.gbegba.model.Produit;
import com.gbegba.service.ProduitService;

public class ProduitDAO implements ProduitService {
    private Connection connection;

    public ProduitDAO() {
        // Initialisez votre connexion à la base de données (utilisez votre propre logique)
        this.connection = DatabaseUtil.getConnection();
    }

    public List<Produit> getAllProduits() {
        List<Produit> produits = new ArrayList<>();

        try {
            String query = "SELECT * FROM produits";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    int produitID = resultSet.getInt("produitID");
                    String nomProduit = resultSet.getString("nomProduit");
                    String categorie = resultSet.getString("categorie");
                    double prix = resultSet.getDouble("prix");
                    int stockDispo = resultSet.getInt("stockDispo");

                    Produit produit = new Produit();
                    produit.setProduitID(produitID);
                    produit.setNomProduit(nomProduit);
                    produit.setCategorie(categorie);
                    produit.setPrix(prix);
                    produit.setStockDispo(stockDispo);

                    produits.add(produit);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produits;
    }

	@Override
	public Produit getProduitById(int produitId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProduit(Produit produit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProduit(Produit produit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduit(int produitId) {
		// TODO Auto-generated method stub
		
	}

   
}
