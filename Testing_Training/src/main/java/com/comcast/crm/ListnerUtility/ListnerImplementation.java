package com.comcast.crm.ListnerUtility;


import java.util.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.crm.generic.baseutility.BaseClass_Original;

public class ListnerImplementation implements ITestListener, ISuiteListener {

	
	public ExtentSparkReporter spark;
	public  static ExtentReports report;
	ExtentTest test;
	public void onStart(ISuite suite) {
		System.out.println("Report configuration");
		// spark report configuration
		String time=	new  Date().toString().replace(" ", "_").replace(":","_");
		
		 spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("CRM test suite result");
		spark.config().setReportName("CRM report");
		spark.config().setTheme(Theme.DARK);

		// add environment information
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows10");
		report.setSystemInfo("BROWSER", "CHROME-100");


	}

	public void onFinish(ISuite suite) {

		System.out.println("Report backup");
		// save the report
		report.flush();
	}

	public void onTestStart(ITestResult result) {

		

		test = report.createTest( result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+"==>STARTED<==");
	}

	public void onTestSuccess(ITestResult result) {

		test.log(Status.PASS,  result.getMethod().getMethodName() + "==>COMPLETED<==");
		
	}

	public void onTestFailure(ITestResult result) {

		String testName = result.getMethod().getMethodName();

		TakesScreenshot ts=(TakesScreenshot)BaseClass_Original.sdriver;
		String filepath= ts.getScreenshotAs(OutputType.BASE64);
		String time=	new  Date().toString().replace(" ", "_").replace(":","_");
		
		test.addScreenCaptureFromBase64String(filepath,testName+" "+time);
		
		test.log(Status.FAIL,  result.getMethod().getMethodName() + "==>FAILED<==");
		
		

		
	}

	public void onTestSkipped(ITestResult result) {
		

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

		
	}

}
