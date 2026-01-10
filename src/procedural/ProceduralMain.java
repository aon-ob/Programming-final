package procedural;

import java.util.Scanner;

public class ProceduralMain {

	// List of all events stored in arrayList
	//	static ArrayList<Event> myEvents = new ArrayList<>();
	
	static int eventCount;
	// --- EVENT 1 DATA ---
    static String name1, place1, gender1;
    static int day1, month1, year1, capacity1;
    static boolean mustBe18_1;
    static String e1_p1_name, e1_p1_gender; static int e1_p1_phone, e1_p1_age;
    static String e1_p2_name, e1_p2_gender; static int e1_p2_phone, e1_p2_age;
    static String e1_p3_name, e1_p3_gender; static int e1_p3_phone, e1_p3_age;
    static String e1_p4_name, e1_p4_gender; static int e1_p4_phone, e1_p4_age;
    static String e1_p5_name, e1_p5_gender; static int e1_p5_phone, e1_p5_age;

    // --- EVENT 2 DATA ---
    static String name2, place2, gender2;
    static int day2, month2, year2, capacity2;
    static boolean mustBe18_2;
    static String e2_p1_name, e2_p1_gender; static int e2_p1_phone, e2_p1_age;
    static String e2_p2_name, e2_p2_gender; static int e2_p2_phone, e2_p2_age;
    static String e2_p3_name, e2_p3_gender; static int e2_p3_phone, e2_p3_age;
    static String e2_p4_name, e2_p4_gender; static int e2_p4_phone, e2_p4_age;
    static String e2_p5_name, e2_p5_gender; static int e2_p5_phone, e2_p5_age;

    // --- EVENT 3 DATA ---
    static String name3, place3, gender3;
    static int day3, month3, year3, capacity3;
    static boolean mustBe18_3;
    static String e3_p1_name, e3_p1_gender; static int e3_p1_phone, e3_p1_age;
    static String e3_p2_name, e3_p2_gender; static int e3_p2_phone, e3_p2_age;
    static String e3_p3_name, e3_p3_gender; static int e3_p3_phone, e3_p3_age;
    static String e3_p4_name, e3_p4_gender; static int e3_p4_phone, e3_p4_age;
    static String e3_p5_name, e3_p5_gender; static int e3_p5_phone, e3_p5_age;

    // --- EVENT 4 DATA ---
    static String name4, place4, gender4;
    static int day4, month4, year4, capacity4;
    static boolean mustBe18_4;
    static String e4_p1_name, e4_p1_gender; static int e4_p1_phone, e4_p1_age;
    static String e4_p2_name, e4_p2_gender; static int e4_p2_phone, e4_p2_age;
    static String e4_p3_name, e4_p3_gender; static int e4_p3_phone, e4_p3_age; 
    static String e4_p4_name, e4_p4_gender; static int e4_p4_phone, e4_p4_age;
    static String e4_p5_name, e4_p5_gender; static int e4_p5_phone, e4_p5_age;

    // --- EVENT 5 DATA ---
    static String name5, place5, gender5;
    static int day5, month5, year5, capacity5;
    static boolean mustBe18_5;
    static String e5_p1_name, e5_p1_gender; static int e5_p1_phone, e5_p1_age;
    static String e5_p2_name, e5_p2_gender; static int e5_p2_phone, e5_p2_age;
    static String e5_p3_name, e5_p3_gender; static int e5_p3_phone, e5_p3_age;
    static String e5_p4_name, e5_p4_gender; static int e5_p4_phone, e5_p4_age;
    static String e5_p5_name, e5_p5_gender; static int e5_p5_phone, e5_p5_age;

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
			System.out.println("2. Search & Filter");
			System.out.println("3. Add participant");
			System.out.println("4. View participants");
			System.out.println("5. Quit");

			// Take option input
			System.out.print("Enter the number for the feature you want to use: ");
			int option = scanner.nextInt();
			// Make sure it is a valid input
			while (option < 1 || option > 5) {
				System.out.print("Please enter a valid number in the range (1-6): ");
				option = scanner.nextInt();
			}
			scanner.nextLine(); // clean scanner

