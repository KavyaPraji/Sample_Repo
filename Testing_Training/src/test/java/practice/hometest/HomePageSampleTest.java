package practice.hometest;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageSampleTest 
{
	@Test
	public void homePageTest(Method mtd)
	{
		System.out.println(mtd.getName() + "Test start");
		SoftAssert assertObj=new SoftAssert();
		System.out.println("step-1");
		System.out.println("step-2");
		
		Assert.assertEquals("Home", "Home-Page");
		System.out.println("step-3");
		Assert.assertEquals("title", "title");
		System.out.println("step-4");
		 assertObj.assertAll();
		
		System.out.println(mtd.getName() + "Test end");
	}
	@Test
	public void verifyLogoHomePageTest(Method mtd)
	{
		
		System.out.println(mtd.getName() + "Test start");
		
		
		SoftAssert assertObj=new SoftAssert();
		System.out.println("step-1");
		System.out.println("step-2");
		assertObj.assertTrue(true);
		System.out.println("step-3");
		System.out.println("step-4");
		
		System.out.println(mtd.getName() + "Test end");
	}
	

	
	
	



}
