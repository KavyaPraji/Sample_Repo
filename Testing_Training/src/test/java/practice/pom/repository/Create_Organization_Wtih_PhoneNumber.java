package practice.pom.repository;

import java.io.FileInputStream;
import java.time.Duration;
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

public class Create_Organization_Wtih_PhoneNumber {

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis=new FileInputStream("./configurationAppData/commondata.properties");
		Properties ps=new Properties();
		ps.load(fis);
		
		String BROWSER=ps.getProperty("browser");
		String URL=ps.getProperty("url");
		String USERNAME=ps.getProperty("username");
		String PASSWORD=ps.getProperty("password");
		
		
		//generate random number
		Random random=new Random();
		int randomInt=random.nextInt(1000);
		
		//read data from  excel file
		FileInputStream fis1=new FileInputStream("./TestScriptData/Test.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh=wb.getSheet("sheet1");
		Row row=sh.getRow(7);
		
		String ORGNAME=row.getCell(2).toString()+randomInt;
		String PHONENUM=row.getCell(3).toString();
		wb.close();
		
		
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
		driver.findElement(By.name("phone")).sendKeys(PHONENUM);
		driver.findElement(By.name("button")).click();
		
		
		//verify header phone number
		String actualPhonenumber=driver.findElement(By.name("dtlview_Phone")).getText();
		if(actualPhonenumber.equals(PHONENUM))
		{
			System.out.println(PHONENUM+ "information is verified===PASS");
		}
		else
		{
			System.out.println(PHONENUM+ "infromation is not verified===FAIL");
			
		}
		driver.quit();
		
		

		
	

	}

}
 