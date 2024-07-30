package src;
import java.sql.*;

public class DatabaseConnection {
    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost/ems",
                        "root", 
                        "Mysql@123"
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static String[] getEventNames() {
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(
                "SELECT event_name FROM events WHERE event_date > CURDATE()" 
            );
            
            ResultSet resultSet = statement.executeQuery();
    
            resultSet.last();
            int numRows = resultSet.getRow();
            resultSet.beforeFirst();
    
            String[] eventNames = new String[numRows];
            int i = 0;
            while (resultSet.next()) {
                eventNames[i] = resultSet.getString("event_name");
                i++;
            }
    
            return eventNames;
        } catch (SQLException e) {
            e.printStackTrace(); // Print the exception details
            return new String[0]; // Return an empty array if there's an error
        }
    }
}    

