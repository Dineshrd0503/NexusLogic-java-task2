package invmang;
import java.sql.*;
import java.util.Scanner;

public class DeleteDetails {
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
            PreparedStatement statement = connection.prepareStatement("DELETE FROM products WHERE id = ?");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the product ID to delete:");
            int idToDelete = scanner.nextInt();

            statement.setInt(1, idToDelete);

            System.out.println("Deleting data from the products table:");
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Record with ID " + idToDelete + " has been deleted successfully");
            } else {
                System.out.println("No record found with ID " + idToDelete);
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}