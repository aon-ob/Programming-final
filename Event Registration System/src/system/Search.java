package system;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Search {

	// Method returning list of events given a search query
	public static ArrayList <Event> searchFor(String text){
		
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
		
		// Split input by spaces and colons
		String[] splitText = text.split(" ");
		
		ArrayList <Event> returnList = new ArrayList <Event> ();
		
		
		// Check and set all queries
		for (int i = 0; i < splitText.length; i++) {
			
			//sort by name
			if(splitText[i].toLowerCase().contains("sortbyname:")) {
				try {
					sortByName = splitText[i].split(":")[1].toLowerCase(); //take part after colon :		
				} catch(Exception e) {}				
			}
			//sort by capacity
			else if(splitText[i].toLowerCase().contains("sortbycapacity:")) {
				try {
					sortByCapacity = splitText[i].split(":")[1].toLowerCase(); //take part after colon :		
				} catch(Exception e) {}				
			}
			//sort by date
			else if(splitText[i].toLowerCase().contains("sortbydate:")) {
				try {
					sortByDate = splitText[i].split(":")[1].toLowerCase(); //take part after colon :		
				} catch(Exception e) {}				
			}
			
			//place query
			else if(splitText[i].toLowerCase().contains("place:")) {
				try {
					 place = splitText[i].split(":")[1].toLowerCase(); //take part after colon :
				} catch(Exception e) {}	
			} 
			//gender query
			else if(splitText[i].toLowerCase().contains("gender:")) {
				try {
					gender = splitText[i].split(":")[1].toLowerCase(); //take part after colon :
					} catch(Exception e) {}	
			}
			//day query
			else if(splitText[i].toLowerCase().contains("day:")) {
				try {
					day = splitText[i].split(":")[1]; //take part after colon:		
				} catch(Exception e) {}				
			}
			//month query
			else if(splitText[i].toLowerCase().contains("month:")) {
				try {
					month = splitText[i].split(":")[1]; //take part after colon :		
				} catch(Exception e) {}				
			}
			//year query
			else if(splitText[i].toLowerCase().contains("year:")) {
				try {
					year = splitText[i].split(":")[1]; //take part after colon :		
				} catch(Exception e) {}				
			}
			//capacity query
			else if(splitText[i].toLowerCase().contains("capacity:")) {
				try {
					capacity = splitText[i].split(":")[1]; //take part after colon :
				} catch(Exception e) {}		
			}
			//mustBe18 query
			else if(splitText[i].toLowerCase().contains("mustbe18:")) {
				try {
					mustBe18 = splitText[i].split(":")[1].toLowerCase(); //take part after colon :		
				} catch(Exception e) {}				
			}
			
			else {
				// If no query then its a keyword
				if(searchKeyWords == "") {
					searchKeyWords = splitText[i];
				} else {
					searchKeyWords = searchKeyWords + " " + splitText[i]; 
				}
			}
			
			
		}
		
		// If no search text then display all
		if(text == "") {
			return(Event.getEventList());
		} 
		
		else {
			for (int i = 0; i < Event.getEventList().size(); i++) {
					if(Event.getEventList().get(i).getName().toLowerCase().contains(searchKeyWords.toLowerCase())) {
						returnList.add(Event.getEventList().get(i));
					
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
		
			
			returnList.removeIf(event -> !event.getPlace().toLowerCase().contains(finalPlace));
			returnList.removeIf(event -> !event.getGender().toLowerCase().contains(finalGender));
			returnList.removeIf(event -> !String.valueOf(event.getMustBe18()).toLowerCase().contains(finalMustBe18));
			
			// day query
			try {
				if(finalDay.contains(">=")) {
					returnList.removeIf(event -> !(event.getDay() >= Integer.parseInt(finalDay.split(">=")[1])));
				} else if(finalDay.contains("<=")) {
					returnList.removeIf(event -> !(event.getDay() <= Integer.parseInt(finalDay.split("<=")[1])));
				} else if(finalDay.contains(">")) {
					returnList.removeIf(event -> !(event.getDay() > Integer.parseInt(finalDay.split(">")[1])));
				} else if(finalDay.contains("<")) {
					returnList.removeIf(event -> !(event.getDay() < Integer.parseInt(finalDay.split("<")[1])));
				} else {
					returnList.removeIf(event -> !(event.getDay() == Integer.parseInt(finalDay)));
				}
			} catch(Exception e) {}
			
			
			// month query
			try {
				if(finalMonth.contains(">=")) {
					returnList.removeIf(event -> !(event.getMonth() >= Integer.parseInt(finalMonth.split(">=")[1])));
				} else if(finalMonth.contains("<=")) {
					returnList.removeIf(event -> !(event.getMonth() <= Integer.parseInt(finalMonth.split("<=")[1])));
				} else if(finalMonth.contains(">")) {
					returnList.removeIf(event -> !(event.getMonth() > Integer.parseInt(finalMonth.split(">")[1])));
				} else if(finalMonth.contains("<")) {
					returnList.removeIf(event -> !(event.getMonth() < Integer.parseInt(finalMonth.split("<")[1])));
				} else {
					returnList.removeIf(event -> !(event.getMonth() == Integer.parseInt(finalMonth)));
				}
			} catch(Exception e) {}
			
			// year query
			try {
				if(finalYear.contains(">=")) {
					returnList.removeIf(event -> !(event.getYear() >= Integer.parseInt(finalYear.split(">=")[1])));
				} else if(finalYear.contains("<=")) {
					returnList.removeIf(event -> !(event.getYear() <= Integer.parseInt(finalYear.split("<=")[1])));
				} else if(finalYear.contains(">")) {
					returnList.removeIf(event -> !(event.getYear() > Integer.parseInt(finalYear.split(">")[1])));
				} else if(finalYear.contains("<")) {
					returnList.removeIf(event -> !(event.getYear() < Integer.parseInt(finalYear.split("<")[1])));
				} else {
					returnList.removeIf(event -> !(event.getYear() == Integer.parseInt(finalYear)));
				}
			} catch(Exception e) {}
			
			// capacity query
			try {
				if(finalCapacity.contains(">=")) {
					returnList.removeIf(event -> !(event.getCapacity() >= Integer.parseInt(finalCapacity.split(">=")[1])));
				} else if(finalCapacity.contains("<=")) {
					returnList.removeIf(event -> !(event.getCapacity() <= Integer.parseInt(finalCapacity.split("<=")[1])));
				} else if(finalCapacity.contains(">")) {
					returnList.removeIf(event -> !(event.getCapacity() > Integer.parseInt(finalCapacity.split(">")[1])));
				} else if(finalCapacity.contains("<")) {
					returnList.removeIf(event -> !(event.getCapacity() < Integer.parseInt(finalCapacity.split("<")[1])));
				} else {
					returnList.removeIf(event -> !(event.getCapacity() == Integer.parseInt(finalCapacity)));
				}
			} catch(Exception e) {}
			
			
			// SORT BY QUERY
			
			// sort by name
			try {	
				// -- BUBBLE SORT ALGORITHM (alphabetically)--
				if(!finalSortByName.isEmpty()) {
					// outer loop
					for (int i = 0; i < returnList.size(); i++) {
						// inner loop
						for (int j = 1; j < returnList.size() - i; j++) {
							// descending sort
							if(finalSortByName.toLowerCase().contains("descending")) {
								// if first word lexicographically less than second word switch them
								if(returnList.get(j).getName().compareTo(returnList.get(j-1).getName()) > 0) {
									returnList = switchEvents(returnList, j);
								}
							} 
							// ascending sort
							else {
								// if first word lexicographically greater than second word switch them
								if(returnList.get(j).getName().compareTo(returnList.get(j-1).getName()) < 0) {
									returnList = switchEvents(returnList, j);
								}
							}
						}
					}
				}
				
						 
					
			} catch(Exception e) {}
			
			// sort by capacity
			try {
				// -- BUBBLE SORT ALGORITHM (integer)--
				if(!finalSortByCapacity.isEmpty()) {
					// outer loop
					for (int i = 0; i < returnList.size(); i++) {
						// inner loop
						for (int j = 1; j < returnList.size() - i; j++) {
							// descending sort
							if (finalSortByCapacity.toLowerCase().contains("descending")) {
								// if first event capacity less than second word capacity switch them
								if (returnList.get(j).getCapacity() > returnList.get(j - 1).getCapacity()) {
									returnList = switchEvents(returnList, j); //switch the events together
								}
							}
							// ascending sort
							else {
								// if first event capacity greater than second word capacity switch them
								if (returnList.get(j).getCapacity() < returnList.get(j - 1).getCapacity()) {
									returnList = switchEvents(returnList, j); //switch the events together
								}
							}
						}
					}
				}
				

			} catch (Exception e) {}
			
			// sort by date
						try {
							// -- BUBBLE SORT ALGORITHM (date)--
							if(!finalSortByDate.isEmpty()) {
								// outer loop
								for (int i = 0; i < returnList.size(); i++) {
									// inner loop
									for (int j = 1; j < returnList.size() - i; j++) {
										// descending sort
										if (finalSortByDate.toLowerCase().contains("descending")) {
											// if first event year less than second word year switch them
											if (returnList.get(j).getYear() > returnList.get(j - 1).getYear()) {
												returnList = switchEvents(returnList, j); //switch the events together
											}
											// if first event month less than second word month switch them while year is the same
											else if (returnList.get(j).getYear() == returnList.get(j - 1).getYear()) {
												
												if (returnList.get(j).getMonth() > returnList.get(j - 1).getMonth()) {
													returnList = switchEvents(returnList, j); //switch the events together
												}
												// if first event day less than second word day switch them while month is the same
												else if (returnList.get(j).getMonth() == returnList.get(j - 1).getMonth()) {
													if (returnList.get(j).getDay() > returnList.get(j - 1).getDay()) {
														returnList = switchEvents(returnList, j); //switch the events together
													}
												}
												
											}

										}
										// ascending sort
										else {
											// if first event year greater than second word year switch them
											if (returnList.get(j).getYear() < returnList.get(j - 1).getYear()) {
												returnList = switchEvents(returnList, j); //switch the events together
											}
											// if first event month greater than second word month switch them while year is the same
											else if (returnList.get(j).getYear() == returnList.get(j - 1).getYear()) {
												
												if (returnList.get(j).getMonth() < returnList.get(j - 1).getMonth()) {
													returnList = switchEvents(returnList, j); //switch the events together
												}
												// if first event day greater than second word day switch them while month is the same
												else if (returnList.get(j).getMonth() == returnList.get(j - 1).getMonth()) {
													if (returnList.get(j).getDay() < returnList.get(j - 1).getDay()) {
														returnList = switchEvents(returnList, j); //switch the events together
													}
												}
												
											}
										}
									}
								}
							}
							

						} catch (Exception e) {}
			
			
				
		}
		
		
		return(returnList);
			
	}
	

	// method to switch 2 events together (used in bubble sort)
	public static ArrayList <Event> switchEvents(ArrayList <Event> list, int index){
		
		ArrayList <Event> returnList = list;
		
		Event temp = returnList.get(index);
		returnList.set(index, returnList.get(index - 1));
		returnList.set(index - 1, temp);
		
		
		return(returnList);
	}
	

}
