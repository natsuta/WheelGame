package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import view.MainFrame;
import view.MenuBar;
import view.RemovePlayer;
import view.ToolBar;

public class RemovePlayerListener {
	public RemovePlayerListener(GameEngine gameEngine, MainFrame mainframe, 
			ToolBar toolbar, MenuBar menubar) {
		toolbar.button4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new RemovePlayer(gameEngine, mainframe);
			}
		});
		menubar.removePlayer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new RemovePlayer(gameEngine, mainframe);
			}
		});
	}
}
