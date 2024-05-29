
package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	
	Connection con;
	public void getdbCOnncection(String url,String username,String password) throws Throwable
	{
		try {
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		
		con=DriverManager.getConnection(url,username,password);
		}catch(Exception e)
		{
			
		}
	}
	public void getDbConnection()
	{
		try {
			Driver driverref=new Driver();
			DriverManager.registerDriver(driverref);
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			}catch(Exception e)
			{
				
			}
	}
	
	public void closeDbConnection() throws SQLException
	{
		try {
			con.close();
		}catch(Exception e)
		{
			
		}
		
		
	}
	public ResultSet  executeSelectQuery(String query) throws Throwable
	{
		ResultSet result=null;
		try {
		Statement sts=con.createStatement();
		 result=sts.executeQuery(query);
		
		}catch(Exception e)
		{
			
		}
		return result;
	}
	public int  executeNonSelectQuery(String query)
	{
		int result=0;
		try {
		Statement sts=con.createStatement();
		 result=sts.executeUpdate(query);
		
		}catch(Exception e)
		{
			
		}
		return result;
		
	}
	
}
