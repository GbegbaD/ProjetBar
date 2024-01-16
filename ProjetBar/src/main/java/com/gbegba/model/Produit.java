package com.gbegba.model;

public class Produit {

	    private int produitID;
	    private String nomProduit;
	    private String categorie;
	    private double prix;
	    private int stockDispo;
	    
	    
		public int getProduitID() {
			return produitID;
		}
		public void setProduitID(int produitID) {
			this.produitID = produitID;
		}
		public String getNomProduit() {
			return nomProduit;
		}
		public void setNomProduit(String nomProduit) {
			this.nomProduit = nomProduit;
		}
		public String getCategorie() {
			return categorie;
		}
		public void setCategorie(String categorie) {
			this.categorie = categorie;
		}
		public double getPrix() {
			return prix;
		}
		public void setPrix(double prix) {
			this.prix = prix;
		}
		public int getStockDispo() {
			return stockDispo;
		}
		public void setStockDispo(int stockDispo) {
			this.stockDispo = stockDispo;
		}
	    
}




