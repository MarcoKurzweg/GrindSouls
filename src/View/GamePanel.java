package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Model.Player;

public class GamePanel extends JPanel {
	
	Player player;
//	Rectangle playerHealthBar = new Rectangle(150,10,550,20);
//	Rectangle enemyHealthBar = new Rectangle(150,670,550,20);
	String file, enemyFile, steht, enemySteht, links, rechts, enemyLinks, enemyRechts;
	int playerHealth, maxPlayerHealth, enemyHealth, maxEnemyHealth, playerExperience, levelUpPoints, count;
	private Rectangle background,background2, enemyRectangle, playerRectangle, enemyIcon;
	private boolean combatStatus;




	public GamePanel() {
	
		background = new Rectangle(150, 38, 702, 478);
		background2 = new Rectangle(852, 38, 702, 478);
		
		enemyRectangle = new Rectangle(650,400,200,100);
		playerRectangle = new Rectangle(150, 400, 200, 100);
		enemyIcon = new Rectangle(540, 530, 130, 120);
		combatStatus = false;
	}


	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//Hintergrund und Boden Images einbinden
		ImageIcon wall = new ImageIcon ("src/Images/Höhle.jpg");
		Image wa = wall.getImage();
		Image wal = wa.getScaledInstance(702, 370, java.awt.Image.SCALE_SMOOTH);
		wall = new ImageIcon(wal);
		
		ImageIcon wall2 = new ImageIcon ("src/Images/Höhle2.jpg");
		Image wa2 = wall2.getImage();
		Image wal2 = wa2.getScaledInstance(702, 370, java.awt.Image.SCALE_SMOOTH);
		wall2 = new ImageIcon(wal2);
		
		ImageIcon ground = new ImageIcon ("src/Images/Cave.png");
		Image gr = ground.getImage();
		Image gro = gr.getScaledInstance(702, 116, java.awt.Image.SCALE_SMOOTH);
		ground = new ImageIcon(gro);
		
		ImageIcon ground2 = new ImageIcon ("src/Images/Cave2.png");
		Image gr2 = ground2.getImage();
		Image gro2 = gr2.getScaledInstance(702, 116, java.awt.Image.SCALE_SMOOTH);
		ground2 = new ImageIcon(gro2);
	
		
//		geändert
		ImageIcon back = new ImageIcon("src/Images/Hintergrund3.png");
		Image ba = back.getImage();
		Image bac = ba.getScaledInstance(700, 700, java.awt.Image.SCALE_SMOOTH);
		back = new ImageIcon(bac);
//		bis hier

		
		
		
		//Hintergrund und Boden zeichnen
	
		g.drawImage(wal, background.x, background.y, null);
		g.drawImage(wal2, background2.x, background2.y, null);
		g.drawImage(gro, background.x, background.y+362, null);
		g.drawImage(gro2, background2.x, background2.y+362, null);
		g.drawImage(bac, 0, 0, null);				//	geändert
		
		//Healthbars, Statsbar und Avatar-Rahmen zeichnen ( Farbe schwarz )
		
		
		
//		hier ein paar werte geändert
		g.setColor(new Color(211,211,211));
		g.fillRect(151,6,548,19);
		g.fillRect(151, 631, 379, 19);
		g.setColor(new Color(0,0,0));
		g.drawRect(151,5,549,20);
//		g.drawRect(151,30,549,35);
		g.drawRect(150,630,380,20);
		g.drawRect(10, 5, 130, 120);
		
		g.drawRect(540, 530, 130, 120);
		
//		geändert
		if(((double)playerHealth/(double)maxPlayerHealth)>0.5){
			g.setColor(new Color(0,255,0));
		}
		if (((double)playerHealth/(double)maxPlayerHealth)<= 0.5 && ((double)playerHealth/(double)maxPlayerHealth)>0.2){
			g.setColor(new Color(255,165,0));
		}
		if (((double)playerHealth/(double)maxPlayerHealth)<=0.2){
			g.setColor(new Color(255,0,0));
		}
		
