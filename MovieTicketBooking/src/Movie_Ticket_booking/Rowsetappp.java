package Movie_Ticket_booking;




import java.sql.Connection;
import java.sql.SQLException;
 
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
 
public class Rowsetappp {
	public static void main(String[] args) {
		try {
			Connection conn = Databaseconnection.getConnection();
            if (conn == null) {
                System.out.println("Database Connection Failed");
                return;
            }
			JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
			rowSet.setUrl("jdbc:mysql://localhost:3306/moviebookingsystem");
			rowSet.setUsername("root");
			rowSet.setPassword("Genpact@123456789");
			rowSet.setCommand("Select * from movies");
			rowSet.execute();
			System.out.println("Using JDBCRowSet:");
			while(rowSet.next()) {
				System.out.println("ID : " + rowSet.getInt("movie_id"));
			}
			System.out.println("======================================");
			while(rowSet.previous()) {
				System.out.println("ID : " + rowSet.getInt("movie_id"));
			}
			System.out.println("======================================");
			rowSet.close();

			CachedRowSet ct = RowSetProvider.newFactory().createCachedRowSet();
//            ct.setUrl("jdbc:mysql://localhost:3306/movie_booking");
//            ct.setUsername("root");
//            ct.setPassword("Genpact@123456789");
 
            ct.setCommand("SELECT * FROM movies");
 
            ct.execute(conn);
            System.out.println("Using CachedRowSet:");
            while (ct.next()) {
                System.out.println("ID : " + ct.getInt("movie_id"));
            }
            System.out.println("======================================");
            // Move cursor to before the first row to iterate in reverse
            ct.afterLast();
 
            while (ct.previous()) {
                System.out.println("ID : " + ct.getInt("movie_id"));
            }
            System.out.println("======================================");
            while(ct.next()) {
            	if(ct.getInt("movie_id") == 3) {
            		ct.updateString("title", "Sab Harry MET SEJAL");
            		ct.updateRow();
            	}
            }
            conn.setAutoCommit(false);
            conn = Databaseconnection.getConnection();
            ct.acceptChanges(conn);
            conn.commit();
            conn.close();
            ct.beforeFirst();
            while(ct.next()) {
            	System.out.println("ID : " + ct.getInt("movie_id"));
            	System.out.println("Title : " + ct.getString("title"));
            	System.out.println("");
            }


            ct.close();

		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}