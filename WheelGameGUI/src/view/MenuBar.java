package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import model.interfaces.GameEngine;

public class MenuBar extends JMenuBar {
	public JMenuItem addPlayer, setBet, removePlayer, exitItem;
	
	private static final long serialVersionUID = 1L;
	public MenuBar(GameEngine gameEngine, MainFrame mainframe) {
		// create Menu
		JMenu fileMenu = new JMenu("File");
		
		fileMenu.setMnemonic(KeyEvent.VK_F);
		this.add(fileMenu);
		
		// create Menu Items		
		addPlayer = new JMenuItem("Add Player");
		setBet = new JMenuItem("Set Bet");
		removePlayer = new JMenuItem("Remove Player");
		
		exitItem = new JMenuItem("Exit", KeyEvent.VK_X);
		exitItem.setAccelerator(KeyStroke.getKeyStroke('X', InputEvent.ALT_DOWN_MASK));
		
		//add listener for exit button
		exitItem.addActionListener(new ActionListener()
	      {
	         @Override
	         public void actionPerformed(ActionEvent e)
	         {
	            System.exit(0);
	         }
	      });
		
		// add MenuItems to the Menu
		fileMenu.add(addPlayer);
		fileMenu.add(setBet);
		fileMenu.add(removePlayer);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
		
		// add the Menu to the MenuBar
		this.add(fileMenu);
	}
}
