package view;

import java.util.Collection;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.PlayerChangeListener;
import model.interfaces.GameEngine;

import model.interfaces.*;

public class PlayerTable extends JTable {
	private GameEngine gameEngine;
	private MainFrame mainframe;
	int prevPoints[];
	Collection<Player> players;
	
	private static final long serialVersionUID = 1L;

	public PlayerTable(GameEngine gameEngine, MainFrame mainframe) {
		this.gameEngine = gameEngine;
		this.mainframe = mainframe;
	}
	
	public void refreshPoints() {
		players = gameEngine.getAllPlayers();
		prevPoints = new int[players.size()];
		int i = 0;
		for (Player player : players) {
			prevPoints[i++] = player.getPoints();
		}
	}
	
	public void tableUpdate() {
		clearSelection();
		mainframe.updateLeftStatus("Hello");
		String colHeaders[] = new String[] { "ID", "Name", "Points", "Bet", "Bet Type", "Win/Loss" };
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.setColumnIdentifiers(colHeaders);
		
		int i = 0;
		for (Player player : players) {
			Object[] dataRow = {player.getPlayerId(), player.getPlayerName(), 
					player.getPoints(), player.getBet(), player.getBetType(),
					(player.getPoints() > prevPoints[i] ? "Win" : 
						player.getPoints() < prevPoints[i] ? "Loss" : "")};
			//line blank if no change
			dtm.addRow(dataRow);
			prevPoints[i] = player.getPoints();
			i++;
		}

		setModel(dtm);
		setVisible(true);
		@SuppressWarnings("unused")
		PlayerChangeListener pcl = new PlayerChangeListener(gameEngine, mainframe, this);
	}
	
}
