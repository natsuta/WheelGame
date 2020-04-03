package view;

import javax.swing.SwingUtilities;

import model.interfaces.GameEngine;
import model.interfaces.Slot;
import view.interfaces.GameEngineCallback;

public class GameEngineCallbackGUI implements GameEngineCallback {

	MainFrame mainFrame;
	
	public GameEngineCallbackGUI(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }	
	
	@Override
	public void nextSlot(Slot slot, GameEngine engine) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				mainFrame.moveBall(slot);
			}
		});
	}

	@Override
	public void result(Slot winningSlot, GameEngine engine) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                mainFrame.updateTable();
                mainFrame.updateCenterStatus("Winning Slot: " 
                + winningSlot.getColor().toString() + " "
                		+ String.valueOf(winningSlot.getNumber()));
            }
        });
	}

}
