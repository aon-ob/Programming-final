package system;

import eventdriven.GUI;

public class Main {

	public static void main(String[] args) {
		
		// Generate initial events
		new Event().setName("Swimming");
		new Event().setDate(30, 10, 2023);;
		new Event("Test", "Amman", 17, 8, 2025, 320, true, "Male");
		new Event();
		new Event().setName("Golfing");
		new Event().setGender("Male");;
		new Event().setName("Sky diving");
		new Event();
		new Event();
		
		new GUI();

	}

}
