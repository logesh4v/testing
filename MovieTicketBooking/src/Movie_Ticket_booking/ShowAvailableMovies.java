//package Movie_Ticket_booking;
//import java.sql.*;
//import java.util.*;
//public class ShowAvailableMovies {
//
//	public static void displayMovies() throws SQLException {
//		Connection conn = Databaseconnection.getConnection();
//		if(conn==null) {
//			System.out.println("Database Connection Failed");
//			return;
//		}
//
//		String query = "select * from movies join shows on movies.movie_id = shows.movie_id;";
// 
//		try(Statement smt = conn.createStatement()){
//			ResultSet rs = smt.executeQuery(query);
//			while(rs.next()) {
//				int movieId = rs.getInt("movie_id");
//				String title = rs.getString("title");
//				String genre = rs.getString("genre");
//				int duration = rs.getInt("duration");
//				Timestamp showtime = rs.getTimestamp("show_time");
//				int available_seats = rs.getInt("available_seats");
//
//				System.out.print(movieId + "||\t" + title + "||\t" + genre + "||\t" + duration + "||\t" + showtime + "||\t" + available_seats);
//				System.out.println(" ");
//
//			}
//		}
//	}
////	public static void main(String[] args) throws SQLException {
////		displayMovies();
////	}
//}











package Movie_Ticket_booking;

import java.sql.*;

public class ShowAvailableMovies {

    public static void displayMovies() throws SQLException {
        Connection conn = Databaseconnection.getConnection();
        if (conn == null) {
            System.out.println("Database Connection Failed");
            return;
        }

        String query = "SELECT * FROM Movies";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("Available Movies:");
            while (rs.next()) {
                int movieId = rs.getInt("Movie_id");
                String title = rs.getString("Title");
                String genre = rs.getString("Genre");
                int duration = rs.getInt("Duration");

                System.out.println("Movie ID: " + movieId);
                System.out.println("Title: " + title);
                System.out.println("Genre: " + genre);
                System.out.println("Duration: " + duration + " minutes");
                System.out.println("---------------------------");
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        displayMovies();
    }
}
