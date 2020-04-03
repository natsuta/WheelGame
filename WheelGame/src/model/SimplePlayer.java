package model;

import model.enumeration.BetType;
import model.interfaces.Player;

public class SimplePlayer implements Player {
	private String playerID;
	private String playerName;
	private int points;
	private int bet;
	private BetType betType;
	
	public SimplePlayer(String playerID, String playerName, int initialPoints) {
		super();
		this.playerID = playerID;
		this.playerName = playerName;
		points = initialPoints;
		bet = 0;
	}

	public String getPlayerId() {
		return playerID;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getBet() {
		return bet;
	}

	public boolean setBet(int bet) {
		resetBet();
		// the bet is set if it is lesser than or equal to the
		// player's current points
		// bet needs to be positive in order for it to proceed
		if (points > 0 && bet <= points && bet >= 0) {
			this.bet = bet;
			return true;
		}
		else
			// otherwise, bet remains at 0
			return false;
	}

	public BetType getBetType() {
		//from this, the win/loss outcome result can be calculated
		//as they are in the BetType enum class
		return betType;
	}

	public void setBetType(BetType betType) {
		this.betType = betType;
	}
	
	public void resetBet() {
		bet = 0;
	}

	@Override
	public String toString() {
		return String.format("\nPlayer: id=%s, name=%s, bet=%s, betType=%s, points=%s",
				getPlayerId(), getPlayerName(), getBet(), getBetType(), getPoints());
	}
		
}
