package com.gbegba.servlets;

import com.gbegba.dao.UtilisateurDAO;
import com.gbegba.model.Utilisateur;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/utilisateurs")
public class utilisateurController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UtilisateurDAO utilisateursDAO;

    public utilisateurController() throws SQLException {
        this.utilisateursDAO = new UtilisateurDAO();
    }

    public String seConnecter(String nomUtilisateur, String motDePasse) {

        Utilisateur utilisateur = utilisateursDAO.trouverParNomUtilisateur(nomUtilisateur);

        if (utilisateur != null && utilisateur.getMotDePasse().equals(motDePasse)) {

            // L'utilisateur est connecté
            String token = generateToken();
            utilisateur.setToken(token);
            utilisateursDAO.update(utilisateur);
            return "verification";

        } else {

            // L'utilisateur n'est pas connecté
            return "connexion";

        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Récupération des données de la requête
        String action = request.getParameter("action");

        // Traitement de la requête
        if (action == null) {
            // Afficher la liste des utilisateurs
            List<Utilisateur> utilisateurs = utilisateursDAO.getAll();

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Liste des utilisateurs</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>Nom</th>");
            out.println("<th>Prénom</th>");
            out.println("<th>Email</th>");
            out.println("</tr>");
            for (Utilisateur utilisateur : utilisateurs) {
                out.println("<tr>");
                out.println("<td>" + utilisateur.getNom() + "</td>");
                out.println("<td>" + utilisateur.getPrenom() + "</td>");
                out.println("<td>" + utilisateur.getEmail() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        } else if (action.equals("se-connecter")) {
            // Se connecter
            String nomUtilisateur = request.getParameter("nom-utilisateur");
            String motDePasse = request.getParameter("mot-de-passe");
            String redirection = seConnecter(nomUtilisateur, motDePasse);
            response.sendRedirect(redirection);
        } else {
            // Erreur
            response.sendError(404);
        }
    }

    private String generateToken() {
        // Génère un token aléatoire
        return UUID.randomUUID().toString();
    }
}
