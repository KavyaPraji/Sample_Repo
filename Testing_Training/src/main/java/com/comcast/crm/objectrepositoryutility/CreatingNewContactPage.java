package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {
	WebDriver driver;

	public CreatingNewContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "lastname")
	 private WebElement lastnameEdt;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	 private WebElement saveContactBtn;
	
	@FindBy(name="support_start_date")
	 private WebElement  startDateEdt;
	
	@FindBy(name="support_end_date")
	 private WebElement  endDateEdt;;
	
	

	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}

	public WebElement getSaveContactBtn() {
		return saveContactBtn;
	}
	
	public void createContact(String contactName)
	{
		lastnameEdt.sendKeys(contactName);
	}

	public WebElement getStartDateEdt() {
		return startDateEdt;
	}

	public WebElement getEndDateEdt() {
		return endDateEdt;
	}
	
	

}
