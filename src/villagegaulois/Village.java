package villagegaulois;

import personnages.Gaulois;
import produit.Produit;

public interface Village {
	public <P extends Produit> boolean installerVendeur(Etal<P> etal,
			Gaulois vendeur, P[] produit, int prix);
	
	public DepenseMarchand[] acheterProduit(String produit,
			int quantiteSouhaitee);
}
