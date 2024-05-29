package Advanced_Selenium_1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class  Execute_Select_Query{

	public static void main(String[] args) throws SQLException 
	{
		Connection con=null;
		try {
		// load /register database driver
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		
		//connect to database
		
		  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		System.out.println("====done====");
		
		//create sequel statement
		
		Statement sts=con.createStatement();
		
		
		//execute select query and get result
		ResultSet res=sts.executeQuery("select* from Student");
		
		while(res.next())
		{
			System.out.println(res.getString(1)+"\t"+res.getString(2)+"\t"+res.getString(3));
		}
		}catch(Exception e)
		{
			System.out.println("exception handled");
		}
		finally{
		
		//close the connection
		con.close();
		System.out.println("connection closed");
		}

	}

}


