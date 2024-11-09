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

	private static List<Jet> fleet = new ArrayList<>();

	public AirField() {
		loadJetsFromFile("jets.txt");
	}

	private List<Jet> loadJetsFromFile(String fileName) {
		try ( BufferedReader bufIn = new BufferedReader(new FileReader(fileName)) ) {
			  String line;
			  
			  while ((line = bufIn.readLine()) != null) {
			  String [] jetData =line.split(", ");
				
			  if (jetData[0].equalsIgnoreCase("fighter")) {
				  Jet j = new FighterJet(jetData[1], Double.parseDouble(jetData[2]), Integer.parseInt(jetData[3]), Long.parseLong(jetData[4]));
				  fleet.add(j);
			  }
			  
			  if (jetData[0].equalsIgnoreCase("cargo")) {
				  Jet j = new CargoJet(jetData[1], Double.parseDouble(jetData[2]), Integer.parseInt(jetData[3]), Long.parseLong(jetData[4]));
				  fleet.add(j);
			  }

			  if (jetData[0].equalsIgnoreCase("passenger")) {
				  Jet j = new PassengerJet(jetData[1], Double.parseDouble(jetData[2]), Integer.parseInt(jetData[3]), Long.parseLong(jetData[4]));
				  fleet.add(j);
			  }
			}
		}
		catch (IOException e) {
			  System.err.println(e);
			}
		
		return fleet;
	}


public static void listFleet() {
	System.out.println(fleet);
	return;
}
//TODO: public methods for handling Jets
	// list fleet
	// iterate over fleet and call each subclasses toString
	// fly all jets
	// iterate over fleet and call each jet's fly method()
	// view fastest jet
	// iterate over fleet and compare speeds (biggest integer in Array of integers)
	// fastestJet variable declared outside of loop
	// view jet with longest range
	// iterate over fleet and compare range
	// longestRange variable declared outside of loop
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
	// quit
	// exit program
}
