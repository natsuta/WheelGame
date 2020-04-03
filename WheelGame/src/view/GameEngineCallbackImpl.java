package view;

import java.util.logging.Level;
import java.util.logging.Logger;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.Slot;
import view.interfaces.GameEngineCallback;

/**
 * 
 * Skeleton/Partial example implementation of GameEngineCallback showing Java logging behaviour
 * 
 * @author Caspar Ryan
 * @see view.interfaces.GameEngineCallback
 * 
 */
public class GameEngineCallbackImpl implements GameEngineCallback
{
   private static final Logger logger = Logger.getLogger(GameEngineCallback.class.getName());

   public GameEngineCallbackImpl()
   {
      // FINE shows wheel spinning output, INFO only shows result
      logger.setLevel(Level.FINE);
   }

   @Override
   public void nextSlot(Slot slot, GameEngine engine)
   {
      // intermediate results logged at Level.FINE
      logger.log(Level.FINE, String.format("Next slot: %s", slot.toString()));
      // TODO: complete this method to log intermediate results
   }

   @Override
   public void result(Slot result, GameEngine engine)
   {
	  engine.calculateResult(result);
      // final results logged at Level.INFO
      logger.log(Level.INFO, String.format("RESULT: %s\n", result.toString()));
      logger.log(Level.INFO, String.format("FINAL PLAYER POINT BALANCES %s", engine.getAllPlayers().toString()));
      // TODO: complete this method to log results
      //you will need to set bets every time
      //if the below line is uncommented
      resetAllBets(engine);
   }
   
   private void resetAllBets(GameEngine engine) {
	   for (Player player : engine.getAllPlayers()) {
		   player.resetBet();
	   }
   }
   
}
