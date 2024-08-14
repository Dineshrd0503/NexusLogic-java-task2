package invmang;
import java.sql.*;

public class DisplayData {
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

            // Displaying the data from the products table
            System.out.println("Displaying data from products table:");
            String query = "SELECT * FROM products";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                System.out.printf("ID: %d, Name: %s, Price: %.2f, Quantity: %d%n", id, name, price, quantity);
            }

            // Closing the resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