		g.fillRect(152,6,(int)((548)*(double)playerHealth/(double)maxPlayerHealth),19);									
		
		
		if (((double)enemyHealth/(double)maxEnemyHealth)>0.5){
			g.setColor(new Color(0,255,0));
		}
		if (((double)enemyHealth/(double)maxEnemyHealth)<=0.5 && ((double)enemyHealth/(double)maxEnemyHealth)>0.2){
			g.setColor(new Color(255,165,0));
		}
		if (((double)enemyHealth/(double)maxEnemyHealth)<=0.2){
			g.setColor(new Color(255,0,0));
		}
		
		g.fillRect(151,631,(int)((379)*(double)enemyHealth/(double)maxEnemyHealth),19);
		
		
		
//	bis hier	
		
		
//		geändert
//		Exp.Bar
		g.setColor(new Color(255,215,0));
		g.drawRect(151,27,549,7);
		g.setColor(new Color(139,0,139));
		g.fillRect(152, 28, 548, 6);
		g.setColor(new Color(238,122,233));
		g.fillRect(152,28,(int)((548)*(double)playerExperience/(double)levelUpPoints),6);	
//		bis hier
		
		
		
		
		//Images Statsbar
		ImageIcon swordIcon = new ImageIcon ("src/Images/stremgth.png");
		Image si = swordIcon.getImage();
		Image sic = si.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
		swordIcon = new ImageIcon(sic);
		
		ImageIcon health = new ImageIcon ("src/Images/Health-Potions.png");
		Image he = health.getImage();
		Image hea = he.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
		health = new ImageIcon(hea);
		
		ImageIcon armor = new ImageIcon ("src/Images/armor.png");
		Image ar = armor.getImage();
		Image arm = ar.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
		armor = new ImageIcon(arm);
		
//		Images Gegner
		
		
		
//	geändert	(Bild noch anpassen!!!!!!!!!!!!)
		
		ImageIcon enemy = new ImageIcon ("src/Images/Enemy.png");
		Image en = enemy.getImage();
		Image ene = en.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
		enemy = new ImageIcon(ene);
		
		ImageIcon play = new ImageIcon(file);
		Image pl = play.getImage();
		Image pla = pl.getScaledInstance(128, 118, java.awt.Image.SCALE_SMOOTH);
		play = new ImageIcon(pla);
	
		ImageIcon enemyIcon = new ImageIcon(enemyFile);
		Image ei = enemyIcon.getImage();
		Image eic = ei.getScaledInstance(128, 118, java.awt.Image.SCALE_SMOOTH);
		enemyIcon = new ImageIcon(eic);
//	bis hier	
		
		
		
		g.drawImage(sic, 155, 42, null);
		g.drawImage(arm, 235, 42, null);
		g.drawImage(hea, 315, 42, null);
		
		
//		geändert
		g.drawImage(ene, 155, 590, null);
		g.drawImage(sic, 300, 590, null);
		g.drawImage(arm, 400, 590, null);
		g.drawImage(pla, 11, 6, null);
		
		if (combatStatus){
			g.drawImage(eic, 539, 529, null);
		}
	
		
	
//		Spieler Icons
		
		ImageIcon character = new ImageIcon(steht);
		Image ch = character.getImage();
		Image cha = ch.getScaledInstance(130, 130, java.awt.Image.SCALE_SMOOTH);
		character = new ImageIcon(cha);
		
		ImageIcon pLinks = new ImageIcon(links);
		Image pli = pLinks.getImage();
		Image plin = pli.getScaledInstance(130, 130, java.awt.Image.SCALE_SMOOTH);
		pLinks = new ImageIcon(plin);
		
