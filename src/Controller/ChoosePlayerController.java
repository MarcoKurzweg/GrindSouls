package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Dieb;
import Model.Krieger;
import Model.Magier;
import Model.Player;
import View.ChoosePlayer;
import View.DiebInfo;
import View.KriegerInfo;
import View.MagierInfo;

//Steuert die Ansicht ChoosePlayer, ruft Controller auf
public class ChoosePlayerController {
	
	private Player player;
	
	public ChoosePlayerController() {
		
		ChoosePlayer choosePlayer = new ChoosePlayer();
		choosePlayer.getkInfoButton().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				choosePlayer.dispose();
				KriegerInfo kI = new KriegerInfo();
			}
		});
		choosePlayer.getmInfoButton().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				choosePlayer.dispose();
				MagierInfo mI = new MagierInfo();
			}
		});
		choosePlayer.getdInfoButton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				choosePlayer.dispose();
				DiebInfo dI = new DiebInfo();	
			}
		});
		choosePlayer.getBackButton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				choosePlayer.dispose();
				GuiController guiController = new GuiController();
			}
		});
		choosePlayer.getKriegerButton().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				choosePlayer.dispose();
				player = new Krieger();
				Controller controller = new Controller(player);
				
			}
		});
		
		choosePlayer.getMagierButton().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				choosePlayer.dispose();
				player = new Magier();
				Controller controller = new Controller(player);
				
			}
		});
		
		choosePlayer.getDiebButton().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				choosePlayer.dispose();
				player = new Dieb();
				Controller controller = new Controller(player);
				
			}
		});
		
	}
}
