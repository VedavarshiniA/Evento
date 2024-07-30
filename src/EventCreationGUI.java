package src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventCreationGUI {
    private static Connection connection;
    private static PreparedStatement preparedStatement; // Changed to PreparedStatement
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Event Creation");
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

        JLabel nameLabel = new JLabel("Event Name:");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);

        JTextField nameText = new JTextField(20);
        nameText.setBounds(100, 20, 165, 25);
        panel.add(nameText);

        JLabel dateLabel = new JLabel("Date (YYYY-MM-DD):");
        dateLabel.setBounds(10, 50, 150, 25);
        panel.add(dateLabel);

        JTextField dateText = new JTextField(10);
        dateText.setBounds(160, 50, 100, 25);
        panel.add(dateText);

        JButton createButton = new JButton("Create Event");
        createButton.setBounds(100, 150, 150, 25);
        panel.add(createButton);

        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String eventName = nameText.getText();
                String eventDate = dateText.getText();
                if(validateDate(eventDate)){
                    createEvent(eventName, eventDate);
                } else {
                    JOptionPane.showMessageDialog(null, "Error: Invalid date provided.");
                }
            }
        });
    }        

    private static void connectToDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/ems", // Updated database name
                    "root", 
                    "Mysql@123"
            );
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createEvent(String eventName, String eventDate) {
        try {
            connectToDatabase(); // Ensure connection is established
            String query = "INSERT INTO events (event_name, event_date) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, eventName);
            preparedStatement.setDate(2, java.sql.Date.valueOf(eventDate)); // Convert String to java.sql.Date
            preparedStatement.executeUpdate();
    
            JOptionPane.showMessageDialog(null, "Event created:\nName: " + eventName + "\nDate: " + eventDate);
            EventCreationReceipt.showReceipt(eventName, eventDate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean validateDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            Date parsedDate = dateFormat.parse(date);
            Date currentDate = new Date();
            return !parsedDate.before(currentDate);
        } catch (ParseException e) {
            return false;
        }
    }
}
