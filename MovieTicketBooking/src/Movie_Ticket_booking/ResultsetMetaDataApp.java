package Movie_Ticket_booking;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
 
public class ResultsetMetaDataApp {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		try(Connection conn = Databaseconnection.getConnection();
				Statement smt = conn.createStatement();
				ResultSet rs = smt.executeQuery("Select * from shows")){

				ResultSetMetaData rsmd = rs.getMetaData();
				int colCount = rsmd.getColumnCount();
				System.out.println(colCount);
				
				
				for (int i = 1; i <= colCount; i++) {
		                System.out.println("Column : " + i);
		                System.out.println("Column Name : " + rsmd.getColumnName(i));
		                System.out.println("Column Label : " + rsmd.getColumnLabel(i));
		                System.out.println("Column Type : " + rsmd.getColumnTypeName(i));
		                System.out.println("Column Type Class : " + rsmd.getColumnClassName(i));
		                System.out.println("Is Nullable : " + rsmd.isNullable(i));
		                System.out.println("Is AutoIncrement : " + rsmd.isAutoIncrement(i));
		                System.out.println("Precision : " + rsmd.getPrecision(i));
		                System.out.println("Column Display Size : " + rsmd.getColumnDisplaySize(i));
		                System.out.println("Table Name : " + rsmd.getTableName(i));
		                System.out.println("Schema Name : " + rsmd.getSchemaName(i));
		                System.out.println("---------------------------");
		            }
	
				}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
}

}
