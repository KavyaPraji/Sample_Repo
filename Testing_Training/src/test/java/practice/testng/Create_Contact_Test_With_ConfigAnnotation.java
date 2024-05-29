package practice.testng;



import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Create_Contact_Test_With_ConfigAnnotation 
{

	@BeforeSuite
	public void configBs()
	{
		System.out.println("execute  before suite");
	}
	
	@BeforeClass
	public void configBc()
	{
		System.out.println("execute  before class");
	}
	@BeforeMethod
	public void configBm()
	{
		System.out.println("Execute before method");
		
	}
	@Test
	public void createContactTest()
	{
		System.out.println("Execute create contact");
	}
	@Test
	public void createContactWithSupportDateTest()
	{
		System.out.println("Execute createContactWithSupportDate ");
	}
	@AfterMethod
	public void configAm()
	{
		System.out.println("Execute after method");
		
	}
	@AfterClass
	public void configAc()
	{
		System.out.println("execute  after class");
	}
	@AfterSuite
	public void configAs()
	{
		System.out.println("execute  after suite");
	}
	

}
