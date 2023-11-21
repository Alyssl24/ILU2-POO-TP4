package produit;

public class Poisson extends Produit{
	private String datePeche;
	
	public Poisson(String datePeche) {
		super("poisson",Unite.PIECE);
		this.datePeche = datePeche;
	}
	
	public String description() {
		StringBuilder chaine = new StringBuilder();
		chaine.append(super.nom + " pêché " + datePeche + ".\n");
		return chaine.toString();
	}
}
