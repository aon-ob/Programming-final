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
				// update the content of eventList with the argument being a list of events returned from the search method for eventManager
				eventList.updateContent(eventManager.search(searchField.getText()));
			}
			// Called when text is deleted
			@Override
			public void removeUpdate(DocumentEvent e) {
				// update the content of eventList with the argument being a list of events returned from the search method for eventManager
				eventList.updateContent(eventManager.search(searchField.getText()));
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

}
