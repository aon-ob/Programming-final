package eventdriven;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import oop.Event;
// using event manager from OOP paradigm
import oop.EventManager;

// (Inheritance)
// Event list class is used to display all event cards in order with a scroll bar
public class EventList extends JScrollPane {

	// All content will be inside this panel
	private JPanel contentPanel;
	// list of events that will be displayed
	private ArrayList<Event> eventList;

	public EventList(EventManager eventManager) {
		
		// set value for eventlist
		eventList = eventManager.getEvents();

		// the inner content panel
		contentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

		// Setup ScrollPane (this)
		setViewportView(contentPanel); // Put the content panel inside the scroll pane
		setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		getVerticalScrollBar().setUnitIncrement(16); // set scrolling speed

		// Load button to initially load and display all events 
		JButton loadBtn = new JButton("Load All Events");
		loadBtn.setBackground(new Color(219, 234, 254)); // Light blue bg
		loadBtn.setForeground(new Color(37, 99, 235)); // Dark blue text
		loadBtn.setLayout(new GridBagLayout()); // to center text
		loadBtn.setPreferredSize(new Dimension(150, 30));
		loadBtn.setMaximumSize(new Dimension(150, 30));
		loadBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loadBtn.setFocusPainted(false);
        
        // (event driven action listener for view all events)
		loadBtn.addActionListener(e -> updateContent(eventManager.getEvents()));
		contentPanel.add(loadBtn);

		// Resizing when changing window size 
		addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				int width = getViewport().getWidth();
				contentPanel.setMinimumSize(new Dimension(width, 100));
				contentPanel.setPreferredSize(new Dimension(width, eventManager.getEvents().size() * 350 - width)); // Set height depending on number of events
				contentPanel.revalidate();
			}
		});
	}

	// change the displayed events when called (no arguments)
	public void updateContent() {
		// Remove old events
				Component[] componentList = contentPanel.getComponents();
				for (int i = 0; i < componentList.length; i++) {
					contentPanel.remove(componentList[i]);
				}
				// Add new events by looping through eventList
				for (int i = 0; i < eventList.size(); i++) {
					// Create an EventCard object passing each event from the eventList
					contentPanel.add(new EventCard(eventList.get(i), this));
				}
				// Resizing when updating how many event cards are displayed
				int width = getViewport().getWidth();
				contentPanel.setMinimumSize(new Dimension(width, 100));
				contentPanel.setPreferredSize(new Dimension(width, eventList.size() * 350 - width)); // Set height depending on number of events
				contentPanel.revalidate(); // Change layout
				contentPanel.repaint(); // Redraw pixels
	}
	
	// change the displayed events when called (overloaded with an argument)
	public void updateContent(ArrayList<Event> eventArrayList) {

		// Remove old events
		Component[] componentList = contentPanel.getComponents();
		for (int i = 0; i < componentList.length; i++) {
			contentPanel.remove(componentList[i]);
		}

		// Add new events
		for (int i = 0; i < eventArrayList.size(); i++) {
			contentPanel.add(new EventCard(eventArrayList.get(i), this));
		}
		// Resizing when updating how many event cards are displayed
		int width = getViewport().getWidth();
		contentPanel.setMinimumSize(new Dimension(width, 100));
		contentPanel.setPreferredSize(new Dimension(width, eventArrayList.size() * 350 - width)); // Set height depending on number of events
		contentPanel.revalidate(); // Change layout
		contentPanel.repaint(); // Redraw pixels
	}

}