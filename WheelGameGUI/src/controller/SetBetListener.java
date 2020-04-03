package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import view.MainFrame;
import view.MenuBar;
import view.SetBet;
import view.ToolBar;

public class SetBetListener {
	public SetBetListener(GameEngine gameEngine, MainFrame mainframe, 
			ToolBar toolbar, MenuBar menubar) {
		toolbar.button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SetBet(gameEngine, mainframe);
			}
		});
		menubar.setBet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SetBet(gameEngine, mainframe);
			}
		});
	}
}
