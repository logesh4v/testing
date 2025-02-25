package Movie_Ticket_booking;

import java.sql.*;
import java.util.Scanner;

public class Booking 
//{

//    public static void bookTicket() throws SQLException {
//        Scanner scanner = new Scanner(System.in);
//
//  
//        System.out.println("Enter your username:");
//        String username = scanner.nextLine();
//        
//        ShowAvailableMovies.displayMovies();
//
//        System.out.println("Enter the Show ID you want to book:");
//        int showId = scanner.nextInt();
//
//        System.out.println("Enter the number of tickets you want to book:");
//        int tickets = scanner.nextInt();
//
//        Connection conn = Databaseconnection.getConnection();
//        if (conn == null) {
//            System.out.println("Database Connection Failed");
//            return;
//        }
//
//        String checkSeatsQuery = "SELECT available_seats FROM shows WHERE show_id = ?";
//        try (PreparedStatement checkStmt = conn.prepareStatement(checkSeatsQuery)) {
//            checkStmt.setInt(1, showId);
//            ResultSet rs = checkStmt.executeQuery();
//            if (rs.next()) {
//                int availableSeats = rs.getInt("available_seats");
//
//                if (availableSeats >= tickets) {
//                    String insertBookingQuery = "INSERT INTO bookings (username, show_id, seats) VALUES (?, ?, ?)";
//                    try (PreparedStatement insertStmt = conn.prepareStatement(insertBookingQuery)) {
//                        insertStmt.setString(1, username);
//                        insertStmt.setInt(2, showId);
//                        insertStmt.setInt(3, tickets);
//                        insertStmt.executeUpdate();
//                    }
//
//                    String updateSeatsQuery = "UPDATE shows SET available_seats = available_seats - ? WHERE show_id = ?";
//                    try (PreparedStatement updateStmt = conn.prepareStatement(updateSeatsQuery)) {
//                        updateStmt.setInt(1, tickets);
//                        updateStmt.setInt(2, showId);
//                        updateStmt.executeUpdate();
//                    }
//
//                    System.out.println("Booking successful!");
//                } else {
//                    System.out.println("Not enough available seats.");
//                }
//            }
//            
//            
//            
//        }
//    }
//    public static void main(String[] args) throws SQLException {
//    	bookTicket();
//	}
//}





//{
//
//    public static void bookTicket() throws SQLException {
//        Scanner scanner = new Scanner(System.in);
//
//       
//        System.out.println("Enter your username:");
//        String username = scanner.nextLine();
//
//        
//        ShowAvailableMovies.displayMovies();
//
//       
//        System.out.println("Enter the Show ID you want to book:");
//        int showId = scanner.nextInt();
//
//        
//        System.out.println("Enter the number of tickets you want to book:");
//        int tickets = scanner.nextInt();
//
//        Connection conn = Databaseconnection.getConnection();
//        if (conn == null) {
//            System.out.println("Database Connection Failed");
//            return;
//        }
//
//        String checkSeatsQuery = "SELECT available_seats FROM shows WHERE show_id = ?";
//        try (PreparedStatement checkStmt = conn.prepareStatement(checkSeatsQuery)) {
//            checkStmt.setInt(1, showId);
//            ResultSet rs = checkStmt.executeQuery();
//            if (rs.next()) {
//                int availableSeats = rs.getInt("available_seats");
//
//                
//                if (availableSeats >= tickets) {
//                    String insertBookingQuery = "INSERT INTO bookings (username, show_id, seats) VALUES (?, ?, ?)";
//                    try (PreparedStatement insertStmt = conn.prepareStatement(insertBookingQuery)) {
//                        insertStmt.setString(1, username);
//                        insertStmt.setInt(2, showId);
//                        insertStmt.setInt(3, tickets);
//                        insertStmt.executeUpdate();
//                    }
//
//                    String updateSeatsQuery = "UPDATE shows SET available_seats = available_seats - ? WHERE show_id = ?";
//                    try (PreparedStatement updateStmt = conn.prepareStatement(updateSeatsQuery)) {
//                        updateStmt.setInt(1, tickets);
//                        updateStmt.setInt(2, showId);
//                        updateStmt.executeUpdate();
//                    }
//
//                    System.out.println("Booking successful!");
//                } else {
//                    // Step 6: If Seats are Not Available
//                    System.out.println("Not enough available seats.");
//                }
//            }
//        }
//    }
//    
//    
//    public static void main(String[] args) throws SQLException {
//  	bookTicket();
//}
//}




 {

    public static void bookTicket() throws SQLException {
        Scanner scanner = new Scanner(System.in);

       
        System.out.println("Enter your username:");
        String userName = scanner.nextLine();

      
        ShowAvailableMovies.displayMovies();

       
        System.out.println("Enter the Show ID you want to book:");
        int showId = scanner.nextInt();

        
        System.out.println("Enter the number of tickets you want to book:");
        int tickets = scanner.nextInt();

        Connection conn = Databaseconnection.getConnection();
        if (conn == null) {
            System.out.println("Database Connection Failed");
            return;
        }

        String checkSeatsQuery = "SELECT available_seats FROM shows WHERE show_id = ?";
        try (PreparedStatement checkStmt = conn.prepareStatement(checkSeatsQuery)) {
            checkStmt.setInt(1, showId);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next()) {
                int availableSeats = rs.getInt("available_seats");

                if (availableSeats >= tickets) {
                    String insertBookingQuery = "INSERT INTO bookings (user_name, show_id, seats_booked) VALUES (?, ?, ?)";
                    try (PreparedStatement insertStmt = conn.prepareStatement(insertBookingQuery)) {
                        insertStmt.setString(1, userName);
                        insertStmt.setInt(2, showId);
                        insertStmt.setInt(3, tickets);
                        insertStmt.executeUpdate();
                    }

                    String updateSeatsQuery = "UPDATE shows SET available_seats = available_seats - ? WHERE show_id = ?";
                    try (PreparedStatement updateStmt = conn.prepareStatement(updateSeatsQuery)) {
                        updateStmt.setInt(1, tickets);
                        updateStmt.setInt(2, showId);
                        updateStmt.executeUpdate();
                    }

                    System.out.println("Booking successful!");
                } else {
                    System.out.println("Not enough available seats.");
                }
            }
        }
    }
    
    
    
//    public static void main(String[] args) throws SQLException {
//  	bookTicket();
//}
}