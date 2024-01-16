package com.gbegba.model;
import java.util.List;

public class Commande {
    private int id;
    private List<Produit> produits;

    public Commande(int id, List<Produit> produits) {
        this.id = id;
        this.produits = produits;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public static void add(Commande commande) {
		// TODO Auto-generated method stub
		
		 Commande.add(commande);
		 
	}

}

	


