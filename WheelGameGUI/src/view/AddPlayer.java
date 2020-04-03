package view;

import java.util.Collection;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class AddPlayer {
	private MainFrame mainframe;
	
	public AddPlayer(GameEngine gameEngine, MainFrame mainframe) {
		this.mainframe = mainframe;
		
		JTextField name = new JTextField(5);
		JTextField initPoints = new JTextField(5);
		Object[] input = {
				"Name:", name,
				"Initial Points:", initPoints
		};
		
		int n = JOptionPane.showConfirmDialog(null, input, "Add Player", JOptionPane.OK_CANCEL_OPTION);
		if (n == JOptionPane.OK_OPTION)
			addPlayertoGame(name.getText(), Integer.valueOf(initPoints.getText()), gameEngine);
	}
	
	@SuppressWarnings("unused")
	public void addPlayertoGame(String name, int points, GameEngine gameEngine) {
		Collection<Player> players = gameEngine.getAllPlayers();
		int count = 0;
		
		for (Player player : players) {
			count = Integer.valueOf(player.getPlayerId());
		}
		count++;
		Player player = new SimplePlayer(String.valueOf(count), name, points);
		gameEngine.addPlayer(player);
		mainframe.refreshPlayers();
		mainframe.updateTable();
	}
}
