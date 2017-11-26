package Model;

public class Krieger extends Player {

	public Krieger() {

		this.klasse = "Krieger";
		this.armorUp += 5;
		this.attackDamage += 5;
//		geändert
		this.file = "src/Images/Krieger.jpg";
		this.steht = "src/Images/Krieger-Steht2.png";
		this.links = "src/Images/Krieger-Links2.png";
		this.rechts = "src/Images/Krieger-Rechts2.png";
		
//		bis hier
	}

}
