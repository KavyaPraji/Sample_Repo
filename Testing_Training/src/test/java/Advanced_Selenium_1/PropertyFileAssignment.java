package Advanced_Selenium_1;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PropertyFileAssignment {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileInputStream fs=new FileInputStream("./src/test/resources/commondata.properties");
		Properties p=new Properties();
		p.load(fs);
		
		String BROWSER=p.getProperty("browser");
		String URL=p.getProperty("url");
		String USERNAME=p.getProperty("username");
		String PASSWORD=p.getProperty("password");
		
		
		WebDriver driver=null;
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equals("chrome"))
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
		Thread.sleep(5000);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		Thread.sleep(5000);
		//driver.switchTo().alert();		
		driver.findElement(By.xpath("(//a[contains(text(),'Create')])[2]")).click();
		driver.findElement(By.name("accountname")).sendKeys("abcd pvt.ltd");
		driver.findElement(By.name("button")).click();
		
		

	}

}