		ImageIcon pRechts = new ImageIcon(rechts);
		Image pr = pRechts.getImage();
		Image pre = pr.getScaledInstance(130, 130, java.awt.Image.SCALE_SMOOTH);
		pRechts = new ImageIcon(pre);
		
		ImageIcon standingEnemy = new ImageIcon(enemySteht);
		Image sE = standingEnemy.getImage();
		Image sEn = sE.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		standingEnemy = new ImageIcon(sEn);
		
		ImageIcon leftEnemy = new ImageIcon(enemyLinks);
		Image le = leftEnemy.getImage();
		Image len = le.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		leftEnemy = new ImageIcon(len);
		
		ImageIcon rightEnemy = new ImageIcon(enemyRechts);
		Image re = rightEnemy.getImage();
		Image ren = re.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		rightEnemy = new ImageIcon(ren);
		
		if(count == 0) {
			g.drawImage(cha, playerRectangle.x + 70, playerRectangle.y - 20, null);
			g.drawImage(sEn, enemyRectangle.x + 100, enemyRectangle.y, null);
		}
		if(count%2 == 1) {
			g.drawImage(plin, playerRectangle.x + 70, playerRectangle.y - 20, null);
			g.drawImage(len, enemyRectangle.x + 100, enemyRectangle.y, null);
		}
		if(count%2 == 0 && count != 0) {
			g.drawImage(pre, playerRectangle.x + 70, playerRectangle.y - 20, null);
			g.drawImage(ren, enemyRectangle.x + 100, enemyRectangle.y, null);
		}
		
		
	}
	
	public void setFile(String file) {
		this.file = file;
	}
	
	public void setEnemyFile(String enemyFile) {
		this.enemyFile = enemyFile;
	}
	
	public void setHealth(int playerHealth) {
		this.playerHealth = playerHealth;
	}
	
	public void setMaxHealth(int maxPlayerHealth) {
		this.maxPlayerHealth = maxPlayerHealth;
	}
	
	public void setEHealth(int enemyHealth){
		this.enemyHealth = enemyHealth;
	}
	
	public void setMaxEHealth(int maxEnemyHealth){
		this.maxEnemyHealth = maxEnemyHealth;
	}
	
	public void setSteht (String steht) {
		this.steht = steht;
	}
	

	public void setPlayerExperience(int playerExperience) {
		this.playerExperience = playerExperience;
	}

	public void setLevelUpPoints(int levelUpPoints) {
		this.levelUpPoints = levelUpPoints;
	}
	
	public void setEnemySteht(String enemySteht) {
		this.enemySteht = enemySteht;
	}
	
	public void moveBackground(){
		background.x -= 6;
		background2.x -= 6;
		enemyRectangle.x -= 10;
		if(background.x == -552){
			background.x = 852;
		}
		if ( background2.x == -552){
			background2.x = 852;
		}
	}
	
	public void setLinks(String links) {
		this.links = links;
	}
	
	public void setRechts(String rechts) {
		this.rechts = rechts;
	}
	
	public Rectangle getEnemyIcon() {
		return enemyIcon;
	}

	public void setEnemyIcon(Rectangle enemyIcon) {
		this.enemyIcon = enemyIcon;
	}
	
	public void setCount( int count) {
		this.count = count;
	}
	public Rectangle addEnemy() {
		return enemyRectangle;
	}
	public void removeEnemy() {
		
	}
	public Rectangle getEnemyRectangle() {
		return enemyRectangle;
	}
	public Rectangle getPlayerRectangle() {
		return playerRectangle;
	}

	public void setCombatStatus(boolean combatStatus) {
		this.combatStatus = combatStatus;
	}
	
	public void setEnemyLinks(String enemyLinks) {
		this.enemyLinks = enemyLinks;
	}
	
	public void setEnemyRechts(String enemyRechts) {
		this.enemyRechts = enemyRechts;
	}
	
	public boolean getCombatStatus() {
		return combatStatus;
	}
//	bis hier	
}
