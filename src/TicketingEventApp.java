package src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicketingEventApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Ticketing and Event Creation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        frame.add(panel);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Vertical layout

        JButton ticketButton = new JButton("Book Ticket");
        JButton eventButton = new JButton("Create Event");
        JLabel newUserLabel = new JLabel("Are you a new user?");
        JButton registerButton = new JButton("Register");

        panel.add(ticketButton);
        panel.add(eventButton);
        panel.add(newUserLabel);
        panel.add(registerButton);

        ticketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the LoginGUI when "Book Ticket" is clicked
                frame.dispose(); // Close the current window
                LoginGUI.main(new String[0]);
            }
        });

        eventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the LoginCreatorGUI when "Create Event" is clicked
                frame.dispose(); // Close the current window
                LoginCreatorGUI.main(new String[0]);
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the RegistrationGUI when "Register" is clicked
                frame.dispose(); // Close the current window
                RegistrationGUI.main(new String[0]);
            }
        });
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
