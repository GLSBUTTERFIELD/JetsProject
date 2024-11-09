package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet() {

	}

	public FighterJet(String model, double speedInMPH, int range, long price) {
		super(model, speedInMPH, range, price);
	}

	@Override
	public String toString() {
		return "Fighter Jet [model: " + getModel() + ", speedInMPH: " + getSpeedInMPH() + ", range: "
				+ getRange() + "miles, price: $ " + getPrice() + "]";
	}

	@Override
	public void fight() {
		// TODO Auto-generated method stub
		
	}
	
}
