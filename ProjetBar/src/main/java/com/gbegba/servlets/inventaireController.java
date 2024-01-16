package com.gbegba.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gbegba.dao.InventaireDAO;
import com.gbegba.model.Inventaire;

@WebServlet("/inventaires")
public class inventaireController extends HttpServlet {

    private InventaireDAO inventaireDAO;

    @Override
    public void init() throws ServletException {
        super.init();

        inventaireDAO = new InventaireDAO((Connection) this.getServletContext().getAttribute("connection"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Inventaire> inventaires = null;
		try {
			inventaires = inventaireDAO.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        request.setAttribute("inventaires", inventaires);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/inventaires.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nom = request.getParameter("nom");
        int quantité = Integer.parseInt(request.getParameter("quantité"));

        Inventaire inventaire = new Inventaire();
        inventaire.setNom(nom);
        inventaire.setQuantité(quantité);

        try {
            inventaireDAO.add(inventaire);

            response.sendRedirect("inventaires");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
