package com.gbegba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gbegba.model.Inventaire;

public class InventaireDAO {

    private Connection connection;

    public InventaireDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Inventaire> getAll() throws SQLException {
        List<Inventaire> inventaires = new ArrayList<>();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM inventaires");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Inventaire inventaire = new Inventaire();
            inventaire.setId(resultSet.getInt("id"));
            inventaire.setNom(resultSet.getString("nom"));
            inventaire.setQuantité(resultSet.getInt("quantité"));
            inventaires.add(inventaire);
        }

        return inventaires;
    }

    public Inventaire get(int id) throws SQLException {
        Inventaire inventaire = null;

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM inventaires WHERE id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            inventaire = new Inventaire();
            inventaire.setId(resultSet.getInt("id"));
            inventaire.setNom(resultSet.getString("nom"));
            inventaire.setQuantité(resultSet.getInt("quantité"));
        }

        return inventaire;
    }

    public void add(Inventaire inventaire) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO inventaires (nom, quantité) VALUES (?, ?)");
        preparedStatement.setString(1, inventaire.getNom());
        preparedStatement.setInt(2, inventaire.getQuantité());
        preparedStatement.executeUpdate();
    }

    public void update(Inventaire inventaire) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE inventaires SET nom = ?, quantité = ? WHERE id = ?");
        preparedStatement.setString(1, inventaire.getNom());
        preparedStatement.setInt(2, inventaire.getQuantité());
        preparedStatement.setInt(3, inventaire.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM inventaires WHERE id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
}
