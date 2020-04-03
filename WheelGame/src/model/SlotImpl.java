package model;

import model.enumeration.Color;
import model.interfaces.Slot;

public class SlotImpl implements Slot {

	private int position;
	private int number;
	private Color color;
	
	public SlotImpl(int position, int number, Color color) {
		super();
		this.position = position;
		this.number = number;
		this.color = color;
	}

	public int getPosition() {
		return position;
	}

	public int getNumber() {
		return number;
	}

	public Color getColor() {
		return color;
	}

	public boolean equals(Slot slot) {
		if (slot.getColor().equals(this.getColor()) && slot.getNumber() == this.getNumber())
			return true;
		else
			return false;
	}
	
	@Override
	public String toString() {
		String colortext = "";
		switch (getColor()) {
		case RED:
			colortext = "Red";
			break;
		case BLACK:
			colortext = "Black";
			break;
		case GREEN0:
			colortext = "Green0";
			break;
		case GREEN00:
			colortext = "Green00";
			break;
		}
		
		return String.format("Position: %s, Colour: %s, Number: %s",
				getPosition(), colortext, getNumber());
	}
}
