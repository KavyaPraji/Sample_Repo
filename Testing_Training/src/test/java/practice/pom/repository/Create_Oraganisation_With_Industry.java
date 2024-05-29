package practice.pom.repository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.genericfileutility.ExcelUtility;
import com.comcast.crm.genericfileutility.FileUtility;

public class Create_Oraganisation_With_Industry {

	public static void main(String[] args) throws Throwable {
		
		FileUtility fu=new FileUtility();
		JavaUtility jlib=new JavaUtility();
		ExcelUtility exu=new ExcelUtility();
		
		
				//read data from property file
				
				
		String BROWSER =fu.getDataFromProperties("browser");
		String URL	   =fu.getDataFromProperties("url");
		String USERNAME=fu.getDataFromProperties("username");
		String PASSWORD=fu.getDataFromProperties("password");
		
				
				
				//generate random number
				
				
				//read data from  excel file
				
				
				String ORGNAME=exu.getDataFromExcel("sheet1", 1, 2)+jlib.getRandomNum();
				String INDUSTRY=exu.getDataFromExcel("sheet1", 1, 3)+jlib.getRandomNum();
				String TYPE=exu.getDataFromExcel("sheet1", 1, 4)+jlib.getRandomNum();
				
				
				
				
				
				
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
				
				
				driver.findElement(By.linkText("Organization")).click();
				driver .findElement(By.xpath("//img[@title='Create Organization...']")).click();
				driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
				
				WebElement element=driver.findElement(By.name("industry"));
				Select sel=new Select( element);
				sel.selectByVisibleText("Energy");
				
				WebElement element1=driver.findElement(By.name("accounttype"));
				Select sel1=new Select( element1);
				sel1.selectByVisibleText("Press");
				
				
				driver.findElement(By.name("button")).click();
				
				//verify  the industry and type info
				
				
				String actualIndustryName=driver.findElement(By.id("dtlview_Industry")).getText();
				if(actualIndustryName.equals(INDUSTRY))
				{
					System.out.println(INDUSTRY+ " information is verified===PASS");
				}
				
				else
				{
					
					System.out.println(INDUSTRY+ " information is  not verified===FAIL");
				}
				
				String actualType=driver.findElement(By.id("dtlview_Type")).getText();
				if(actualType.equals(TYPE)) {
					System.out.println(TYPE+ " information is verified===PASS");
				}
				
				else
				{
					System.out.println(TYPE+ " information is  not verified===FAIL");
				}
				
				//logout
				driver.quit();
				
		 

	}

}
