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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DatabaseUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;
import com.comcast.crm.genericfileutility.ExcelUtility;
import com.comcast.crm.genericfileutility.FileUtility;
import com.comcast.crm.objectrepositoryutility.Homepage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class BaseClass_Original {
	public WebDriver driver = null;
	
	
	
	
	public static WebDriver sdriver = null;
	

	public DatabaseUtility dbLib = new DatabaseUtility();
	public FileUtility fLib = new FileUtility();
	public JavaUtility jlib = new JavaUtility();
	public ExcelUtility exu = new ExcelUtility();
	public WebdriverUtility wLib=new WebdriverUtility();

	@BeforeSuite
	public void configBs() {
		System.out.println("connect to DB,Report Config");
		dbLib.getDbConnection();
		
		
	}

	@BeforeClass
	public void configBc() throws IOException {
		System.out.println("Launch browser");

		String BROWSER = fLib.getDataFromProperties("browser");
		// fLib.getDataFromProperties("browser");

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();

		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();

		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();

		} else {
			driver = new ChromeDriver();

		}
		sdriver=driver;
		UtilityClassObject.setDriver(driver);

	}

	@BeforeMethod
	public void configBm() throws IOException {

		System.out.println("login into application");
		String URL = fLib.getDataFromProperties("url");
		String USERNAME = fLib.getDataFromProperties("username");
		String PASSWORD = fLib.getDataFromProperties("password");
		LoginPage lp = new LoginPage(driver);
		lp.logininToApp(URL, USERNAME, PASSWORD);

	}

	@AfterMethod
	public void configAm() {
		System.out.println("logout");
		Homepage hp = new Homepage(driver);
		hp.logout();

	}

	@AfterClass
	public void configAc() {
		System.out.println("close the browser");
		driver.close();
	}

	@AfterSuite
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
