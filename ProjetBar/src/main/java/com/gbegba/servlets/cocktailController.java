package com.gbegba.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.gbegba.model.Cocktail;
import com.gbegba.dao.CocktailDAO;

@WebServlet("/cocktails")
public class cocktailController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private CocktailDAO cocktailDAO;

    public cocktailController() throws SQLException {
        cocktailDAO = new CocktailDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Récupération des données de la requête
        String action = request.getParameter("action");

        // Traitement de la requête
        if (action == null) {
            // Afficher la liste des cocktails
            List<Cocktail> cocktails = cocktailDAO.getAll();

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Liste des cocktails</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>Titre</th>");
            out.println("<th>Type</th>");
            out.println("</tr>");
            for (Cocktail cocktail : cocktails) {
                out.println("<tr>");
                out.println("<td>" + cocktail.getTitre() + "</td>");
                out.println("<td>" + cocktail.getType() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
            /*
             * } else if (action.equals("ajouter-cocktail")) {
            // Ajouter un cocktail
            Cocktail cocktail = new Cocktail(
                    request.getParameter("nom"),
                    request.getParameter("description"));
            cocktailDAO.add(cocktail);

            response.sendRedirect("/cocktails");
             */
        } else if (action.equals("modifier-cocktail")) {
            // Modifier un cocktail
            int id = Integer.parseInt(request.getParameter("id"));
            Cocktail cocktail = cocktailDAO.get(id);
            cocktail.setTitre(request.getParameter("titre"));
            cocktailDAO.update(cocktail);

            response.sendRedirect("/cocktails");
        } else if (action.equals("supprimer-cocktail")) {
            // Supprimer un cocktail
            int id = Integer.parseInt(request.getParameter("id"));
            cocktailDAO.delete(id);

            response.sendRedirect("/cocktails");
        } else {
            // Erreur
            response.sendError(404);
        }
    }
}
