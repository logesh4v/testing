package Movie_Ticket_booking;

import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.rowset.*;

public class AvailableShowFilter implements javax.sql.rowset.Predicate {
	
	private int minSeats;
	

public AvailableShowFilter(int minSeats)
{
	this.minSeats=minSeats;
	}
	
	
	
	@Override
	public boolean evaluate(RowSet rs) {
		try
		{
			int availableSeats=rs.getInt("Available_Seats");
			return availableSeats>=minSeats;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		return false;
		}
	}

	@Override
	public boolean evaluate(Object value, int column) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean evaluate(Object value, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
