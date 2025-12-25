package eventdriven;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import system.Event; // import the Event class

public class EventCard extends JPanel{
	
	private Color gray = Color.GRAY;

	public EventCard(Event event) {

		setPreferredSize(new Dimension(300, 220));
        setMaximumSize(new Dimension(300, 220));
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);
        
        setBorder(new EmptyBorder(15, 15, 15, 15)); // Padding
        
        
        // Event name
        JLabel nameLbl = new JLabel(event.getName());
        nameLbl.setFont(new Font("SansSerif", Font.BOLD, 16));
        nameLbl.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        // Event Date
        JLabel dateLbl = new JLabel("📅  " + event.getDate());
        dateLbl.setFont(new Font("SansSerif", Font.PLAIN, 13));
        dateLbl.setForeground(gray);
        dateLbl.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        // Event Place
        JLabel placeLbl = new JLabel("📍  " + event.getPlace());
        placeLbl.setFont(new Font("SansSerif", Font.PLAIN, 13));
        placeLbl.setForeground(gray);
        placeLbl.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        // Capacity
        JLabel capacityLbl = new JLabel("👥  Capacity: " + event.getCapacity());
        capacityLbl.setFont(new Font("SansSerif", Font.PLAIN, 13));
        capacityLbl.setForeground(gray);
        capacityLbl.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        // Separator Line
        JSeparator sep = new JSeparator();
        sep.setMaximumSize(new Dimension(300, 10));
        sep.setForeground(gray);
        sep.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        // Container for tags
        JPanel tagsPnl = new JPanel();
        tagsPnl.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        tagsPnl.setAlignmentX(Component.LEFT_ALIGNMENT);
        tagsPnl.add(new Tag(event.getGender()));
        tagsPnl.setBackground(Color.WHITE);
        tagsPnl.add(Box.createRigidArea(new Dimension(15, 0))); // spacing
        if(event.getMustBe18()) {
        	tagsPnl.add(new Tag("18+"));
        } else {
        	tagsPnl.add(new Tag("13+"));
        }

        
        add(nameLbl);
        add(Box.createRigidArea(new Dimension(0, 15)));
        add(dateLbl);
        add(Box.createRigidArea(new Dimension(0, 8)));
        add(placeLbl);
        add(Box.createRigidArea(new Dimension(0, 8)));
        add(capacityLbl);
        add(Box.createRigidArea(new Dimension(0, 15)));
        add(sep);
        add(Box.createRigidArea(new Dimension(0, 15)));
        add(tagsPnl);
        

	}

}

class Tag extends JPanel{
	public Tag(String text) {
        setBackground(new Color(219, 234, 254)); // Light blue bg
        setLayout(new GridBagLayout()); // to center text
        setBorder(new EmptyBorder(4, 10, 4, 10)); // Padding
        setAlignmentX(Component.LEFT_ALIGNMENT);
        JLabel tagLbl = new JLabel(text); // Text
        tagLbl.setForeground(new Color(37, 99, 235)); // Dark blue text
        tagLbl.setFont(new Font("SansSerif", Font.BOLD, 11));
        tagLbl.setLayout(new GridBagLayout());
        add(tagLbl);
        
        setPreferredSize(new Dimension(50, 30));
        setMaximumSize(new Dimension(50, 30));
        
	}
}
