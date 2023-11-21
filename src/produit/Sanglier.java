package produit;

import personnages.Gaulois;

public class Sanglier extends Produit{
	private int poids;
	private Gaulois chasseur;
	
	public Sanglier(int poids, Gaulois chasseur) {
		super("sanglier",Unite.KILOGRAMME);
		this.chasseur = chasseur;
		this.poids = poids;
	}
	
	public String description() {
		StringBuilder chaine = new StringBuilder();
		chaine.append(super.nom + " de " + poids + " " + super.unite.getUnite() + " chassé par " + chasseur.getNom() + ".\n");
		return chaine.toString();
	}
	
	public double calculerPrix(int prix) {
		double prixfinal = (double) prix / 1000 * poids;
		return prixfinal;
	}
}