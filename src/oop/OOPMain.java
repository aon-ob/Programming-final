package oop;

// Import necessary java.util classes
import java.util.Scanner;

public class OOPMain {

	public static void main(String[] args) {

		// create EventManager object to manage all things related to events like adding and removing them.
		EventManager eventManager = new EventManager();

		// Initialize scanner to take user input
		Scanner scanner = new Scanner(System.in);

		// Program keeps taking user input forever until the user chooses to quit.
		while (true) {
			// Menu
			System.out.println();
			System.out.println("--- OOP Event System ---");
			System.out.println("1. View All Events");
			System.out.println("2. Search & Sort");
			System.out.println("3. Add participant");
			System.out.println("4. View participants");
			System.out.println("5. Help (Filter & Sort)");
			System.out.println("6. Quit");

			// Take option input
			System.out.print("Enter the number for the feature you want to use: ");
			int option = scanner.nextInt();
			// Make sure it is a valid input
			while (option < 1 || option > 6) {
				System.out.print("Please enter a valid number in the range (1-5): ");
				option = scanner.nextInt();
			}
			scanner.nextLine(); // clean scanner

			// Display all events option
			if (option == 1) {
				System.out.println();
				System.out.println("All events: ");
				System.out.println();

				// Use static printEventNames method from manager class and then pass the events
				// list from the object
				EventManager.printEvents(eventManager.getEvents());
			}
			// Display events from search query option
			else if (option == 2) {
				System.out.print("Enter search query: ");
				String searchQuery = scanner.nextLine();
				System.out.println();

				// Use static printEventNames method from manager class and then pass the search
				// method result
				EventManager.printEvents(eventManager.search(searchQuery));
			}

			// Add participant option
			else if (option == 3) {
				System.out.println();
				System.out.println("All events: ");
				System.out.println();
				// print all events for user reference
				EventManager.printEvents(eventManager.getEvents());
				System.out.print("Enter number for the event you want to add a participant to: ");

				// take user input for the event they want to add a participant to
				int eventNumber = scanner.nextInt();
				// Make sure it is a valid input
				while (eventNumber <= 0 || eventNumber > eventManager.getEvents().size()) {
					System.out.print(
							"Please enter a valid number in the range (1-" + eventManager.getEvents().size() + "): ");
					eventNumber = scanner.nextInt();
				}
				scanner.nextLine(); // clean scanner

				// take values for participant info
				System.out.print("Enter name of the participant: ");
				String name = scanner.nextLine();
				System.out.print("Enter phone number: ");
				int phoneNumber = scanner.nextInt();
				scanner.nextLine(); // clean scanner
				System.out.print("Enter age: ");
				int age = scanner.nextInt();
				// Make sure it is a valid input
				while (age < 13) {
					System.out.print("Participant must be over 13 years old to participate: ");
					age = scanner.nextInt();
				}
				scanner.nextLine(); // clean scanner
				System.out.print("Enter gender: ");
				String gender = scanner.nextLine().toLowerCase();
				// Make sure it is a valid input
				while (!gender.equals("male") && !gender.equals("female")) {
					System.out.print("Please enter a valid gender (male/female): ");
					gender = scanner.nextLine().toLowerCase();
				}

				// call add participant method with arguments (subtract 1 from event number to match indexing starting from 0 in java)
				eventManager.getEvents().get(eventNumber - 1).addParticipant(new Participant(name, phoneNumber, age, gender));

			}

			// Display participants of certain event option
			else if (option == 4) {
				System.out.println();
				System.out.println("All events: ");
				System.out.println();
				// print all events for user reference
				EventManager.printEvents(eventManager.getEvents());
				System.out.print("Enter number for the event you want to view the participants of: ");

				int eventNumber = scanner.nextInt();
				// Make sure it is a valid input
				while (eventNumber <= 0 || eventNumber > eventManager.getEvents().size()) {
					System.out.print("Please enter a valid number in the range (1-" + eventManager.getEvents().size() + "): ");
					eventNumber = scanner.nextInt();
				}
				scanner.nextLine(); // clean scanner

				// Print participants of event chosen (subtract 1 from event number to match indexing starting from 0 in java)
				eventManager.getEvents().get(eventNumber - 1).printParticipants();
			}
			// Help option
			else if (option == 5) {
				// Prints instructions on how to use the search/filter/sort features
				System.out.println();
				System.out.println("-- How to use the filter and sort feature");
				System.out.println("To filter, type the name of the attribute you want to filter by followed by a colon (:) then the value to filter for.");
				System.out.println("eg. gender:male");
				System.out.println("To filter for numbers, you can use inequalities like (>, <, >=, <=) or just a colon for an exact value.");
				System.out.println("eg. year:>=2025");
				System.out.println("To sort, write 'sortBy' followed by the name of the attribute you want to sort by followed by a colon (:) then 'ascending' or 'descending'.");
				System.out.println("eg. sortByDate:descending");
				System.out.println("Note: capitalization is not important");

			}
			// Quit option
			else if (option == 6) {
				System.exit(0);
			}
		}

	}

}
