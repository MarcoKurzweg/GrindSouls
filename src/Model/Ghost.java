package Model;

public class Ghost extends Enemy {
	public Ghost() {
		this.enemyType = "Ghost";
		this.enemyAttackDamage = 20;
//		geändert
		this.maxEnemyHealth = 110;
		this.enemyHealth = maxEnemyHealth;
//		bis hier
		this.armorClass = "magic";
		this.enemyFile = "src/Images/Ghost.png";					//geändert
		this.enemySteht = "src/Images/Geist-Steht2.png";
		this.enemyLinks = "src/Images/Geist-Links2.png";
		this.enemyRechts = "src/Images/Geist-Rechts2.png";
	}
}
