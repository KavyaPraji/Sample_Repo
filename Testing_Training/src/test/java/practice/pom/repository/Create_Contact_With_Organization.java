package practice.pom.repository;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Create_Contact_With_Organization {

	public static void main(String[] args) throws Throwable {
		
		//read data from property file
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
				String contactLastName=row.getCell(3).toString();
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
				driver.findElement(By.name("button")).click();
				
				//verify  header message expected result
				
				String headerInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(headerInfo.contains(ORGNAME))
				{
					System.out.println(ORGNAME+ "header verified===PASS");
				}
				else
				{
					System.out.println(ORGNAME+ "header is not verified===FAIL");
					
				}
				
				
				
				//navigate to contact module
				driver.findElement(By.linkText("Contacts")).click();
				driver .findElement(By.xpath("//img[@title='Create Contact...']")).click();
				driver.findElement(By.name("lastname")).sendKeys(contactLastName);
				
				driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
				
				//switch to child window
				
				
				Set<String> child=driver.getWindowHandles();
				Iterator<String> it=child.iterator();
				while(it.hasNext())
				{
					String windowID=it.next();
					driver.switchTo().window(windowID);
					
					String actUrl=driver.getCurrentUrl();
					if(actUrl.contains("module=Accounts"))
					{
						break;
											}
					
				}
				driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
				driver.findElement(By.name("search")).click();
				driver.findElement(By.xpath("//a[text()='"+ORGNAME+" ']")).click();
				
				//switch to parent window
				Set<String> child1=driver.getWindowHandles();
				Iterator<String> it1=child.iterator();
				while(it1.hasNext())
				{
					String windowID=it1.next();
					driver.switchTo().window(windowID);
					
					String actUrl=driver.getCurrentUrl();
					if(actUrl.contains("module=Contact"))
					{
						break;
											}
					
				}
				
				driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
					
				
				//verify header organization  name and contact name info expected result
				String actualcontactName=driver.findElement(By.id("dtlview_Last Name")).getText();
				if(actualcontactName.equals(contactLastName))
				{
					System.out.println(contactLastName+ " information is created===PASS");
				}
				
				else
				{
					System.out.println(contactLastName+ " information is  not created===FAIL");
				}
				
				String actOrgname=driver.findElement(By.id("mouseArea_Organization Name")).getText();
				if(actOrgname.equals(ORGNAME)) 
				{
					System.out.println(actOrgname+ " information is created===PASS");
				}
				else
				{
					System.out.println(actOrgname+"  information is not verified");
				}

				
				
				
				driver.quit();

	}

}
