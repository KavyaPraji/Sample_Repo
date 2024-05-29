package practice.testng;
/**
 * test class for Contact module
 * @author Kavya
 *
 */

import org.testng.annotations.Test;

import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.crm.generic.baseutility.BaseClass_Original;

public class SearchContactTest extends BaseClass_Original
{
	/**
	 * 
	 * Scenario:login()==>navigateContact()==>creataContact()==>verify
	 */
	@Test
	public void searchContact()
	{
		/*step 1:Login to application*/
		LoginPage lp=new LoginPage(driver);
		lp.logininToApp("url", "usraname", "password");
	}

}
