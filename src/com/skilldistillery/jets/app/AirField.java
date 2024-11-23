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
		for (int i = 0; i < fleet.size(); i++) {
			System.out.println((i + 1) + ": " + fleet.get(i));
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
		System.out.println("Currently, the fastet jet in our fleet is " + fastestJet + ".\nThe " + fastestJet.getModel()
				+ " has a top speed of Mach" + fastestJet.getSpeedInMach());
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
		System.out.println("Currently, the jet with the longest range in our fleet is " + jetWithLongestRange + ".");
	}

	public void loadCargoJets() {
		for (Jet jet : fleet) {
			if (jet instanceof CargoJet) {
				((CargoJet) jet).loadCargo();
			}
		}
	}

	public void initiateDogFight() {
		for (Jet jet : fleet) {
			if (jet instanceof FighterJet) {
				((FighterJet) jet).fight();
			}
		}
	}

	public void addJetToFleet(int jetType, String model, double speedInMPH, int range, long price) {
		if (jetType == 1) {
			Jet j = new PassengerJet(model, speedInMPH, range, price);
			fleet.add(j);
		}

		else if (jetType == 2) {
			Jet j = new CargoJet(model, speedInMPH, range, price);
			fleet.add(j);		}

		else if (jetType == 3) {
			Jet j = new FighterJet(model, speedInMPH, range, price);
			fleet.add(j);
		}

		else {
			System.out.println("Invalid input. Please enter a number 1-3.");
		}
		
		System.out.println("\nYour " + fleet.getLast().getModel() + " jet has successfully been added to the fleet.");
	}

	public void removeJetFromFleet(int jetToRemove) {
		Jet removedJet = fleet.remove(jetToRemove);
		System.out.println("The jet " + removedJet + " has succesfully been removed from the fleet.");
	}

	public int getSize() {
		return fleet.size();
	}

}


