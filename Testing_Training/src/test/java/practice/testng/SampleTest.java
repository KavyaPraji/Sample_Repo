package practice.testng;

import org.testng.annotations.Test;

public class SampleTest 
{
	@Test(priority=1)
	public void createContactTest()
	{
		System.out.println("execute createContactTest");
	}
	@Test(priority=2)
	public void modifyContact()
	{
		System.out.println("execute modify contact test");
	} 

	@Test(priority=3)
	public void deleteContact()
	{
		System.out.println("execute delete contact test");
	}
	
	
	
	
	
	

	

}

