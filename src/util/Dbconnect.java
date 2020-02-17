package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnect 
{
	public static Connection dbconnect() throws SQLException 
	{
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		
		String url="jdbc:mysql://localhost:3306/foodordering";
		String user="root";
		String pass="";
		
		Connection con = DriverManager.getConnection(url,user,pass);
		return con;
	}
}
