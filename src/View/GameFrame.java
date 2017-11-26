package View;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.*;

public class GameFrame extends JFrame {

//	????
	Player player = new Magier();
//	????

	JButton attackButton, potionButton, stealButton, runButton, saveButton, loadButton; //Änderung
//	geï¿½ndert
	JLabel lifeLabel, attackLabel,armorLabel, potionsLabel, enemyLabel, enemyLifeLabel, enemyAttackLabel, enemyArmorLabel, levelLabel;
//	bis hier
	GamePanel gP = new GamePanel();
	
	public GameFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(700,700);
		setTitle("DungeonGrind");
		getContentPane();
		setLocationRelativeTo(null);
		
		gP.setLayout(null);
		
//		Buttons anlegen.
		
		attackButton = new JButton("Angriff");
		attackButton.setBounds(20,150,100,30);
		attackButton.setBackground(Color.BLACK);
		attackButton.setFont(new Font("Arial", Font.BOLD, 12));
		attackButton.setForeground(Color.RED);
		potionButton = new JButton("Heilen");
		potionButton.setBounds(20,190,100,30);
		potionButton.setBackground(Color.BLACK);
		potionButton.setFont(new Font("Arial", Font.BOLD, 12));
		potionButton.setForeground(Color.RED);
		stealButton = new JButton("Stehlen");
		stealButton.setBounds(20,230,100,30);
		stealButton.setBackground(Color.BLACK);
		stealButton.setFont(new Font("Arial", Font.BOLD, 12));
		stealButton.setForeground(Color.RED);
		runButton = new JButton("Flüchten");
		runButton.setBounds(20,270,100,30);
		runButton.setBackground(Color.BLACK);
		runButton.setFont(new Font("Arial", Font.BOLD, 12));
		runButton.setForeground(Color.RED);
		saveButton = new JButton("Speichern");
		saveButton.setBounds(20,380,100,30);
		saveButton.setBackground(Color.BLACK);
		saveButton.setFont(new Font("Arial", Font.BOLD, 12));
		saveButton.setForeground(Color.RED);
		loadButton = new JButton("Laden");
		loadButton.setBounds(20,420,100,30);
		loadButton.setBackground(Color.BLACK);
		loadButton.setFont(new Font("Arial", Font.BOLD, 12));
		loadButton.setForeground(Color.RED);
		

		
//		Label anlegen.
		
		
//		ein paar werte geï¿½ndert
		attackLabel = new JLabel();
		attackLabel.setBounds(180,44,50,20);
		attackLabel.setFont(new Font("Arial", Font.BOLD, 16));
		attackLabel.setForeground(Color.WHITE);
		
		lifeLabel = new JLabel();
		lifeLabel.setBounds(375,7,150,20);
		lifeLabel.setFont(new Font("Castellar", Font.BOLD, 18));
		lifeLabel.setForeground(Color.BLACK);
		
		armorLabel = new JLabel();
		armorLabel.setBounds(260,44,50,20);
		armorLabel.setFont(new Font("Arial", Font.BOLD, 16));
		armorLabel.setForeground(Color.WHITE);
		
		potionsLabel = new JLabel();
		potionsLabel.setBounds(340,44,50,20);
		potionsLabel.setFont(new Font("Arial", Font.BOLD, 16));
		potionsLabel.setForeground(Color.WHITE);
//	geï¿½ndert	
		enemyLabel = new JLabel();
		enemyLabel.setBounds(180, 592, 100, 20);
		enemyLabel.setFont(new Font("Arial", Font.BOLD, 16));
		enemyLabel.setForeground(Color.WHITE);
		
		enemyLifeLabel = new JLabel();
		enemyLifeLabel.setBounds(300, 632, 150, 20);
		enemyLifeLabel.setFont(new Font("Castellar", Font.BOLD, 18));
		enemyLifeLabel.setForeground(Color.BLACK);
		
		enemyAttackLabel = new JLabel();
		enemyAttackLabel.setBounds(325, 592, 100, 20);
		enemyAttackLabel.setFont(new Font("Arial", Font.BOLD, 16));
		enemyAttackLabel.setForeground(Color.WHITE);
		
		enemyArmorLabel = new JLabel();
		enemyArmorLabel.setBounds(425, 592, 100, 20);
		enemyArmorLabel.setFont(new Font("Arial", Font.BOLD, 16));
		enemyArmorLabel.setForeground(Color.WHITE);
		
