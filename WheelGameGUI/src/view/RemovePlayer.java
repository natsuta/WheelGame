package view;

import javax.swing.JOptionPane;

import model.interfaces.GameEngine;

public class RemovePlayer {
	public RemovePlayer(GameEngine gameEngine, MainFrame mainframe) {
		String id;
		try {
			id = (mainframe.table.getValueAt(mainframe.table.getSelectedRow(), 0).toString());
		}
		catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Please select a player", 
					"Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		gameEngine.removePlayer(gameEngine.getPlayer(id));
		mainframe.refreshPlayers();
		mainframe.updateTable();
	}
}
