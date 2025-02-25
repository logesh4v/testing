package Movie_Ticket_booking;
 
import java.sql.Connection;
import java.sql.SQLException;
 
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
 
public class Rowsetapp {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //JDBC ROW SET
		try {
			Connection conn=Databaseconnection.getConnection();
			
			JdbcRowSet rowSet=RowSetProvider.newFactory().createJdbcRowSet();
			rowSet.setUrl("jdbc:mysql://localhost:3306/moviebookingsystem");
			rowSet.setUsername("root");
			rowSet.setPassword("Genpact@123456789");
			
			rowSet.setCommand("select * from movies");
			
			rowSet.execute();
			
			while(rowSet.next()) {
				System.out.println("ID :"+rowSet.getInt("movie_id"));
			}
			while(rowSet.previous()) {
				System.out.println("ID :"+rowSet.getInt("movie_id"));
			}
			
			rowSet.close();
			CachedRowSet ct=RowSetProvider.newFactory().createCachedRowSet();
			ct.setCommand("select * from movies");
			ct.execute(conn);
			
			if (conn != null && !conn.isClosed()) {
                conn.close();
            }
 
          
            while (ct.next()) {
                int movieId = ct.getInt("movie_id");
                String title = ct.getString("title");
                String genre = ct.getString("genre");
                int duration = ct.getInt("duration");
 
                System.out.println("Movie ID: " + movieId);
                System.out.println("Title: " + title);
                System.out.println("Genre: " + genre);
                System.out.println("Duration: " + duration + " minutes");
                System.out.println("-------------------------");
            }
            
            //offline
            
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
 
}