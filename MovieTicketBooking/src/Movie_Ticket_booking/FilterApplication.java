package Movie_Ticket_booking;


import java.sql.*;

import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.RowSetProvider;

public class FilterApplication {
	
	public static void main (String args[])
	{
		try(Connection conn=Databaseconnection.getConnection();
				Statement smt =conn.createStatement();
					ResultSet rs=smt.executeQuery("Select * from shows"))
		{
			FilteredRowSet frs=RowSetProvider.newFactory().createFilteredRowSet();
			frs.populate(rs);
			
			frs.setFilter(new AvailableShowFilter(90));
			
			while(frs.next())
			{
	                int showId = frs.getInt("show_id");
	                int movieId = frs.getInt("movie_id");
	 
	                String showTime = frs.getString("show_time");
	                int seats = frs.getInt("available_seats");
	 
	                System.out.println("Show Id: " + showId + " Movie Id: " +  movieId + " Seats: " + seats + " Show Time: " + showTime);
	            }			
				 
			}
	
			
			
		
		catch(SQLException e)
		
		{
		e.printStackTrace();
		return ;
		}

	}
}
