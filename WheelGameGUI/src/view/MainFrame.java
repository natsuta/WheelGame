package view;
import java.awt.BorderLayout;
import javax.swing.*;

import model.interfaces.GameEngine;
import model.interfaces.Slot;

public class MainFrame extends JFrame {
	//create component variables to be called
	public GameEngine gameEngine;
	public MenuBar menubar;
	public PlayerTable table;
	public JScrollPane tablepane;
	public MainPanel panel;
	public ToolBar toolbar;
	public StatusBar status;
	
	private static final long serialVersionUID = 1L;

	public MainFrame(GameEngine gameEngine) {
		
		this.gameEngine = gameEngine;
		
		//create components
		table = new PlayerTable(gameEngine, this);
		tablepane = new JScrollPane(table);
		panel = new MainPanel(gameEngine);
		menubar = new MenuBar(gameEngine, this);
		toolbar = new ToolBar(gameEngine, this, menubar);
		status = new StatusBar(gameEngine);
		
		setLayout(new BorderLayout(2, 2));
		setTitle("WheelGame");
		setBounds(100, 100, 1000, 600);
		
		// create Menu Bar
		setJMenuBar(menubar);

		add(toolbar, BorderLayout.NORTH);
		add(tablepane, BorderLayout.WEST);
		add(panel, BorderLayout.CENTER);
		//for some reason, if above is on EAST, it disappears
		add(status, BorderLayout.SOUTH);
		refreshPlayers();
		updateTable();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void refreshPlayers() {
		table.refreshPoints();
	}
	
	public void updateTable() {
		table.tableUpdate();
	}
	
	public void moveBall(Slot slot) {
		panel.updatePosition(slot);
	}
	
	public void updateLeftStatus(String message) {
		status.leftStatusUpdate(message);
	}
	public void updateCenterStatus(String message) {
		status.centerStatusUpdate(message);
	}
	public void updateRightStatus(String message) {
		status.rightStatusUpdate(message);
	}
}