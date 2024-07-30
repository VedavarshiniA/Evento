package src;
import javax.swing.*;
import java.awt.*;

public class ReceiptGUI {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Receipt");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel, " ", "", 0, 0.0);

        frame.setVisible(true);
    }

    public static void showReceipt(String selectedEvent, String selectedSlot, int numTickets, double totalAmount) {
        JFrame frame = new JFrame("Receipt");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel, selectedEvent, selectedSlot, numTickets, totalAmount);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel, String selectedEvent, String selectedSlot, int numTickets, double totalAmount) {
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Receipt");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(150, 20, 100, 25);
        panel.add(titleLabel);

        JLabel eventLabel = new JLabel("Selected Event:");
        eventLabel.setBounds(50, 60, 150, 25);
        panel.add(eventLabel);

        JLabel slotLabel = new JLabel("Selected Slot:");
        slotLabel.setBounds(50, 90, 150, 25);
        panel.add(slotLabel);

        JLabel ticketsLabel = new JLabel("Number of Tickets:");
        ticketsLabel.setBounds(50, 120, 150, 25);
        panel.add(ticketsLabel);

        JLabel amountLabel = new JLabel("Total Amount:");
        amountLabel.setBounds(50, 150, 150, 25);
        panel.add(amountLabel);

        JLabel eventValueLabel = new JLabel(selectedEvent);
        eventValueLabel.setBounds(200, 60, 150, 25);
        panel.add(eventValueLabel);

        JLabel slotValueLabel = new JLabel(selectedSlot);
        slotValueLabel.setBounds(200, 90, 150, 25);
        panel.add(slotValueLabel);

        JLabel ticketsValueLabel = new JLabel(String.valueOf(numTickets));
        ticketsValueLabel.setBounds(200, 120, 150, 25);
        panel.add(ticketsValueLabel);

        JLabel amountValueLabel = new JLabel(String.valueOf(totalAmount));
        amountValueLabel.setBounds(200, 150, 150, 25);
        panel.add(amountValueLabel);

        JButton bookButton = new JButton("Book");
        bookButton.setBounds(80, 180, 100, 25);
        panel.add(bookButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(220, 180, 100, 25);
        panel.add(cancelButton);

        bookButton.addActionListener(e -> {
            // Add booking logic here
            JOptionPane.showMessageDialog(null, "Event booked successfully!");

            // Navigate to Card Selection GUI
            CardSelectionGUI.main(new String[]{});
        });

        cancelButton.addActionListener(e -> System.exit(0));
    }
}
