package com.skilldistillery.jets.app;

import java.util.Scanner;

public class JetsApplication {

	private AirField airField = new AirField();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		JetsApplication app = new JetsApplication();
		app.launch();
		sc.close();
	}

	private void launch() {

		System.out.println("Welcome to the Skill Distillery Airfield!\n");
		boolean keepGoing = true;
		while (keepGoing) {
			displayUserMenu();
			String userInput = sc.nextLine();
			switch (userInput) {
			case "1":
				airField.listFleet();
				break;

			case "2":
				airField.fly();
				break;

			case "3":
				// TODO: call findFastestJet from Airfield class
				break;

			case "4":
				// TODO: call findLongestRange from Airfield
				break;

			case "5":
				// TODO: call loadCargoJets from Airfield
				break;

			case "6":
				// TODO: call Dogfight method
				break;

			case "7":
				// TODO: call addJet method
				break;

			case "8":
				// TODO: call removeJet
				break;

			case "9":
				System.out.println("Thanks for visiting the Skill Distillery AirField today! \nGoodbye.");
				keepGoing = false;
				break;

			default:
				System.out.println("Invalid input. Please enter a number 1-9.");
				break;

			}
		}
	}

	private void displayUserMenu() {
		System.out.println("\n.........................................");
		System.out.println(".\tWhat would you like to do?     \t.");
		System.out.println(". 1. Print out the current fleet   \t.");
		System.out.println(". 2. Fly all jets   \t\t\t.");
		System.out.println(". 3. View the fastest jet   \t\t.");
		System.out.println(". 4. View the jet with longest range\t.");
		System.out.println(". 5. Load all cargo jets   \t\t.");
		System.out.println(". 6. Dogfight!   \t\t\t.");
		System.out.println(". 7. Add a new jet to the fleet   \t.");
		System.out.println(". 8. Remove a jet from the fleet   \t.");
		System.out.println(". 9. Exit the program   \t\t.");
		System.out.println(".........................................\n");
	}
	
	

}
