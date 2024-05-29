package Advanced_Selenium_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Execute_Nonselect_Query_Practice {

	public static void main(String[] args) throws SQLException {
		
		
		//load database driver
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		
		//connect to database
		
		 Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		 
		 //create statement
		 Statement sts=connect.createStatement();
		 
		 //execute non select query and get result
		 int result=sts.executeUpdate("INSERT INTO STUDENT (id,name,phno) VALUES(107,'Balamani','9746325890')");
		 
		 System.out.println(result);
		 
		 connect.close();

	}

}
