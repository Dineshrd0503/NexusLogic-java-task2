package invmang;
import java.sql.*;
public class InsertData {
    private static final String url = "jdbc:mysql://localhost:3305/inventorydb";
    private static final String username = "root";
    private static final String password = "1234@";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("no database selected");
        }
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            System.out.println("inserting data into products table ");
            String query1 = String.format("insert into products(id,name,price,quantity)values(%o,'%s',%f,%d)", 131, "mysoe sandal soap", 210.24, 300);
            int rowsaffected = statement.executeUpdate(query1);
            if (rowsaffected > 0)
                System.out.println("rows has been changed");
            else
                System.out.println("data not insrerted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
