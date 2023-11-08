package produit;

public enum Unite {
	LITRE("l"),GRAMME("g"),KILOGRAMME("kg"),CENTILITRE("cl"),MILLILITRE("ml"),PIECE("par pièce");
	
	private String nom;
	
	private Unite(String nom) {
		this.nom = nom;
	}
}
