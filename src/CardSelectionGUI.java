package src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CardSelectionGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Card Selection");
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

        JLabel titleLabel = new JLabel("Card Selection");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(130, 20, 200, 25);
        panel.add(titleLabel);

        JRadioButton creditCardRadioButton = new JRadioButton("Credit Card");
        creditCardRadioButton.setBounds(50, 60, 150, 25);
        panel.add(creditCardRadioButton);

        JRadioButton debitCardRadioButton = new JRadioButton("Debit Card");
        debitCardRadioButton.setBounds(50, 90, 150, 25);
        panel.add(debitCardRadioButton);

        ButtonGroup paymentTypeGroup = new ButtonGroup();
        paymentTypeGroup.add(creditCardRadioButton);
        paymentTypeGroup.add(debitCardRadioButton);

        JButton selectButton = new JButton("Select");
        selectButton.setBounds(150, 160, 100, 30);
        panel.add(selectButton);

        selectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedPaymentType = "";
                if (creditCardRadioButton.isSelected()) {
                    selectedPaymentType = "Credit Card";
                } else if (debitCardRadioButton.isSelected()) {
                    selectedPaymentType = "Debit Card";
                }

                if (!selectedPaymentType.isEmpty()) {
                    // Call the payment page with the selected payment type
                    PaymentGUI.showPaymentPage(selectedPaymentType);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a payment type.");
                }
            }
        });

        selectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedPaymentType = "";
                if (creditCardRadioButton.isSelected()) {
                    selectedPaymentType = "Credit Card";
                } else if (debitCardRadioButton.isSelected()) {
                    selectedPaymentType = "Debit Card";
                }
        
                if (!selectedPaymentType.isEmpty()) {
                    // Add your payment processing logic here
                   
                    PaymentGUI.main(new String[]{});
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a payment type.");
                }
            }
        });
        
    }
}
