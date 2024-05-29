package practice.testng;

import org.testng.annotations.Test;

public class OrderTest {
	@Test(priority=2)
	public void createOrderTest()
	{
		System.out.println("Execute createOrder==>123 ");
//		String str=null;
//		System.out.println(str.equals("123"));
	}
	@Test(dependsOnMethods="createOrderTest", priority=1)
	public void billingAnOrderTest()
	{
		System.out.println("Execute  billingAnOrder===>123");
	}
	

}
