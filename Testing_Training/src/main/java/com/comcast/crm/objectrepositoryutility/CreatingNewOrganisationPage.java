package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganisationPage 
{
	
	WebDriver driver;
	public CreatingNewOrganisationPage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	
	@FindBy(id="phone")
	private WebElement phnoEdt;
	
	
	
	
	
	
	
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	public WebElement getIndustryDropDown() 
	{
		return industryDropDown;
	}
	
	public void  createOrg(String orgName)
	{
		orgNameEdt.sendKeys(orgName);
		
		
	}
	
	public WebElement getPhnoEdt() {
		return phnoEdt;
	}
	
	public void selectIndustry(WebElement element ,String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}

	

	
	
	
	
}
