package Advanced_Selenium_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Execute_Select_Query_Practice {

	public static void main(String[] args) throws SQLException 
	{
		 Connection connect=null;
		 try {
		//load or register database driver
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		
		//connection to database
		
		connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		//create sequel statement
		Statement state=connect.createStatement();	
		
		//create select query and execute result
		ResultSet result=state.executeQuery("select*from Student");
		
		while(result.next())
		{
			System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3));
		}
		 }catch(Exception e)
		 {
			 System.out.println("exception handled");
		 }
		 finally 
		 {
		
			 connect.close();
		
		 }

	}

}
