package invmang;
import java.sql.*;
import java.util.Scanner;

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
            PreparedStatement statement = connection.prepareStatement("UPDATE products SET name = ?, description = ?, price = ?, quantity = ? WHERE id = ?");
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the product ID to update:");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            System.out.println("Enter new product name:");
            String name = scanner.nextLine();

            System.out.println("Enter new product description:");
            String description = scanner.nextLine();

            System.out.println("Enter new product price:");
            double price = scanner.nextDouble();
            scanner.nextLine(); // Consume newline left-over

            System.out.println("Enter new product quantity:");
            int quantity = scanner.nextInt();

            statement.setString(1, name);
            statement.setString(2, description);
            statement.setDouble(3, price);
            statement.setInt(4, quantity);
            statement.setInt(5, id);

            int rowsAffected = statement.executeUpdate();

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