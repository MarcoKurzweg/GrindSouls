package Model;


import java.util.Random;

public class Enemy {

	Random rand = new Random();
	String enemyType;
	int maxEnemyHealth;
	int enemyAttackDamage;
	int enemyHealth;
	int enemyXp;
	boolean enemyAlive = true;
	String armorClass;
	String loot = "";
	
//	geï¿½ndert
	String enemyFile;
	String enemySteht, enemyLinks, enemyRechts;
//	bis hier
	
	
	
	int[] enemyInformation = {maxEnemyHealth , enemyAttackDamage, enemyHealth, enemyXp};
	int eMLoc = 0;
	int eALoc = 1;
	int eHLoc = 2;
	int eXLoc = 3;
	
	int eLLoc = 0;
	int eNLoc = 1;
	
	
	
	public String getEnemyType (){
	return enemyType; 
 	} 
	
	public String getArmorClass (){
		return armorClass;
	}
	
	public String getEnemyFile() {
		return enemyFile;
	}
	
	public int getEnemyMaxHealth (){
	return maxEnemyHealth; 
 	} 
	
	public int getEnemyAttackDamage (){
	return enemyAttackDamage; 
 	} 
	
	public int getEnemyHealth (){
	return enemyHealth; 
 	} 

	//Liefert true, wenn der Enemy alive ist
	public boolean getEnemyAliveStatus (){
		return enemyAlive;
 	} 
	
	public int getEnemyXp (){
		return enemyXp;
 	} 
	
	public String getLoot(){
		return loot;
	}
	
	public void takeDamage (int damage, String playerKlasse){
		if (this.armorClass == "heavy" && playerKlasse == "Dieb"){
			damage = damage * 125 / 100;
		}
		if (this.armorClass == "magic" && playerKlasse == "Magier"){
			damage = damage * 125 / 100;
		}
		if (this.armorClass == "light" && playerKlasse == "Krieger"){
			damage = damage * 125 / 100;
		}
		this.enemyHealth = enemyHealth - damage;
		if (this.enemyHealth < 1){
			this.enemyAlive = false;
			this.enemyHealth = 0;
		}
	}
	
	public void setMaxEnemyHealth (int enemyHealth){
		this.maxEnemyHealth = enemyHealth;
	}
	
	public void setEnemyAttackDamage (int attackDamage){
		this.enemyAttackDamage = attackDamage;
	}
	
	public void setEnemyXP (int experience){
		this.enemyXp = experience;
	}
	
	public void setLoot (String loot){
		this.loot = loot;
	}	 
	
	public void generateLoot (){
		double randomNumber = Math.random() * 100;
		if (randomNumber > 25 && randomNumber < 55){
			this.loot = "Heiltrank";
		}
		if (randomNumber > 56 && randomNumber < 75){
			this.loot = "Talisman";
		}
		if (randomNumber > 76 && randomNumber < 90){
			this.loot = "Waffe";
		}
		if (randomNumber > 91 && randomNumber <= 100){
			this.loot = "Rüstung";
		}
	}
	
	public void setEnemySteht(String enemySteht) {
		this.enemySteht = enemySteht;
	}
	public String getSteht() {
		return enemySteht;
	}
	public String getEnemyLinks() {
		return enemyLinks;
	}
	public String getEnemyRechts() {
		return enemyRechts;
	}
}
