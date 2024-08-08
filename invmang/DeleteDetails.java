package invmang;
import java.sql.*;

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
            Statement statement = connection.createStatement();

            // Define the conditions for deletion
            int idToDelete = 131;
            String nameToDelete = "mysoe sandal soap";
            double priceToDelete = 220.50;

            System.out.println("Deleting data from the products table:");

            // Delete the record based on id, name, and price
            String deleteQuery = String.format("DELETE FROM products WHERE id = %d AND name = '%s' AND price = %.2f",
                    idToDelete, nameToDelete, priceToDelete);

            int rowsAffected = statement.executeUpdate(deleteQuery);

            if (rowsAffected > 0) {
                System.out.println("Data has been deleted successfully");
            } else {
                System.out.println("No data was deleted");
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
