package View;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.*;
import View.CPPanel;
import View.DiebInfo;
import View.GameFrame;
import View.Gui;
import View.KriegerInfo;
import View.MagierInfo;

public class ChoosePlayer extends JFrame {
	
	Player player;
	JButton kriegerButton, kInfoButton, magierButton, mInfoButton, diebButton, dInfoButton, backButton;


	public ChoosePlayer (){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(700,700);
		setTitle("ChoosePlayer");
		getContentPane();
		setLocationRelativeTo(null);
		
		JPanel main = new CPPanel();
		main.setLayout(null);
		
		JLabel title = new JLabel("Wähle deinen Character");
		JLabel fighter = new JLabel("Krieger");
		JLabel mage = new JLabel("Magier");
		JLabel thief = new JLabel("Dieb");
		
		kriegerButton = new JButton("Wählen");
		kInfoButton = new JButton("Info");
		magierButton = new JButton("Wählen");
		mInfoButton = new JButton("Info");
		diebButton = new JButton("Wählen");
		dInfoButton = new JButton("Info");
		backButton = new JButton ("Back");
	
		
//		Buttons konfigurieren.
		kriegerButton.setBounds(100,460,100,40);
		kriegerButton.setBackground(Color.BLACK);
		kriegerButton.setFont(new Font("Arial", Font.BOLD, 16));
		kriegerButton.setForeground(Color.RED);
		
		magierButton.setBounds(285,460,100,40);
		magierButton.setBackground(Color.BLACK);
		magierButton.setFont(new Font("Arial", Font.BOLD, 16));
		magierButton.setForeground(Color.RED);
		
		diebButton.setBounds(475,460,100,40);
		diebButton.setBackground(Color.BLACK);
		diebButton.setFont(new Font("Arial", Font.BOLD, 16));
		diebButton.setForeground(Color.RED);
		
		kInfoButton.setBounds(100,510,100,40);
		kInfoButton.setBackground(Color.BLACK);
		kInfoButton.setFont(new Font("Arial", Font.BOLD, 16));
		kInfoButton.setForeground(Color.RED);
		
		mInfoButton.setBounds(285,510,100,40);
		mInfoButton.setBackground(Color.BLACK);
		mInfoButton.setFont(new Font("Arial", Font.BOLD, 16));
		mInfoButton.setForeground(Color.RED);
		
		dInfoButton.setBounds(475,510,100,40);
		dInfoButton.setBackground(Color.BLACK);
		dInfoButton.setFont(new Font("Arial", Font.BOLD, 16));
		dInfoButton.setForeground(Color.RED);
		
		backButton.setBounds(570,600,100,40);
		backButton.setBackground(Color.BLACK);
		backButton.setFont(new Font("Arial", Font.BOLD, 16));
		backButton.setForeground(Color.RED);
		
//		Label konfigurieren.
		title.setBounds(130, 30, 500, 50);
		title.setFont(new Font("Chiller", Font.BOLD, 50));
		title.setForeground(Color.RED);
		
		fighter.setBounds(110, 150, 100, 50);
		fighter.setFont(new Font("Chiller", Font.BOLD, 30));
		fighter.setForeground(Color.RED);
		
		mage.setBounds(305, 150, 100, 50);
		mage.setFont(new Font("Chiller", Font.BOLD, 30));
		mage.setForeground(Color.RED);
		
		thief.setBounds(500, 150, 100, 50);
		thief.setFont(new Font("Chiller", Font.BOLD, 30));
		thief.setForeground(Color.RED);
		
//		Button Listener für Hauptfenster
		


		
//		Buttons hinzufügen.
		main.add(kriegerButton);
		main.add(magierButton);
		main.add(diebButton);
		main.add(kInfoButton);
		main.add(mInfoButton);
		main.add(dInfoButton);
		main.add(backButton);
		
//		Label hinzufügen.
		main.add(title);
		main.add(fighter);
		main.add(mage);
		main.add(thief);
		
		add(main);
		
	}


	public JButton getKriegerButton() {
		return kriegerButton;
	}


	public void setKriegerButton(JButton kriegerButton) {
		this.kriegerButton = kriegerButton;
	}


	public JButton getkInfoButton() {
		return kInfoButton;
	}


	public void setkInfoButton(JButton kInfoButton) {
		this.kInfoButton = kInfoButton;
	}


	public JButton getMagierButton() {
		return magierButton;
	}


	public void setMagierButton(JButton magierButton) {
		this.magierButton = magierButton;
	}


	public JButton getmInfoButton() {
		return mInfoButton;
	}


	public void setmInfoButton(JButton mInfoButton) {
		this.mInfoButton = mInfoButton;
	}


	public JButton getDiebButton() {
		return diebButton;
	}


	public void setDiebButton(JButton diebButton) {
		this.diebButton = diebButton;
	}


	public JButton getdInfoButton() {
		return dInfoButton;
	}


	public void setdInfoButton(JButton dInfoButton) {
		this.dInfoButton = dInfoButton;
	}


	public JButton getBackButton() {
		return backButton;
	}


	public void setBackButton(JButton backButton) {
		this.backButton = backButton;
	}
	
}
