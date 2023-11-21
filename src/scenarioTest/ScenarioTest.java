package scenarioTest;

import personnages.Gaulois;
import produit.Poisson;
import produit.Produit;
import produit.Sanglier;
import villagegaulois.Etal;
import villagegaulois.IEtal;

public class ScenarioTest {
	
	public static void main(String[] args) {
		Gaulois ordralfabetix = new Gaulois("Ordralfabétix", 9);
		Gaulois obelix = new Gaulois("Obélix", 20);
		Gaulois asterix = new Gaulois("Astérix", 6);
		
		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);
		
		Sanglier[] sangliersObelix = {sanglier1, sanglier2};
		Sanglier[] sangliersAsterix = {sanglier3, sanglier4};
		
		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = {poisson1};
		
		Etal<Sanglier> etal1 = new Etal<>();
		Etal<Sanglier> etal2 = new Etal<>();
		Etal<Poisson> etal3 = new Etal<>();
		
		etal2.installerVendeur(obelix, sangliersObelix, 8);
		etal1.installerVendeur(asterix, sangliersAsterix, 10);
		etal3.installerVendeur(ordralfabetix, poissons, 7);
		
		Etal[] etals = {etal1,etal2, etal3};
		
		StringBuilder chaine = new StringBuilder();
		chaine.append("ETAT MARCHE\n\n");
		for (int i = 0; i < etals.length; i++) {
			chaine.append(etals[i].etatEtal());
		}
		
		int nbrAAcheter = 3;
		int numEtal = 0;
		int quantiteAVendre;
		double prix;
		while (nbrAAcheter != 0 || numEtal != 3) {
			prix = 0;
			quantiteAVendre = etals[numEtal].contientProduit("sanglier", nbrAAcheter);
			if (quantiteAVendre != 0) {
				prix = etals[numEtal].acheterProduit(quantiteAVendre);
				chaine.append("A l'étal " + numEtal + " je paye " + prix + " sous.\n");
				nbrAAcheter -= quantiteAVendre;
			}
			numEtal++;
		}
		
		chaine.append("\nETAT MARCHE\n\n");
		for (int i = 0; i < etals.length; i++) {
			chaine.append(etals[i].etatEtal());
		}
		System.out.println(chaine.toString());
	}
}
