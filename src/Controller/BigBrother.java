package Controller;

import javax.swing.JDialog;

import Model.Player;
import View.GameFrame;
import View.GamePanel;

public class BigBrother implements Runnable {
	private Player player;
	private GamePanel gamePanel;
	private GameFrame gameFrame;
	private boolean isRunning;
	
	
	public BigBrother(Player player, GameFrame gameFrame, GamePanel gamePanel) {
		isRunning = true;
		this.player = player;
		this.gameFrame = gameFrame;
		this.gamePanel = gamePanel;
	}
	
	
	@Override
	public void run() {

		
		while(isRunning) {
			
//			if (player.getInFight()) {
//				gameFrame.getAttackButton().setEnabled(true);
//				
//				
//			} else {
//				gameFrame.getAttackButton().setEnabled(false);
//				
//			}
			
			
			
			if (!player.getIsAlive()) {
				new JDialog(gameFrame,"Verkackt");
			}
			
			
		}
	}
}
