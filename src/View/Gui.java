package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gui extends JFrame{
	

	JButton neuesSpiel, spielLaden, spielInfos;
	
	public Gui(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(700,700);
		setTitle("DungeonGrind");
		getContentPane();
		setLocationRelativeTo(null);
		
		JPanel mainPanel = new GuiPanel();
		mainPanel.setLayout(null);
		
		neuesSpiel = new JButton("Neues Spiel");
		spielLaden = new JButton("Laden");
		spielInfos = new JButton("Highscore");
		
		JLabel title = new JLabel("Grind Souls");
		title.setBounds(160,50,500,200);
		title.setFont(new Font("Chiller", Font.BOLD, 100));
		title.setForeground(Color.RED);
		
		
		neuesSpiel.setBounds(250,430,200,50);
		neuesSpiel.setBackground(Color.BLACK);
		neuesSpiel.setFont(new Font("Arial", Font.BOLD, 20));
		neuesSpiel.setForeground(Color.RED);
		spielLaden.setBounds(250,500,200,50);
		spielLaden.setBackground(Color.BLACK);
		spielLaden.setFont(new Font("Arial", Font.BOLD, 20));
		spielLaden.setForeground(Color.RED);
		spielInfos.setBounds(250,570,200,50);
		spielInfos.setBackground(Color.BLACK);
		spielInfos.setFont(new Font("Arial", Font.BOLD, 20));
		spielInfos.setForeground(Color.RED);
		
		mainPanel.add(neuesSpiel);
		mainPanel.add(spielLaden);
		mainPanel.add(spielInfos);
		mainPanel.add(title);
		
		add(mainPanel);
		
	}

	public JButton getNeuesSpiel() {
		return neuesSpiel;
	}

	public void setNeuesSpiel(JButton neuesSpiel) {
		this.neuesSpiel = neuesSpiel;
	}

	public JButton getSpielLaden() {
		return spielLaden;
	}

	public void setSpielLaden(JButton spielLaden) {
		this.spielLaden = spielLaden;
	}

	public JButton getSpielInfos() {
		return spielInfos;
	}

	public void setSpielInfos(JButton spielInfos) {
		this.spielInfos = spielInfos;
	}




}
