package Movie_Ticket_booking;

import java.sql.*;

public class DatabaseTables {

	public static void createTables()
	{
		Connection conn=Databaseconnection.getConnection();
		if(conn==null)
		{
			System.out.println("Database connection failed");
			return;
		}
		try {
			Statement smt=conn.createStatement();
			//statement object used for general purpose access to the db
			//execute sql statement at runtime
			//create table--create
		String createMoviesTable="Create Table IF not exists Movies("
				+"Movie_id INT Auto_increment Primary key,"+"Title varchar(60) not null,"
				+"Genre varchar(20),"
				+"Duration int not null)";
		smt.executeUpdate(createMoviesTable);
		System.out.println("Movies Table as been Created");
		
		
		String createShowTable = "CREATE TABLE IF NOT EXISTS Shows("
		           + "show_id INT AUTO_INCREMENT PRIMARY KEY, "
		           + "movie_id INT, "
		           + "show_time DATETIME NOT NULL, "
		           + "available_seats INT NOT NULL, "
		           + "FOREIGN KEY (movie_id) REFERENCES Movies(movie_id)"
		           + ");";

		smt.executeUpdate(createShowTable);
		System.out.println("Shows Table Created Successfully!");
		
		
		String createBookingTable = "CREATE TABLE IF NOT EXISTS Bookings ("
                + "booking_id INT AUTO_INCREMENT PRIMARY KEY, "
                + "user_name VARCHAR(50) NOT NULL, "
                + "show_id INT NOT NULL, "
                + "seats_booked INT NOT NULL, "
                + "booking_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, "
                + "FOREIGN KEY (show_id) REFERENCES Shows(show_id)"
                + ");";
		smt.executeUpdate(createBookingTable);
		System.out.println("Booking Table Created Successfully!");
		
		
		
		
		 String createUsersTable = "CREATE TABLE IF NOT EXISTS Users ("
                 + "userid INT AUTO_INCREMENT PRIMARY KEY, "
                 + "username VARCHAR(255) NOT NULL, "
                 + "pwd VARCHAR(255) NOT NULL, "
                 + "admin BOOLEAN NOT NULL)";
         smt.executeUpdate(createUsersTable);
         System.out.println("Users Table Created Successfully!");
		
		
		
		
		
		
		
		
		
		
		
		
		//shows
		//show_id-int-auto-primary key
		//movie if -int
		//showtime-datatime-notnull
		//availble _seats-int not null
		//foreign key(movie id) refer movies (movies id)
		
		//booking 
		//booking_id-int-primary key
		//username-varchar()--notnull,
		//showid int not null;
		//seats_booked
		//bookingdate timestamp default current_timestamp
		//foregin key as show_id refer to show(shows_id)
		
		
		smt.close();
		conn.close();
		
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	



public static void main(String[] args) {
    createTables();
}
}
