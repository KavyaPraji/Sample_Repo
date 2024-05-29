package practice.testng;

import org.testng.annotations.Test;

import com.crm.generic.baseutility.BaseClass;
import com.crm.generic.baseutility.BaseClass_Simple;

public class Create_Contact_With_Baseclass extends BaseClass_Simple
{
	@Test
	public void createContact() 
	{
		System.out.println("execute create contact and verify");

	}
	@Test
	public void createContactwithDate() 
	{
		System.out.println("execute createContactwithDate and verify");
				
	}

}
