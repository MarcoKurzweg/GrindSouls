package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.Timer;

import Model.Enemy;
import Model.Player;
import View.GameFrame;
import View.GamePanel;

public class Controller {
	

	private GameFrame gameFrame;
	private GamePanel gamePanel;
	private Random random = new Random();
	private int randomIndex;
	private Timer timer;
	int count = 0;
	private double randomNumber;

	private Player player;
	private EnemyFactory enemyFactory;
	private String[] enemyTypes = {"Minotaur","Skeleton","Ghost"};
	private Enemy enemy;
	
	private String attack = "src/Sounds/Punsh.wav";
	private String heal = "src/Sounds/Heal.wav";
	private String steal = "src/Sounds/Steal.wav";
	private String steps = "src/Sounds/Steps.wav";	
	
	private boolean fight = false;
	
	
	private BigBrother bigBrother;

	
	public Controller(Player player){
		

		this.player = player;
		enemyFactory = new EnemyFactory();
		gameFrame = new GameFrame();
		gamePanel = gameFrame.getGamePanel();
		
		
		
		//Änderung
//		bigBrother = new BigBrother(player, gameFrame, gamePanel);
//		Thread a = new Thread(bigBrother);
//		a.start();
		gameFrame.add(gamePanel);
		start();

		configureButtons();
		//Erster Gegner wird gespawnt
//		player.setInFight(true);
//		randomIndex = ThreadLocalRandom.current().nextInt(0, 2 + 1);
//		enemy = enemyFactory.createEnemy(enemyTypes[randomIndex]);
//		gameFrame.setCombatButtons();
//		updateGUI();
		gameFrame.addKeyListener(new KeyAdapter(){
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyPressed(e);
				
				if(e.getKeyCode() == KeyEvent.VK_D && !gameFrame.getGamePanel().getCombatStatus()){
					timer.start();
				}
			}
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyTyped(e);
				
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyReleased(e);
				
				if(e.getKeyCode() == KeyEvent.VK_D){
					timer.stop();
				}
			}
			
		});
		
		gameFrame.requestFocus();
		timer = new Timer(10, new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				count++;
				update();
				gameFrame.getGamePanel().repaint();
				gameFrame.getGamePanel().setCount(count);
				
				try {
					AudioInputStream stream = AudioSystem.getAudioInputStream(new File(steps));
					AudioFormat af = stream.getFormat();
					int size = (int) (af.getFrameSize() * stream.getFrameLength());
					byte[] audio  = new byte[size];
					DataLine.Info info = new DataLine.Info(Clip.class, af, size);
					stream.read(audio, 0, size);
					
					// for(int i=0; i < 32; i++) {
					Clip clip = (Clip) AudioSystem.getLine(info);
					clip.open(af, audio, 0, size);
					clip.start();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		
		
	}
	

	
	private void configureButtons() {
		//Buttons
		gameFrame.getAttackButton().addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				//Schadensberechnung
				player.takeDamage(random.nextInt(enemy.getEnemyAttackDamage()), player.getArmorUp());
				enemy.takeDamage(random.nextInt(player.getAttackDamage()), player.getKlasse());
					
				updateGUI();
				
				
				try {
					AudioInputStream stream = AudioSystem.getAudioInputStream(new File(attack));
					AudioFormat af = stream.getFormat();
					int size = (int) (af.getFrameSize() * stream.getFrameLength());
					byte[] audio  = new byte[size];
					DataLine.Info info = new DataLine.Info(Clip.class, af, size);
					stream.read(audio, 0, size);
					
					// for(int i=0; i < 32; i++) {
					Clip clip = (Clip) AudioSystem.getLine(info);
					clip.open(af, audio, 0, size);
					clip.start();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				//Abrechnung nach dem Kampf
				if (!enemy.getEnemyAliveStatus()){
					updateAfterFight();
					gameFrame.getGamePanel().getEnemyRectangle().setLocation(650, 400);
					
					gameFrame.requestFocus();

				}
				
		        if (!player.getIsAlive()) {
                    gameFrame.dispose();
                    GuiController guiController = new GuiController();
                } 

			}
		});
				
		//Heiltrank Button
		gameFrame.getPotionButton().addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//HeilungsAbwicklung
				if(player.getNumPotions() > 0){
					player.potionHeal(player.getPotionHeal());
					gameFrame.updatePlayerStats(player.getAttackDamage(), player.getPlayerHealth(), player.getMaxPlayerHealth(), player.getArmorUp(), player.getNumPotions(),player.getPlayerLevel());
					gameFrame.getGamePanel().setHealth(player.getPlayerHealth());
					gameFrame.getGamePanel().setMaxHealth(player.getMaxPlayerHealth());
					gameFrame.getGamePanel().repaint();
					
					gameFrame.requestFocus();
							
					
					try {
						AudioInputStream stream = AudioSystem.getAudioInputStream(new File(heal));
						AudioFormat af = stream.getFormat();
						int size = (int) (af.getFrameSize() * stream.getFrameLength());
						byte[] audio  = new byte[size];
						DataLine.Info info = new DataLine.Info(Clip.class, af, size);
						stream.read(audio, 0, size);
						
						// for(int i=0; i < 32; i++) {
						Clip clip = (Clip) AudioSystem.getLine(info);
						clip.open(af, audio, 0, size);
						clip.start();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		
		//DiebstahlButton nur bei Dieb
		if(player.getKlasse()== "Dieb"){
			gameFrame.getStealButton().addActionListener(new ActionListener() {
				
				@Override
				//Diebstahlberechnung
				public void actionPerformed(ActionEvent e) {
					player.takeDamage(random.nextInt(enemy.getEnemyAttackDamage()), player.getArmorUp());
					randomNumber = Math.random() * 100;
					
					if (randomNumber >= 60 && randomNumber <= 70){
						player.equipItem("Heiltrank");
					}
					else if (randomNumber >= 71 && randomNumber <= 80){
						player.equipItem("Talisman");
					} 
					else if (randomNumber >= 81 && randomNumber <= 90) {
						player.equipItem("Waffe");
					} 
					else if (randomNumber >= 91 && randomNumber <= 100) {
						player.equipItem("Rüstung");
					} 
					gameFrame.updatePlayerStats(player.getAttackDamage(), player.getPlayerHealth(), player.getMaxPlayerHealth(), player.getArmorUp(), player.getNumPotions(),player.getPlayerLevel());
					gameFrame.getGamePanel().setHealth(player.getPlayerHealth());
					gameFrame.getGamePanel().setMaxHealth(player.getMaxPlayerHealth());
					gameFrame.getGamePanel().repaint();
					
					try {
						AudioInputStream stream = AudioSystem.getAudioInputStream(new File(steal));
						AudioFormat af = stream.getFormat();
						int size = (int) (af.getFrameSize() * stream.getFrameLength());
						byte[] audio  = new byte[size];
						DataLine.Info info = new DataLine.Info(Clip.class, af, size);
						stream.read(audio, 0, size);
						
						// for(int i=0; i < 32; i++) {
						Clip clip = (Clip) AudioSystem.getLine(info);
						clip.open(af, audio, 0, size);
						clip.start();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			});
			
		} else {
			gameFrame.getStealButton().setVisible(false);
		}
		


		//FlüchtenButton
		gameFrame.getRunButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
				

	}
	//Neuzeichnen der Gui nach Kampfphase
	private void updateGUI() {
		gameFrame.updatePlayerStats(player.getAttackDamage(), player.getPlayerHealth(), player.getMaxPlayerHealth(), player.getArmorUp(), player.getNumPotions(),player.getPlayerLevel());
		gameFrame.updateEnemyStats(enemy.getEnemyType(),enemy.getEnemyHealth(),enemy.getEnemyMaxHealth(),enemy.getEnemyAttackDamage(),enemy.getArmorClass());
		gameFrame.getGamePanel().setFile(player.getFile());
		gameFrame.getGamePanel().setEnemyFile(enemy.getEnemyFile());
		gameFrame.getGamePanel().setHealth(player.getPlayerHealth());
		gameFrame.getGamePanel().setMaxHealth(player.getMaxPlayerHealth());
		gameFrame.getGamePanel().setEHealth(enemy.getEnemyHealth());
		gameFrame.getGamePanel().setMaxEHealth(enemy.getEnemyMaxHealth());
		gameFrame.getGamePanel().setSteht(player.getSteht());
		gameFrame.getGamePanel().setPlayerExperience(player.getExperience());
		gameFrame.getGamePanel().setLevelUpPoints(player.getLevelUpPoints());
		gameFrame.getGamePanel().repaint();	
		gameFrame.getGamePanel().setEnemySteht(enemy.getSteht());
	}
	
	//Neuzeichnen der GUI und Abrechnung nach Kampf
	private void updateAfterFight(){
		player.increaseLevel(enemy.getEnemyXp());
		player.equipItem(enemy.getLoot());
		gameFrame.getGamePanel().setPlayerExperience(player.getExperience());
		gameFrame.getGamePanel().setLevelUpPoints(player.getLevelUpPoints());
		gameFrame.getGamePanel().setHealth(player.getPlayerHealth());
		gameFrame.updatePlayerStats(player.getAttackDamage(), player.getPlayerHealth(), player.getMaxPlayerHealth(), player.getArmorUp(), player.getNumPotions(),player.getPlayerLevel());
		gameFrame.getGamePanel().repaint();
		gameFrame.getGamePanel().setCombatStatus(false);
		
		//Neuen Gegner erstellen
		randomIndex = ThreadLocalRandom.current().nextInt(0, 2 + 1);
		enemy = enemyFactory.createEnemy(enemyTypes[randomIndex]);
		gameFrame.getGamePanel().setEnemyFile(enemy.getEnemyFile());
		gameFrame.getGamePanel().setEnemySteht(enemy.getSteht());
		gameFrame.getGamePanel().setEnemyLinks(enemy.getEnemyLinks());
		gameFrame.getGamePanel().setEnemyRechts(enemy.getEnemyRechts());
		
		
		player.setInFight(false);
		gameFrame.setMenuButtons();

		
	
	}
	
	//GameSetup ausführen
	private void start(){
		gameFrame.getGamePanel().setHealth(player.getPlayerHealth());
		gameFrame.updatePlayerStats(player.getAttackDamage(), player.getPlayerHealth(), player.getMaxPlayerHealth(), player.getArmorUp(), player.getNumPotions(),player.getPlayerLevel());
		gameFrame.getGamePanel().repaint();
		gameFrame.setMenuButtons();
		gameFrame.getGamePanel().setFile(player.getFile());
		gameFrame.getGamePanel().setHealth(player.getPlayerHealth());
		gameFrame.getGamePanel().setMaxHealth(player.getMaxPlayerHealth());
		
		//Übergeben der MoveAssets
		gameFrame.getGamePanel().setSteht(player.getSteht());
		
		
		
//		Neuer Gegner wird erstellt
		randomIndex = ThreadLocalRandom.current().nextInt(0, 2 + 1);
		enemy = enemyFactory.createEnemy(enemyTypes[randomIndex]);
		gameFrame.getGamePanel().setEnemySteht(enemy.getSteht());
		
	}
	
	//Bewegen der Elemente und Kollisionsprüfung
	public void update() {
		
		gameFrame.getGamePanel().setLinks(player.getLinks());
		gameFrame.getGamePanel().setRechts(player.getRechts());
		
		gameFrame.getGamePanel().setEnemyLinks(enemy.getEnemyLinks());
		gameFrame.getGamePanel().setEnemyRechts(enemy.getEnemyRechts());
		
		gameFrame.getGamePanel().moveBackground();
		gameFrame.getGamePanel().repaint();
			
			checkCollision();
		
	}
	//Kollisionsprüfung
	private boolean checkCollision() {
		boolean collides = false;
		
		//Bei Kollision startet der Kampf
		if(gameFrame.getGamePanel().getEnemyRectangle().intersects(gameFrame.getGamePanel().getPlayerRectangle())){
			
			collides = true;
			timer.stop();
			gameFrame.updatePlayerStats(player.getAttackDamage(), player.getPlayerHealth(), player.getMaxPlayerHealth(), player.getArmorUp(), player.getNumPotions(),player.getPlayerLevel());
			gameFrame.getGamePanel().setCombatStatus(true);
			gameFrame.updateEnemyStats(enemy.getEnemyType(),enemy.getEnemyHealth(),enemy.getEnemyMaxHealth(),enemy.getEnemyAttackDamage(),enemy.getArmorClass());
			gameFrame.getGamePanel().setFile(player.getFile());
			gameFrame.getGamePanel().setEnemyFile(enemy.getEnemyFile());
			gameFrame.getGamePanel().setHealth(player.getPlayerHealth());
			gameFrame.getGamePanel().setMaxHealth(player.getMaxPlayerHealth());
			gameFrame.getGamePanel().setEHealth(enemy.getEnemyHealth());
			gameFrame.getGamePanel().setMaxEHealth(enemy.getEnemyMaxHealth());
			gameFrame.getGamePanel().setCount(0);
			gameFrame.getGamePanel().setPlayerExperience(player.getExperience());
			gameFrame.getGamePanel().setLevelUpPoints(player.getLevelUpPoints());
			gameFrame.getGamePanel().repaint();
			fight = true;
			gameFrame.setCombatButtons();
			gameFrame.getGamePanel().setEnemySteht(enemy.getSteht());
			count = 0;
		}
		
		else {
			collides = false;
		}	
	
	return collides;
	
	}
}
