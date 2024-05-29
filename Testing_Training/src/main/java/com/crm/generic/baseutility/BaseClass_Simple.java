package com.crm.generic.baseutility;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass_Simple 
{
	@BeforeSuite
	public void configBs() {
		System.out.println("connect to DB,Report Config");
		
	}
	
	@BeforeSuite
	public void configBs1() {
		System.out.println("connect to DB==1,Report Config==1");
		
	}

	@BeforeClass
	public void configBc() throws IOException {
		System.out.println("Launch browser");

		

	}
	@BeforeClass
	public void configBc1() throws IOException {
		System.out.println("Launch browser===1");

		

	}

	@BeforeMethod
	public void configBm() throws IOException {

		System.out.println("login into application");
		

	}
	@BeforeMethod
	public void configBm1() throws IOException {

		System.out.println("login into application==1");
		

	}

	@AfterMethod
	public void configAm() {
		System.out.println("logout");
		

	}
	@AfterMethod
	public void configAm1() {
		System.out.println("logout==1");
		

	}

	@AfterClass
	public void configAc() {
		System.out.println("close the browser");
		
	}
	@AfterClass
	public void configAc1() {
		System.out.println("close the browser==1");
		
	}

	@AfterSuite
	public void configAs() throws SQLException {
		System.out.println("close DB ,Report backup");
		
	}

	@AfterSuite
	public void configAs1() throws SQLException {
		System.out.println("close DB ,Report backup==1");
		
	}

}


