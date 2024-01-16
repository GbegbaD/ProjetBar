package com.gbegba.service;
	import java.util.List;
	import com.gbegba.model.Produit;

	public interface ProduitService {
	    List<Produit> getAllProduits();
	    Produit getProduitById(int produitId);
	    void addProduit(Produit produit);
	    void updateProduit(Produit produit);
	    void deleteProduit(int produitId);
	   
	}
	

