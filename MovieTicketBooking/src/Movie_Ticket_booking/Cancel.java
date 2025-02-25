//package Movie_Ticket_booking;
//import java.sql.*;
//import java.util.*;
//
//public class Cancel {
//
//    public static void cancelTicket() throws SQLException {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Enter your username:");
//        String userName = scanner.nextLine();
//        System.out.println("Enter your booking ID:");
//        int bookingId = scanner.nextInt();
//
//        Connection conn = Databaseconnection.getConnection();
//        if (conn == null) {
//            System.out.println("Database Connection Failed");
//            return;
//        }
//
//       
//        String checkBookingQuery = "SELECT show_id, seats_booked FROM bookings WHERE booking_id = ? AND user_name = ?";
//        try (PreparedStatement checkStmt = conn.prepareStatement(checkBookingQuery)) {
//            checkStmt.setInt(1, bookingId);
//            checkStmt.setString(2, userName);
//            ResultSet rs = checkStmt.executeQuery();
//
//            if (rs.next()) {
//                int showId = rs.getInt("show_id");
//                int seatsBooked = rs.getInt("seats_booked");
//
//               
//                String deleteBookingQuery = "DELETE FROM bookings WHERE booking_id = ?";
//                try (PreparedStatement deleteStmt = conn.prepareStatement(deleteBookingQuery)) {
//                    deleteStmt.setInt(1, bookingId);
//                    deleteStmt.executeUpdate();
//                }
//
//            
//                String updateSeatsQuery = "UPDATE shows SET available_seats = available_seats + ? WHERE show_id = ?";
//                try (PreparedStatement updateStmt = conn.prepareStatement(updateSeatsQuery)) {
//                    updateStmt.setInt(1, seatsBooked);
//                    updateStmt.setInt(2, showId);
//                    updateStmt.executeUpdate();
//                }
//
//                System.out.println("Booking cancelled successfully!");
//            } else {
//                System.out.println("No such booking found for the given username and booking ID.");
//            }
//        }
//    }
//}















package Movie_Ticket_booking;

import java.sql.*;
import java.util.Scanner;

public class Cancel {

    public static void cancelTicket() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your username:");
        String userName = scanner.nextLine();
        System.out.println("Enter your booking ID:");
        int bookingId = scanner.nextInt();

        Connection conn = Databaseconnection.getConnection();
        if (conn == null) {
            System.out.println("Database Connection Failed");
            return;
        }

        String checkBookingQuery = "SELECT show_id, seats_booked FROM bookings WHERE booking_id = ? AND user_name = ?";
        try (PreparedStatement checkStmt = conn.prepareStatement(checkBookingQuery)) {
            checkStmt.setInt(1, bookingId);
            checkStmt.setString(2, userName);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                int showId = rs.getInt("show_id");
                int seatsBooked = rs.getInt("seats_booked");

                String deleteBookingQuery = "DELETE FROM bookings WHERE booking_id = ?";
                try (PreparedStatement deleteStmt = conn.prepareStatement(deleteBookingQuery)) {
                    deleteStmt.setInt(1, bookingId);
                    deleteStmt.executeUpdate();
                }

                String updateSeatsQuery = "UPDATE shows SET available_seats = available_seats + ? WHERE show_id = ?";
                try (PreparedStatement updateStmt = conn.prepareStatement(updateSeatsQuery)) {
                    updateStmt.setInt(1, seatsBooked);
                    updateStmt.setInt(2, showId);
                    updateStmt.executeUpdate();
                }

                System.out.println("Booking cancelled successfully!");
            } else {
                System.out.println("No such booking found for the given username and booking ID.");
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        cancelTicket();
    }
}
