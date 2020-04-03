package controller;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.interfaces.GameEngine;
import view.MainFrame;

public class PlayerChangeListener {
	public PlayerChangeListener(GameEngine gameEngine, 
			MainFrame mainframe, JTable table) {
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				try {
					mainframe.updateLeftStatus("Player Selected: " +
							table.getValueAt(table.getSelectedRow(), 1).toString());
				}
				catch (ArrayIndexOutOfBoundsException e) {
					table.clearSelection();
					return;
				} 
			}
		});
	}
}
