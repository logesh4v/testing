package Movie_Ticket_booking;
import java.sql.Connection;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetProvider;

public class JoinRowSetApp {
    public static void main(String[] args) {
        Connection conn = Databaseconnection.getConnection();
        try {
            
            CachedRowSet movies = RowSetProvider.newFactory().createCachedRowSet();
            movies.setCommand("SELECT * FROM movies");
            movies.execute(conn);

           
            CachedRowSet shows = RowSetProvider.newFactory().createCachedRowSet();
            shows.setCommand("SELECT * FROM shows");
            shows.execute(conn);

         
            conn.close();
            System.out.println("Connection closed");

 
            JoinRowSet joinrs = RowSetProvider.newFactory().createJoinRowSet();
            movies.setMatchColumn("movie_id");
            shows.setMatchColumn("movie_id");

           
            joinrs.addRowSet(movies);
            joinrs.addRowSet(shows);

         
            while (joinrs.next()) {
                int movieId = joinrs.getInt("movie_id");
                String title = joinrs.getString("title");
                String genre = joinrs.getString("genre");
                int duration = joinrs.getInt("duration");
                int showId = joinrs.getInt("show_id");
                String showTime = joinrs.getString("show_time");
                int availableSeats = joinrs.getInt("available_seats");

                System.out.println("ID: " + movieId + 
                                   ", Title: " + title + 
                                   ", Genre: " + genre + 
                                   ", Duration: " + duration + 
                                   ", Show ID: " + showId + 
                                   ", Show Time: " + showTime + 
                                   ", Available Seats: " + availableSeats);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
