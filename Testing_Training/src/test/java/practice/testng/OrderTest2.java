package practice.testng;

import org.testng.annotations.Test;

public class OrderTest2 {
	@Test(invocationCount =10)
	public void createOrderTest()
	{
		System.out.println("Execute createOrder==>123 ");
//		String str=null;
//		System.out.println(str.equals("123"));
	}
	@Test(enabled=false)
	public void billingAnOrderTest()
	{
		System.out.println("Execute  billingAnOrder===>123");
	}
	

}

