package Movie_Ticket_booking;
import java.sql.*;
import java.util.Scanner;

public class View_Booking {
	public static void ViewUserBookings() throws SQLException {
        Connection conn = Databaseconnection.getConnection();
        if (conn == null) {
            System.out.println("Database Connection Failed");
            return;
        }
 
        String procedure = "CREATE PROCEDURE GetMovieDetailsByUsername(IN username VARCHAR(255))"
                         + "BEGIN "
                         + "select * from movies join shows on movies.movie_id = shows.movie_id join bookings on bookings.show_id = shows.show_id where user_name = username;"
                         + "END;";
        Statement stmt = conn.createStatement();
        // Execute the stored procedure creation
        stmt.execute(procedure);
        System.out.println("View Bookings procedure created successfully.");
    }
 
 
 
 
 

public static void main(String[] args) throws SQLException {
	 ViewUserBookings();

}
}