package com.skilldistillery.jets.entities;

public abstract class Jet {
	private String model;
	private double speedInMPH;
	private int range;
	private long price;

	public Jet() {}

	public Jet(String model, double speedInMPH, int range, long price) {
		super();
		this.model = model;
		this.speedInMPH = speedInMPH;
		this.range = range;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeedInMPH() {
		return speedInMPH;
	}

	public void setSpeedInMPH(double speedInMPH) {
		this.speedInMPH = speedInMPH;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public void fly() {
		//override in each subclass
		System.out.println(this.model + " flying");
		//use range and speed to determine how long the jet can fly
	}
	
	public double getSpeedInMach (double speedInMPH) {
		return 0.0;
		//TODO: find MPH conversion to Mach
		//subclasses do not override this
	}
	
	@Override
	public String toString() {
		return "Jet [model: " + model + ", speedInMPH: " + speedInMPH + ", range: " + range + " miles" + ", price: $" + price + "]";
	}
}
