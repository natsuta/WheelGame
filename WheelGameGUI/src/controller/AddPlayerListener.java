package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import view.AddPlayer;
import view.MainFrame;
import view.MenuBar;
import view.ToolBar;

public class AddPlayerListener {
	public AddPlayerListener(GameEngine gameEngine, MainFrame mainframe, 
			ToolBar toolbar, MenuBar menubar) {
		toolbar.button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddPlayer(gameEngine, mainframe);
			}
		});
		menubar.addPlayer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddPlayer(gameEngine, mainframe);
			}
		});
	}
}
