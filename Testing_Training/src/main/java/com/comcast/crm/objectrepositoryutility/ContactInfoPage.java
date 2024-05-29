package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage 
{
	WebDriver driver;
	public ContactInfoPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="//span[@class='dvHeaderText']")
	private WebElement ContactheaderMsg;
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement startDateInfo;
	
	@FindBy(id="dtlview_Support End Date")
	private WebElement endtDateInfo;
	
	public WebElement getContactheaderMsg() {
		return ContactheaderMsg;
	}

	public WebElement getStartDateInfo() {
		return startDateInfo;
	}

	public WebElement getEndtDateInfo() {
		return endtDateInfo;
	}

}
