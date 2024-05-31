package pac1;

import org.testng.annotations.Test;

public class ContactTest 
{
	@Test
	public void createContactTest()
	{
		String URL=System.getProperty("url");
		System.out.println(URL);
		String BROWSER=System.getProperty("browser");
		System.out.println(BROWSER);
		String USERNAME=System.getProperty("username");
		System.out.println(USERNAME);
		String PASSWORD=System.getProperty("password");
		System.out.println(PASSWORD);
		System.out.println("execute createContactTest");
		
	}
	
	@Test
	public void ModifyContactTest()
	{
		System.out.println("execute modifyContactTest");
		
	}

}
