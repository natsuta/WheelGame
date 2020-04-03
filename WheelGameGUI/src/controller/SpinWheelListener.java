package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import view.MainFrame;
import view.ToolBar;

public class SpinWheelListener {
	public SpinWheelListener(GameEngine gameEngine, MainFrame mainframe, ToolBar toolbar) {
		toolbar.button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainframe.table.clearSelection();
				mainframe.refreshPlayers();
				gameEngine.getWheelSlots();
				new Thread() {
					@Override
					public void run() {
						gameEngine.spin(1, 200, 4);
					}
				}.start();
			}
		});
	}
}