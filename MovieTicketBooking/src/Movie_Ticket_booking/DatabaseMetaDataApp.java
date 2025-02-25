package Movie_Ticket_booking;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
 
public class DatabaseMetaDataApp {
 
    public static void main(String[] args) {
        try (Connection conn = Databaseconnection.getConnection()) {
 
            // metadata
            DatabaseMetaData dbmd = conn.getMetaData();
 
            // fetch db info
            System.out.println("Database Product Version: " + dbmd.getDatabaseProductVersion());
            System.out.println("Database Product Name: " + dbmd.getDatabaseProductName());
            System.out.println("JDBC Driver Name: " + dbmd.getDriverName());
            System.out.println("JDBC Driver Version: " + dbmd.getDriverVersion());
            System.out.println("Database URL: " + dbmd.getURL());
            System.out.println("Database Username: " + dbmd.getUserName());
 
            // RETRIEVE TABLES in DB
            ResultSet rs = dbmd.getTables("movie_booking", null, "%", new String[] {"TABLE"});
            System.out.println("Tables in the database:");
            while (rs.next()) {
                System.out.println(rs.getString("TABLE_NAME"));
            }
 
            // Retrieve columns of the "shows" table
            ResultSet rs2 = dbmd.getColumns(" moviebookingsystem", null, "shows", "%");
            System.out.println("\nColumns in the 'shows' table:");
            while (rs2.next()) {
                System.out.println("Column Name: " + rs2.getString("COLUMN_NAME"));
                System.out.println("Column Type: " + rs2.getString("TYPE_NAME"));
                System.out.println("---------------------------");
            }
 
            // Retrieve primary keys 
            ResultSet rs3 = dbmd.getPrimaryKeys("movie_booking", null, "shows");
            while (rs3.next()) {
                System.out.println("Primary Key Column: " + rs3.getString("COLUMN_NAME"));
                System.out.println("---------------------------");
            }
 
            // Check support for transactions
            System.out.println("Supports Transactions: " + dbmd.supportsTransactions());
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
