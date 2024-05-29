package Advanced_Selenium_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleTest {

	public static void main(String[] args) throws SQLException {
		// load /register database driver
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		
		//connect to database
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		System.out.println("====done====");
		
		//create sequel statement
		
		Statement sts=con.createStatement();
		
		
		//execute select query and get result
		ResultSet res=sts.executeQuery("select* from Student");
		
		while(res.next())
		{
			System.out.println(res.getString(1)+"\t"+res.getString(2)+"\t"+res.getString(3));
		}
		
		//close the connection
		//con.close();

	}

}
