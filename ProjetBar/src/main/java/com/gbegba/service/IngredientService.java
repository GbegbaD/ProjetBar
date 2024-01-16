package com.gbegba.service;

import java.util.List;

import com.gbegba.model.Ingredient;

public interface IngredientService {

	    List<Ingredient> getAllIngredients();

	    Ingredient getIngredientById(Long id);

	    void addIngredient(Ingredient ingredient);

	    void updateIngredient(Ingredient ingredient);

	    void deleteIngredient(Long id);

		void ajoutIngredient(Ingredient ingredient);

		void modifIngredient(Ingredient ingredient);
	}



