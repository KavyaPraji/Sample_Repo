package practice.pom.repository;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;
import com.comcast.crm.genericfileutility.ExcelUtility;
import com.comcast.crm.genericfileutility.FileUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganisationPage;
import com.comcast.crm.objectrepositoryutility.Homepage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganisationInformationPage;
import com.comcast.crm.objectrepositoryutility.Organizationpage;

public class Create_Organization_Test_And_Delete_POM {

	public static void main(String[] args) throws Throwable 
	{
		
		
		FileUtility fu=new FileUtility();
		JavaUtility jlib=new JavaUtility();
		ExcelUtility exu=new ExcelUtility();
		WebdriverUtility wbu=new WebdriverUtility ();
		
		//read data from property file

		String BROWSER =fu.getDataFromProperties("browser");
		String URL	   =fu.getDataFromProperties("url");
		String USERNAME=fu.getDataFromProperties("username");
		String PASSWORD=fu.getDataFromProperties("password");
		
		
		//generate random number and read data from  excel file
		
		
		String ORGNAME=exu.getDataFromExcel("sheet1", 10, 2)+jlib.getRandomNum();
		
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
		
		
		wbu.waitForPageToLoad(driver);
		driver.get(URL);
		
		
		
		
		//login into application
//		lp.getUsernameEdt().sendKeys(USERNAME);
//		lp.getPassowrdEdt().sendKeys(PASSWORD);
//		lp.getLoginButton().click();
//		
		
		//OR login into application
		LoginPage lp=new LoginPage(driver);
		lp.logininToApp(USERNAME, PASSWORD);
		
		//navigate to organization module
		Homepage hp=new Homepage(driver);
		hp.getOrgLink().click();
	
		
		
		//click on create Organization button
		Organizationpage op=new Organizationpage(driver);
		op.getCreateNewOrgButton().click();
		
		//enter all the details and create new organization
		
		CreatingNewOrganisationPage cop=new CreatingNewOrganisationPage (driver);
		cop.createOrg(ORGNAME);
		
		//verify  header message expected result
		OrganisationInformationPage oip=new OrganisationInformationPage(driver);
		 String actOrgName=oip.getHeaderMsg().getText();
		 if(actOrgName.contains(ORGNAME))
		 {
			 System.out.println(ORGNAME+"is verified ==PASS");
		 }
		 else
		 {
			 System.out.println(ORGNAME+"is not verified ==FAIL");
		 }
		
		//go back to organization page
		 hp.getOrgLink().click();
		 
		 // search for Organization
		 op.getSearchEdt().sendKeys(ORGNAME);
		 wbu.Select(op.getSearchEdt()," Organization Name");
		 op.getSearchnowBtn().click();
		 
		 //in dynamic web table select and delete organization at run time
		 driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']/../../td[8]/a[text()='del']")).click();
		 wbu.switchToAlertAndAccept(driver);
		 
		 
		//logout
		 hp.logout();
		
		
		driver.quit();
		

		 
		 			
		 
		 			
			
				
				

	}

}
