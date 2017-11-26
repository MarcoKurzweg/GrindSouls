package Model;

public class Minotaur extends Enemy{
	
	public Minotaur() {
		this.enemyType = "Minotaur";
		this.enemyAttackDamage = 30;
//		ge�ndert
		this.maxEnemyHealth = 100;
		this.enemyHealth = maxEnemyHealth;
//		bis hier
		this.armorClass = "heavy";
		this.enemyFile = "src/Images/Minotaur.png";								//ge�ndert
		this.enemySteht = "src/Images/Werwolf-Steht2.png";
		this.enemyLinks = "src/Images/Werwolf-Links2.png";
		this.enemyRechts = "src/Images/Werwolf-Rechts2.png";

		
	}

}
