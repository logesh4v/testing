package Movie_Ticket_booking;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class StoredProcedureCallable {
    public static void storedProcedure() throws SQLException {
        Connection conn = Databaseconnection.getConnection();
        if (conn == null) {
            System.out.println("Database Connection Failed");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        
     
        String procedure = "CREATE PROCEDURE GetMovieTitle1(IN movieId INT, OUT movietitle VARCHAR(255)) " +
                           "BEGIN " +
                           "SELECT title INTO movietitle FROM movies WHERE movie_id = movieId; " +
                           "END;";
        Statement stmt = conn.createStatement();
        stmt.execute(procedure);
        System.out.println("Stored procedure created successfully.");
    }

    public static void main(String[] args) throws SQLException {
        storedProcedure();
    }
}