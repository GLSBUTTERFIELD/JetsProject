package com.skilldistillery.jets.app;

import java.util.Scanner;

import com.skilldistillery.jets.entities.Jet;

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
				airField.findFastestJet();
				break;

			case "4":
				airField.getLongestRange();
				break;

			case "5":
				airField.loadCargoJets();
				break;

			case "6":
				airField.initiateDogFight();
				break;

			case "7":
				displayJetTypeToAdd();
				int userJetType = sc.nextInt();
				System.out.println("Please enter the model: ");
				String userJetModel = sc.nextLine();
				System.out.println("Please enter the jet's speed in MPH: ");
				double userJetSpeed = sc.nextDouble();
				sc.nextLine();
				System.out.println("Please enter the jet's range in miles: ");
				int userJetRange = sc.nextInt();
				sc.nextLine();
				System.out.println("Please enter the jet's price: ");
				long userJetPrice = sc.nextLong();

				airField.addJetToFleet(userJetType, userJetModel, userJetSpeed, userJetRange, userJetPrice);

				break;

			case "8":
				airField.listFleet();
				System.out.println("\nWhich jet would you like to remove from the fleet?\n");
				int jetToRemove = 0;
				try {
					jetToRemove = sc.nextInt();
					sc.nextLine();
					airField.removeJetFromFleet(jetToRemove);
				} catch (Exception e) {
					System.out.println("Invalid input. Please enter a number 1-" + airField.getSize() + ".");
				}
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

	private void displayJetTypeToAdd() {
		System.out.println("\n.-----------------------------------.");
		System.out.println("| What type of jet are you adding?  |");
		System.out.println("| 1. Passenger Jet                  |");
		System.out.println("| 2. Cargo Jet                      |");
		System.out.println("| 3. Fighter Jet                    |");
		System.out.println(".-----------------------------------.\n");
	}

}
