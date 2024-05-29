package com.crm.generic.baseutility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.databaseutility.DatabaseUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.genericfileutility.ExcelUtility;
import com.comcast.crm.genericfileutility.FileUtility;
import com.comcast.crm.objectrepositoryutility.Homepage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class BaseClass {
	public WebDriver driver = null;
	public DatabaseUtility dbLib = new DatabaseUtility();
	public FileUtility fLib = new FileUtility();
	public JavaUtility jlib = new JavaUtility();
	public ExcelUtility exu = new ExcelUtility();

	@BeforeSuite(groups= {"SmokeTest","RegressionTest"})
	public void configBs() {
		System.out.println("connect to DB,Report Config");
		dbLib.getDbConnection();
	}
	@Parameters("BROWSER")
	@BeforeClass(groups= {"SmokeTest","RegressionTest"})
	public void configBc(String browser) throws IOException {
		System.out.println("Launch browser");

		String BROWSER = browser;
				//fLib.getDataFromProperties("browser");

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();

		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();

		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();

		} else {
			driver = new ChromeDriver();

		}

	}

	@BeforeMethod(groups= {"SmokeTest","RegressionTest"})
	public void configBm() throws IOException {

		System.out.println("login into application");
		String URL = fLib.getDataFromProperties("url");
		String USERNAME = fLib.getDataFromProperties("username");
		String PASSWORD = fLib.getDataFromProperties("password");
		LoginPage lp = new LoginPage(driver);
		lp.logininToApp(URL,USERNAME,PASSWORD);

		
	}

	@AfterMethod(groups= {"SmokeTest","RegressionTest"})
	public void configAm() {
		System.out.println("logout");
		Homepage hp = new Homepage(driver);
		hp.logout();

	}

	@AfterClass(groups= {"SmokeTest","RegressionTest"})
	public void configAc() {
		System.out.println("close the browser");
		driver.close();
	}

	@AfterSuite(groups= {"SmokeTest","RegressionTest"})
	public void configAs() throws SQLException {
		System.out.println("close DB ,Report backup");
		dbLib.closeDbConnection();
	}
//	@BeforeTest
//	public void configBt()
//	{
//		System.out.println("execute configBt ");
//		
//	}
//	@AfterTest
//	public void configAt()
//	{
//		System.out.println("execute configAt"
//				+ " ");
//		
//	}

}


