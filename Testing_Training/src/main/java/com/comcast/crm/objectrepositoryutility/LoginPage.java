package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;

/**
 * 
 * @author Kavya
 * 
 * Contains login page elementS AND business library like login()
 * 
 */
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class LoginPage extends WebdriverUtility
{
	//Rule 1-create a separate java class
	//Rule 2-Object creation
	WebDriver  driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	 private  WebElement usernameEdt;
	
	@FindBy(name="user_password")
	 private WebElement passowrdEdt;
	
	@FindBy(id="submitButton")
	 private WebElement loginButton;
	//Rule 3-object initialization
	
	//Rule 4-Object Encapsulation
	

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPassowrdEdt() {
		return passowrdEdt;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	//objectUtilization or provide action
	
	/**
	 * 
	 * login to application based on user name,password,url arguments
	 * @param url
	 * @param username
	 * @param password
	 */
	
	public void logininToApp(String url,String username,String password)
	{
		waitForPageToLoad(driver);
		driver.get(url);
		usernameEdt.sendKeys(username);
		passowrdEdt.sendKeys(password);
		loginButton.click();
		
		
		
		
	}
	
	
	
	
	
	

}
