package system;

// Represents individual participants signing up to events
public class Participant {
	
	// Initialize variables
	private String name;
	private int phoneNumber;
	private int age;
	private String gender;
	
	// Static variable to count number of participants registered
	private static int participantCount = 0;

	// Default constructor
	public Participant() {
		super();
		participantCount++; // Increment participants Count
		setName("Participant " + participantCount);
		setPhoneNumber(0);
		setAge(13);
		setGender("Unknown");
	}
	
	// Parameterized constructor
	public Participant(String name, int phoneNumber, int age, String gender) {
		super();
		participantCount++; // Increment participants Count
		setName(name);
		setPhoneNumber(phoneNumber);
		setAge(age);
		setGender(gender);
	}
	
	// Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age >= 13) {
			this.age = age;
		}
		else {
			System.err.println("Participant must be atleast 13 years old to register.");
		}
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		if(gender == "Male" || gender == "Female") {
			this.gender = gender;
		}
		else {
			System.err.println("Participant gender must be either Male or Female.");
		}
	} 
	
	// Method to display all info about the event
		public void printInfo() {
			System.out.println("Participant name: " + name);
			System.out.println("Phone number: " + phoneNumber);
			System.out.println("Age: " + age);
			System.out.println("Gender: " + gender);
		}

}
