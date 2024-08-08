package invmang;
import java.sql.*;

public class UpdateDetails{
    private static final String url = "jdbc:mysql://localhost:3305/inventorydb";
    private static final String username = "root";
    private static final String password = "1234@";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Database driver not found");
        }

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            System.out.println("Updating data in the products table:");
            String updateQuery = "UPDATE products SET price = 220.50, quantity = 250 WHERE id = 131";
            int rowsAffected = statement.executeUpdate(updateQuery);

            if (rowsAffected > 0) {
                System.out.println("Data has been updated successfully");
            } else {
                System.out.println("No data was updated");
            }


            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

