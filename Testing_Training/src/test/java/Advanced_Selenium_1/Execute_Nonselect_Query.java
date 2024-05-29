package Advanced_Selenium_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Execute_Nonselect_Query {

	public static void main(String[] args) throws SQLException {
		// load database driver
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		
		//connect to database
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		System.out.println("====done====");
		
		//create sequel statement
		
		Statement sts=con.createStatement();
		//execute non select query and get result 
		
		int result=sts.executeUpdate("INSERT INTO Student(id,name,phno) VALUES(106,'Gayathri','7854637320');");
		System.out.println(result);
		//close the connection
		con.close(); 
		
		
		
		
		

	}

}