			// Display all events option
			if (option == 1) {
				System.out.println();
				System.out.println("All events: ");
				System.out.println();

				printEvents(); // Prints all events
			}
			// Display events from search query option
			else if (option == 2) {
				// Search Menu
				System.out.println();
				System.out.println("--- Search Options ---");
				System.out.println("1. Filter by name");
				System.out.println("2. Filter by place");
				System.out.println("3. Filter by gender");
				System.out.println("4. Filter by day");
				System.out.println("5. Filter by month");
				System.out.println("6. Filter by year");
				System.out.println("7. Filter by capacity");
				System.out.println("8. Filter by 18 only");
				
				// Take option input
				System.out.print("Enter the number for the feature you want to use: ");
				int searchOption = scanner.nextInt();
				// Make sure it is a valid input
				while (searchOption < 1 || searchOption > 8) {
					System.out.print("Please enter a valid number in the range (1-8): ");
					searchOption = scanner.nextInt();
				}
				scanner.nextLine(); // clean scanner
				
				String name = "";
				String place = "";
				String gender = "";
				int day = -1;
				String dayOperation = "";
				int month = -1;
				String monthOperation = "";
				int year = -1;
				String yearOperation = "";
				int capacity = -1;
				String capacityOperation = "";
				String mustBe18 = "";
				
				if(searchOption == 1) {
					System.out.println("Enter the name you want to filter for: ");
					name = scanner.nextLine();
				} 
				else if(searchOption == 2) {
					System.out.println("Enter the place you want to filter for: ");
					place = scanner.nextLine();
				} 
				else if(searchOption == 3) {
					System.out.println("Enter the gender you want to filter for (male, female, mixed): ");
					gender = scanner.nextLine();
					while (!(gender.toLowerCase().equals("male") || gender.toLowerCase().equals("female") || gender.toLowerCase().equals("mixed"))) {
						System.out.print("Please enter a valid gender (male, female, mixed): ");
						gender = scanner.nextLine();
					}
				}
				else if(searchOption == 4) {
					System.out.println("Enter the day you want to filter for (integer 1-31): ");
					day = scanner.nextInt();
					while (day < 1 || day > 31) {
						System.out.print("Please enter a valid number in the range (1-31): ");
						day = scanner.nextInt();
					}
					scanner.nextLine(); // clean scanner
					
					System.out.println("Enter the operation you want to use (>, <, >=, <=) (keep empty to filter for exact value =): ");
					dayOperation = scanner.nextLine();
					while (!(dayOperation.toLowerCase().equals(">") || dayOperation.toLowerCase().equals("<") || dayOperation.toLowerCase().equals(">=") || dayOperation.toLowerCase().equals("<=") || dayOperation.toLowerCase().equals(""))) {
						System.out.print("Please enter a valid operation (>, <, >=, <=, empty): ");
						dayOperation = scanner.nextLine();
					}								
				}
				else if(searchOption == 5) {
					System.out.println("Enter the month you want to filter for (integer 1-12): ");
					month = scanner.nextInt();
					while (month < 1 || month > 12) {
						System.out.print("Please enter a valid number in the range (1-12): ");
						month = scanner.nextInt();
					}
					scanner.nextLine(); // clean scanner
					
					System.out.println("Enter the operation you want to use (>, <, >=, <=) (keep empty to filter for exact value =): ");
					monthOperation = scanner.nextLine();
					while (!(monthOperation.toLowerCase().equals(">") || monthOperation.toLowerCase().equals("<") || monthOperation.toLowerCase().equals(">=") || monthOperation.toLowerCase().equals("<=") || monthOperation.toLowerCase().equals(""))) {
						System.out.print("Please enter a valid operation (>, <, >=, <=, empty): ");
						monthOperation = scanner.nextLine();
					}								
				}
				else if(searchOption == 6) {
					System.out.println("Enter the year you want to filter for (integer 2025-3000): ");
					year = scanner.nextInt();
					while (year < 2025 || year > 3000) {
						System.out.print("Please enter a valid number in the range (2025-3000): ");
						year = scanner.nextInt();
					}
					scanner.nextLine(); // clean scanner
					
					System.out.println("Enter the operation you want to use (>, <, >=, <=) (keep empty to filter for exact value =): ");
					yearOperation = scanner.nextLine();
					while (!(yearOperation.toLowerCase().equals(">") || yearOperation.toLowerCase().equals("<") || yearOperation.toLowerCase().equals(">=") || yearOperation.toLowerCase().equals("<=") || yearOperation.toLowerCase().equals(""))) {
						System.out.print("Please enter a valid operation (>, <, >=, <=, empty): ");
						yearOperation = scanner.nextLine();
					}								
				}
				else if(searchOption == 7) {
					System.out.println("Enter the capacity you want to filter for (integer 0-5): ");
					capacity = scanner.nextInt();
					while (capacity < 0 || capacity > 5) {
						System.out.print("Please enter a valid number in the range (0-5): ");
						capacity = scanner.nextInt();
					}
					scanner.nextLine(); // clean scanner
					
					System.out.println("Enter the operation you want to use (>, <, >=, <=) (keep empty to filter for exact value =): ");
					capacityOperation = scanner.nextLine();
					while (!(capacityOperation.toLowerCase().equals(">") || capacityOperation.toLowerCase().equals("<") || capacityOperation.toLowerCase().equals(">=") || capacityOperation.toLowerCase().equals("<=") || capacityOperation.toLowerCase().equals(""))) {
						System.out.print("Please enter a valid operation (>, <, >=, <=, empty): ");
						capacityOperation = scanner.nextLine();
					}								
				}
				else if(searchOption == 8) {
					System.out.println("Enter if the event is only 18+ (true, false): ");
					mustBe18 = scanner.nextLine();
					while (!(mustBe18.toLowerCase().equals("true") || mustBe18.toLowerCase().equals("false"))) {
						System.out.print("Please enter a valid input (true, false): ");
						mustBe18 = scanner.nextLine();
					}
				}
				
				
				// Prints events by the searchEvents method which uses the search query to print a list of events matching it
				searchEvents(name, place, gender, day, dayOperation, month, monthOperation, year, yearOperation, capacity, capacityOperation, mustBe18);
			}
			// Add participant option
			else if (option == 3) {
				System.out.println();
				System.out.println("All events: ");
				System.out.println();
				// Print all the events for reference so the user can choose one.
				printEvents();
				// User picks the event to add a participant to
				System.out.print("Enter number for the event you want to add a participant to: ");
				int eventNumber = scanner.nextInt();
				// Make sure it is a valid input
				while (eventNumber <= 0 || eventNumber > eventCount) {
					System.out.print("Please enter a valid number in the range (1-" + eventCount + "): ");
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
				printEvents();
				System.out.print("Enter number for the event you want to view the participants of: ");
				// Pick the event from a number
				int eventNumber = scanner.nextInt();
				// Make sure it is a valid input
				while (eventNumber <= 0 || eventNumber > eventCount) {
					System.out.print("Please enter a valid number in the range (1-" + eventCount + "): ");
					eventNumber = scanner.nextInt();
				}
				scanner.nextLine(); // clean scanner
				// Call the print participants method to print all participants of the event selected
				printParticipants(eventNumber);
			}
			// Quit option
			else if (option == 5) {
				System.exit(0);
			}

		}

	}

	// Search events method (Search and filter feature) (view all events feature)
	// (contains bubble sort algorithm)
	public static void searchEvents(String name, String place, String gender, int day, String dayOperation, int month, String monthOperation, int year, String yearOperation, int capacity, String capacityOperation, String mustBe18) {
		// Filter by selected query


		// place query
		if (place != "") {
			place = place.toLowerCase();
			boolean ev1 = false;
			boolean ev2 = false;
			boolean ev3 = false;
			boolean ev4 = false;
			boolean ev5 = false;
			if(place1.toLowerCase().contains(place)) {
				ev1 = true;
			}
			if(place2.toLowerCase().contains(place)) {
				ev2 = true;
			}
			if(place3.toLowerCase().contains(place)) {
				ev3 = true;
			}
			if(place4.toLowerCase().contains(place)) {
				ev4 = true;
			}
			if(place5.toLowerCase().contains(place)) {
				ev5 = true;
			}
			
			printEvents(ev1, ev2, ev3, ev4, ev5);
		}
		// gender query
		else if (gender != "") {
			gender = gender.toLowerCase();
			boolean ev1 = false;
			boolean ev2 = false;
			boolean ev3 = false;
			boolean ev4 = false;
			boolean ev5 = false;
			
			if(gender1.toLowerCase().equals(gender)) {
				ev1 = true;
			}
			if(gender2.toLowerCase().equals(gender)) {
				ev2 = true;
			}
			if(gender3.toLowerCase().equals(gender)) {
				ev3 = true;
			}
			if(gender4.toLowerCase().equals(gender)) {
				ev4 = true;
			}
			if(gender5.toLowerCase().equals(gender)) {
				ev5 = true;
			}
			
			printEvents(ev1, ev2, ev3, ev4, ev5);
		}
		// day query
		else if (day != -1) {
			boolean ev1 = false;
			boolean ev2 = false;
			boolean ev3 = false;
			boolean ev4 = false;
			boolean ev5 = false;
			if(dayOperation.contains(">=")) {
				if(day1 >= day) {
					ev1 = true;
				}
				if(day2 >= day) {
					ev2 = true;
				}
				if(day3 >= day) {
					ev3 = true;
				}
				if(day4 >= day) {
					ev4 = true;
				}
				if(day5 >= day) {
					ev5 = true;
				}
			}
			else if(dayOperation.contains("<=")) {
				if(day1 <= day) {
					ev1 = true;
				}
				if(day2 <= day) {
					ev2 = true;
				}
				if(day3 <= day) {
					ev3 = true;
				}
				if(day4 <= day) {
					ev4 = true;
				}
				if(day5 <= day) {
					ev5 = true;
				}
			}
			else if(dayOperation.contains(">")) {
				if(day1 > day) {
					ev1 = true;
				}
				if(day2 > day) {
					ev2 = true;
				}
				if(day3 > day) {
					ev3 = true;
				}
				if(day4 > day) {
					ev4 = true;
				}
				if(day5 > day) {
					ev5 = true;
				}
			}
			else if(dayOperation.contains("<")) {
				if(day1 < day) {
					ev1 = true;
				}
				if(day2 < day) {
					ev2 = true;
				}
				if(day3 < day) {
					ev3 = true;
				}
				if(day4 < day) {
					ev4 = true;
				}
				if(day5 < day) {
					ev5 = true;
				}
			}
			else {
				if(day1 == day) {
					ev1 = true;
				}
				if(day2 == day) {
					ev2 = true;
				}
				if(day3 == day) {
					ev3 = true;
				}
				if(day4 == day) {
					ev4 = true;
				}
				if(day5 == day) {
					ev5 = true;
				}
			}
			
			
			printEvents(ev1, ev2, ev3, ev4, ev5);
		}
		// month query
		else if (month != -1) {
			boolean ev1 = false;
			boolean ev2 = false;
			boolean ev3 = false;
			boolean ev4 = false;
			boolean ev5 = false;
			if(monthOperation.contains(">=")) {
				if(month1 >= month) {
					ev1 = true;
				}
				if(month2 >= month) {
					ev2 = true;
				}
				if(month3 >= month) {
					ev3 = true;
				}
				if(month4 >= month) {
					ev4 = true;
				}
				if(month5 >= month) {
					ev5 = true;
				}
			}
			else if(monthOperation.contains("<=")) {
				if(month1 <= month) {
					ev1 = true;
				}
				if(month2 <= month) {
					ev2 = true;
				}
				if(month3 <= month) {
					ev3 = true;
				}
				if(month4 <= month) {
					ev4 = true;
				}
				if(month5 <= month) {
					ev5 = true;
				}
			}
			else if(monthOperation.contains(">")) {
				if(month1 > month) {
					ev1 = true;
				}
				if(month2 > month) {
					ev2 = true;
				}
				if(month3 > month) {
					ev3 = true;
				}
				if(month4 > month) {
					ev4 = true;
				}
				if(month5 > month) {
					ev5 = true;
				}
			}
			else if(monthOperation.contains("<")) {
				if(month1 < month) {
					ev1 = true;
				}
				if(month2 < month) {
					ev2 = true;
				}
				if(month3 < month) {
					ev3 = true;
				}
				if(month4 < month) {
					ev4 = true;
				}
				if(month5 < month) {
					ev5 = true;
				}
			}
			else {
				if(month1 == month) {
					ev1 = true;
				}
				if(month2 == month) {
					ev2 = true;
				}
				if(month3 == month) {
					ev3 = true;
				}
				if(month4 == month) {
					ev4 = true;
				}
				if(month5 == month) {
					ev5 = true;
				}
			}
			
			
			printEvents(ev1, ev2, ev3, ev4, ev5);
		}
		// year query
		else if (year != -1) {
			boolean ev1 = false;
			boolean ev2 = false;
			boolean ev3 = false;
			boolean ev4 = false;
			boolean ev5 = false;
			if(yearOperation.contains(">=")) {
				if(year1 >= year) {
					ev1 = true;
				}
				if(year2 >= year) {
					ev2 = true;
				}
				if(year3 >= year) {
					ev3 = true;
				}
				if(year4 >= year) {
					ev4 = true;
				}
				if(year5 >= year) {
					ev5 = true;
				}
			}
			else if(yearOperation.contains("<=")) {
				if(year1 <= year) {
					ev1 = true;
				}
				if(year2 <= year) {
					ev2 = true;
				}
				if(year3 <= year) {
					ev3 = true;
				}
				if(year4 <= year) {
					ev4 = true;
				}
				if(year5 <= year) {
					ev5 = true;
				}
			}
			else if(yearOperation.contains(">")) {
				if(year1 > year) {
					ev1 = true;
				}
				if(year2 > year) {
					ev2 = true;
				}
				if(year3 > year) {
					ev3 = true;
				}
				if(year4 > year) {
					ev4 = true;
				}
				if(year5 > year) {
					ev5 = true;
				}
			}
			else if(yearOperation.contains("<")) {
				if(year1 < year) {
					ev1 = true;
				}
				if(year2 < year) {
					ev2 = true;
				}
				if(year3 < year) {
					ev3 = true;
				}
				if(year4 < year) {
					ev4 = true;
				}
				if(year5 < year) {
					ev5 = true;
				}
			}
			else {
				if(year1 == year) {
					ev1 = true;
				}
				if(year2 == year) {
					ev2 = true;
				}
				if(year3 == year) {
					ev3 = true;
				}
				if(year4 == year) {
					ev4 = true;
				}
				if(year5 == year) {
					ev5 = true;
				}
			}
			
			
			printEvents(ev1, ev2, ev3, ev4, ev5);
		}
		// capacity query
		else if (capacity != -1) {
			boolean ev1 = false;
			boolean ev2 = false;
			boolean ev3 = false;
			boolean ev4 = false;
			boolean ev5 = false;
			if(capacityOperation.contains(">=")) {
				if(capacity1 >= capacity) {
					ev1 = true;
				}
				if(capacity2 >= capacity) {
					ev2 = true;
				}
				if(capacity3 >= capacity) {
					ev3 = true;
				}
				if(capacity4 >= capacity) {
					ev4 = true;
				}
				if(capacity5 >= capacity) {
					ev5 = true;
				}
			}
			else if(capacityOperation.contains("<=")) {
				if(capacity1 <= capacity) {
					ev1 = true;
				}
				if(capacity2 <= capacity) {
					ev2 = true;
				}
				if(capacity3 <= capacity) {
					ev3 = true;
				}
				if(capacity4 <= capacity) {
					ev4 = true;
				}
				if(capacity5 <= capacity) {
					ev5 = true;
				}
			}
			else if(capacityOperation.contains(">")) {
				if(capacity1 > capacity) {
					ev1 = true;
				}
				if(capacity2 > capacity) {
					ev2 = true;
				}
				if(capacity3 > capacity) {
					ev3 = true;
				}
				if(capacity4 > capacity) {
					ev4 = true;
				}
				if(capacity5 > capacity) {
					ev5 = true;
				}
			}
			else if(capacityOperation.contains("<")) {
				if(capacity1 < capacity) {
					ev1 = true;
				}
				if(capacity2 < capacity) {
					ev2 = true;
				}
				if(capacity3 < capacity) {
					ev3 = true;
				}
				if(capacity4 < capacity) {
					ev4 = true;
				}
				if(capacity5 < capacity) {
					ev5 = true;
				}
			}
			else {
				if(capacity1 == capacity) {
					ev1 = true;
				}
				if(capacity2 == capacity) {
					ev2 = true;
				}
				if(capacity3 == capacity) {
					ev3 = true;
				}
				if(capacity4 == capacity) {
					ev4 = true;
				}
				if(capacity5 == capacity) {
					ev5 = true;
				}
			}
			
			
			printEvents(ev1, ev2, ev3, ev4, ev5);
		}
		// mustBe18 query
		else if (mustBe18 != "") {
			mustBe18 = mustBe18.toLowerCase();
			boolean ev1 = false;
			boolean ev2 = false;
			boolean ev3 = false;
			boolean ev4 = false;
			boolean ev5 = false;
			if(mustBe18.equals("true")) {
				if(mustBe18_1) {
					ev1 = true;
				}
				if(mustBe18_2) {
					ev2 = true;
				}
				if(mustBe18_3) {
					ev3 = true;
				}
				if(mustBe18_4) {
					ev4 = true;
				}
				if(mustBe18_5) {
					ev5 = true;
				}
				
				printEvents(ev1, ev2, ev3, ev4, ev5);
				
			} else {
				printEvents();
			}
			
			
			
		}
		// search query keywords
		else if (name != "") {
			name = name.toLowerCase();
			boolean ev1 = false;
			boolean ev2 = false;
			boolean ev3 = false;
			boolean ev4 = false;
			boolean ev5 = false;
			if(name1.toLowerCase().contains(name)) {
				ev1 = true;
			}
			if(name2.toLowerCase().contains(name)) {
				ev2 = true;
			}
			if(name3.toLowerCase().contains(name)) {
				ev3 = true;
			}
			if(name4.toLowerCase().contains(name)) {
				ev4 = true;
			}
			if(name5.toLowerCase().contains(name)) {
				ev5 = true;
			}
			
			printEvents(ev1, ev2, ev3, ev4, ev5);
		}

	

	}

	// Method to setup the sample data
	public static void setupSampleData() {
        eventCount = 5;

        // EVENT 1
        name1 = "Swimming 1"; place1 = "Pool"; 
        day1 = 10; month1 = 5; year1 = 2025; capacity1 = 3; mustBe18_1 = false; gender1 = "Male";
        

        e1_p1_name = "Ahmed"; e1_p1_phone = 70000023; e1_p1_age = 17; e1_p1_gender = "Male";

        e1_p2_name = "Osama"; e1_p2_phone = 70004051; e1_p2_age = 19; e1_p2_gender = "Male";

        e1_p3_name = "Zaid"; e1_p3_phone = 79998877; e1_p3_age = 18; e1_p3_gender = "Male";

        e1_p4_name = ""; e1_p4_phone = -1; e1_p4_age = -1; e1_p4_gender = "";
        
        e1_p5_name = ""; e1_p5_phone = -1; e1_p5_age = -1; e1_p5_gender = "";
        

        //EVENT 2
        name2 = "Swimming 2"; place2 = "Pool"; 
        day2 = 11; month2 = 5; year2 = 2025; capacity2 = 3; mustBe18_2 = false; gender2 = "Female";
        

        e2_p1_name = "Salma"; e2_p1_phone = 70000023; e2_p1_age = 17; e2_p1_gender = "Female";

        e2_p2_name = "Sara"; e2_p2_phone = 70004051; e2_p2_age = 19; e2_p2_gender = "Female";

        e2_p3_name = "Nour"; e2_p3_phone = 78885522; e2_p3_age = 16; e2_p3_gender = "Female";
        
        e2_p4_name = ""; e2_p4_phone = -1; e2_p4_age = -1; e2_p4_gender = "";
        
        e2_p5_name = ""; e2_p5_phone = -1; e2_p5_age = -1; e2_p5_gender = "";
        
        // EVENT 3
        name3 = "Karting"; place3 = "Basement"; 
        day3 = 17; month3 = 8; year3 = 2025; capacity3 = 2; mustBe18_3 = false; gender3 = "Mixed";
        

        e3_p1_name = "Layth"; e3_p1_phone = 70000023; e3_p1_age = 17; e3_p1_gender = "Male";

        e3_p2_name = "Mariam"; e3_p2_phone = 70004051; e3_p2_age = 19; e3_p2_gender = "Female";

        e3_p3_name = ""; e3_p3_phone = -1; e3_p3_age = -1; e3_p3_gender = "";
        
        e3_p4_name = ""; e3_p4_phone = -1; e3_p4_age = -1; e3_p4_gender = "";

        e3_p5_name = ""; e3_p5_phone = -1; e3_p5_age = -1; e3_p5_gender = "";

        // EVENT 4
        name4 = "Movie"; place4 = "Cinema"; 
        day4 = 5; month4 = 2; year4 = 2025; capacity4 = 5; mustBe18_4 = true; gender4 = "Mixed";
        

        e4_p1_name = "Ammar"; e4_p1_phone = 70000023; e4_p1_age = 20; e4_p1_gender = "Male";

        e4_p2_name = "Hala"; e4_p2_phone = 70004051; e4_p2_age = 19; e4_p2_gender = "Female";

        e4_p3_name = "Tariq"; e4_p3_phone = 77712345; e4_p3_age = 21; e4_p3_gender = "Male";
        
        e4_p4_name = "Kareem"; e4_p4_phone = 70000023; e4_p4_age = 20; e4_p4_gender = "Male";

        e4_p5_name = "Mariam"; e4_p5_phone = 70004051; e4_p5_age = 19; e4_p5_gender = "Female";

        // EVENT 5
        name5 = "Cooking"; place5 = "Kitchen"; 
        day5 = 2; month5 = 1; year5 = 2026; capacity5 = 4; mustBe18_5 = true; gender5 = "Mixed";
        

        e5_p1_name = "Kareem"; e5_p1_phone = 70000023; e5_p1_age = 20; e5_p1_gender = "Male";

        e5_p2_name = "Reem"; e5_p2_phone = 70004051; e5_p2_age = 19; e5_p2_gender = "Female";

        e5_p3_name = "Iman"; e5_p3_phone = 70003011; e5_p3_age = 18; e5_p3_gender = "Female";
        
        e5_p4_name = "Alaa"; e5_p4_phone = 70000051; e5_p4_age = 21; e5_p4_gender = "Male";
        
        e5_p5_name = ""; e5_p5_phone = -1; e5_p5_age = -1; e5_p5_gender = "";

    }

	// Display the list of all events
	public static void printEvents() {
		// Print the attributes of each event
		System.out.println("Event: 1");
		System.out.println("Event Name: " + name1);
		System.out.println("Date: " + day1 + "/" + month1 + "/" + year1);
		System.out.println("Place: " + place1);
		System.out.println("18+: " + mustBe18_1);
		System.out.println("Capacity: " + capacity1 + "/5");
		System.out.println("Gender: " + gender1);
		System.out.println();
		
		System.out.println("Event: 2");
		System.out.println("Event Name: " + name2);
		System.out.println("Date: " + day2 + "/" + month2 + "/" + year2);
		System.out.println("Place: " + place2);
		System.out.println("18+: " + mustBe18_2);
		System.out.println("Capacity: " + capacity2 + "/5");
		System.out.println("Gender: " + gender2);
		System.out.println();
		
		System.out.println("Event: 3");
		System.out.println("Event Name: " + name3);
		System.out.println("Date: " + day3 + "/" + month3 + "/" + year3);
		System.out.println("Place: " + place3);
		System.out.println("18+: " + mustBe18_3);
		System.out.println("Capacity: " + capacity3 + "/5");
		System.out.println("Gender: " + gender3);
		System.out.println();
		
		System.out.println("Event: 4");
		System.out.println("Event Name: " + name4);
		System.out.println("Date: " + day4 + "/" + month4 + "/" + year4);
		System.out.println("Place: " + place4);
		System.out.println("18+: " + mustBe18_4);
		System.out.println("Capacity: " + capacity4 + "/5");
		System.out.println("Gender: " + gender4);
		System.out.println();
		
		System.out.println("Event: 5");
		System.out.println("Event Name: " + name5);
		System.out.println("Date: " + day5 + "/" + month5 + "/" + year5);
		System.out.println("Place: " + place5);
		System.out.println("18+: " + mustBe18_5);
		System.out.println("Capacity: " + capacity5 + "/5");
		System.out.println("Gender: " + gender5);
		System.out.println();
		
	}
	// (Overloading)
	// Display the list of events depending on search (Linear search algorithm)
	public static void printEvents(boolean ev1, boolean ev2, boolean ev3, boolean ev4, boolean ev5) {
		// Print the attributes of each event if the event is true
		if(ev1) {
			System.out.println("Event: 1");
			System.out.println("Event Name: " + name1);
			System.out.println("Date: " + day1 + "/" + month1 + "/" + year1);
			System.out.println("Place: " + place1);
			System.out.println("18+: " + mustBe18_1);
			System.out.println("Capacity: " + capacity1 + "/5");
			System.out.println("Gender: " + gender1);
			System.out.println();
		}
		
		if(ev2) {
			System.out.println("Event: 2");
			System.out.println("Event Name: " + name2);
			System.out.println("Date: " + day2 + "/" + month2 + "/" + year2);
			System.out.println("Place: " + place2);
			System.out.println("18+: " + mustBe18_2);
			System.out.println("Capacity: " + capacity2 + "/5");
			System.out.println("Gender: " + gender2);
			System.out.println();
		}
		
		if(ev3) {
			System.out.println("Event: 3");
			System.out.println("Event Name: " + name3);
			System.out.println("Date: " + day3 + "/" + month3 + "/" + year3);
			System.out.println("Place: " + place3);
			System.out.println("18+: " + mustBe18_3);
			System.out.println("Capacity: " + capacity3 + "/5");
			System.out.println("Gender: " + gender3);
			System.out.println();
		}
		
		if(ev4) {
			System.out.println("Event: 4");
			System.out.println("Event Name: " + name4);
			System.out.println("Date: " + day4 + "/" + month4 + "/" + year4);
			System.out.println("Place: " + place4);
			System.out.println("18+: " + mustBe18_4);
			System.out.println("Capacity: " + capacity4 + "/5");
			System.out.println("Gender: " + gender4);
			System.out.println();
		}
		
		if(ev5) {
			System.out.println("Event: 5");
			System.out.println("Event Name: " + name5);
			System.out.println("Date: " + day5 + "/" + month5 + "/" + year5);
			System.out.println("Place: " + place5);
			System.out.println("18+: " + mustBe18_5);
			System.out.println("Capacity: " + capacity5 + "/5");
			System.out.println("Gender: " + gender5);
			System.out.println();
		}
		
	}

	// Add participant method to add participants to a specific event
	public static void addParticipant(int eventNumber, String name, int number, int age, String gender) {
		// Add participant to chosen event
		
		// Add to event 1
		if(eventNumber == 1) {
			// Check if gender matches
			if(gender1.toLowerCase().equals(gender) || gender1.toLowerCase().equals("mixed")) {
				// Check if age matches
				if(mustBe18_1 && age >= 18 || !mustBe18_1) {
					// Add to slot 1
					if(capacity1 == 0) {
						e1_p1_name = name;
						e1_p1_phone = number;
						e1_p1_age = age;
						e1_p1_gender = gender;
					}
					// Add to slot 2
					else if(capacity1 == 1) {
						e1_p2_name = name;
						e1_p2_phone = number;
						e1_p2_age = age;
						e1_p2_gender = gender;
					}
					// Add to slot 3
					else if(capacity1 == 2) {
						e1_p3_name = name;
						e1_p3_phone = number;
						e1_p3_age = age;
						e1_p3_gender = gender;
					}
					// Add to slot 4
					else if(capacity1 == 3) {
						e1_p4_name = name;
						e1_p4_phone = number;
						e1_p4_age = age;
						e1_p4_gender = gender;
					}
					// Add to slot 5
					else if(capacity1 == 4) {
						e1_p5_name = name;
						e1_p5_phone = number;
						e1_p5_age = age;
						e1_p5_gender = gender;
					}
					else if(capacity1 == 5) {
						System.err.println("This event is full.");
						
						// to counteract incrementing capacity
						capacity1 -= 1;
					}
					
					// increase capacity
					capacity1 += 1;
					
				}
				else {
					System.err.println("Participant must be atleast 18 years old to participate in this event.");
				}
			}
			else {
				System.err.println("Participant must be " + gender1 + " to paricipate in this event.");
			}
			
		}

		// Add to event 2
		if(eventNumber == 2) {
			// Check if gender matches
			if(gender1.toLowerCase().equals(gender) || gender2.toLowerCase().equals("mixed")) {
				// Check if age matches
				if(mustBe18_2 && age >= 18 || !mustBe18_2) {
					// Add to slot 1
					if(capacity2 == 0) {
						e2_p1_name = name;
						e2_p1_phone = number;
						e2_p1_age = age;
						e2_p1_gender = gender;
					}
					// Add to slot 2
					else if(capacity2 == 1) {
						e2_p2_name = name;
						e2_p2_phone = number;
						e2_p2_age = age;
						e2_p2_gender = gender;
					}
					// Add to slot 3
					else if(capacity2 == 2) {
						e2_p3_name = name;
						e2_p3_phone = number;
						e2_p3_age = age;
						e2_p3_gender = gender;
					}
					// Add to slot 4
					else if(capacity2 == 3) {
						e2_p4_name = name;
						e2_p4_phone = number;
						e2_p4_age = age;
						e2_p4_gender = gender;
					}
					// Add to slot 5
					else if(capacity2 == 4) {
						e2_p5_name = name;
						e2_p5_phone = number;
						e2_p5_age = age;
						e2_p5_gender = gender;
					}
					else if(capacity2 == 5) {
						System.err.println("This event is full.");
						
						// to counteract incrementing capacity
						capacity2 -= 1;
					}
					// increase capacity
					capacity2 += 1;
					
				}
				else {
					System.err.println("Participant must be atleast 18 years old to participate in this event.");
				}
			}
			else {
				System.err.println("Participant must be " + gender2 + " to paricipate in this event.");
			}
			
		}
		// Add to event 3
		if(eventNumber == 3) {
			// Check if gender matches
			if(gender3.toLowerCase().equals(gender) || gender3.toLowerCase().equals("mixed")) {
				// Check if age matches
				if(mustBe18_3 && age >= 18 || !mustBe18_3) {
					// Add to slot 1
					if(capacity3 == 0) {
						e3_p1_name = name;
						e3_p1_phone = number;
						e3_p1_age = age;
						e3_p1_gender = gender;
					}
					// Add to slot 2
					else if(capacity3 == 1) {
						e3_p2_name = name;
						e3_p2_phone = number;
						e3_p2_age = age;
						e3_p2_gender = gender;
					}
					// Add to slot 3
					else if(capacity3 == 2) {
						e3_p3_name = name;
						e3_p3_phone = number;
						e3_p3_age = age;
						e3_p3_gender = gender;
					}
					// Add to slot 4
					else if(capacity3 == 3) {
						e3_p4_name = name;
						e3_p4_phone = number;
						e3_p4_age = age;
						e3_p4_gender = gender;
					}
					// Add to slot 5
					else if(capacity3 == 4) {
						e3_p5_name = name;
						e3_p5_phone = number;
						e3_p5_age = age;
						e3_p5_gender = gender;
					}
					else if(capacity2 == 5) {
						System.err.println("This event is full.");
						
						// to counteract incrementing capacity
						capacity2 -= 1;
					}
					
					// increase capacity
					capacity3 += 1;
					
				}
				
				else {
					System.err.println("Participant must be atleast 18 years old to participate in this event.");
				}
			}
			else {
				System.err.println("Participant must be " + gender3 + " to paricipate in this event.");
			}
			
		}
		// Add to event 4
		if(eventNumber == 4) {
			// Check if gender matches
			if(gender4.toLowerCase().equals(gender) || gender4.toLowerCase().equals("mixed")) {
				// Check if age matches
				if(mustBe18_4 && age >= 18 || !mustBe18_4) {
					// Add to slot 1
					if(capacity4 == 0) {
						e4_p1_name = name;
						e4_p1_phone = number;
						e4_p1_age = age;
						e4_p1_gender = gender;
					}
					// Add to slot 2
					else if(capacity4 == 1) {
						e4_p2_name = name;
						e4_p2_phone = number;
						e4_p2_age = age;
						e4_p2_gender = gender;
					}
					// Add to slot 3
					else if(capacity4 == 2) {
						e4_p3_name = name;
						e4_p3_phone = number;
						e4_p3_age = age;
						e4_p3_gender = gender;
					}
					// Add to slot 4
					else if(capacity4 == 3) {
						e4_p4_name = name;
						e4_p4_phone = number;
						e4_p4_age = age;
						e4_p4_gender = gender;
					}
					// Add to slot 5
					else if(capacity4 == 4) {
						e4_p5_name = name;
						e4_p5_phone = number;
						e4_p5_age = age;
						e4_p5_gender = gender;
					}
					else if(capacity4 == 5) {
						System.err.println("This event is full.");
						
						// to counteract incrementing capacity
						capacity4 -= 1;
					}
					// increase capacity
					capacity4 += 1;
					
				}
				
				else {
					System.err.println("Participant must be atleast 18 years old to participate in this event.");
				}
			}
			else {
				System.err.println("Participant must be " + gender4 + " to paricipate in this event.");
			}
			
		}
		// Add to event 5
		if(eventNumber == 5) {
			// Check if gender matches
			if(gender5.toLowerCase().equals(gender) || gender5.toLowerCase().equals("mixed")) {
				// Check if age matches
				if(mustBe18_5 && age >= 18 || !mustBe18_5) {
					// Add to slot 1
					if(capacity5 == 1) {
						e5_p1_name = name;
						e5_p1_phone = number;
						e5_p1_age = age;
						e5_p1_gender = gender;
					}
					// Add to slot 2
					else if(capacity5 == 2) {
						e5_p2_name = name;
						e5_p2_phone = number;
						e5_p2_age = age;
						e5_p2_gender = gender;
					}
					// Add to slot 3
					else if(capacity5 == 3) {
						e5_p3_name = name;
						e5_p3_phone = number;
						e5_p3_age = age;
						e5_p3_gender = gender;
					}
					// Add to slot 4
					else if(capacity5 == 4) {
						e5_p4_name = name;
						e5_p4_phone = number;
						e5_p4_age = age;
						e5_p4_gender = gender;
					}
					// Add to slot 5
					else if(capacity5 == 5) {
						e5_p5_name = name;
						e5_p5_phone = number;
						e5_p5_age = age;
						e5_p5_gender = gender;
					}
					else if(capacity5 == 5) {
						System.err.println("This event is full.");
						
						// to counteract incrementing capacity
						capacity5 -= 1;
					}
					// increase capacity
					capacity5 += 1;
					
				}
				else {
					System.err.println("Participant must be atleast 18 years old to participate in this event.");
				}
			}
			else {
				System.err.println("Participant must be " + gender5 + " to paricipate in this event.");
			}
			
		}
	}

	// Print all participants and their details for a specific event
	public static void printParticipants(int eventNumber) {
		System.out.println();
		// Print event 1 participants
		if(eventNumber == 1) {
			if(capacity1 >= 1) {
				System.out.println("Participant name: " + e1_p1_name);
				System.out.println("Phone number: " + e1_p1_phone);
				System.out.println("Age: " + e1_p1_age);
				System.out.println("Gender: " + e1_p1_gender);
				System.out.println();
			}
			if(capacity1 >= 2) {
				System.out.println("Participant name: " + e1_p2_name);
				System.out.println("Phone number: " + e1_p2_phone);
				System.out.println("Age: " + e1_p2_age);
				System.out.println("Gender: " + e1_p2_gender);
				System.out.println();
			}
			if(capacity1 >= 3) {
				System.out.println("Participant name: " + e1_p3_name);
				System.out.println("Phone number: " + e1_p3_phone);
				System.out.println("Age: " + e1_p3_age);
				System.out.println("Gender: " + e1_p3_gender);
				System.out.println();
			}
			if(capacity1 >= 4) {
				System.out.println("Participant name: " + e1_p4_name);
				System.out.println("Phone number: " + e1_p4_phone);
				System.out.println("Age: " + e1_p4_age);
				System.out.println("Gender: " + e1_p4_gender);
				System.out.println();
			}
			if(capacity1 >= 5) {
				System.out.println("Participant name: " + e1_p5_name);
				System.out.println("Phone number: " + e1_p5_phone);
				System.out.println("Age: " + e1_p5_age);
				System.out.println("Gender: " + e1_p5_gender);
				System.out.println();
			}
		}
		
		// Print event 2 participants
		if(eventNumber == 2) {
			if(capacity2 >= 1) {
				System.out.println("Participant name: " + e2_p1_name);
				System.out.println("Phone number: " + e2_p1_phone);
				System.out.println("Age: " + e2_p1_age);
				System.out.println("Gender: " + e2_p1_gender);
				System.out.println();
			}
			if(capacity2 >= 2) {
				System.out.println("Participant name: " + e2_p2_name);
				System.out.println("Phone number: " + e2_p2_phone);
				System.out.println("Age: " + e2_p2_age);
				System.out.println("Gender: " + e2_p2_gender);
				System.out.println();
			}
			if(capacity2 >= 3) {
				System.out.println("Participant name: " + e2_p3_name);
				System.out.println("Phone number: " + e2_p3_phone);
				System.out.println("Age: " + e2_p3_age);
				System.out.println("Gender: " + e2_p3_gender);
				System.out.println();
			}
			if(capacity2 >= 4) {
				System.out.println("Participant name: " + e2_p4_name);
				System.out.println("Phone number: " + e2_p4_phone);
				System.out.println("Age: " + e2_p4_age);
				System.out.println("Gender: " + e2_p4_gender);
				System.out.println();
			}
			if(capacity2 >= 5) {
				System.out.println("Participant name: " + e2_p5_name);
				System.out.println("Phone number: " + e2_p5_phone);
				System.out.println("Age: " + e2_p5_age);
				System.out.println("Gender: " + e2_p5_gender);
				System.out.println();
			}
		}
		
		// Print event 3 participants
		if(eventNumber == 3) {
			if(capacity3 >= 1) {
				System.out.println("Participant name: " + e3_p1_name);
				System.out.println("Phone number: " + e3_p1_phone);
				System.out.println("Age: " + e3_p1_age);
				System.out.println("Gender: " + e3_p1_gender);
				System.out.println();
			}
			if(capacity3 >= 2) {
				System.out.println("Participant name: " + e3_p2_name);
				System.out.println("Phone number: " + e3_p2_phone);
				System.out.println("Age: " + e3_p2_age);
				System.out.println("Gender: " + e3_p2_gender);
				System.out.println();
			}
			if(capacity3 >= 3) {
				System.out.println("Participant name: " + e3_p3_name);
				System.out.println("Phone number: " + e3_p3_phone);
				System.out.println("Age: " + e3_p3_age);
				System.out.println("Gender: " + e3_p3_gender);
				System.out.println();
			}
			if(capacity3 >= 4) {
				System.out.println("Participant name: " + e3_p4_name);
				System.out.println("Phone number: " + e3_p4_phone);
				System.out.println("Age: " + e3_p4_age);
				System.out.println("Gender: " + e3_p4_gender);
				System.out.println();
			}
			if(capacity3 >= 5) {
				System.out.println("Participant name: " + e3_p5_name);
				System.out.println("Phone number: " + e3_p5_phone);
				System.out.println("Age: " + e3_p5_age);
				System.out.println("Gender: " + e3_p5_gender);
				System.out.println();
			}
		}
		
		// Print event 4 participants
		if(eventNumber == 4) {
			if(capacity4 >= 1) {
				System.out.println("Participant name: " + e4_p1_name);
				System.out.println("Phone number: " + e4_p1_phone);
				System.out.println("Age: " + e4_p1_age);
				System.out.println("Gender: " + e4_p1_gender);
				System.out.println();
			}
			if(capacity4 >= 2) {
				System.out.println("Participant name: " + e4_p2_name);
				System.out.println("Phone number: " + e4_p2_phone);
				System.out.println("Age: " + e4_p2_age);
				System.out.println("Gender: " + e4_p2_gender);
				System.out.println();
			}
			if(capacity4 >= 3) {
				System.out.println("Participant name: " + e4_p3_name);
				System.out.println("Phone number: " + e4_p3_phone);
				System.out.println("Age: " + e4_p3_age);
				System.out.println("Gender: " + e4_p3_gender);
				System.out.println();
			}
			if(capacity4 >= 4) {
				System.out.println("Participant name: " + e4_p4_name);
				System.out.println("Phone number: " + e4_p4_phone);
				System.out.println("Age: " + e4_p4_age);
				System.out.println("Gender: " + e4_p4_gender);
				System.out.println();
			}
			if(capacity4 >= 5) {
				System.out.println("Participant name: " + e4_p5_name);
				System.out.println("Phone number: " + e4_p5_phone);
				System.out.println("Age: " + e4_p5_age);
				System.out.println("Gender: " + e4_p5_gender);
				System.out.println();
			}
		}
		
		// Print event 5 participants
		if(eventNumber == 5) {
			if(capacity5 >= 1) {
				System.out.println("Participant name: " + e5_p1_name);
				System.out.println("Phone number: " + e5_p1_phone);
				System.out.println("Age: " + e5_p1_age);
				System.out.println("Gender: " + e5_p1_gender);
				System.out.println();
			}
			if(capacity5 >= 2) {
				System.out.println("Participant name: " + e5_p2_name);
				System.out.println("Phone number: " + e5_p2_phone);
				System.out.println("Age: " + e5_p2_age);
				System.out.println("Gender: " + e5_p2_gender);
				System.out.println();
			}
			if(capacity5 >= 3) {
				System.out.println("Participant name: " + e5_p3_name);
				System.out.println("Phone number: " + e5_p3_phone);
				System.out.println("Age: " + e5_p3_age);
				System.out.println("Gender: " + e5_p3_gender);
				System.out.println();
			}
			if(capacity5 >= 4) {
				System.out.println("Participant name: " + e5_p4_name);
				System.out.println("Phone number: " + e5_p4_phone);
				System.out.println("Age: " + e5_p4_age);
				System.out.println("Gender: " + e5_p4_gender);
				System.out.println();
			}
			if(capacity5 >= 5) {
				System.out.println("Participant name: " + e5_p5_name);
				System.out.println("Phone number: " + e5_p5_phone);
				System.out.println("Age: " + e5_p5_age);
				System.out.println("Gender: " + e5_p5_gender);
				System.out.println();
			}
		}
	}

}
