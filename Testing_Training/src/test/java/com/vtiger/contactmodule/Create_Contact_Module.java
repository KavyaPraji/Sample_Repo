package com.vtiger.contactmodule;

import org.openqa.selenium.By;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.Homepage;

import com.crm.generic.baseutility.BaseClass_Original;

public class Create_Contact_Module extends BaseClass_Original{

	@Test(groups="SmokeTest")
	public void createContactTest() throws Throwable
	{
		String LASTNAME = fLib.getDataFromProperties("lastname");
		//navigate to contact
		
		//UtilityClassObject.getTest().log(Status.INFO,"navigate to contact");
		Homepage hp=new Homepage(driver);
		hp.getContactLink().click();
		
		ContactPage cp=new ContactPage(driver);
		cp.getCreateNewContactButton().click();
		
		
		
		//create contact
		//UtilityClassObject.getTest().log(Status.INFO,"create  contact");
		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ccp.createContact(LASTNAME);
		ccp.getSaveContactBtn().click();
		
		
		
		//verify  header message expected result
		//UtilityClassObject.getTest().log(Status.INFO,"verify header message");
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
				String actuaLastName=driver.findElement(By.xpath("//td[@id='mouseArea_Last Name']")).getText();
				System.out.println(actuaLastName);
				
				
		        if (actuaLastName.replace(" ", "").equals(LASTNAME.replace(" ", ""))) {
		        	System.out.println(LASTNAME+ " information is created===PASS");
		           
		        } else {
		        	System.out.println(LASTNAME+ " information is  not created===FAIL");
		        }

				
				
		
	}
	@Test(groups="RegressionTest")
	public void createContactWithSupportDate() throws Throwable
	{
		String LASTNAME = fLib.getDataFromProperties("lastname");
		//navigate to contact
		
		//UtilityClassObject.getTest().log(Status.INFO,"navigate to contact");
		Homepage hp=new Homepage(driver);
		hp.getContactLink().click();
		
		ContactPage cp=new ContactPage(driver);
		cp.getCreateNewContactButton().click();
		
		
		
		//create contact
		//UtilityClassObject.getTest().log(Status.INFO,"create  contact");
		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ccp.createContact(LASTNAME);
		ccp.getSaveContactBtn().click();
		
		//fetch the system date(today's date)

		String CURRENTDATE=jlib.getSystemDateInFormat();

		ccp.getStartDateEdt().clear();
		ccp.getStartDateEdt().sendKeys(CURRENTDATE);
				
		//fetch day after 30 days
		String LASTDATE=jlib.getRequiredDateInFormat(30);
		ccp.getEndDateEdt().clear();
		ccp.getEndDateEdt().sendKeys(LASTDATE);
		
		ccp.getSaveContactBtn().click();
		
		//verify start date and end date
		ContactInfoPage  cip=new ContactInfoPage(driver);
		
		
		String actCurrentDate=cip.getStartDateInfo().getText();
		if(actCurrentDate.equals(CURRENTDATE))
		{
			System.out.println(CURRENTDATE+ " information is verified===PASS");
		}
		
		else
		{
			
			System.out.println(CURRENTDATE+ " information is  not verified===FAIL");
		}
		
		String actEndDate=cip.getEndtDateInfo().getText();
		if(actEndDate.equals(LASTDATE)) {
			System.out.println(LASTDATE+ " information is verified===PASS");
		}
		
		else
		{
			System.out.println(LASTDATE+ " information is  not verified===FAIL");
		}
		System.out.println("executed createContactWithSupportDate succesfully ");
		
	}
	@Test
	public void createContactWithOrg()
	{
		System.out.println("execute createContactWithOrg succesfully");
	}
}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
		
		
		
			
				
			
				
				

	


