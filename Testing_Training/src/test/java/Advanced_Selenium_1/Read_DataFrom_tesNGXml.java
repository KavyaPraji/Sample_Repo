package Advanced_Selenium_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class Read_DataFrom_tesNGXml
{
	@Test
	public void sampleTest(XmlTest test)
	{
//		System.out.println("executed");
//		System.out.println(test.getParameter("browser"));
//		System.out.println(test.getParameter("url"));
//		System.out.println(test.getParameter("username"));
//		System.out.println(test.getParameter("password"));
		
		
		String BROWSER =test.getParameter("browser");
		String URL 	   =test.getParameter("url");
		String USERNAME =test.getParameter("username");
		String PASSWORD =test.getParameter("password");
		
		WebDriver driver=null;
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
			
		}
		else if(BROWSER.equals("firefox"))
		{
			driver =new FirefoxDriver();
			
		}
		else if(BROWSER.equals("edge"))
		{
			driver=new EdgeDriver();
			
		}
		else
		{
			driver=new ChromeDriver();
			
		}	
		
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		
	}
	

}

 