package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

import model.enumeration.BetType;
import model.enumeration.Color;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.Slot;
import view.interfaces.GameEngineCallback;

public class GameEngineImpl implements GameEngine {

	private Collection<Player> players = new ArrayList<Player>();
	private Collection<GameEngineCallback> gameEngineCallbacks = new ArrayList<GameEngineCallback>();
	private Collection<Slot> slots = new ArrayList<Slot>();
		
	public void spin(int initialDelay, int finalDelay, int delayIncrement) {
		Iterator<Slot> slotite = slots.iterator();
		//iterator object does not repeat, so a new one has to be called
		//to replace the old one when it reaches the end
		Slot currentSlot = (Slot) slotite.next();
		//uncomment from here to select random slot
		Random random = new Random();
		int stop = random.nextInt(36);
		for (int i=0; i < stop; i++) {
			//calls next slot until it reaches the stopping number
			currentSlot = (Slot) slotite.next();
			if (!slotite.hasNext())
				slotite = slots.iterator();
		}
		//uncomment to here
		for (int delay = initialDelay; delay <= finalDelay; delay += delayIncrement) {
			currentSlot = (Slot) slotite.next();
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (GameEngineCallback gec : gameEngineCallbacks) {
				gec.nextSlot(currentSlot, this);
			}
			if (!slotite.hasNext())
				slotite = slots.iterator();
		}
		for (GameEngineCallback gec : gameEngineCallbacks)
			gec.result(currentSlot, this);
		
	}

	public void calculateResult(Slot winningSlot) {
		for (Player player : players) {
			if (player.getPoints() > 0)
				player.getBetType().applyWinLoss(player, winningSlot);
			else
				player.setBet(0);
		}
	}

	public void addPlayer(Player player) {
		players.add(player);
	}

	public Player getPlayer(String id) {
		for (Player player : players) {
			if (id.equals(player.getPlayerId()))
				return player;
		}
		return null;
	}

	public boolean removePlayer(Player player) {
		for (Player play : players) {
			if (player.getPlayerId() == play.getPlayerId()) {
				players.remove(player);
				return true;
			}	
		}
		return false;
	}

	public Collection<Player> getAllPlayers() {
		return players;
	}

	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
		gameEngineCallbacks.add(gameEngineCallback);
	}

	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		for (GameEngineCallback gec : gameEngineCallbacks) {
			if (gec.getClass().equals(gameEngineCallback.getClass())) {
				gec = null;
				return true;
			}
		}
		return false;	
	}
	
	public boolean placeBet(Player player, int bet, BetType betType) {
		player.setBetType(betType);
		//even if players don't want to bet they can predict what colour will come up
		//(not sure why you would want to do that though)
		if (player.setBet(bet) == true) {
			return true;
		}
		else
			return false;
	}

	public Collection<Slot> getWheelSlots() {
		//hardcoded as per requirements
		slots.add(new SlotImpl(0, 00, Color.GREEN00));
		slots.add(new SlotImpl(1, 27, Color.RED));
		slots.add(new SlotImpl(2, 10, Color.BLACK));
		slots.add(new SlotImpl(3, 25, Color.RED));
		slots.add(new SlotImpl(4, 29, Color.BLACK));
		slots.add(new SlotImpl(5, 12, Color.RED));
		slots.add(new SlotImpl(6, 8, Color.BLACK));
		slots.add(new SlotImpl(7, 19, Color.RED));
		slots.add(new SlotImpl(8, 31, Color.BLACK));
		slots.add(new SlotImpl(9, 18, Color.RED));
		slots.add(new SlotImpl(10, 6, Color.BLACK));
		slots.add(new SlotImpl(11, 21, Color.RED));
		slots.add(new SlotImpl(12, 33, Color.BLACK));
		slots.add(new SlotImpl(13, 16, Color.RED));
		slots.add(new SlotImpl(14, 4, Color.BLACK));
		slots.add(new SlotImpl(15, 23, Color.RED));
		slots.add(new SlotImpl(16, 35, Color.BLACK));
		slots.add(new SlotImpl(17, 14, Color.RED));
		slots.add(new SlotImpl(18, 2, Color.BLACK));
		slots.add(new SlotImpl(19, 0, Color.GREEN0));
		slots.add(new SlotImpl(20, 28, Color.BLACK));
		slots.add(new SlotImpl(21, 9, Color.RED));
		slots.add(new SlotImpl(22, 26, Color.BLACK));
		slots.add(new SlotImpl(23, 30, Color.RED));
		slots.add(new SlotImpl(24, 11, Color.BLACK));
		slots.add(new SlotImpl(25, 7, Color.RED));
		slots.add(new SlotImpl(26, 20, Color.BLACK));
		slots.add(new SlotImpl(27, 32, Color.RED));
		slots.add(new SlotImpl(28, 17, Color.BLACK));
		slots.add(new SlotImpl(29, 5, Color.RED));
		slots.add(new SlotImpl(30, 22, Color.BLACK));
		slots.add(new SlotImpl(31, 34, Color.RED));
		slots.add(new SlotImpl(32, 15, Color.BLACK));
		slots.add(new SlotImpl(33, 3, Color.RED));
		slots.add(new SlotImpl(34, 24, Color.BLACK));
		slots.add(new SlotImpl(35, 36, Color.RED));
		slots.add(new SlotImpl(36, 13, Color.BLACK));
		slots.add(new SlotImpl(37, 1, Color.RED));
		return slots;
	}
	
}
