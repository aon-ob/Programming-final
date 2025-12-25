package system;

import java.util.ArrayList; // import array list class

public class Event {
	
	// Initializing variables
	private String name;
	private String place;
	private int day;
	private int month;
	private int year;
	private int capacity;
	private boolean mustBe18;
	private String gender;
	
	// Array List containing participant objects
	private ArrayList <Participant> participants = new ArrayList<Participant>();
	
	// Static variable to count number of events made and store them
	private static ArrayList <Event> eventList = new ArrayList<Event>();
	
	// Default constructor
	public Event() {
		super();
		
		eventList.add(this);

		setName("Event " + eventList.size());
		setPlace("Unknown");
		setDay(1);
		setMonth(1);
		setYear(2025);
		setCapacity(1);
		setMustBe18(false);
		setGender("Mixed");
	}
	
	// Parameterized constructor
	public Event(String name, String place, int day, int month, int year, int capacity, boolean mustBe18, String gender) {
		super();
		
		eventList.add(this);
		
		setName(name);
		setPlace(place);
		setDay(day);
		setMonth(month);
		setYear(year);
		setCapacity(capacity);
		setMustBe18(mustBe18);
		setGender(gender);
	}

	// Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getDay() {
		return day;
	}

	// Adding condition to set day
	public void setDay(int day) {
		if(day <= 31 && day > 0) {
			this.day = day;
		}
		else {
			System.err.println("Day should be between 1-31.");
		}
	}

	public int getMonth() {
		return month;
	}

	// Adding condition to set month
	public void setMonth(int month) {
		if(month <= 12 && month > 0) {
			this.month = month;
		}
		else {
			System.err.println("Month should be between 1-12.");
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		if(capacity > 0) {
			this.capacity = capacity;
		}
		else {
			System.err.println("Capacity must be at least 1.");
		}
	}
	
	public boolean getMustBe18() {
		return mustBe18;
	}

	public void setMustBe18(boolean mustBe18) {
		this.mustBe18 = mustBe18;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public ArrayList getParticipants() {
		return participants;
	}
	
	// Method to change date
	public void setDate(int day, int month, int year) {
		setDay(day);
		setMonth(month);
		setYear(year);
	}
	
	// Method to return the date formatted (month/day/year)
	public String getDate() {
		return(month + "/" + day + "/" + year);
	}
	
	
	
	public static ArrayList<Event> getEventList() {
		return eventList;
	}

	public static void setEventList(ArrayList<Event> eventList) {
		Event.eventList = eventList;
	}

	public void setParticipants(ArrayList<Participant> participants) {
		this.participants = participants;
	}

	// Method to display all info about the event
	public void printInfo() {
		System.out.println("Event Name: " + name);
		System.out.println("Place: " + place);
		System.out.println("Date: " + getDate());
		System.out.println("Capacity: " + capacity);
		System.out.println("18 Only: " + mustBe18);
		System.out.println("Required Gender: " + gender);
		System.out.println("Participant Count: " +  participants.size());
	}
	
	// Method to add participant to the participants list
	public void addParticipant(Participant participant) {
		
		
		if(mustBe18) {
			// if event is only for 18 year olds and participant is 18
			if(mustBe18 && participant.getAge() >= 18) {
				participants.add(participant);
			} 
			// if event is for 18 year olds and participant is under 18
			else {
				System.err.println("Participant must be atleast 18 years of age to register in this event.");
			}
		}
		else {
			// if event is for all genders or gender matched event gender
			if(gender == participant.getGender() || gender == "Mixed") {
				participants.add(participant);
			}
			else {
				System.err.println("Participant must be a " + gender + " to register in this event.");
			}
		}
		
		
	}
	
}