		levelLabel = new JLabel("Lvl");
		levelLabel.setBounds(85, 130, 50, 10);
		levelLabel.setFont(new Font("Arial", Font.BOLD, 12));
		levelLabel.setForeground(Color.YELLOW);
//	bis hier!!!	
		
		
//		Buttons an Panel
		gP.add(attackButton);
		gP.add(potionButton);
		gP.add(stealButton);
		gP.add(runButton);
		gP.add(saveButton);
		gP.add(loadButton);
		
//		Labels an Panel
		gP.add(attackLabel);
		gP.add(lifeLabel);
		gP.add(armorLabel);
		gP.add(potionsLabel);
		gP.add(levelLabel);
//		geï¿½ndert
		gP.add(enemyLabel);
		gP.add(enemyLifeLabel);
		gP.add(enemyAttackLabel);
		gP.add(enemyArmorLabel);
//		bis hier
		
		add(gP);
	}
	


	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public JButton getAttackButton() {
		return attackButton;
	}

	public void setAttackButton(JButton attackButton) {
		this.attackButton = attackButton;
	}

	public JButton getPotionButton() {
		return potionButton;
	}

	public void setPotionButton(JButton potionButton) {
		this.potionButton = potionButton;
	}

	public JButton getStealButton() {
		return stealButton;
	}

	public void setStealButton(JButton stealButton) {
		this.stealButton = stealButton;
	}

	public JButton getRunButton() {
		return runButton;
	}

	public void setRunButton(JButton runButton) {
		this.runButton = runButton;
	}

	public JButton getSaveButton() {
		return saveButton;
	}

	public void setSaveButton(JButton saveButton) {
		this.saveButton = saveButton;
	}

	public JButton getLoadButton() {
		return loadButton;
	}

	public void setLoadButton(JButton loadButton) {
		this.loadButton = loadButton;
	}

	public JLabel getLifeLabel() {
		return lifeLabel;
	}

	public void setLifeLabel(JLabel lifeLabel) {
		this.lifeLabel = lifeLabel;
	}

	public JLabel getAttackLabel() {
		return attackLabel;
	}

	public void setAttackLabel(JLabel attackLabel) {
		this.attackLabel = attackLabel;
	}

	public JLabel getPotionsLabel() {
		return potionsLabel;
	}

	public void setPotionsLabel(JLabel potionsLabel) {
		this.potionsLabel = potionsLabel;
	}

	public JLabel getEnemyLabel() {
		return enemyLabel;
	}

	public void setDamageLabel(JLabel enemyLabel) {
		this.enemyLabel = enemyLabel;
	}

	public JLabel getEnemyLifeLabel() {
		return enemyLifeLabel;
	}

	public void setEnemyLifeLabel(JLabel enemyLifeLabel) {
		this.enemyLifeLabel = enemyLifeLabel;
	}

	public JLabel getEnemyAttackLabel() {
		return enemyAttackLabel;
	}

	public void setEnemyAttackLabel(JLabel enemyAttackLabel) {
		this.enemyAttackLabel = enemyAttackLabel;
	}


	public void setGamePanel(GamePanel gP) {
		this.gP = gP;
	}

	public GamePanel getGamePanel(){
		return gP;
	}
	
	public void updatePlayerStats(int attackDamage, int playerHealth, int maxPlayerHealth, int armorUp, int numPotions, int playerLevel) {
		attackLabel.setText(": " + attackDamage);
		lifeLabel.setText(playerHealth + " / " + maxPlayerHealth);
		armorLabel.setText(": " + armorUp);
		potionsLabel.setText(": " + numPotions);
		levelLabel.setText("LvL: " + playerLevel);
		
	}
//	geä½ndert
	public void updateEnemyStats(String enemyType, int enemyHealth, int maxEnemyHealth, int enemyAttackDamage, String armorClass) {
		enemyLabel.setText(enemyType);
		enemyLifeLabel.setText(enemyHealth + " / " + maxEnemyHealth);
		enemyAttackLabel.setText(": " + enemyAttackDamage);
		enemyArmorLabel.setText(armorClass);
	}
	
	//Switchen der Buttons ins Menu
	public void setMenuButtons(){
		attackButton.setEnabled(false);
		stealButton.setEnabled(false);
		runButton.setEnabled(false);
		saveButton.setEnabled(true);
		loadButton.setEnabled(true);
		
		//ausblenden des Enemies
		enemyLabel.setVisible(false);
		enemyLifeLabel.setVisible(false);
		enemyAttackLabel.setVisible(false);
		enemyArmorLabel.setVisible(false);
	}
	
	public void setCombatButtons(){
		attackButton.setEnabled(true);
		stealButton.setEnabled(true);
		runButton.setEnabled(true);
		saveButton.setEnabled(false);
		loadButton.setEnabled(false);
		
		enemyLabel.setVisible(true);
		enemyLifeLabel.setVisible(true);
		enemyAttackLabel.setVisible(true);
		enemyArmorLabel.setVisible(true);
		
	}
	
	
	
	
}
