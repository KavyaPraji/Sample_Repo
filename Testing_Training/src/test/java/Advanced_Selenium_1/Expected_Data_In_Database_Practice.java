package Advanced_Selenium_1;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class Expected_Data_In_Database_Practice {

	@Test
	public void check() throws SQLException
	{
		String ExpectedStudentName="Balamani";
		boolean flag=false;
		
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		
		Statement stm=con.createStatement();
		
		ResultSet result=stm.executeQuery("select*from student");
		
		while(result.next())
		{
			String ActualStudentName=result.getString(2);
			if(ExpectedStudentName.equals(ActualStudentName))
			{
				flag=true;
				System.out.println(ExpectedStudentName+"  is available ==>PASS");
			}
		}
		if(flag==false)
		{
			System.out.println(ExpectedStudentName+"  is not available ==>FAIL");
		}
		
		con.close();
		
		
		
				
		
	}

}
