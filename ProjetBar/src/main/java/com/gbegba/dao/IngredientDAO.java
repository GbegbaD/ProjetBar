package com.gbegba.dao;

import com.gbegba.model.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class IngredientDAO {

    private List<Ingredient> ingredients;

    public IngredientDAO() {
        ingredients = new ArrayList<>();
    }

    public void add(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public List<Ingredient> getAll() {
        return ingredients;
    }
}
