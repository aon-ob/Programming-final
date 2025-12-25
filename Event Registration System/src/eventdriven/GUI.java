package eventdriven;

import system.Event;
import system.Search;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class GUI {

    public GUI() {
        JFrame frame = new JFrame();
        
        // Frame settings
        frame.setLayout(new BorderLayout()); 
        frame.setPreferredSize(new Dimension(900, 700));
        
        // SEARCH BAR
        JPanel searchPnl = new JPanel(new BorderLayout());
        searchPnl.setBackground(Color.WHITE);
        searchPnl.setPreferredSize(new Dimension(900, 60));
        searchPnl.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(220, 220, 220), 1, true), 
            new EmptyBorder(10, 20, 10, 20) // Padding inside the bar
        ));
        
        JLabel searchIcon = new JLabel("🔍  "); 
        searchIcon.setForeground(Color.GRAY);
        searchIcon.setFont(new Font("SansSerif", Font.PLAIN, 16));
        
        JTextField searchField = new JTextField("");
        searchField.setBorder(null);
        searchField.setForeground(Color.GRAY);
       
        
        searchPnl.add(searchIcon, BorderLayout.WEST);
        searchPnl.add(searchField, BorderLayout.CENTER);
        
       
        
        // Add Search Panel to the Top of the Frame
        frame.add(searchPnl, BorderLayout.NORTH);


        // EVENT LIST
        
        EventList eventList = new EventList();
        frame.add(eventList, BorderLayout.CENTER);
        
        // Search feature
        
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
            	eventList.updateContent(Search.searchFor(searchField.getText()));// Called when text is typed or pasted
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            	eventList.updateContent(Search.searchFor(searchField.getText()));
            }
            
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

    public static void main(String[] args) {
       
    }
}