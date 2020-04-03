package view;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

import client.MyTestClient;
import controller.*;
import model.interfaces.GameEngine;
import model.interfaces.Slot;


public class ToolBar extends JToolBar {
	private static final long serialVersionUID = 1L;
	
	public JButton button1, button2, button3, button4;
	
	@SuppressWarnings("unused")
	public ToolBar(GameEngine gameEngine, MainFrame mainframe, MenuBar menubar) {		
		button1 = new JButton("Spin");
		button2 = new JButton("Add Player");
		button3 = new JButton("Set Bet");
		button4 = new JButton("Remove Player");
		
		add(button1);
		add(new Separator());
		add(button2);
		add(button3);
		add(button4);
		SpinWheelListener swl = new SpinWheelListener(gameEngine, mainframe, this);
		AddPlayerListener apl = new AddPlayerListener(gameEngine, mainframe, this, menubar);
		SetBetListener sbl = new SetBetListener(gameEngine, mainframe, this, menubar);
		RemovePlayerListener rpl = new RemovePlayerListener(gameEngine, mainframe, this, menubar);
	}
		
	// private helper method to log w heel slots
	public static void logWheel(Collection<Slot> wheel) {
		final Logger logger = Logger.getLogger(MyTestClient.class.getName());
		logger.log(Level.INFO, "LOGGING WHEEL DATA CREATED BY GameEngineImpl");
		for (Slot slot : wheel)
			logger.log(Level.INFO, slot.toString());
		logger.log(Level.INFO, "END WHEEL LOG\n");
   }
}
