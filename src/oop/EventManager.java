package oop;
//import necessary java.util classes
import java.util.ArrayList;

// EventManager class that is used to manage all events currently available and allows sorting, searching, and viewing events
public class EventManager {

	// event list attribute (encapsulated)
	private ArrayList<Event> events;

	// Default constructor
	public EventManager() {
		// initialize events to an empty array list
		setEvents(new ArrayList<>());

		// Sample data
		events.add(new Event("Swimming 1", "Pool", 10, 5, 2025, 20, false, "Male"));
		events.add(new Event("Swimming 2", "Pool", 11, 5, 2025, 20, false, "Female"));
		events.add(new Event("Karting", "Basement", 17, 8, 2025, 15, false, "Mixed"));
		events.add(new Event("Movie", "Cinema", 5, 2, 2025, 50, true, "Mixed"));
		events.add(new Event("Cooking", "Kitchen", 2, 1, 2026, 3, true, "Mixed"));

		events.get(0).addParticipant(new Participant("Ahmed", 70000023, 17, "Male"));
		events.get(0).addParticipant(new Participant("Osama", 70004051, 19, "Male"));
		events.get(1).addParticipant(new Participant("Salma", 70000023, 17, "Female"));
		events.get(1).addParticipant(new Participant("Sara", 70004051, 19, "Female"));
		events.get(2).addParticipant(new Participant("Layth", 70000023, 17, "Male"));
		events.get(2).addParticipant(new Participant("Mariam", 70004051, 19, "Female"));
		events.get(2).addParticipant(new Participant("Mariam", 70004051, 19, "Female"));
		events.get(3).addParticipant(new Participant("Ammar", 70000023, 20, "Male"));
		events.get(3).addParticipant(new Participant("Hala", 70004051, 19, "Female"));
		events.get(4).addParticipant(new Participant("Kareem", 70000023, 20, "Male"));
		events.get(4).addParticipant(new Participant("Reem", 70004051, 19, "Female"));
		events.get(4).addParticipant(new Participant("Iman", 70003011, 18, "Female"));
	}

	// Search method (includes bubble sort algorithm) (Search and filter feature)
	// (view all events feature)
	public ArrayList<Event> search(String query) {
		ArrayList<Event> results = new ArrayList<>();

		// Initialize search queries (empty value means no query)
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

		// Split input by spaces
		String[] splitText = query.split(" ");

		// Check and set all queries
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
			return (this.events);
		}

		else {
			for (int i = 0; i < this.events.size(); i++) {
				if (this.events.get(i).getName().toLowerCase().contains(searchKeyWords.toLowerCase())) {
					results.add(this.events.get(i));

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

	// method to switch 2 events together (used in bubble sort)
	private static ArrayList<Event> switchEvents(ArrayList<Event> list, int index) {

		ArrayList<Event> returnList = list;

		Event temp = returnList.get(index);
		returnList.set(index, returnList.get(index - 1));
		returnList.set(index - 1, temp);

		return (returnList);
	}

	// Display the list of events depending on search
	public static void printEvents(ArrayList<Event> eventList) {
		System.out.println();
		for (int i = 0; i < eventList.size(); i++) {
			System.out.println("Event " + (i + 1));
			// use the Event class' printInfo method
			eventList.get(i).printInfo();
			System.out.println();

		}
	}

	// getters and setters

	public ArrayList<Event> getEvents() {
		return (events);
	}

	public void setEvents(ArrayList<Event> events) {
		this.events = events;
	}

}
