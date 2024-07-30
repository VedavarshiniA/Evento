package src;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class PaymentGUI {

    public static void main(String[] args) {
        showPaymentPage("");
    }

    public static void showPaymentPage(String selectedEvent) {
        JFrame frame = new JFrame("Payment Page");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Payment Details");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(120, 20, 200, 25);
        panel.add(titleLabel);

        JLabel cardNumberLabel = new JLabel("Card Number:");
        cardNumberLabel.setBounds(50, 60, 150, 25);
        panel.add(cardNumberLabel);

        JTextField cardNumberText = new JTextField(20);
        cardNumberText.setBounds(200, 60, 150, 25);
        panel.add(cardNumberText);

        JLabel expirationLabel = new JLabel("Expiration Date (MM/YY):");
        expirationLabel.setBounds(50, 90, 150, 25);
        panel.add(expirationLabel);

        JTextField expirationText = new JTextField(5);
        expirationText.setBounds(200, 90, 70, 25);
        panel.add(expirationText);

        JLabel cvvLabel = new JLabel("CVV:");
        cvvLabel.setBounds(50, 120, 150, 25);
        panel.add(cvvLabel);

        JTextField cvvText = new JTextField(3);
        cvvText.setBounds(200, 120, 40, 25);
        panel.add(cvvText);

        JButton processPaymentButton = new JButton("Process Payment");
        processPaymentButton.setBounds(100, 160, 200, 30);
        panel.add(processPaymentButton);

        processPaymentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cardNumber = cardNumberText.getText();
                String expirationDate = expirationText.getText();
                String cvv = cvvText.getText();

                // Add your payment processing logic here
                // For example, validate card details and process payment
                if (cardNumber.isEmpty() || expirationDate.isEmpty() || cvv.isEmpty() || cardNumber.length()!=16 || cvv.length()!=3) {
                    JOptionPane.showMessageDialog(null, "Please fill in the valid details");
                } 
                else {
                    if (isValidCardDetails(cardNumber, expirationDate, cvv)) {
                        PaymentReceiptGUI.showReceipt();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Card Details. Please try again.");
                    }
                }
            }
        });
               
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static boolean isValidCardDetails(String cardNumber, String expirationDate, String cvv) {
        // Add your validation logic here (e.g., check card number format, expiration date, etc.)
        // For simulation purposes, we assume card details are valid
        return true;
    }
}