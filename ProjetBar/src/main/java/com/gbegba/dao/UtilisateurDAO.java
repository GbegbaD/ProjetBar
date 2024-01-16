package com.gbegba.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.gbegba.model.Utilisateur;

public class UtilisateurDAO {

    private Connection connection;

    public UtilisateurDAO() throws SQLException {
        // Définissez les informations de connexion à la base de données
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:8889/BarManagementDB";
        String username = "root";
        String password = "root";

        // Chargez le pilote JDBC
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new SQLException(e);
        }

        // Créez une connexion à la base de données
        connection = DriverManager.getConnection(url, username, password);
    }

    public void add(Utilisateur utilisateur) throws SQLException {
        // Préparez la requête SQL
        String sql = "INSERT INTO utilisateurs (nom, prenom, email, mot_de_passe) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // Remplacez les marqueurs (?) par les valeurs de l'utilisateur
        preparedStatement.setString(1, utilisateur.getNom());
        preparedStatement.setString(2, utilisateur.getPrenom());
        preparedStatement.setString(3, utilisateur.getEmail());
        preparedStatement.setString(4, utilisateur.getMotDePasse());

        // Exécutez la requête SQL
        preparedStatement.executeUpdate();
    }

    public Utilisateur get(int id) {
        String sql = "SELECT * FROM utilisateurs WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setId(rs.getInt("id"));
                utilisateur.setNom(rs.getString("nom"));
                utilisateur.setPrenom(rs.getString("prenom"));
                utilisateur.setEmail(rs.getString("email"));
                utilisateur.setMotDePasse(rs.getString("motDePasse"));
                return utilisateur;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Utilisateur> getAll() {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        String sql = "SELECT * FROM utilisateurs";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setId(rs.getInt("id"));
                utilisateur.setNom(rs.getString("nom"));
                utilisateur.setPrenom(rs.getString("prenom"));
                utilisateur.setEmail(rs.getString("email"));
                utilisateur.setMotDePasse(rs.getString("motDePasse"));
                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateurs;
    }

    public void delete(int id) {
        String sql = "DELETE FROM utilisateurs WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Utilisateur utilisateur) {
        String sql = "UPDATE utilisateurs SET nom=?, prenom=?, email=?, motDePasse=? WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, utilisateur.getNom());
            ps.setString(2, utilisateur.getPrenom());
            ps.setString(3, utilisateur.getEmail());
            ps.setString(4, utilisateur.getMotDePasse());
            ps.setInt(5, utilisateur.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Utilisateur trouverParNomUtilisateur(String nomUtilisateur) {
        String sql = "SELECT * FROM utilisateurs WHERE nomUtilisateur = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, nomUtilisateur);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setId(rs.getInt("id"));
                utilisateur.setNom(rs.getString("nom"));
                utilisateur.setPrenom(rs.getString("prenom"));
                utilisateur.setEmail(rs.getString("email"));
                utilisateur.setMotDePasse(rs.getString("motDePasse"));
                return utilisateur;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
