package src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaymentReceiptGUI {

    public static void showReceipt() {
        JFrame frame = new JFrame("Payment Receipt");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        JLabel successLabel = new JLabel("Payment Successful!");
        successLabel.setFont(new Font("Arial", Font.BOLD, 20));
        successLabel.setBounds(100, 20, 200, 25);
        panel.add(successLabel);

        JLabel thanksLabel = new JLabel("Thanks for Booking!");
        thanksLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        thanksLabel.setBounds(120, 60, 200, 20);
        panel.add(thanksLabel);

        JButton closeButton = new JButton("Close");
        closeButton.setBounds(150, 180, 100, 30);
        panel.add(closeButton);

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Close the application when button is clicked
            }
        });
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        showReceipt();
    }
}
