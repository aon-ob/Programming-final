package eventdriven;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

//using event manager from OOP paradigm
import oop.EventManager;
import shared.Event;

public class EventDrivenMain {

	public static void main(String[] args) {

		EventManager eventManager = new EventManager();

		JFrame frame = new JFrame();

		// Frame settings
		frame.setLayout(new BorderLayout());
		frame.setPreferredSize(new Dimension(900, 700));

		// SEARCH BAR
		JPanel searchPnl = new JPanel(new BorderLayout());
		searchPnl.setBackground(Color.WHITE);
		searchPnl.setPreferredSize(new Dimension(900, 60));
		searchPnl.setBorder(BorderFactory.createCompoundBorder(new LineBorder(new Color(220, 220, 220), 1, true),
				new EmptyBorder(10, 20, 10, 20) // Padding inside the bar
		));
		
		JLabel searchIcon = new JLabel("🔍  ");
		searchIcon.setForeground(Color.GRAY);
		searchIcon.setFont(new Font("SansSerif", Font.PLAIN, 16));

		// Text field for search bar
		JTextField searchField = new JTextField("");
		searchField.setBorder(null);
		searchField.setForeground(Color.GRAY);

		// add search icon and field to search bar
		searchPnl.add(searchIcon, BorderLayout.WEST);
		searchPnl.add(searchField, BorderLayout.CENTER);

		// Add Search Panel to the Top of the Frame
		frame.add(searchPnl, BorderLayout.NORTH);

		// EVENT LIST

		EventList eventList = new EventList(eventManager);
		frame.add(eventList, BorderLayout.CENTER);

		// Search feature

		// (Event driven listener for search bar)
		searchField.getDocument().addDocumentListener(new DocumentListener() {
			// Called when text is typed or pasted
			@Override
			public void insertUpdate(DocumentEvent e) {
				eventList.updateContent(searchEvents(eventManager.getEvents(), searchField.getText()));
			}
			// Called when text is deleted
			@Override
			public void removeUpdate(DocumentEvent e) {
				eventList.updateContent(searchEvents(eventManager.getEvents(), searchField.getText()));
			}
			// Must have to avoid error
			public void changedUpdate(DocumentEvent e) {
				// Leaving empty
			}

		});

		// Frame Coding Standards
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Event Registration System");
		frame.pack();
		frame.setVisible(true);
	}

	// Search events method (Search and filter feature) (view all events feature)
	// (contains bubble sort algorithm)
	public static ArrayList<Event> searchEvents(ArrayList<Event> sourceList, String query) {
		// Initialize results
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

	// method to switch 2 events together (used often in bubble sort)
	private static ArrayList<Event> switchEvents(ArrayList<Event> list, int index) {

		ArrayList<Event> returnList = list;

		Event temp = returnList.get(index);
		returnList.set(index, returnList.get(index - 1));
		returnList.set(index - 1, temp);

		return (returnList);
	}

}
