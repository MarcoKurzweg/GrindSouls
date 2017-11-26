package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.ChoosePlayerController;

public class DiebInfo extends JFrame {

	JPanel panel = new JPanel();
	JLabel info = new JLabel("Informationen zum Dieb:");
	JLabel text = new JLabel("Diebe sind heimtückisch ");
	JLabel text2 = new JLabel("und bewandert im Taschendiebstahl!");
	JLabel text3 = new JLabel("Du kannst kritische Treffer landen");
	JLabel text4 = new JLabel("und Gegner beklauen!");
	JButton back = new JButton("Back");
	
	public DiebInfo() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(500,500);
		setTitle("ChoosePlayer");
		getContentPane();
		setLocationRelativeTo(null);
		panel.setLayout(null);
		
		info.setBounds(30, 30, 400, 50);
		info.setFont(new Font("Chiller", Font.BOLD, 40));
		info.setForeground(Color.RED);
		
		text.setBounds(20, 100, 400, 50);
		text.setFont(new Font("Chiller", Font.BOLD, 25));
		text.setForeground(Color.RED);
		text2.setBounds(20, 150, 400, 50);
		text2.setFont(new Font("Chiller", Font.BOLD, 25));
		text2.setForeground(Color.RED);
		text3.setBounds(20, 200, 400, 50);
		text3.setFont(new Font("Chiller", Font.BOLD, 25));
		text3.setForeground(Color.RED);
		text4.setBounds(20, 250, 400, 50);
		text4.setFont(new Font("Chiller", Font.BOLD, 25));
		text4.setForeground(Color.RED);
		
		back.setBounds(370,400,100,40);
		back.setBackground(Color.BLACK);
		back.setFont(new Font("Arial", Font.BOLD, 16));
		back.setForeground(Color.RED);
		
		back.addActionListener(new java.awt.event.ActionListener(){
			
			@Override
			public void actionPerformed( java.awt.event.ActionEvent ae) {
				
					dispose();
					ChoosePlayerController CP = new ChoosePlayerController();
			}
						
					
				});
		
		
		panel.add(info);
		panel.add(text);
		panel.add(text2);
		panel.add(text3);
		panel.add(text4);
		panel.add(back);
		
		panel.setBackground(Color.BLACK);
		
		add(panel);
		
	}
	
}
