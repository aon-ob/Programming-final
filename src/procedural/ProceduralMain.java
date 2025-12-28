package procedural;

// Import necessary java.util classes
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

// Import necessary shared classes
import shared.Event;
import shared.Participant;

public class ProceduralMain {

	// List of all events stored in arrayList
	static ArrayList<Event> myEvents = new ArrayList<>();

	// Main method
	public static void main(String[] args) {
		// Setup Data
		setupSampleData();
		// Initialize scanner to receive inputs
		Scanner scanner = new Scanner(System.in);

		// Program keeps taking user input forever until the user chooses to quit.
		while (true) {
			System.out.println();
			// Menu
			System.out.println("--- Procedural Event System ---");
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
				System.out.print("Please enter a valid number in the range (1-6): ");
				option = scanner.nextInt();
			}
			scanner.nextLine(); // clean scanner

			// Display all events option
			if (option == 1) {
				System.out.println();
				System.out.println("All events: ");
				System.out.println();

				printEvents(myEvents); // Prints all events
			}
			// Display events from search query option
			else if (option == 2) {
				System.out.print("Enter search query: ");
				String searchQuery = scanner.nextLine();
				System.out.println();
				// Prints events returned by the searchEvents method which uses the search query to return a list of events
				printEvents(searchEvents(myEvents, searchQuery));
			}
			// Add participant option
			else if (option == 3) {
				System.out.println();
				System.out.println("All events: ");
				System.out.println();
				// Print all the events for reference so the user can choose one.
				printEvents(myEvents);
				// User picks the event to add a participant to
				System.out.print("Enter number for the event you want to add a participant to: ");
				int eventNumber = scanner.nextInt();
				// Make sure it is a valid input
				while (eventNumber <= 0 || eventNumber > myEvents.size()) {
					System.out.print("Please enter a valid number in the range (1-" + myEvents.size() + "): ");
					eventNumber = scanner.nextInt();
				}
				scanner.nextLine(); // clean scanner

				// Take values for participant info
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

				// Call add participant method with arguments
				addParticipant(eventNumber, name, phoneNumber, age, gender);

			}

			// Display participants of certain event option
			else if (option == 4) {
				System.out.println();
				System.out.println("All events: ");
				System.out.println();
				// Print all events for reference
				printEvents(myEvents);
				System.out.print("Enter number for the event you want to view the participants of: ");
				// Pick the event from a number
				int eventNumber = scanner.nextInt();
				// Make sure it is a valid input
				while (eventNumber <= 0 || eventNumber > myEvents.size()) {
					System.out.print("Please enter a valid number in the range (1-" + myEvents.size() + "): ");
					eventNumber = scanner.nextInt();
				}
				scanner.nextLine(); // clean scanner
				// Call the print participants method to print all participants of the event selected
				printParticipants(eventNumber);
			}
			// Help option
			else if (option == 5) {
				// Prints instructions on how to use the search/filter/sort features
				System.out.println();
				System.out.println("-- How to use the filter and sort feature");
				System.out.println(
						"To filter, type the name of the attribute you want to filter by followed by a colon (:) then the value to filter for.");
				System.out.println("eg. gender:male");
				System.out.println(
						"To filter for numbers, you can use inequalities like (>, <, >=, <=) or just a colon for an exact value.");
				System.out.println("eg. year:>=2025");
				System.out.println(
						"To sort, write 'sortBy' followed by the name of the attribute you want to sort by followed by a colon (:) then 'ascending' or 'descending'.");
				System.out.println("eg. sortByDate:descending");
				System.out.println("Note: capitalization is not important");

			}
			// Quit option
			else if (option == 6) {
				System.exit(0);
			}

		}

	}

	// Search events method (Search and filter feature) (view all events feature)
	// (contains bubble sort algorithm)
	public static ArrayList<Event> searchEvents(ArrayList<Event> sourceList, String query) {
		// Initialize results
		ArrayList<Event> results = new ArrayList<>();

		// Initialize search queries (if left empty, means query wont be used)
		String place = "";
		String gender = "";
		String day = "";
		String month = "";
		String year = "";
		String capacity = "";
		String mustBe18 = "";
		String searchKeyWords = "";

		// Initialize sorting queries
		String sortByName = "";
		String sortByCapacity = "";
		String sortByDate = "";

		// Split input by spaces to separate the queries
		String[] splitText = query.split(" ");

		// Check for and set all queries to the values entered in the input
		for (int i = 0; i < splitText.length; i++) {

			// sort by name
			if (splitText[i].toLowerCase().contains("sortbyname:")) {
				try {
					sortByName = splitText[i].split(":")[1].toLowerCase(); // take part after colon :
				} catch (Exception e) {
				}
			}
			// sort by capacity
			else if (splitText[i].toLowerCase().contains("sortbycapacity:")) {
				try {
					sortByCapacity = splitText[i].split(":")[1].toLowerCase(); // take part after colon :
				} catch (Exception e) {
				}
			}
			// sort by date
			else if (splitText[i].toLowerCase().contains("sortbydate:")) {
				try {
					sortByDate = splitText[i].split(":")[1].toLowerCase(); // take part after colon :
				} catch (Exception e) {
				}
			}

			// place query
			else if (splitText[i].toLowerCase().contains("place:")) {
				try {
					place = splitText[i].split(":")[1].toLowerCase(); // take part after colon :
				} catch (Exception e) {
				}
			}
			// gender query
			else if (splitText[i].toLowerCase().contains("gender:")) {
				try {
					gender = splitText[i].split(":")[1].toLowerCase(); // take part after colon :
				} catch (Exception e) {
				}
			}
			// day query
			else if (splitText[i].toLowerCase().contains("day:")) {
				try {
					day = splitText[i].split(":")[1]; // take part after colon:
				} catch (Exception e) {
				}
			}
			// month query
			else if (splitText[i].toLowerCase().contains("month:")) {
				try {
					month = splitText[i].split(":")[1]; // take part after colon :
				} catch (Exception e) {
				}
			}
			// year query
			else if (splitText[i].toLowerCase().contains("year:")) {
				try {
					year = splitText[i].split(":")[1]; // take part after colon :
				} catch (Exception e) {
				}
			}
			// capacity query
			else if (splitText[i].toLowerCase().contains("capacity:")) {
				try {
					capacity = splitText[i].split(":")[1]; // take part after colon :
				} catch (Exception e) {
				}
			}
			// mustBe18 query
			else if (splitText[i].toLowerCase().contains("mustbe18:")) {
				try {
					mustBe18 = splitText[i].split(":")[1].toLowerCase(); // take part after colon :
				} catch (Exception e) {
				}
			}

			else {
				// If no query then its a keyword
				if (searchKeyWords == "") {
					searchKeyWords = splitText[i];
				} else {
					searchKeyWords = searchKeyWords + " " + splitText[i];
				}
			}

		}

		// If no search text then display all
		if (query == "") {
			return (sourceList);
		}

		else {
			for (int i = 0; i < sourceList.size(); i++) {
				if (sourceList.get(i).getName().toLowerCase().contains(searchKeyWords.toLowerCase())) {
					results.add(sourceList.get(i));

				}

			}

			// Finalize variables to avoid error
			final String finalPlace = place;
			final String finalGender = gender;
			final String finalDay = day;
			final String finalMonth = month;
			final String finalYear = year;
			final String finalCapacity = capacity;
			final String finalMustBe18 = mustBe18;

			final String finalSortByName = sortByName;
			final String finalSortByCapacity = sortByCapacity;
			final String finalSortByDate = sortByDate;

			// Filter through queries

			results.removeIf(event -> !event.getPlace().toLowerCase().contains(finalPlace));
			results.removeIf(event -> !event.getGender().toLowerCase().contains(finalGender));
			results.removeIf(event -> !String.valueOf(event.getMustBe18()).toLowerCase().contains(finalMustBe18));

			// day query
			try {
				if (finalDay.contains(">=")) {
					results.removeIf(event -> !(event.getDay() >= Integer.parseInt(finalDay.split(">=")[1])));
				} else if (finalDay.contains("<=")) {
					results.removeIf(event -> !(event.getDay() <= Integer.parseInt(finalDay.split("<=")[1])));
				} else if (finalDay.contains(">")) {
					results.removeIf(event -> !(event.getDay() > Integer.parseInt(finalDay.split(">")[1])));
				} else if (finalDay.contains("<")) {
					results.removeIf(event -> !(event.getDay() < Integer.parseInt(finalDay.split("<")[1])));
				} else {
					results.removeIf(event -> !(event.getDay() == Integer.parseInt(finalDay)));
				}
			} catch (Exception e) {
			}

			// month query
			try {
				if (finalMonth.contains(">=")) {
					results.removeIf(event -> !(event.getMonth() >= Integer.parseInt(finalMonth.split(">=")[1])));
				} else if (finalMonth.contains("<=")) {
					results.removeIf(event -> !(event.getMonth() <= Integer.parseInt(finalMonth.split("<=")[1])));
				} else if (finalMonth.contains(">")) {
					results.removeIf(event -> !(event.getMonth() > Integer.parseInt(finalMonth.split(">")[1])));
				} else if (finalMonth.contains("<")) {
					results.removeIf(event -> !(event.getMonth() < Integer.parseInt(finalMonth.split("<")[1])));
				} else {
					results.removeIf(event -> !(event.getMonth() == Integer.parseInt(finalMonth)));
				}
			} catch (Exception e) {
			}

			// year query
			try {
				if (finalYear.contains(">=")) {
					results.removeIf(event -> !(event.getYear() >= Integer.parseInt(finalYear.split(">=")[1])));
				} else if (finalYear.contains("<=")) {
					results.removeIf(event -> !(event.getYear() <= Integer.parseInt(finalYear.split("<=")[1])));
				} else if (finalYear.contains(">")) {
					results.removeIf(event -> !(event.getYear() > Integer.parseInt(finalYear.split(">")[1])));
				} else if (finalYear.contains("<")) {
					results.removeIf(event -> !(event.getYear() < Integer.parseInt(finalYear.split("<")[1])));
				} else {
					results.removeIf(event -> !(event.getYear() == Integer.parseInt(finalYear)));
				}
			} catch (Exception e) {
			}

			// capacity query
			try {
				if (finalCapacity.contains(">=")) {
					results.removeIf(event -> !(event.getCapacity() >= Integer.parseInt(finalCapacity.split(">=")[1])));
				} else if (finalCapacity.contains("<=")) {
					results.removeIf(event -> !(event.getCapacity() <= Integer.parseInt(finalCapacity.split("<=")[1])));
				} else if (finalCapacity.contains(">")) {
					results.removeIf(event -> !(event.getCapacity() > Integer.parseInt(finalCapacity.split(">")[1])));
				} else if (finalCapacity.contains("<")) {
					results.removeIf(event -> !(event.getCapacity() < Integer.parseInt(finalCapacity.split("<")[1])));
				} else {
					results.removeIf(event -> !(event.getCapacity() == Integer.parseInt(finalCapacity)));
				}
			} catch (Exception e) {
			}

			// SORT BY QUERY

			// sort by name
			try {
				// -- BUBBLE SORT ALGORITHM (alphabetically)--
				if (!finalSortByName.isEmpty()) {
					// outer loop
					for (int i = 0; i < results.size(); i++) {
						// inner loop
						for (int j = 1; j < results.size() - i; j++) {
							// descending sort
							if (finalSortByName.toLowerCase().contains("descending")) {
								// if first word lexicographically less than second word switch them
								if (results.get(j).getName().compareTo(results.get(j - 1).getName()) > 0) {
									results = switchEvents(results, j);
								}
							}
							// ascending sort
							else {
								// if first word lexicographically greater than second word switch them
								if (results.get(j).getName().compareTo(results.get(j - 1).getName()) < 0) {
									results = switchEvents(results, j);
								}
							}
						}
					}
				}

			} catch (Exception e) {
			}

			// sort by capacity
			try {
				// -- BUBBLE SORT ALGORITHM (integer)--
				if (!finalSortByCapacity.isEmpty()) {
					// outer loop
					for (int i = 0; i < results.size(); i++) {
						// inner loop
						for (int j = 1; j < results.size() - i; j++) {
							// descending sort
							if (finalSortByCapacity.toLowerCase().contains("descending")) {
								// if first event capacity less than second word capacity switch them
								if (results.get(j).getCapacity() > results.get(j - 1).getCapacity()) {
									results = switchEvents(results, j); // switch the events together
								}
							}
							// ascending sort
							else {
								// if first event capacity greater than second word capacity switch them
								if (results.get(j).getCapacity() < results.get(j - 1).getCapacity()) {
									results = switchEvents(results, j); // switch the events together
								}
							}
						}
					}
				}

			} catch (Exception e) {
			}

			// sort by date
			try {
				// -- BUBBLE SORT ALGORITHM (date)--
				if (!finalSortByDate.isEmpty()) {
					// outer loop
					for (int i = 0; i < results.size(); i++) {
						// inner loop
						for (int j = 1; j < results.size() - i; j++) {
							// descending sort
							if (finalSortByDate.toLowerCase().contains("descending")) {
								// if first event year less than second word year switch them
								if (results.get(j).getYear() > results.get(j - 1).getYear()) {
									results = switchEvents(results, j); // switch the events together
								}
								// if first event month less than second word month switch them while year is
								// the same
								else if (results.get(j).getYear() == results.get(j - 1).getYear()) {

									if (results.get(j).getMonth() > results.get(j - 1).getMonth()) {
										results = switchEvents(results, j); // switch the events together
									}
									// if first event day less than second word day switch them while month is the
									// same
									else if (results.get(j).getMonth() == results.get(j - 1).getMonth()) {
										if (results.get(j).getDay() > results.get(j - 1).getDay()) {
											results = switchEvents(results, j); // switch the events together
										}
									}

								}

							}
							// ascending sort
							else {
								// if first event year greater than second word year switch them
								if (results.get(j).getYear() < results.get(j - 1).getYear()) {
									results = switchEvents(results, j); // switch the events together
								}
								// if first event month greater than second word month switch them while year is
								// the same
								else if (results.get(j).getYear() == results.get(j - 1).getYear()) {

									if (results.get(j).getMonth() < results.get(j - 1).getMonth()) {
										results = switchEvents(results, j); // switch the events together
									}
									// if first event day greater than second word day switch them while month is
									// the same
									else if (results.get(j).getMonth() == results.get(j - 1).getMonth()) {
										if (results.get(j).getDay() < results.get(j - 1).getDay()) {
											results = switchEvents(results, j); // switch the events together
										}
									}

								}
							}
						}
					}
				}

			} catch (Exception e) {
			}

		}

		return results;
	}

	// method to switch 2 events order together (used often in bubble sort)
	private static ArrayList<Event> switchEvents(ArrayList<Event> list, int index) {

		ArrayList<Event> returnList = list;

		Event temp = returnList.get(index);
		returnList.set(index, returnList.get(index - 1));
		returnList.set(index - 1, temp);

		return (returnList);
	}

	// Method to setup the sample data
	public static void setupSampleData() {
		// add new events to event list
		myEvents.add(new Event("Swimming 1", "Pool", 10, 5, 2025, 20, false, "Male"));
		myEvents.add(new Event("Swimming 2", "Pool", 11, 5, 2025, 20, false, "Female"));
		myEvents.add(new Event("Karting", "Basement", 17, 8, 2025, 15, false, "Mixed"));
		myEvents.add(new Event("Movie", "Cinema", 5, 2, 2025, 50, true, "Mixed"));
		myEvents.add(new Event("Cooking", "Kitchen", 2, 1, 2026, 3, true, "Mixed"));

		// add participants to each event
		addParticipant(1, "Ahmed", 70000023, 17, "Male");
		addParticipant(1, "Osama", 70004051, 19, "Male");
		addParticipant(2, "Salma", 70000023, 17, "Female");
		addParticipant(2, "Sara", 70004051, 19, "Female");
		addParticipant(3, "Layth", 70000023, 17, "Male");
		addParticipant(3, "Alaa", 70000051, 13, "Male");
		addParticipant(3, "Mariam", 70004051, 19, "Female");
		addParticipant(4, "Ammar", 70000023, 20, "Male");
		addParticipant(4, "Hala", 70004051, 19, "Female");
		addParticipant(5, "Kareem", 70000023, 20, "Male");
		addParticipant(5, "Reem", 70004051, 19, "Female");
		addParticipant(5, "Iman", 70003011, 18, "Female");
	}

	// Display the list of events depending on search
	public static void printEvents(ArrayList<Event> eventList) {
		// Print the attributes of each event
		for (int i = 0; i < eventList.size(); i++) {

			System.out.println("Event " + (i + 1));
			System.out.println("Event: " + eventList.get(i).getName());
			System.out.println("Date: " + eventList.get(i).getDate());
			System.out.println("Place: " + eventList.get(i).getPlace());
			System.out.println("18+: " + eventList.get(i).getMustBe18());
			System.out.println("Capacity: " + eventList.get(i).getCapacity());
			System.out.println("Gender: " + eventList.get(i).getGender());
			System.out.println("Participant count: " + eventList.get(i).getParticipants().size());
			System.out.println();

		}
	}

	// Add participant method to add participants to a specific event
	public static void addParticipant(int eventNumber, String name, int number, int age, String gender) {
		// Create participant object
		Participant participant = new Participant(name, number, age, gender);

		// Add participant to the event
		myEvents.get(eventNumber - 1).addParticipant(participant);
	}

	// Print all participants and their details for a specific event
	public static void printParticipants(int eventNumber) {
		System.out.println();
		for (int i = 0; i < myEvents.get(eventNumber - 1).getParticipants().size(); i++) {
			Participant participant = myEvents.get(eventNumber - 1).getParticipants().get(i);
			System.out.println("Participant name: " + participant.getName());
			System.out.println("Phone number: " + participant.getPhoneNumber());
			System.out.println("Age: " + participant.getAge());
			System.out.println("Gender: " + participant.getGender());
			System.out.println();

		}
	}

}
