package Movie_Ticket_booking;

import java.sql.*;
import java.util.*;
import java.util.Date;
 
//public class Test {
//    public static void main(String[] args) {
//        Connection conn = null;
//        CallableStatement cstmt = null;
//        try {
//            conn = Databaseconnection.getConnection();
//            if (conn == null) {
//                System.out.println("Database Connection Failed");
//                return;
//            }
//
//            
//            cstmt = conn.prepareCall("{CALL GetMovieTitle1(?, ?)}");
//
//
//            System.out.print("Enter your movie Id: ");
//            Scanner scanner = new Scanner(System.in);
//            int movieId = scanner.nextInt();
//            cstmt.setInt(1, movieId);
//
//      
//            cstmt.registerOutParameter(2, Types.VARCHAR);
//
//          
//            cstmt.execute();
//
//         
//            String title = cstmt.getString(2);
//            System.out.println("Movie Title: " + title);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (cstmt != null) 
//                	cstmt.close();
//                if (conn != null) 
//                	conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
//






public class Test {

	public static void Testing1() {
		Connection conn = null;
        CallableStatement cstmt = null;
        try {
            conn = Databaseconnection.getConnection();
            if (conn == null) {
                System.out.println("Database Connection Failed");
                return;
            }
 
        
            cstmt = conn.prepareCall("{CALL GetMovieTitleAndGenre(?,?,?)}");
 
          
            System.out.print("Enter your movie Id: ");
            Scanner scanner = new Scanner(System.in);
            int movieId = scanner.nextInt();
            cstmt.setInt(1, movieId);
 
          
            cstmt.registerOutParameter(2, Types.VARCHAR);
            cstmt.registerOutParameter(3, Types.VARCHAR);
 
          
            cstmt.execute();
 
         
            String title = cstmt.getString(2);
            String genre = cstmt.getString(3);
            System.out.println("Movie Title: " + title);
            System.out.println("Movie Genre: " + genre);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (cstmt != null) cstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}


	public static void Testing2() {
		Connection conn = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        try {
            conn = Databaseconnection.getConnection();
            if (conn == null) {
                System.out.println("Database Connection Failed");
                return;
            }
 
           
            cstmt = conn.prepareCall("{CALL GetMovieDetailsByUsername(?)}");
 
           
            System.out.print("Enter your username: ");
            Scanner scanner = new Scanner(System.in);
            String username = scanner.nextLine();
            cstmt.setString(1, username);
 

            rs = cstmt.executeQuery();
 
           
            while (rs.next()) {
                String name = rs.getString("user_name");
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                int seatsBooked = rs.getInt("seats_booked");
                Time showTime = rs.getTime("show_time");
                Date bookingDate = rs.getDate("booking_date");
                // Print the columns
                System.out.println("----------------------------------------------------------------------------------------------");
                System.out.println("Username: " + name);
                System.out.println("Movie Title: " + title);
                System.out.println("Movie Genre: " + genre);
                System.out.println("Seats Booked: " + seatsBooked);
                System.out.println("Show Time: " + showTime);
                System.out.println("Booking Date: " + bookingDate);
                System.out.println("________________________________________________________________________________________________");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (cstmt != null) cstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}
	
	
	public static void CancelUserBooking() throws SQLException {
        Connection conn = Databaseconnection.getConnection();
        if (conn == null) {
            System.out.println("Database Connection Failed");
            return;
        }

        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{CALL CancelBookingByUsername(?, ?)}");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();
            cstmt.setString(1, username);

            System.out.print("Enter your booking ID: ");
            int bookingId = scanner.nextInt();
            cstmt.setInt(2, bookingId);

            cstmt.execute();
            System.out.println("Booking canceled successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (cstmt != null) cstmt.close();
                // Do not close the connection here
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



	
	
	
	
    public static void main(String[] args)throws SQLException {
//      Testing1();
        //Testing2();
        CancelUserBooking();
    }
}
