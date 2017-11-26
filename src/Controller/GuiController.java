package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.Gui;

public class GuiController {
	public GuiController() {
		Gui gui = new Gui();
		
		gui.getNeuesSpiel().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChoosePlayerController cPC = new ChoosePlayerController();
				gui.dispose();
			}
		});
		
		
		gui.getSpielInfos().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg) {
				
				
			}
			
			
			
		});
		
	}
}
