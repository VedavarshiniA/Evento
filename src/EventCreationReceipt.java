package src;
import javax.swing.*;
import java.awt.*;

public class EventCreationReceipt {

    public static void showReceipt(String eventName, String eventDate) {
        JFrame frame = new JFrame("Event Creation Receipt");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Event Creation Receipt");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(80, 20, 250, 25);
        panel.add(titleLabel);

        JLabel nameLabel = new JLabel("Event Name:");
        nameLabel.setBounds(50, 60, 100, 25);
        panel.add(nameLabel);

        JLabel dateLabel = new JLabel("Event Date:");
        dateLabel.setBounds(50, 90, 100, 25);
        panel.add(dateLabel);

        JLabel nameValueLabel = new JLabel(eventName);
        nameValueLabel.setBounds(160, 60, 150, 25);
        panel.add(nameValueLabel);

        JLabel dateValueLabel = new JLabel(eventDate);
        dateValueLabel.setBounds(160, 90, 150, 25);
        panel.add(dateValueLabel);

        JButton closeButton = new JButton("Close");
        closeButton.setBounds(150, 160, 100, 30);
        panel.add(closeButton);

        closeButton.addActionListener(e -> { 
            System.exit(0);
             // Close the receipt window
        });
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
