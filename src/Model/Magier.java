package Model;

public class Magier extends Player {

	public Magier() {

		this.klasse = "Magier";
		this.potionHeal = 50;
		this.numPotions += 2;
		
//		geändert
		this.file = "src/Images/Magier.jpg";
		this.steht = "src/Images/Magier-Steht2.png";
		this.links = "src/Images/Magier-Links2.png";
		this.rechts = "src/Images/Magier-Rechts2.png";
		
//		bis hier
	}

}
