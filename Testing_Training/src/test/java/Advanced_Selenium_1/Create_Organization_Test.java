package Advanced_Selenium_1;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.genericfileutility.ExcelUtility;
import com.comcast.crm.genericfileutility.FileUtility;

public class Create_Organization_Test {

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
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		driver.findElement(By.linkText("Organization")).click();
		driver .findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		driver.findElement(By.name("button")).click();
		
		//verify  header message expected result
		
		String headerInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerInfo.contains(ORGNAME))
		{
			System.out.println(ORGNAME+ "header verified===PASS");
		}
		else
		{
			System.out.println(ORGNAME+ "header verified===FAIL");
			
		}
		
		//verify header organization  name info expected result
		String actualOrgName=driver.findElement(By.id("dtlview_Organization Name")).getText();
		if(actualOrgName.equals(ORGNAME))
		{
			System.out.println(ORGNAME+ " information is created===PASS");
		}
		
		else
		{
			System.out.println(ORGNAME+ " information is  not created===FAIL");
		}
		
		
		driver.quit();
		
				

	}

}
