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

		System.out.println("Welcome to the Skill Distillery Airfield!");
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
				boolean keepShowingListToAdd = true;
				int userJetType = 0;
				while (keepShowingListToAdd) {
					try {
						displayJetTypeToAdd();
						userJetType = Integer.parseInt(sc.nextLine());
						if ((userJetType == 1) || (userJetType == 2) || (userJetType == 3)) {
							keepShowingListToAdd = false;
						} else {
							System.out.println("Invalid input. Please enter a number 1-3.");
							keepShowingListToAdd = true;
						}
					} catch (Exception e) {
						System.out.println("Invalid input. Please try again.");
						keepShowingListToAdd = true;
					}
				}

				String model = getJetModelFromUser();
				double speed = getJetSpeedFromUser();
				int range = getJetRangeFromUser();
				long price = getJetPriceFromUser();
				airField.addJetToFleet(userJetType, model, speed, range, price);

				break;

			case "8":
					airField.listFleet();
					System.out.println("\nWhich jet would you like to remove from the fleet?");
					int jetToRemove = 0;
					try {
						jetToRemove = (sc.nextInt() -1);
						sc.nextLine();
						airField.removeJetFromFleet(jetToRemove);
					} catch (Exception e) {
						System.out.println("Invalid input. Please enter a number 1-" + airField.getSize() + ".\n");
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

	private String getJetModelFromUser() {
		System.out.println("Please enter the jet's model: ");
		return sc.nextLine();
	}

	private double getJetSpeedFromUser() {
		double userSpeed = 0.0;
		boolean keepLooping = true;
		while (keepLooping) {
			System.out.println("Please enter the jet's speed in MPH: ");
			try {
				userSpeed = sc.nextDouble();
				sc.nextLine();
				keepLooping = false;
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("Invalid input for speed. Please try again.");
				keepLooping = true;
			}
		}
		return userSpeed;
	}

	private int getJetRangeFromUser() {
		int userRange = 0;
		boolean keepLooping = true;
		while (keepLooping) {
			System.out.println("Please enter the jet's range in miles: ");
			try {
				userRange = sc.nextInt();
				sc.nextLine();
				keepLooping = false;
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("Invalid input for range. Please try again.");
				keepLooping = true;
			}
		}
		return userRange;
	}

	private long getJetPriceFromUser() {
		long userPrice = 0;
		boolean keepLooping = true;
		while (keepLooping) {
			System.out.println("Please enter the jet's price: ");
			try {
				userPrice = sc.nextLong();
				sc.nextLine();
				keepLooping = false;
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("Invalid input for price. Please try again.");
				keepLooping = true;
			}
		}
		return userPrice;
	}
}
