package scenarioTest;

import produit.Poisson;
import produit.Produit;
import produit.Sanglier;
import villagegaulois.Etal;
import villagegaulois.IEtal;

public class ScenarioTest {
	public static void main(String[] args) {
		IEtal[] marche = new IEtal[3];
		Etal<Sanglier> etalSanglier = new Etal<>();
		marche[0] = etalSanglier;
	}
	
}
