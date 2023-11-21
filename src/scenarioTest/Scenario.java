package scenarioTest;

import personnages.Gaulois;
import produit.Poisson;
import produit.Produit;
import produit.Sanglier;
import villagegaulois.DepenseMarchand;
import villagegaulois.Village;
import villagegaulois.Etal;

public class Scenario {

	public static void main(String[] args) {

		// TODO Partie 4 : creer de la classe anonyme Village
		Village village = new Village() {
			private Etal[] etals = new Etal[3];
			private int nbEtals = 0;
			
			@Override
			public <P extends Produit> boolean installerVendeur(Etal<P> etal, Gaulois vendeur, P[] produit, int prix) {
				etal.installerVendeur(vendeur, produit, prix);
				etals[nbEtals] = etal;
				nbEtals++;
				return true;
				
			}
			
			@Override
			public DepenseMarchand[] acheterProduit(String produit, int quantiteSouhaitee) {
				DepenseMarchand[] depense = new DepenseMarchand[3];
				double prixPaye;
				int quantiteAVendre;
				for (int i = 0; i < nbEtals && quantiteSouhaitee != 0; i++) {
					quantiteAVendre = etals[i].contientProduit(produit, quantiteSouhaitee);
					prixPaye = etals[i].acheterProduit(quantiteAVendre);
					depense[i] = new DepenseMarchand(etals[i].getVendeur(), quantiteAVendre, produit, prixPaye);
					quantiteSouhaitee -= quantiteAVendre;
				}
				return depense;
			}
			
			public String toString() {
				StringBuilder chaine = new StringBuilder();
				chaine.append("ETAT MARCHE\n\n");
				for (int i = 0; i < nbEtals; i++) {
					chaine.append(etals[i].etatEtal()); 
				}
				return chaine.toString();
			}
		};
		// fin

		Gaulois ordralfabetix = new Gaulois("Ordralfabétix", 9);
		Gaulois obelix = new Gaulois("Obélix", 20);
		Gaulois asterix = new Gaulois("Astérix", 6);

		Etal<Sanglier> etalSanglierObelix = new Etal<>();
		Etal<Sanglier> etalSanglierAsterix = new Etal<>();
		Etal<Poisson> etalPoisson = new Etal<>();

		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);

		Sanglier[] sangliersObelix = { sanglier1, sanglier2 };
		Sanglier[] sangliersAsterix = { sanglier3, sanglier4 };

		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = { poisson1 };

		village.installerVendeur(etalSanglierAsterix, asterix, sangliersAsterix, 10);
		village.installerVendeur(etalSanglierObelix, obelix, sangliersObelix, 8);
		village.installerVendeur(etalPoisson, ordralfabetix, poissons, 5);

		System.out.println(village.toString());

		DepenseMarchand[] depense = village.acheterProduit("sanglier", 3);

		for (int i = 0; i < depense.length && depense[i] != null; i++) {
			System.out.println(depense[i].toString());
		}

		System.out.println(village);

	}

}
