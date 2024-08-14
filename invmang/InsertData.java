package invmang;

import java.sql.*;
import java.util.*;

public class InsertData {
    static Scanner sc = new Scanner(System.in);
    private static final String url = "jdbc:mysql://localhost:3305/inventorydb";
    private static final String username = "root";
    private static final String password = "1234@";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("No database selected");
        }
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement("insert into products(id, name, description, price, quantity) values (?, ?, ?, ?, ?)");
            System.out.println("How many records do you want to enter?");
            int n = sc.nextInt();
            System.out.println("Inserting data into products table ");
            int rowsAffected = 0;
            while (n > 0) {
                System.out.println("Enter product id");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter product name");
                String name = sc.nextLine();
                System.out.println("Enter description");
                String description = sc.nextLine();
                System.out.println("Enter price of product");
                int price = sc.nextInt();
                System.out.println("Enter quantity");
                int quantity = sc.nextInt();

                statement.setInt(1, id);
                statement.setString(2, name);
                statement.setString(3, description);
                statement.setInt(4, price);
                statement.setInt(5, quantity);

                rowsAffected += statement.executeUpdate();
                n -= 1;
            }

            if (rowsAffected > 0)
                System.out.println("Rows have been inserted successfully");
            else
                System.out.println("Data not inserted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}