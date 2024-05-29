package Advanced_Selenium_1;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class MultipleDataonExpectedCondition 
{
	public static void main(String[] args) throws Throwable 
	{
		String expectedTestId="tc-02";
		
		String data1="";
		String data2="";
		String data3="";
		
		boolean flag=false;
		
		FileInputStream fs=new FileInputStream(".src/test/resources/expec.xlsx");
		
		Workbook wb=WorkbookFactory.create(fs);
		Sheet sh=wb.getSheet("Multi");
		
		int rowCount=sh.getLastRowNum();
		for(int i=0;i<=rowCount;i++)
		{
			String data="";
			try {
				data=sh.getRow(i).getCell(0).toString();
				if(data.equals(expectedTestId))
				{
					data1=sh.getRow(i).getCell(1).toString();
					data2=sh.getRow(i).getCell(2).toString();
					data3=sh.getRow(i).getCell(3).toString();
				}
				
			}catch(Exception e){}
		}
		if(flag==true)
		{
			System.out.println(data1);
			System.out.println(data2);
			System.out.println(data3);
		}
		else
		{
			System.out.println(expectedTestId+"data is not available");
		}
		wb.close();
		
		
		
		
		
	}

}
