package Movie_Ticket_booking;

import java.sql.*;
import java.util.Scanner;

public class BookingConfirmation {

    public static void confirmBooking() throws SQLException {
        Scanner scanner = new Scanner(System.in);

       
        System.out.println("Enter your username:");
        String userName = scanner.nextLine();

        Connection conn = Databaseconnection.getConnection();
        if (conn == null) {
            System.out.println("Database Connection Failed");
            return;
        }

 
        String query = "SELECT b.booking_id, b.user_name, m.title, s.show_time, b.seats_booked " +
                       "FROM bookings b " +
                       "JOIN shows s ON b.show_id = s.show_id " +
                       "JOIN movies m ON s.movie_id = m.movie_id " +
                       "WHERE b.user_name = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, userName);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int bookingId = rs.getInt("booking_id");
                String movieName = rs.getString("title");
                Timestamp showTime = rs.getTimestamp("show_time");
                int seatsBooked = rs.getInt("seats_booked");

                System.out.println("Booking ID: " + bookingId);
                System.out.println("Username: " + userName);
                System.out.println("Movie Name: " + movieName);
                System.out.println("Show Time: " + showTime);
                System.out.println("Seats Booked: " + seatsBooked);
                System.out.println("---------------------------");
            }
        }
    }
    
    public static void main(String args[]) throws SQLException
    {
    	
    	confirmBooking();
}
}










