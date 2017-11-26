package View;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GuiPanel extends JPanel{

	
	public GuiPanel(){
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		ImageIcon main = new ImageIcon ("src/Images/Start.jpg");
		Image ma = main.getImage();
		Image mai = ma.getScaledInstance(700, 700, java.awt.Image.SCALE_SMOOTH);
		main = new ImageIcon(mai);
		
		g.drawImage(mai,0,0,null);
		
	}
	
}
