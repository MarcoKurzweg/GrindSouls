package Model;

public class Skeleton extends Enemy{
	public Skeleton() {
		this.enemyType = "Skeleton";
		this.enemyAttackDamage = 20;
//		ge�ndert
		this.maxEnemyHealth = 70;
		this.enemyHealth = maxEnemyHealth;
//		bis hier
		this.armorClass = "light";
		this.enemyFile = "src/Images/Skeleton.png";				//ge�ndert
		this.enemySteht = "src/Images/Skelett-Steht2.png";
		this.enemyLinks = "src/Images/Skelett-Links2.png";
		this.enemyRechts = "src/Images/Skelett-Rechts2.png";
	}
}
