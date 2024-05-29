package practice.testng;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.crm.generic.baseutility.BaseClass_Original;


public class InvoiceTestRetry 
{
	@Test(retryAnalyzer=com.comcast.crm.ListnerUtility.Retry_Listner_Implementation.class)
	public void activateSim()
	{
		
		System.out.println("execute createInvoiceTest");
		
		
		Assert.assertEquals("", "Login");
		
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
		
	}
	
	

}
