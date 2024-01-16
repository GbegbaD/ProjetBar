package com.gbegba.servlets;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ImagesServlet")
public class ImagesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = null;
        try {
            // Charger le driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connexion à la base de données (à personnaliser avec vos paramètres)
            conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/BarManagementDB", "localhost", "root");

            // Récupérer le chemin de l'image depuis la base de données
            String idImage = request.getParameter("id");
            String sql = "SELECT chemin_image FROM images WHERE id = ?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, idImage);
                ResultSet result = statement.executeQuery();
                if (result.next()) {
                    String imagePath = result.getString("chemin_image");

                    // Récupérer le flux de sortie de la réponse
                    try (OutputStream out = response.getOutputStream()) {
                        // Écrire l'image dans le flux de sortie
                        // (Ici, vous pouvez également gérer différents types de fichiers, pas seulement des images)
                        // Par exemple, vous pouvez définir le type MIME avec response.setContentType("image/jpeg");
                        // puis utiliser ImageIO.write pour écrire des images dans le flux de sortie.
                        // Pour simplifier, nous utilisons simplement OutputStream pour le téléchargement de fichiers.
                        response.setContentType("application/octet-stream");
                        response.setHeader("Content-Disposition", "attachment;filename=" + imagePath);
                        byte[] buffer = new byte[4096];
                        int bytesRead;
                        while ((bytesRead = request.getInputStream().read(buffer)) != -1) {
                            out.write(buffer, 0, bytesRead);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
