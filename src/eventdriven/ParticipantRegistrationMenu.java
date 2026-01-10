package eventdriven;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import oop.Event;
// Import event manager from oop paradigm
import oop.EventManager;
import oop.Participant;

import java.awt.*;

// Popup that shows when the user wants to add a new participant
public class ParticipantRegistrationMenu extends JDialog {

    private JTextField nameField, phoneField, ageField;
    private JComboBox<String> genderBox;
    private Event event;

    public ParticipantRegistrationMenu(Event event, EventList eventList) {
        this.event = event;
        
        // Window Setup
        setTitle("Register for " + event.getName());
        setSize(400, 350);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null); // Center on screen
        setModal(true); // Blocks the user from clicking the main window until this closes

        // Form Panel
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        formPanel.setBackground(Color.WHITE);

        // Name input
        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);

        // Phone number input
        formPanel.add(new JLabel("Phone:"));
        phoneField = new JTextField();
        formPanel.add(phoneField);

        // Age input
        formPanel.add(new JLabel("Age:"));
        ageField = new JTextField();
        formPanel.add(ageField);

        // Gender input
        formPanel.add(new JLabel("Gender:"));
        String[] genders = {"Male", "Female"};
        genderBox = new JComboBox<>(genders);
        formPanel.add(genderBox);

        add(formPanel, BorderLayout.CENTER);

        // Submit button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        
        // Submit button
        JButton submitBtn = new JButton("Register");
        submitBtn.setBackground(new Color(219, 234, 254)); // Light blue bg
        submitBtn.setForeground(new Color(37, 99, 235)); // Dark blue text
        submitBtn.setLayout(new GridBagLayout()); // to center text
        submitBtn.setPreferredSize(new Dimension(90, 30));
        submitBtn.setMaximumSize(new Dimension(90, 30));
        submitBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        submitBtn.setFocusPainted(false);
        
        // Submit button listener
        submitBtn.addActionListener(e -> registerParticipant(eventList));

        buttonPanel.add(submitBtn);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true); // Show window
    }

    private void registerParticipant(EventList eventList) {
    	// Try-catch statement to make sure user enters valid values
        try {
            // Get Data from fields
            String name = nameField.getText();
            String gender = (String) genderBox.getSelectedItem();
            int age = Integer.parseInt(ageField.getText());
            int phone = Integer.parseInt(phoneField.getText());

            
            
            // Make sure participant is allowed to enter event
            
            
            if (age < 13) {
            	JOptionPane.showMessageDialog(this, "Participant must be atleast 13 years old to register to any event.", "Age error" ,JOptionPane.ERROR_MESSAGE);
            }
	        // if under 18 and event is 18+
            else if (event.getMustBe18() && age < 18) {
	    		JOptionPane.showMessageDialog(this, "Participant must be atleast 18 years old to register to this event.", "Age error" ,JOptionPane.ERROR_MESSAGE);
	    	}
	    	// if gender does not match
	    	else if (!event.getGender().toLowerCase().equals(gender.toLowerCase()) && !event.getGender().toLowerCase().equals("mixed")) {
	    		JOptionPane.showMessageDialog(this, "Participant must be " + event.getGender() + " to register to this event.", "Gender error" ,JOptionPane.ERROR_MESSAGE);
	    	}
	    	// if capacity is full
	    	else if (event.getParticipants().size() == event.getCapacity()) {
	    		JOptionPane.showMessageDialog(this, "This event is at full capacity", "Capacity error" ,JOptionPane.ERROR_MESSAGE);
	    	}
	    	// if none then add participant
	    	else {
	    		// Create Participant Object
	            Participant participant = new Participant(name, phone, age, gender);
	    		event.addParticipant(participant);
	    		// Update displayed content (change capacity count)
	            eventList.updateContent();
	            // Show success message
	            JOptionPane.showMessageDialog(this, "Successfully registered " + name + "!");
	            // Close popup
	            dispose();
	    	}


            
            
            // catch invalid value error
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for Age and Phone.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } 
    }
}