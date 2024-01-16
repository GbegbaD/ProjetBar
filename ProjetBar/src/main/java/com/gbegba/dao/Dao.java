package com.gbegba.dao;

import java.sql.SQLException;
import java.util.List;

import com.gbegba.model.Ingredient;
import com.gbegba.model.Recette;
import com.gbegba.model.Utilisateur;

public interface Dao<T> {

	    T get(int id) throws SQLException;

		void add(Recette recette) throws SQLException;

		void update(Recette recette) throws SQLException;

		void delete(int id) throws SQLException;
		
	
		List<Utilisateur> getAll() throws SQLException;

		void update(Utilisateur utilisateur) throws SQLException;

		void add(Utilisateur utilisateur) throws SQLException;
		
		void add(Ingredient ingredient) throws SQLException;

		void update(Ingredient ingredient) throws SQLException;
		
		
		

	}


