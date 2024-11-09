package com.skilldistillery.jets.entities;

public class CargoJet extends Jet implements CargoCarrier {

	public CargoJet() {
		super();
	}

	public CargoJet(String model, double speedInMPH, int range, long price) {
		super(model, speedInMPH, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Cargo Jet [model: " + getModel() + ", speedInMPH: " + getSpeedInMPH() + ", range: "
				+ getRange() + "miles, price: $" + getPrice() + "]";
	}


	
}
