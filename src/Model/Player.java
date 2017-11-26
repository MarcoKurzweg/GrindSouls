package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Player {

	protected String name;
	protected String klasse;
	
	protected boolean isAlive;
	protected int playerHealth = 100;
	protected int attackDamage = 50;
	protected int numPotions = 3;
	protected int potionHeal = 30;
	protected int playerExperience = 0;
	protected int levelUpPoints = 50;
	protected int armorUp = 0;
	protected int weaponUp = 0;
	protected int playerLevel = 1;
	protected int maxPlayerHealth = 100;
	protected int score;
	protected String file = "";
	protected String steht, links, rechts, sound;

	// SpielerInfos aus SaveFile
	protected int[] saveInformation = { playerHealth, attackDamage, numPotions, potionHeal, playerExperience, playerLevel,
			levelUpPoints, armorUp, weaponUp, score, maxPlayerHealth };
	protected int pHLoc = 0;
	protected int pALoc = 1;
	protected int pPLoc = 2;
	protected int pHeLoc = 3;
	protected int pXPLoc = 4;
	protected int pLLoc = 5;
	protected int pLpLoc = 6;
	protected int pArLoc = 7;
	protected int pWLoc = 8;
	protected int pSLoc = 9;
	protected int pMHLoc = 10;

	protected String[] userInformation = { name, klasse };
	protected int pNLoc = 0;
	protected int pKLoc = 1;

	//Boolean, gibt an ob Player im Kampf ist
	protected boolean inFight;
	
	
	public Player() {
		isAlive = true;
	}
	
	
	
	
	
	// Laden
	public void readUser(String filePath) {
		File inputFile;
		BufferedReader inputReader;

		try {
			inputFile = new File(filePath);
			inputReader = new BufferedReader(new FileReader(inputFile));
			for (int i = 0; i < userInformation.length; i++) {
				userInformation[i] = inputReader.readLine();
			}
			this.name = userInformation[pNLoc];
			this.klasse = userInformation[pKLoc];

			inputReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void readPlayer(String filePath) {
		File inputFile;
		BufferedReader inputReader;

		try {
			inputFile = new File(filePath);
			inputReader = new BufferedReader(new FileReader(inputFile));
			for (int i = 0; i < saveInformation.length; i++) {
				saveInformation[i] = Integer.parseInt(inputReader.readLine());
			}
			this.playerHealth = saveInformation[pHLoc];
			this.attackDamage = saveInformation[pALoc];
			this.numPotions = saveInformation[pPLoc];
			this.potionHeal = saveInformation[pHeLoc];
			this.playerExperience = saveInformation[pXPLoc];
			this.playerLevel = saveInformation[pLLoc];
			this.levelUpPoints = saveInformation[pLpLoc];
			this.armorUp = saveInformation[pArLoc];
			this.weaponUp = saveInformation[pWLoc];
			this.score = saveInformation[pSLoc];
			this.maxPlayerHealth = saveInformation[pMHLoc];

			inputReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Speichern
	public void saveUser(String filePath) {
		File outputFile;
		BufferedWriter outputWriter;

		try {
			outputFile = new File(filePath);
			outputWriter = new BufferedWriter(new FileWriter(outputFile));

			userInformation[pNLoc] = name;
			userInformation[pKLoc] = klasse;

			for (int i = 0; i < userInformation.length; i++) {
				outputWriter.write(userInformation[i] + "\n");
			}

			outputWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void savePlayer(String filePath) {
		File outputFile;
		BufferedWriter outputWriter;

		try {
			outputFile = new File(filePath);
			outputWriter = new BufferedWriter(new FileWriter(outputFile));

			saveInformation[pHLoc] = playerHealth;
			saveInformation[pALoc] = attackDamage;
			saveInformation[pPLoc] = numPotions;
			saveInformation[pHeLoc] = potionHeal;
			saveInformation[pXPLoc] = playerExperience;
			saveInformation[pLLoc] = playerLevel;
			saveInformation[pLpLoc] = levelUpPoints;
			saveInformation[pArLoc] = armorUp;
			saveInformation[pWLoc] = weaponUp;
			saveInformation[pSLoc] = score;
			saveInformation[pMHLoc] = maxPlayerHealth;

			for (int i = 0; i < saveInformation.length; i++) {
				outputWriter.write(Integer.toString(saveInformation[i]) + "\n");
			}

			outputWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Getter Methoden
	public String getName() {
		return name;
	}

	public String getKlasse() {
		return klasse;
	}

	public int getLevelUpPoints() {
		return levelUpPoints;
	}

	public int getPlayerHealth() {
		return playerHealth;
	}
	

	public int getMaxPlayerHealth() {
		return maxPlayerHealth;
	}

	public int getScore() {
		return score;
	}

	public int getAttackDamage() {
		return attackDamage;
	}

	public int getNumPotions() {
		return numPotions;
	}

	public int getPotionHeal() {
		return potionHeal;
	}

	public int getExperience() {
		return playerExperience;
	}

	public int getArmorUp() {
		return armorUp;
	}

	// Setter Methoden
	public void increaseArmorUp(int armorUps) {
		this.armorUp += armorUps;
	}

	
	//Ã„nderung
	public void takeDamage(int damage, int armor) {
		damage = damage - armor;
		if (damage <= 1){
			damage = 0;
		}
		this.playerHealth = playerHealth - damage;
		if (playerHealth <= 0) {
			isAlive = false;
		}
	}

	public void potionHeal(int heal) {
		this.numPotions--;
		this.playerHealth = playerHealth + potionHeal;
		if (this.playerHealth > this.maxPlayerHealth) {
			this.playerHealth = this.maxPlayerHealth;
		}
	}

	public void increaseLevel(int experience) {
		this.playerExperience += experience;
		increaseScore(experience);
		if (playerExperience >= levelUpPoints){
			this.playerLevel ++;
			this.attackDamage ++; 
			this.playerExperience = playerExperience - levelUpPoints;
			this.levelUpPoints = levelUpPoints + 50;
			this.playerHealth = maxPlayerHealth;
			
		}

	}

	public void levelUp(int increase) {
		
		this.attackDamage += increase;
	}

	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}

	public void setPlayerHealth(int playerHealth) {
		this.playerHealth = playerHealth;
		this.maxPlayerHealth = playerHealth;
	}

	public void setLevelUpPoints(int levelUpPoints) {
		this.levelUpPoints = levelUpPoints;
	}

	public void increaseAttackDamage(int addition) {
		this.attackDamage += addition;
	}

	public void increaseNumPotions(int potions) {
		this.numPotions += potions;
	}

	public void setPotionHeal(int potionHeal) {
		this.potionHeal = potionHeal;
	}

	public void setNumPotions(int numPotion) {
		this.numPotions = numPotion;
	}

	public void increaseScore(int points) {
		this.score += points;
	}

	public void increaseExperience(int experience) {
		this.playerExperience += experience;
		increaseScore(experience);
	}

	public void setExperience(int experience) {
		this.playerExperience = experience;
	}

	public void improveDamage(int damage) {

	}

	public void setKlasse(String klasse) {
		this.klasse = klasse;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public void setFile(String file) {
		this.file = file;
	}
	
	public String getFile() {
		return file;
	}
	
	public String getSteht() {
		return steht;
	}
	
	public void setSteht(String steht) {
		this.steht = steht;
	}
	
	public boolean getInFight() {
		return inFight;
	}
	
	public void setInFight(boolean inFight) {
		this.inFight = inFight;
	}
	
	public boolean getIsAlive() {
		return isAlive;
	}
	
	public void setIsAlive() {
		this.isAlive = isAlive;
	}
	
	public void equipItem(String item){
		if(item == "Talisman"){
			armorUp++;
		}
		if(item == "Rüstung"){
			armorUp += 3;
		}
		if(item == "Waffe"){
			attackDamage += 3;
		}
		if (item == "Heiltrank"){
			numPotions++;
		}
	}
	
	public int getPlayerLevel() {
		return playerLevel;
	}
	
	public String getLinks() {
		return links;
	}
	
	public String getRechts() {
		return rechts;
	}
	
	public String getSound() {
		return sound;
	}

}