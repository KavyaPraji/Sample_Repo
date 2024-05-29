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
import org.testng.annotations.Test;

import com.comcast.crm.objectrepositoryutility.Homepage;
import com.crm.generic.baseutility.BaseClass;

public class Create_Contact_Module extends BaseClass{

	@Test
	public void createContactTest() throws Throwable
	{
		
		//navigate to contact
		Homepage hp=new Homepage(driver);
		hp.getContactLink().click();
		String LASTNAME="kavya";
		//create contact
		//CreatingNewContactPage ccp=new CreatingNewContactPage();
		
		//verify  header message expected result
		
		String headerInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerInfo.contains(LASTNAME))
		{
			System.out.println(LASTNAME+ "header verified===PASS");
		}
		else
		{
			System.out.println(LASTNAME+ "header verified===FAIL");
			
		}

		
		//verify header contact  name info expected result
		String actuaLastName=driver.findElement(By.id("mouseArea_Last Name")).getText();
		if(actuaLastName.equals(LASTNAME))
		{
			System.out.println(LASTNAME+ " information is created===PASS");
		}
		
		else
		{
			System.out.println(LASTNAME+ " information is  not created===FAIL");
		}
		
		
		
		
			
				
			
				
				

	}

}
