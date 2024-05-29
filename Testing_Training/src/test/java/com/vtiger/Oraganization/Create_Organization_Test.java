package com.vtiger.Oraganization;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.genericfileutility.ExcelUtility;
import com.comcast.crm.genericfileutility.FileUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganisationPage;
import com.comcast.crm.objectrepositoryutility.Homepage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganisationInformationPage;
import com.comcast.crm.objectrepositoryutility.Organizationpage;
import com.crm.generic.baseutility.BaseClass;
import com.crm.generic.baseutility.BaseClass_Original;

public class Create_Organization_Test extends BaseClass_Original 
{

		@Test(groups="SmokeTest")
		public void createOrgTest() throws IOException, Throwable {
		// navigate to organization
		Homepage hp = new Homepage(driver);
		hp.getOrgLink().click();
		
		Organizationpage op=new Organizationpage(driver);
		op.getCreateNewOrgButton().click();

		String ORGNAME = fLib.getDataFromProperties("orgname");

		// create organization
		CreatingNewOrganisationPage cop = new CreatingNewOrganisationPage(driver);
		cop.createOrg(ORGNAME);
		cop.getSaveButton().click();

		// verify header message expected result
		OrganisationInformationPage oip = new OrganisationInformationPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		if (actOrgName.contains(ORGNAME)) {
			System.out.println(ORGNAME + "is verified ==PASS");
		} else {
			System.out.println(ORGNAME + "is not verified ==FAIL");
		}
		System.out.println("executed createOrgTest succesfully");
	}
		
		@Test(groups="RegressionTest")
		public void createOrgWithIndustry() throws IOException, Throwable
		{
			//navigate to Organization
			CreatingNewOrganisationPage cop=new CreatingNewOrganisationPage(driver);
			Organizationpage op=new Organizationpage(driver);
			
			Homepage hp = new Homepage(driver);
			hp.getOrgLink().click();
			
			//create organization with Industry
			
			op.getCreateNewOrgButton().click();
			
			String ORGNAME = fLib.getDataFromProperties("orgname");
			
			
			cop.createOrg(ORGNAME);
			WebElement ele1=cop.getIndustryDropDown();
			String INDUSTRY=fLib.getDataFromProperties("industry");
			
			 cop.selectIndustry(ele1, INDUSTRY);
			
			 cop.getSaveButton();
			
			
			
			//verify  the industry and  info
			OrganisationInformationPage oip=new OrganisationInformationPage(driver);
			
			String actualIndustryName=oip.getIndustryInfo().getText();
			if(actualIndustryName.equals(INDUSTRY))
			{
				System.out.println(INDUSTRY+ " information is verified===PASS");
			}
			
			else
			{
				
				System.out.println(INDUSTRY+ " information is  not verified===FAIL");
			}
			System.out.println("executed createOrgWithIndustry succesfully");
			
			
			
		}
		@Test(groups="RegressionTest")
		public void createOrgWithPhoneNumber() throws IOException, Throwable
		{
			//navigate to organization
			Homepage hp = new Homepage(driver);
			hp.getOrgLink().click();
			
			//create organization with phone number
			
			Organizationpage op=new Organizationpage(driver);
			op.getCreateNewOrgButton().click();
			
			String ORGNAME = fLib.getDataFromProperties("orgname");
			
			CreatingNewOrganisationPage cop=new CreatingNewOrganisationPage(driver);
			cop.createOrg(ORGNAME);
			
			
			
			String PHONENUMBER = fLib.getDataFromProperties("phno");
			
			cop.getPhnoEdt().sendKeys(PHONENUMBER);
			
			//verify header phone number
			String actualPhonenumber=driver.findElement(By.name("dtlview_Phone")).getText();
			if(actualPhonenumber.equals(PHONENUMBER))
			{
				System.out.println(PHONENUMBER+ "information is verified===PASS");
			}
			else
			{
				System.out.println(PHONENUMBER+ "infromation is not verified===FAIL");
				
			}
			System.out.println("execute createOrgWithPhoneNumber succesfully ");
			
			
			
		}
		

	

	
		
}



