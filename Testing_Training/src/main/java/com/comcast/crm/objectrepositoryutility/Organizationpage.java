package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizationpage
{
	
	WebDriver driver;
	public Organizationpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createNewOrgButton;
	
	@FindBy(name="search_text")
	 private WebElement searchEdt;
	
	@FindBy(name="search_field")
	 private WebElement searchDropDown;
	
	@FindBy(xpath="//input[@name='submit']")
	 private WebElement searchnowBtn;
	

	public WebElement getSearchnowBtn() {
		return searchnowBtn;
	}

	public WebElement getSearchDropDown() {
		return searchDropDown;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getCreateNewOrgButton() {
		return createNewOrgButton;
	}
	
}
