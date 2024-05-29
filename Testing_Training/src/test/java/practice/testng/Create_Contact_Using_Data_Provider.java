package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Create_Contact_Using_Data_Provider 
{
	@Test(dataProvider="getData")
	public void createContactTest(String firstname,String lastname,long phno)
	{
		System.out.println("First name: "+  firstname+"  Lastname:  "+ lastname+"=="+phno);
	}

	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr=new Object[3][3];
		
		objArr[0][0]="Deepak";
		objArr[0][1]="Sylendra";
		objArr[0][2]=9845632172l;
		
		objArr[1][0]="Sam";
		objArr[1][1]="agureo";
		objArr[1][2]=8078245580l;
		
		objArr[2][0]="Jhon";
		objArr[2][1]="Smith";
		objArr[2][2]=8129953216l;
		
		return objArr;
	}
}

