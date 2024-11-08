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
	//TODO: loop that displaysUserMenu, gets choice from scanner, acts on choice (SWITCH)
		displayUserMenu();
	}

	private void displayUserMenu() {
		System.out.println();
	}
	
}
