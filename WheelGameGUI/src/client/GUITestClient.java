package client;
import javax.swing.SwingUtilities;

import model.*;
import model.enumeration.BetType;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.*;

public class GUITestClient {

	public static void main(String[] args) {
		final GameEngine gameEngine = new GameEngineImpl();
		
		// create some test players
		Player[] players = new Player[] { new SimplePlayer("1", "Come In Spinner", 1000),
				new SimplePlayer("2", "The Loser", 750), new SimplePlayer("3", "The Dabbler", 500) };
		int enumOrdinal = 0;
		for (Player player : players) {
			gameEngine.addPlayer(player);
			// mod with BetType length so we always stay in range even if num players increases
			// NOTE: we are passing a different BetType each time!
			gameEngine.placeBet(player, 100, BetType.values()[enumOrdinal++]);
		}
		MainFrame mainFrame = new MainFrame(gameEngine);
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());
				gameEngine.addGameEngineCallback(new GameEngineCallbackGUI(mainFrame));
				
			}
		});
	}
}
