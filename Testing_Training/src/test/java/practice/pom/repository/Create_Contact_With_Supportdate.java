package practice.pom.repository;

import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.genericfileutility.ExcelUtility;
import com.comcast.crm.genericfileutility.FileUtility;

public class Create_Contact_With_Supportdate {

	public static void main(String[] args) throws Throwable 
	{
		
		
		FileUtility fu=new FileUtility();
		JavaUtility jlib=new JavaUtility();
		ExcelUtility exu=new ExcelUtility();
		
		
		//read data from property file

		String BROWSER =fu.getDataFromProperties("browser");
		String URL	   =fu.getDataFromProperties("url");
		String USERNAME=fu.getDataFromProperties("username");
		String PASSWORD=fu.getDataFromProperties("password");
		
		
		//generate random number and read data from  excel file
		
		
		String ORGNAME=exu.getDataFromExcel("sheet1", 1, 2)+jlib.getRandomNum();
		
				
				
				//fetch the system date(today's date)
		
			String CURRENTDATE=jlib.getSystemDateInFormat();
				
				
				//fetch day after 30 days
				String LASTDATE=jlib.getRequiredDateInFormat(30);
				
				
				
				WebDriver driver=null;
				
				if(BROWSER.equals("chrome"))
				{
					driver=new ChromeDriver();
					
				}
				else if(BROWSER.equals("firefox"))
				{
					driver=new FirefoxDriver();
					
				}
				else if(BROWSER.equals("edge"))
				{
					driver=new EdgeDriver();
					
				}
				else
				{
					driver=new ChromeDriver();
					
				}
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				driver.get(URL);
				
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submit_button")).click();
				
				driver.findElement(By.linkText("Contacts")).click();
				driver .findElement(By.xpath("//img[@title='Create Contact...']")).click();
				//driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
				
				

				driver.findElement(By.name("support_start_date")).clear();
				driver.findElement(By.name("support_start_date")).sendKeys(CURRENTDATE);
				
				driver.findElement(By.name("support_end_date")).clear();
				
				driver.findElement(By.name("support_end_date")).sendKeys(LASTDATE);
				
				
				driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
				
				
				//verify start date and end date
				
				String actCurrentDate=driver.findElement(By.id("dtlview_Support Start Date")).getText();
				if(actCurrentDate.equals(CURRENTDATE))
				{
					System.out.println(CURRENTDATE+ " information is verified===PASS");
				}
				
				else
				{
					
					System.out.println(CURRENTDATE+ " information is  not verified===FAIL");
				}
				
				String actEndDate=driver.findElement(By.id("dtlview_Support End Date")).getText();
				if(actEndDate.equals(LASTDATE)) {
					System.out.println(LASTDATE+ " information is verified===PASS");
				}
				
				else
				{
					System.out.println(LASTDATE+ " information is  not verified===FAIL");
				}
				
				driver.quit();
				
	}

}
