package produit;

import personnages.Gaulois;

public class Sanglier extends Produit{
	private int poids;
	private Gaulois chasseur;
	
	public Sanglier(Gaulois chasseur) {
		super("sanglier",Unite.PIECE);
		this.chasseur = chasseur;
	}
	
	public void description() {
		System.out.println(super.nom + " de " + poids + " chassé par " + chasseur.getNom() + ".\n");
	}

}
