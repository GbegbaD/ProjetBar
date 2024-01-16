package com.gbegba.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gbegba.model.DatabaseUtil;
import com.gbegba.model.Produit;

public class ProduitServiceImpl implements ProduitService {
    private Connection connection;

    public ProduitServiceImpl() {
        this.connection = DatabaseUtil.getConnection();
    }

    @Override
    public Produit getProduitById(int produitId) {
        Produit produit = null;

        try {
            String query = "SELECT * FROM produits WHERE produitID = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, produitId);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        produit = new Produit();
                        produit.setProduitID(resultSet.getInt("produitID"));
                        produit.setNomProduit(resultSet.getString("nomProduit"));
                        produit.setCategorie(resultSet.getString("categorie"));
                        produit.setPrix(resultSet.getDouble("prix"));
                        produit.setStockDispo(resultSet.getInt("stockDispo"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produit;
    }

    @Override
    public void addProduit(Produit produit) {
        try {
            String query = "INSERT INTO produits (nomProduit, categorie, prix, stockDispo) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, produit.getNomProduit());
                statement.setString(2, produit.getCategorie());
                statement.setDouble(3, produit.getPrix());
                statement.setInt(4, produit.getStockDispo());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProduit(Produit produit) {
        try {
            String query = "UPDATE produits SET nomProduit = ?, categorie = ?, prix = ?, stockDispo = ? WHERE produitID = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, produit.getNomProduit());
                statement.setString(2, produit.getCategorie());
                statement.setDouble(3, produit.getPrix());
                statement.setInt(4, produit.getStockDispo());
                statement.setInt(5, produit.getProduitID());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduit(int produitId) {
        try {
            String query = "DELETE FROM produits WHERE produitID = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, produitId);

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
	public List<Produit> getAllProduits() {
		// TODO Auto-generated method stub
		return null;
	}
}
