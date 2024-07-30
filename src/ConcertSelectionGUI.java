package src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ConcertSelectionGUI {
    private static Connection connection;
    private static Statement statement;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Concert Selection");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Select a Concert:");
        titleLabel.setBounds(10, 20, 150, 25);
        panel.add(titleLabel);

        // Assuming you have a method in DatabaseConnection to retrieve events
        //DatabaseConnection.getConnection();
        //String[] events= DatabaseConnection.getEventNames();
        String[] events = {"Music Concert","Tech Conference","Art Exhibition","Sports Tournament"};
        JComboBox<String> concertComboBox = new JComboBox<>(events);
        concertComboBox.setBounds(160, 20, 150, 25);
        panel.add(concertComboBox);

        JLabel slotLabel = new JLabel("Select a Slot:");
        slotLabel.setBounds(10, 50, 150, 25);
        panel.add(slotLabel);

        String[] slots = { "Bronze", "Silver", "Gold", "Platinum"};
        JComboBox<String> slotComboBox = new JComboBox<>(slots);
        slotComboBox.setBounds(160, 50, 150, 25);
        panel.add(slotComboBox);

        JLabel ticketsLabel = new JLabel("Number of Tickets:");
        ticketsLabel.setBounds(10, 80, 150, 25);
        panel.add(ticketsLabel);

        JTextField ticketsTextField = new JTextField(5);
        ticketsTextField.setBounds(160, 80, 50, 25);
        panel.add(ticketsTextField);

        JButton selectButton = new JButton("Select");
        selectButton.setBounds(10, 110, 100, 25);
        panel.add(selectButton);

        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(10, 140, 300, 25);
        panel.add(resultLabel);

        selectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedEvent = (String) concertComboBox.getSelectedItem();
                String selectedSlot = (String) slotComboBox.getSelectedItem();
                int numTickets = Integer.parseInt(ticketsTextField.getText());

                double ticketPrice = calculateTicketPrice(selectedSlot);
                double totalAmount = numTickets * ticketPrice;

                String resultMessage = "You selected: " + selectedEvent + " - Slot: " + selectedSlot +
                                      "\nNumber of Tickets: " + numTickets + "\nTotal Amount: " + totalAmount;
                resultLabel.setText(resultMessage);

                // Show receipt with the selected event, slot, number of tickets, and amount
                ReceiptGUI.showReceipt(selectedEvent, selectedSlot, numTickets, totalAmount);
            }
        });
    }

    
    private static double calculateTicketPrice(String slot) {
        // Define your ticket prices based on slots
        switch (slot) {
            case "Gold": return 2200.0;
            case "Silver": return 1500.0;
            case "Bronze": return 1200.0;
            case "Platinum": return 2800.0;
            default: return 0.0; // Handle invalid slot
        }
    }
} 

