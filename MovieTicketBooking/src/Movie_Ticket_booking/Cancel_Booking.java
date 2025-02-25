package Movie_Ticket_booking;

import java.sql.*;

import java.util.*; 

public class Cancel_Booking {

    public static void CreateCancelBookingProcedure() throws SQLException {
        Connection conn = Databaseconnection.getConnection();
        if (conn == null) {
            System.out.println("Database Connection Failed");
            return;
        }

        String procedure = "CREATE PROCEDURE CancelBookingByUsername("
                         + "IN username VARCHAR(255),"
                         + "IN bookingId INT)"
                         + "BEGIN "
                         + "DELETE FROM bookings "
                         + "WHERE user_name = username AND booking_id = bookingId;"
                         + "END;";
        Statement stmt = conn.createStatement();
        stmt.execute(procedure);
        System.out.println("Cancel Booking procedure created successfully.");
        stmt.close();
        conn.close();
    }
}
    
    
    
    
    

//    public static void CancelUserBooking() throws SQLException {
//        Connection conn = Databaseconnection.getConnection();
//        if (conn == null) {
//            System.out.println("Database Connection Failed");
//            return;
//        }
//
//        CallableStatement cstmt = null;
//        try {
//            cstmt = conn.prepareCall("{CALL CancelBookingByUsername(?, ?)}");
//
//            Scanner scanner = new Scanner(System.in);
//            System.out.print("Enter your username: ");
//            String username = scanner.nextLine();
//            cstmt.setString(1, username);
//
//            System.out.print("Enter your booking ID: ");
//            int bookingId = scanner.nextInt();
//            cstmt.setInt(2, bookingId);
//
//            cstmt.execute();
//            System.out.println("Booking canceled successfully.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (cstmt != null) cstmt.close();
//                if (conn != null) conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public static void main(String[] args) throws SQLException {
//        CreateCancelBookingProcedure();
//        CancelUserBooking();
//    }
//}

    

        