package Movie_Ticket_booking;
import java.sql.*;
import java.time.LocalDateTime;

public class Insert_data {
	public static void insertMovie()
	{
		Connection conn= Databaseconnection.getConnection();
		if(conn==null)
		{
			System.out.println("Database Connection Failed");
			return;
			
		}
		String insertMovieSQL="Insert into Movies(title,genre,duration)Values(?,?,?);";
		//PreparedStatement psmt =conn.prepareStatement(insertMovieSQL);
		
		try(PreparedStatement psmt =conn.prepareStatement(insertMovieSQL))
		
		{
			psmt.setString(1, "2 States");
			psmt.setString(2, "ROM-COM");
			psmt.setInt(3, 150);
			psmt.executeLargeUpdate();
			
			
			psmt.setString(1, "Meiyazhagan");
			psmt.setString(2, "Feel-Good");
			psmt.setInt(3, 150);
			psmt.executeLargeUpdate();
			
			psmt.setString(1, "GHILLI");
			psmt.setString(2, "Action");
			psmt.setInt(3, 150);
			psmt.executeLargeUpdate();
			
			
			System.out.println("Movies data has been inserted");
		}
		
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	
	}
	
public static void insertShows()
{
Connection conn=Databaseconnection.getConnection();
if(conn==null)
{
	System.out.println("Database Connection Failed");
	return;
	
}


String insertShowSQL = "Insert into Shows (movie_id, show_time, available_seats) Values(?,?,?);";

try(PreparedStatement psmt = conn.prepareStatement(insertShowSQL)){
	//show1
	psmt.setInt(1, 1);
	psmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.of(2025,2,14, 18,30)));
	psmt.setInt(3, 100);
	psmt.executeUpdate();
	//show1
	psmt.setInt(1, 2);
	psmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.of(2025,2,13, 13,30)));
	psmt.setInt(3, 120);
	psmt.executeUpdate();
	//show1
	psmt.setInt(1, 3);
	psmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.of(2025,2,12, 16,30)));
	psmt.setInt(3, 90);
	psmt.executeUpdate();

	System.out.println("Shows data inserted successfully");
}catch(SQLException e){
	e.printStackTrace();
}
}
public static void main(String[] args) throws SQLException {
insertMovie();
insertShows();
}

}
