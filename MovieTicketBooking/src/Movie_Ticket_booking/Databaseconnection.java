package Movie_Ticket_booking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Databaseconnection {
	
	private static final String URL="jdbc:mysql://localhost:3306/moviebookingsystem";
	private static final String USER="root";
	private static final String PASSWORD="Genpact@123456789";
	
	private static Connection connection;
	
	public static Connection getConnection()
	{
		if(connection==null)
		{
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection=DriverManager.getConnection(URL,USER,PASSWORD);
				System.out.println("Database Has Been Connected ");
			}
			catch(SQLException | ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			
		}
		return connection;
	}
	
	public static void main (String[] args)
	{
		getConnection();
	}
	

}
