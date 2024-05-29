package practice.testng;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Sample_Report_Test {
	public ExtentReports report;

	@BeforeSuite
	public void configBS() {
		// spark report configuration
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM test suite result");
		spark.config().setReportName("CRM report");
		spark.config().setTheme(Theme.DARK);

		// add environment information
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows10");
		report.setSystemInfo("BROWSER", "CHROME-100");

	}

	@AfterSuite
	public void configAS() {
		// save the report
		report.flush();
	}

	@Test
	public void createContactTest() {
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		
		
		
		
		


		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");
		if ("HDFCFC".equals("HDFC")) {
			test.log(Status.PASS, "cotact is created");
		} else {
			
			test.log(Status.FAIL, "contact is not created");
		}
		test.log(Status.INFO, "logout app");
		driver.close();

	}
	
	@Test
	public void createContactWithOrgTest() {
		

		ExtentTest test = report.createTest("createContactWithOrgTest");

		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact with org");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "contact  with org is created");
		} else {
			test.log(Status.FAIL, "contact with org is not created");
		}
		test.log(Status.INFO, "logout app");

	}
	@Test
	public void createContactWithPhonenumTest() {

		ExtentTest test = report.createTest("createContactWithPhonenumTest");

		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact wih phone number");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "contact with phonenum is created");
		} else {
			test.log(Status.FAIL, "contact with phonenum is not created");
		}
		test.log(Status.INFO, "logout app");

	}

}
