package Advanced_Selenium_1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Property_File_Excel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties ps=new Properties();
		ps.load(fis);
		
		String BROWSER=ps.getProperty("browser");
		String URL=ps.getProperty("url");
		String USERNAME=ps.getProperty("username");
		String PASSWORD=ps.getProperty("password");
		FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\Test.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		String ORGNAME=wb.getSheet("sheet1").getRow(1).getCell(1).toString();
		
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
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submit_button")).click();
		
		
		driver.findElement(By.linkText("Organization")).click();
		driver .findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		driver.findElement(By.name("button")).click();
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
