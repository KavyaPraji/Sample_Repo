package Advanced_Selenium_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;
import org.testng.Assert;

import com.mysql.cj.jdbc.Driver;

public class ExpectedDataInDatabase {

	 @Test
	 public void check() throws SQLException
	 {
		 String ExpectedStudentName="Gayatri";
		 boolean flag=false;
		 
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
				String actualStudentName=res.getString(2);
				System.out.println(actualStudentName);
				if(ExpectedStudentName.equals(actualStudentName))
				{
					flag=true;
					System.out.println(ExpectedStudentName+"  is avilable===PASS");
				}
			}
			if(flag==false)
			{
				System.out.println(ExpectedStudentName+" is not avilable===FAIL");
				Assert.fail();
			}
			
			//close the connection
			con.close();
		 
		 
	 }
	
		
		

	

}
