package eventdriven;

import system.Event;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

// Display all Events
public class EventList extends JScrollPane {

    private JPanel contentPanel;

    public EventList() {
        // the inner content panel
        contentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
        contentPanel.setBackground(Color.LIGHT_GRAY);
        contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Setup ScrollPane (this)
        setViewportView(contentPanel); // Put the content panel inside the scroll pane
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        getVerticalScrollBar().setUnitIncrement(16); // set scrolling speed

    	// Add events
        if(Event.getEventList() != null) {
            for (int i = 0; i < Event.getEventList().size(); i++) {
                contentPanel.add(new EventCard(Event.getEventList().get(i)));
            }
        }

        // Resizing when changing window size
        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
            	int width = getViewport().getWidth();
            	contentPanel.setPreferredSize(new Dimension(width, Event.getEventList().size()*310 - width)); // Set height depending on number of events
            	contentPanel.revalidate();
            }
        });
    }
    
    // change the displayed events when called
    public void updateContent(ArrayList <Event> eventArrayList) {
    	
    	// Remove old events
    	Component[] componentList = contentPanel.getComponents();
    	for (int i = 0; i < componentList.length; i++) {
			contentPanel.remove(componentList[i]);
		}
    	
    	// Add new events
    	for (int i = 0; i < eventArrayList.size(); i++) {
            contentPanel.add(new EventCard(eventArrayList.get(i)));
        }
    	int width = getViewport().getWidth();
    	contentPanel.setPreferredSize(new Dimension(width, eventArrayList.size()*310 - width)); // Set height depending on number of events
    	contentPanel.revalidate(); // Change layout
        contentPanel.repaint(); // Redraw pixels
    }

}