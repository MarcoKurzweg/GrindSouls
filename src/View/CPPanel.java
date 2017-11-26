package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class CPPanel extends JPanel {

	public CPPanel(){
		
		setBackground(Color.BLACK);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		ImageIcon krieger = new ImageIcon("src/Images/Krieger.jpg");
		Image kr = krieger.getImage();
		Image kri = kr.getScaledInstance(150, 250, java.awt.Image.SCALE_SMOOTH);
		krieger = new ImageIcon(kri);
		
		ImageIcon magier = new ImageIcon("src/Images/Magier.jpg");
		Image ma = magier.getImage();
		Image mag = ma.getScaledInstance(150, 250, java.awt.Image.SCALE_SMOOTH);
		magier = new ImageIcon(mag);
		
		ImageIcon dieb = new ImageIcon("src/Images/Dieb.jpg");
		Image di = dieb.getImage();
		Image die = di.getScaledInstance(150, 250, java.awt.Image.SCALE_SMOOTH);
		dieb = new ImageIcon(die);
		
		
		g.drawImage(kri, 70, 200, null);
		g.drawImage(mag, 260, 200, null);
		g.drawImage(die, 450, 200, null);
		
	}
	
}
