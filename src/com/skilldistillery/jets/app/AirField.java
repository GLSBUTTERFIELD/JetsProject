package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.jets.entities.CargoJet;
import com.skilldistillery.jets.entities.FighterJet;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.PassengerJet;

public class AirField {

	private List<Jet> fleet = new ArrayList<>();

	public AirField() {
		loadJetsFromFile("jets.txt");
	}

	private void loadJetsFromFile(String fileName) {
		try (BufferedReader bufIn = new BufferedReader(new FileReader(fileName))) {
			String line;

			while ((line = bufIn.readLine()) != null) {
				String[] jetData = line.split(", ");

				if (jetData[0].equalsIgnoreCase("fighter")) {
					Jet j = new FighterJet(jetData[1], Double.parseDouble(jetData[2]), Integer.parseInt(jetData[3]),
							Long.parseLong(jetData[4]));
					fleet.add(j);
				}

				if (jetData[0].equalsIgnoreCase("cargo")) {
					Jet j = new CargoJet(jetData[1], Double.parseDouble(jetData[2]), Integer.parseInt(jetData[3]),
							Long.parseLong(jetData[4]));
					fleet.add(j);
				}

				if (jetData[0].equalsIgnoreCase("passenger")) {
					Jet j = new PassengerJet(jetData[1], Double.parseDouble(jetData[2]), Integer.parseInt(jetData[3]),
							Long.parseLong(jetData[4]));
					fleet.add(j);
				}
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public void listFleet() {
		System.out.println("The fleet currently contains: \n");
		for (Jet jet : fleet) {
			System.out.println(jet);
		}
	}

	public void fly() {
		System.out.println("Flying all jets!\n");
		for (Jet jet : fleet) {
			jet.fly();
		}
	}

	public void findFastestJet() {
		Jet fastestJet = null;
		for (int i = 0; i < fleet.size(); i++) {
			if (fastestJet == null) {
				fastestJet = fleet.get(i);
			} else if (fleet.get(i).getSpeedInMPH() > fastestJet.getSpeedInMPH()) {
				fastestJet = fleet.get(i);
			}

		}
		System.out.println("The fastet jet in our fleet currently is " + fastestJet + ".\nThe " 
		+ fastestJet.getModel() + " has a top speed of Mach" + fastestJet.getSpeedInMach());
	}
	
	
	public void getLongestRange() {
		Jet jetWithLongestRange = null;
		for (int i = 0; i < fleet.size(); i++) {
			if (jetWithLongestRange == null) {
				jetWithLongestRange = fleet.get(i);
			} else if (fleet.get(i).getRange() > jetWithLongestRange.getRange()) {
				jetWithLongestRange = fleet.get(i);
			}

		}
		System.out.println("The jet with the longest range in our fleet currently is " + jetWithLongestRange + ".");
	}

}
//TODO: public methods for handling Jets

// load all Cargo Jets
	// iterate through fleet and use instanceof to see if I'm a Cargo Jet
	// call loadCargo() method
// Dogfight
	// iterate through fleet and use instanceof to see if I'm a fighter Jet
	// call fight() method
// add Jet to fleet
	// get input from user - type of Jet, model, speed, range, price
	// AirField.addNewJet();
	// tell AirField to add to Fleet
// remove jet from fleet
	// get input from user - which Jet
	// find index and remove from list
