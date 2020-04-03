package view;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.enumeration.BetType;
import model.interfaces.GameEngine;

public class SetBet {
	private GameEngine gameEngine;
	private MainFrame mainframe;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public SetBet(GameEngine gameEngine, MainFrame mainframe) {
		this.gameEngine = gameEngine;
		this.mainframe = mainframe;
		BetType[] betTypes = new BetType[BetType.values().length];
		String[] betTypeString = new String[BetType.values().length];
		int i = 0;
		for (BetType bt : BetType.values()) {
			betTypes[i] = bt;
			betTypeString[i++] = bt.toString();
		}
		String id;
		
		try {
			id = (mainframe.table.getValueAt(mainframe.table.getSelectedRow(), 0).toString());
		}
		catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Please select a player", 
					"Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		JComboBox betTypeSelect = new JComboBox(betTypes);
		JTextField betPoints = new JTextField(5);
		Object[] input = {
				"Bet Type:", betTypeSelect,
				"Bet Points", betPoints
		};
		JOptionPane.showConfirmDialog(null, input, "Set Bet", JOptionPane.OK_CANCEL_OPTION);
		setBettoPlayer(id, betTypes[betTypeSelect.getSelectedIndex()],
				Integer.valueOf(betPoints.getText()));
	}
	
	public void setBettoPlayer(String id, BetType betType, int points) {		
		gameEngine.placeBet(gameEngine.getPlayer(id), points, betType);
		mainframe.updateTable();
	}
}
