package Advanced_Selenium_1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Property_File_Practice {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("./src/test/resources/commonvtigerdata.properties");
		
		Properties pobj=new Properties();
		pobj.load(fis);
		
		String BROWSER =pobj.getProperty("browser");
		String URL =pobj.getProperty("url");
		String USERNAME =pobj.getProperty("username");
		String PASSWORD =pobj.getProperty("password");
		
		WebDriver driver =null;
		if(BROWSER.equals("chrome"))
		{
					driver=new ChromeDriver();
		}
		else if(BROWSER.equals("friefox"))
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
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME );
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
	
		
		

		
	}

}
