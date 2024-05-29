package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage  {
	
	
	WebDriver driver;
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//a[text()='Organizations'])[1]")
	private WebElement orgLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignLink;
	
	
	@FindBy(linkText="More")
	private WebElement MoreLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;
	
	



	public WebElement getOrgLink() {
		return orgLink;
	}



	public WebElement getContactLink() {
		return contactLink;
	}



	public WebElement getCampaignLink() {
		return campaignLink;
	}



	public WebElement getMoreLink() {
		return MoreLink;
	}



	public void navigateToCampaignPage()
	{
		
		Actions action=new Actions(driver);
		action.moveToElement(MoreLink).perform();
		campaignLink.click();
	}
	
	public void logout()
	{
		Actions action=new Actions(driver);
		
		action.moveToElement(adminImg).perform();
		signOutLink.click();
		
	}



	public WebElement getAdminImg() {
		return adminImg;
	}



	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	
	
	
	

}
