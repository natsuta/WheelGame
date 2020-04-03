package view;

import java.awt.*;
import javax.swing.*;

import model.interfaces.GameEngine;

public class StatusBar extends JPanel {
	private static final long serialVersionUID = 1L;
	private String leftMessage;
	private String centerMessage;
	private String rightMessage;
	
	private JLabel leftLabel;
	private JLabel centerLabel;
	private JLabel rightLabel;
	
	public StatusBar(GameEngine gameEngine) {
		leftLabel = new JLabel("Hello");
		centerLabel = new JLabel("Winning Slot: ");
		rightLabel = new JLabel("status 3");
		setLayout(new GridLayout(1,3));
		add(leftLabel);
		add(centerLabel);
		add(rightLabel);
		customiseLabels();
	}
	
	private void customiseLabels() {
		leftLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		centerLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		centerLabel.setHorizontalAlignment(JLabel.CENTER);
		
		rightLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		rightLabel.setHorizontalAlignment(JLabel.RIGHT);
	}
	
	public static void setlabel(Object object) {
		System.out.println(object);
	}
	
	public void leftStatusUpdate(String message) {
		remove(leftLabel);
		remove(centerLabel);
		remove(rightLabel);
		leftMessage = message;
		leftLabel = new JLabel(leftMessage);
		add(leftLabel);
		add(centerLabel);
		add(rightLabel);
		customiseLabels();
	}
	
	public void centerStatusUpdate(String message) {
		remove(centerLabel);
		remove(rightLabel);
		centerMessage = message;
		centerLabel = new JLabel(centerMessage);
		add(centerLabel);
		add(rightLabel);
		customiseLabels();
	}
	
	public void rightStatusUpdate(String message) {
		remove(rightLabel);
		rightMessage = message;
		rightLabel = new JLabel(rightMessage);
		customiseLabels();
	}
}
