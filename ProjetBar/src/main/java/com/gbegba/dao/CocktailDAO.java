package com.gbegba.dao;

import com.gbegba.model.Cocktail;

import java.util.ArrayList;
import java.util.List;

public class CocktailDAO {

    private List<Cocktail> cocktails;

    public CocktailDAO() {
        cocktails = new ArrayList<>();
    }

    public void add(Cocktail cocktail) {
        cocktails.add(cocktail);
    }

    public List<Cocktail> getAll() {
        return cocktails;
    }

    public Cocktail get(int id) {
        for (Cocktail cocktail : cocktails) {
            if (cocktail.getId() == id) {
                return cocktail;
            }
        }

        return null;
    }

	public void update(Cocktail cocktail) {
		// TODO Auto-generated method stub
		
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
}
