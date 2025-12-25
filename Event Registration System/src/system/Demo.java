package system;

public class Demo {

	public static void main(String[] args) {
		Event event1 = new Event();
		
		System.out.println(event1.getDate());
		
		Event event2 = new Event();
		System.out.println(event2.getName());
		event2.setDate(3, 13, 2025);
		
		event2.printInfo();
		
		event2.setGender("All");
		
		Participant participant1 = new Participant();
		participant1.setGender("Male");
		participant1.printInfo();
		
		
		event2.addParticipant(participant1);
		
		event2.printInfo();
				
	}
}
