package practice.testng;

import org.testng.annotations.Test;

import com.crm.generic.baseutility.BaseClass;
import com.crm.generic.baseutility.BaseClass_Simple;

public class Create_Organization_With_Baseclass extends BaseClass_Simple
{
	@Test
	public void createOrgTest() 
	{
		System.out.println("execute createOrgTest and verify");

	}
	@Test
	public void createOrgWithIndustry() 
	{
		System.out.println("execute createOrgWithIndustry and verify");
				
	}

}

